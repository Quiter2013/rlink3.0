/**    
 * Copyright (C),Robustel 广州鲁邦通物联网科技有限公司<br/>
 * network:http://www.robustel.com
 * @FileName: ImportExportUtil.java
 * @Package: com.robustel.platform.common.util
 * @project: ice
 * @Description: 模块目的、功能描述  
 * @Author leicheng
 * @Date 2015年6月24日 下午2:20:26
 * @History: 修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 **/

package com.robustel.common.utils.excel;

import com.robustel.common.utils.exception.UnsupportedFileTypeException;
import com.robustel.common.utils.AppUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @file ImportExportUtil
 * @author leicheng
 * @date 2015年6月24日 下午2:20:26
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [Robustel/ice] （可选）
 */
public class ImportExportUtil {

	private final static String SHEET_NAME = "sheet1";
	private final static int ROW_START_INDEX = 1;

	public static interface ConvertHandle<T> {
		public T convert(Row row);
	}

	private static <T> List<T> importObjectForWorkbook(Workbook wb, ConvertHandle<T> convertHandle) throws IOException {
		List<T> result = new ArrayList<T>();
		Sheet sheet1 = wb.getSheetAt(0);
		int index = ROW_START_INDEX;
		while (true) {
			Row row = sheet1.getRow(index++);
			if (row == null)
				break;

			T rs = convertHandle.convert(row);
			if (rs != null)
				result.add(convertHandle.convert(row));

		}
		return result;
	}

	public static <T> List<T> importObjectForExcel2003(InputStream inputStream, ConvertHandle<T> convertHandle)
			throws IOException {
		try (Workbook wb = new HSSFWorkbook(inputStream);) {
			return importObjectForWorkbook(wb, convertHandle);
		}
	}

	public static <T> List<T> importObjectForExcel2007(InputStream inputStream, ConvertHandle<T> convertHandle)
			throws IOException {
		Workbook workbook = null;
		try {
			//Workbook wb = new XSSFWorkbook(inputStream);
			workbook = WorkbookFactory.create(inputStream);  
			} catch (Exception e) {
		}
		return importObjectForWorkbook(workbook, convertHandle);
	}

	private static void exportToWorkboot(Workbook wb, List<String> columns, List<Map<String, Object>> data) {
		Sheet sheet1 = wb.createSheet(SHEET_NAME);
		BasePOIUtil basePOIUtil = new BasePOIUtil(wb, sheet1);
		Row row = sheet1.createRow(0);

		final int totalCols = columns.size();

		row.createCell(0).setCellValue("");
		basePOIUtil.MergeCell(0, 0, 0, totalCols - 1);

		row = sheet1.createRow(sheet1.getLastRowNum() + 1);
		int index = 0;
		for (String str : columns) {
			row.createCell(index++).setCellValue(str);
		}

		for (Map<String, Object> list : data) {
			row = sheet1.createRow(sheet1.getLastRowNum() + 1);
			index = 0;
			for (String str : columns) {
				Object value = list.get(str);
				Cell cell = row.createCell(index++);
				if (value == null)
					continue;
				if (value instanceof Number) {
					cell.setCellValue(((Number) value).doubleValue());
				} else if (value instanceof Boolean) {
					cell.setCellValue((boolean) value);
				} else if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Date) {
					cell.setCellValue(((Date) value));
				} else {
					cell.setCellValue(String.valueOf(value));
				}
			}
		}

		basePOIUtil.setPrintStyle(true, true, true);
	}

	public static void exportToExcel2003(OutputStream outputStream, List<String> columns,
			List<Map<String, Object>> data) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			exportToWorkboot(wb, columns, data);
			wb.write(outputStream);
		} finally {
			wb.close();
		}
	}

	public static void exportToExcel2007(OutputStream outputStream, List<String> columns,
			List<Map<String, Object>> data) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		try {
			exportToWorkboot(wb, columns, data);
			wb.write(outputStream);
		} finally {
			wb.close();
		}
	}

	/**
	 * 
	 * <p>
	 * 通过扩展名导入EXCEL
	 * <p>
	 * <p>
	 * 功能详细描述
	 * <p>
	 * 
	 * @param suffix
	 *            扩展名（xls,xlsx）
	 * @param inputStream
	 * @param convertHandle
	 * @return
	 * @throws IOException
	 * @return List<T>
	 * @exception [违例类型]
	 *                [违例说明]
	 * @see [类、类#方法、类#成员]
	 * @author huangjt
	 * @date 2016年7月5日 下午7:06:11
	 */
	public static <T> List<T> importExcelBySuffix(String suffix, InputStream inputStream,
			ConvertHandle<T> convertHandle) throws IOException {
		if ("xls".equals(suffix)) {
			try (Workbook wb = new HSSFWorkbook(inputStream);) {
				return importObjectForWorkbook(wb, convertHandle);
			}
		} else if ("xlsx".equals(suffix)) {
			try (Workbook wb = new XSSFWorkbook(inputStream)) {
				return importObjectForWorkbook(wb, convertHandle);
			}
		} else {
			throw new UnsupportedFileTypeException("Unsupported file formats.");
		}
	}
	
	public static Object caseCellValue(Cell cell){
		Object cellValue = null;
		
		if(AppUtils.isBlank(cell))
			return null;
		
		switch (cell.getCellType()) {  
		
        case HSSFCell.CELL_TYPE_NUMERIC: // 数字  
            DecimalFormat df = new DecimalFormat("0");  
            cellValue = df.format(cell.getNumericCellValue());  
            break;  

        case HSSFCell.CELL_TYPE_STRING: // 字符串  
            cellValue = cell.getStringCellValue().trim();  
            break;  

        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean  
            cellValue = cell.getBooleanCellValue() + "";  
            break;  

        case HSSFCell.CELL_TYPE_FORMULA: // 公式  
            cellValue = cell.getCellFormula() + "";  
            break;  

        case HSSFCell.CELL_TYPE_BLANK: // 空值  
            cellValue = "";  
            break;  

        case HSSFCell.CELL_TYPE_ERROR: // 故障  
            cellValue = "非法字符";  
            break;  

        default:  
            cellValue = "未知类型";  
            break;  
        } 
		
		return cellValue;
    } 

}
