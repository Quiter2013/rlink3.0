package com.robustel.pl.app.multilingual.service.impl;

import com.robustel.common.core.exception.BizException;
import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.common.utils.UUIDUtil;
import com.robustel.common.utils.constant.ErrCode;
import com.robustel.common.utils.excel.ImportExportUtil;
import com.robustel.pl.app.multilingual.dao.LanguageKeyMapper;
import com.robustel.pl.app.multilingual.dao.MultilingualCofMapper;
import com.robustel.pl.app.multilingual.dao.MultilingualDataMapper;
import com.robustel.pl.app.multilingual.entity.MultilingualCof;
import com.robustel.pl.app.multilingual.entity.MultilingualData;
import com.robustel.pl.app.multilingual.service.MultilingualDataService;
import com.robustel.pl.app.multilingual.vo.LanguageKeyVo;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Desc 系统多语言数据服务接口实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-03
 */
@Service("multilingualDataService")
public class MultilingualDataServiceImpl extends BaseServiceImpl<MultilingualDataMapper,MultilingualData> implements MultilingualDataService {
    private Logger logger = Logger.getLogger(MultilingualDataServiceImpl.class);

    @Autowired
    private LanguageKeyMapper languageKeyMapper;
    @Autowired
    private MultilingualCofMapper multilingualCofMapper;
    @Autowired
    private MultilingualDataMapper multilingualDataMapper;

    @Override
    public byte[] exportData(String appId) {
        byte[] result = null;
        // 固定的表头字段
        String[] columnHead = new String[] { "KEY代码", "KEY类型", "默认值", "KEY描述" };
        // 动态表头
        List<String> baseHead = new ArrayList<String>();
        baseHead.addAll(Arrays.asList(columnHead));

        // 1）根据应用获取语种列表
        List<MultilingualCof> cofs = multilingualCofMapper.queryCofs2App(appId);
        // 动态添加head
        for (MultilingualCof con : cofs) {
            baseHead.add(con.getMultilingualName());
        }

        // 存放组装好数据的容器
        List<Map<String, Object>> assembleDatas = new ArrayList<Map<String, Object>>();

        // 2）根据应用获取多语言Key列表
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", appId);
        List<LanguageKeyVo> keys = languageKeyMapper.queryKeysByAppId(params);

        // 3）查找所设置的语言
        Map<String, Map<String, String>> datas = this.getShowValues(cofs);

        // 组装数据
        // 4）遍历多语言Key
        for (LanguageKeyVo key : keys) {
            Map<String, Object> assembleData = new HashMap<String, Object>();
            assembleData.put(columnHead[0], key.getKeyCode());
            assembleData.put(columnHead[1], "0".equals(key.getKeyType()) ? "普通页面" : "系统后台");
            assembleData.put(columnHead[2], key.getDefaultValue());
            assembleData.put(columnHead[3], key.getKeyDesc());

            // 存入list容器中
            assembleDatas.add(assembleData);
        }

        // 动态添加多语言
        for (MultilingualCof cof : cofs) {
            for (Map<String, Object> map : assembleDatas) {
                map.put(cof.getMultilingualName(), datas.get(cof.getMultilingualName()).get(map.get(columnHead[0])));
            }
        }

        logger.info("正在生成导出数据 . . .");
       // TODO 导出需要重构
        result  = null;
       // result = ExportUtil.exportToExcel2007(baseHead, assembleDatas);

        return result;
    }

