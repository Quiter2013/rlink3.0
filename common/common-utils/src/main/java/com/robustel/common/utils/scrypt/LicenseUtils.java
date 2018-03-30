package com.robustel.common.utils.scrypt;

import com.robustel.common.utils.file.FileEncrypter;
import com.robustel.common.utils.file.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * License工具类
 * 
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-06-12
 */
public class LicenseUtils {
    private static Logger logger = Logger.getLogger(LicenseUtils.class);

    /**
     * 判断license文件是否有效,标准有：1）文件内容必须完整；
     * 
     * @param password 加密密码
     * @param fileName 经过加密的原license文件
     * @return
     */
    public static boolean isValid(String password, String fileName) {
        // 默认为无效
        boolean isValid = false;
        // 获取解密文件
        String tempFileName = "decrypt_" + System.currentTimeMillis() + FileUtils.fileType(fileName);
        try {
            FileEncrypter.decrypt(fileName, password, tempFileName);

            // 获取文件最后一行的数据
            String lastLine = FileUtils.FileUtilsBase.getLastLineContent(FileUtils.getFile(tempFileName));
            if (lastLine.length() == 32) {
                isValid = FileUtils.judgeFileValid(tempFileName);
            }
        } catch (Exception e) {
            logger.info(String.format("获取文件最后一行数据报错:%s", e.getMessage()));
        } finally {
            // 删除临时文件
            File tempFile = new File(tempFileName);
            if (tempFile.exists() && tempFile.isFile()) {
                tempFile.delete();
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        // license加密密码
        String password = "robustel2010";
        // 测试license是否第一次被读取
        String licenseFile = "H:\\FileUpload\\import\\license - mac.rb";
        // System.out.println(String.format("是否第一次读取：%s",
        // !LicenseUtils.isMoreReader(password, licenseFile)));
        // 添加本机使用标识
        // LicenseUtils.addUniqueFlag(password, licenseFile);
        // System.out.println(String.format("是否第一次读取：%s",
        // !LicenseUtils.isMoreReader(password, licenseFile)));

        // 判断license文件是否有效
        System.out.println(String.format("文件是否本机独有: %s", isValid(password, licenseFile)));

        // 测试license和pc绑定的功能
        testUnique();
    }

    /**
     * 测试license和pc绑定的功能
     */
    private static void testUnique() {
        // license加密密码
        String password = "robustel2010";
        String licenseFile = "H:\\FileUpload\\import\\license - mac.rb";
        // 获取解密文件
        String tempFileName = "decrypt_" + System.currentTimeMillis() + FileUtils.fileType(licenseFile);
        FileEncrypter.decrypt(licenseFile, password, tempFileName);

        // 向文件末尾加入PC的MAC地址
        // String mac = SystemInfoUtils.getLocalPcMac();
        // 模拟其他的及其的mac地址，本机是：70-85-C2-25-33-CF
        String mac = "70-85-C2-25-33-CD";
        FileUtils.addContext2File(tempFileName, mac);
        // 加密
        FileEncrypter.encrypt(tempFileName, password, licenseFile);
    }
}
