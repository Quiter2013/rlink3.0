package com.robustel.common.utils.file;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Desc 文件加密工具类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-12
 */
public class FileEncrypter {
    private static Logger logger = Logger.getLogger(FileEncrypter.class);

    public static void main(String args[]) {
        String inputFile = "C:\\Users\\HZJ\\Videos\\15logs\\license.rb";
        String password = "robustel2010";
        String decryptFile = "C:\\Users\\HZJ\\Videos\\15logs\\dencrypt.rb";
        // encrypt(inputFile, password, outputFile);

        decrypt(inputFile, password, decryptFile);
        boolean isValid = FileUtils.judgeFileValid(decryptFile);
        if (isValid) {

        }
    }

    /**
     * 将文件inputFile以密码password加密后输出到指定位置outputFile
     * 
     * @param inputFile 待加密文件
     * @param password 加密密码
     * @param outputFile 加密后的文件
     */
    public static void encrypt(String inputFile, String password, String outputFile) {
        // 1)获取加密密码的md5值
        if (password.length() < 5) {
            logger.info("密码长度必须大于5");
        } else {
            FileInputStream fis = null;
            try {
                // 1)获取密码的md5值
                String sKey = getPasswordMd5(password);
                if (sKey != null && sKey.length() == 48) {
                    File fileIn = FileUtils.getFile(inputFile);
                    byte[] bytK1 = getKeyByStr(sKey.substring(0, 16));
                    byte[] bytK2 = getKeyByStr(sKey.substring(16, 32));
                    byte[] bytK3 = getKeyByStr(sKey.substring(32, 48));

                    fis = new FileInputStream(fileIn);
                    byte[] bytIn = new byte[(int) fileIn.length()];
                    for (int i = 0; i < fileIn.length(); i++) {
                        bytIn[i] = (byte) fis.read();
                    }
                    // 加密
                    byte[] bytOut = encryptByDES(encryptByDES(encryptByDES(bytIn, bytK1), bytK2), bytK3);
                    FileOutputStream fos = new FileOutputStream(FileUtils.getFile(outputFile));
                    for (int i = 0; i < bytOut.length; i++) {
                        fos.write((int) bytOut[i]);
                    }
                    fos.close();
                } else {
                    logger.info("获取密码加密值出错");
                }
            } catch (Exception e) {
                logger.info(String.format("文件加密出现异常:%s", e.getMessage()));
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        logger.info(String.format("文件流关闭异常:%s", e.getMessage()));
                    }
                }
            }

        }
    }

    /**
     * 解密encryptFile并输出为decryptFile
     * 
     * @param encryptFile 加密文件
     * @param password 密码
     * @param decryptFile 解密后输出的文件
     * @return
     */
    public static void decrypt(String encryptFile, String password, String decryptFile) {
        FileInputStream fis = null;
        try {
            // 1)获取密码的md5值
            String sKey = getPasswordMd5(password);
            if (sKey != null && sKey.length() == 48) {
                File fileIn = FileUtils.getFile(encryptFile);
                File fileOut = FileUtils.getFile(decryptFile);

                String strPath = fileIn.getPath();
                strPath = strPath.substring(0, strPath.length() - 5);
                byte[] bytK1 = getKeyByStr(sKey.substring(0, 16));
                byte[] bytK2 = getKeyByStr(sKey.substring(16, 32));
                byte[] bytK3 = getKeyByStr(sKey.substring(32, 48));

                fis = new FileInputStream(fileIn);
                long fileInLength = fileIn.length();
                byte[] bytIn = new byte[Integer.parseInt(fileInLength + "")];
                for (int i = 0; i < fileIn.length(); i++) {
                    bytIn[i] = (byte) fis.read();
                }
                // 2)解密
                byte[] bytOut = decryptByDES(decryptByDES(decryptByDES(bytIn, bytK3), bytK2), bytK1);
                FileOutputStream fos = new FileOutputStream(fileOut);
                for (int i = 0; i < bytOut.length; i++) {
                    fos.write((int) bytOut[i]);
                }
                fos.close();
            }
        } catch (Exception e) {
            logger.info(String.format("文件解密出现异常:%s", e.getMessage()));
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 用DES方法加密输入的字节 bytKey需为8字节长，是加密的密码
     */
    private static byte[] encryptByDES(byte[] bytP, byte[] bytKey) throws Exception {
        DESKeySpec desKS = new DESKeySpec(bytKey);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey sk = skf.generateSecret(desKS);
        Cipher cip = Cipher.getInstance("DES");
        cip.init(Cipher.ENCRYPT_MODE, sk);
        return cip.doFinal(bytP);
    }

    /**
     * 用DES方法解密输入的字节 bytKey需为8字节长，是解密的密码
     */
    private static byte[] decryptByDES(byte[] bytE, byte[] bytKey) throws Exception {
        DESKeySpec desKS = new DESKeySpec(bytKey);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey sk = skf.generateSecret(desKS);
        Cipher cip = Cipher.getInstance("DES");
        cip.init(Cipher.DECRYPT_MODE, sk);
        return cip.doFinal(bytE);
    }

    /**
     * 输入密码的字符形式，返回字节数组形式。 如输入字符串：AD67EA2F3BE6E5AD
     * 返回字节数组：{173,103,234,47,59,230,229,173}
     */
    private static byte[] getKeyByStr(String str) {
        byte[] bRet = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            Integer itg = new Integer(16 * getChrInt(str.charAt(2 * i)) + getChrInt(str.charAt(2 * i + 1)));
            bRet[i] = itg.byteValue();
        }
        return bRet;
    }

    /**
     * 计算一个16进制字符的10进制值 输入：0-W
     */
    private static int getChrInt(char chr) {
        int iRet = 0;
        switch (chr) {
        case '0':
            iRet = 0;
            break;
        case '1':
            iRet = 1;
            break;
        case '2':
            iRet = 2;
            break;
        case '3':
            iRet = 3;
            break;
        case '4':
            iRet = 4;
            break;
        case '5':
            iRet = 5;
            break;
        case '6':
            iRet = 6;
            break;
        case '7':
            iRet = 7;
            break;
        case '8':
            iRet = 8;
            break;
        case '9':
            iRet = 9;
            break;
        case 'A':
            iRet = 10;
            break;
        case 'B':
            iRet = 11;
            break;
        case 'C':
            iRet = 12;
            break;
        case 'D':
            iRet = 13;
            break;
        case 'E':
            iRet = 14;
            break;
        case 'F':
            iRet = 15;
            break;
        case 'G':
            iRet = 16;
            break;
        case 'H':
            iRet = 17;
            break;
        case 'I':
            iRet = 18;
            break;
        case 'J':
            iRet = 19;
            break;
        case 'K':
            iRet = 20;
            break;
        case 'L':
            iRet = 21;
            break;
        case 'M':
            iRet = 22;
            break;
        case 'N':
            iRet = 23;
            break;
        case 'O':
            iRet = 24;
            break;
        case 'P':
            iRet = 25;
            break;
        case 'Q':
            iRet = 26;
            break;
        case 'R':
            iRet = 27;
            break;
        case 'S':
            iRet = 28;
            break;
        case 'T':
            iRet = 29;
            break;
        case 'U':
            iRet = 30;
            break;
        case 'V':
            iRet = 31;
            break;
        case 'Y':
            iRet = 32;
            break;
        case 'Z':
            iRet = 33;
            break;
        case 'X':
            iRet = 34;
            break;
        case 'W':
            iRet = 35;
            break;
        default:
            break;
        }
        return iRet;
    }

    /**
     * 获取字符串的md5值
     * 
     * @param plainText
     * @return
     */
    private static String md5s(String plainText) {
        String str = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 获取密码的md5值
     * @param password
     * @return
     */
    private static String getPasswordMd5(String password) {
        String sKey = null;
        if (password.length() < 5) {
            logger.info("密码长度必须大于5");
        } else {
            String pass1 = password.substring(0, 2);
            String pass2 = password.substring(2, 4);
            String pass3 = password.substring(4);
            sKey = md5s(pass1) + md5s(pass2) + md5s(pass3);
        }
        return sKey;
    }
}