    @Override
    public Map<String, Object> importData(String muId, String fileName, InputStream fileIs) {
        Map<String, Object> result = new HashMap<String, Object>();
        // 新增数
        int add = 0;
        // 修改数
        int update = 0;
        // 忽略数
        int ignore = 0;

        List<MultilingualData> multDatas = null;
        // 获取后缀名
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
            multDatas = ImportExportUtil.importExcelBySuffix(suffix, fileIs, new ImportExportUtil.ConvertHandle<MultilingualData>() {
                @Override
                public MultilingualData convert(Row row) {
                    int i = row.getLastCellNum();

                    if (i >= 4) {
                        // 做数据校验
                        if (row.getCell(0) == null || row.getCell(4) == null) {
                            return null;
                        }
                        if (StringUtils.isEmpty(getStringCellValue(row.getCell(0), null)) ||
                                StringUtils.isEmpty( getStringCellValue(row.getCell(4), null))) {
                            return null;
                        }
                        try {
                            MultilingualData mul = new MultilingualData();
                            mul.setKeyCode(getStringCellValue(row.getCell(0), null));
                            mul.setShowValue(getStringCellValue(row.getCell(4), null));
                            return mul;
                        } catch (BizException e) {
                            return null;
                        }
                    } else {
                        return null;
                    }
                }

                public String getStringCellValue(Cell cell, String pattern) throws BizException {
                    if (cell == null) {
                        if (pattern == null)
                            return "";
                        else
                            throw new BizException();
                    }
                    String result;
                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        result = "" + (long) cell.getNumericCellValue();
                        break;
                    default:
                        result = cell.getStringCellValue();
                        break;
                    }
                    result = result.trim();
                    if (pattern != null) {
                        Pattern patternInstance = Pattern.compile(pattern);
                        if (!patternInstance.matcher(result).find()) {
                            throw new BizException();
                        }
                    }
                    return result;
                }

            });
        } catch (Exception e) {
            throw new BizException(ErrCode.ERROR_CODE144, e.toString(), e);
        }
        if (multDatas.size() == 0) {
            throw new BizException(ErrCode.ERROR_CODE144, "");
        }
        Map<String, String> langs = this.getLanguageInfos(muId);
        for (MultilingualData m : multDatas) {
            // 查找记录
            MultilingualData od = multilingualDataMapper.selectByMuIdAndKeyCode(muId, m.getKeyCode());
            if (od != null) {
                // 更新
                od.setShowValue(m.getShowValue());
                multilingualDataMapper.updateByPrimaryKeySelective(od);

                update++;
            } else {
                // 保存
                if (langs.get(m.getKeyCode()) != null) { // 当前系统不存在key不保存
                    m.setMuDataId(UUIDUtil.getKeys());
                    m.setMuId(muId);
                    m.setLangKeyId(langs.get(m.getKeyCode()));
                    multilingualDataMapper.insert(m);

                    add++;
                } else {
                    ignore++;
                }
            }
        }
        result.put("add", add);
        result.put("update", update);
        result.put("ignore", ignore);
        return result;
    }

    private Map<String, Map<String, String>> getShowValues(List<MultilingualCof> cofs) {
        // 对语言分组
        Map<String, Map<String, String>> langDatas = new HashMap<String, Map<String, String>>();
        List<MultilingualData> data = null;
        Map<String, String> ds = null;// {多语言key,多语言Value}
        for (MultilingualCof co : cofs) {
            MultilingualData md = new MultilingualData();
            md.setMuId(co.getMuId());
            data = multilingualDataMapper.getMulDatas(md);
            // List转Map
            ds = new HashMap<String, String>();
            for (MultilingualData da : data) {
                ds.put(da.getKeyCode(), da.getShowValue());
            }
            langDatas.put(co.getMultilingualName(), ds);
        }

        return langDatas;
    }

    /**
     * 通过语种获取多语言Key和Code，步骤：<br>
     * 1)根据语种ID获取应用ID；<br>
     * 2)根据应用ID获取多语言Key列表。<br>
     * 
     * @param muId 语种ID
     * @return
     */
    private Map<String, String> getLanguageInfos(String muId) {
        // 根据语种ID获取appId
        MultilingualCof mc = multilingualCofMapper.selectByPrimaryKey(muId);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", mc.getAppId());
        List<LanguageKeyVo> lngs = languageKeyMapper.queryKeysByAppId(params);
        Map<String, String> langs = new HashMap<String, String>();
        for (LanguageKeyVo vo : lngs) {
            langs.put(vo.getKeyCode(), vo.getLangKeyId());
        }

        return langs;
    }
}
