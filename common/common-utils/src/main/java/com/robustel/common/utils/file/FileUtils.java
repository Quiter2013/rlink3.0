package com.robustel.common.utils.file;

import com.robustel.common.utils.scrypt.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc 文件工具类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-15
 */
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
    // 从当前系统中获取换行符，默认是"\n"
    static String lineSeparator = System.getProperty("line.separator", "\n");

    private static MessageDigest messagedigest = null;
    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            logger.info("初始化失败，MessageDigest不支持MD5Util。" + nsaex.getMessage());
        }
    }

    /**
     * @Desc 生成文件的md5校验值
     * @param fileName 文件名
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(String fileName) {
        InputStream fis = null;
        try {
            fis = new FileInputStream(new File(fileName));
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                messagedigest.update(buffer, 0, numRead);
            }
        } catch (FileNotFoundException e) {
            logger.info(String.format("找不到指定的文件:%s", fileName));
        } catch (IOException e) {
            logger.info(String.format("获取md5校验值时发生异常%s", e.getMessage()));
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    logger.info(String.format("关闭流异常:%s", e.getMessage()));
                }
            }
        }
        return FileUtilsBase.bufferToHex(messagedigest.digest());
    }

    /**
     * @Desc 向指定文件添加md5文件完整性校验位(32位)，步骤:
     * 1)获取文件的md5校验位；
     * 2)将md5校验位加密；
     * 3)将加密后的字符串追加到文件末尾(换行);
     * @param fileName 文件名
     */
    public static void addValidateFlag(String fileName) {
        // 1)获取文件的md5校验位；
        String validate = getFileMD5String(fileName);
        // 2)将md5校验位加密；
        String encryptStr = EncryptUtil.endcodingPassword(validate);
        // 3)将加密后的字符串追加到文件末尾(换行);
        addContext2FileNewLine(fileName, encryptStr);
    }

    /**
     * @Desc 监测文件的完整性,即:判断含有md5校验值的文件是否被修改过,步骤:<br/>
     * 1)获取文件最后一行的数据(加密过的md5校验值);<br/>
     * 2)获取fileName文件去除md5校验值后生成的新文件newFile;<br/>
     * 3)获取新文件newFile的md5值并加密，与1)步骤获取到的值对比;<br/>
     * 4)如果一样就返回true,不一样就返回false;<br/>
     * @param fileName 解密后的文件名
     * @return 文件完整返回true,不完整返回false
     */
    public static boolean judgeFileValid(String fileName) {
        boolean isValid = false;
        String newFileName = "tmp" + System.currentTimeMillis() + fileType(fileName);
        try {
            // 获取没有追加md5校验值的文件
            getResourceFile(fileName, newFileName);
            String flag = getFileMD5String(newFileName);

            String md5 = FileUtilsBase.getLastLineContent(new File(fileName));
            // 校验值只有前32位有效
            String integrity = md5.substring(0, 32);
            if (EncryptUtil.isGt(flag, integrity)) {
                isValid = true;
            }
        } catch (Exception e) {
            logger.info(String.format("---licesen:判断license完整性出错:%s", e.getMessage()));
        } finally {
            File temp1 = new File(newFileName);
            if (temp1.exists() && temp1.isFile()) {
                temp1.delete();
            }
        }

        return isValid;
    }

    /**
     * @Desc 获取文件类型
     * @param fileName
     * @return
     */
    public static String fileType(String fileName) {
        String type = "";
        int index = fileName.lastIndexOf(".");
        type = fileName.substring(index, fileName.length());
        return type;
    }

    /**
     * @Desc 将输入流写入指定的文件fileName，如果指定文件已存在，则替换指定文件的内容
     * @param is
     * @param fileName
     */
    public static void uploadFile(InputStream is, String fileName) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            // 如果指定的文件存在，则先删除，然后再新建
            File sourceFile = new File(fileName);
            if (sourceFile.exists() && sourceFile.isFile()) {
                sourceFile.delete();
            }
            // 新建一个空文件
            sourceFile.createNewFile();

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            // 获取输入流内容
            List<String> contents = new ArrayList<String>();
            String tmp = null;
            while ((tmp = reader.readLine()) != null) {
                contents.add(tmp);
            }
            reader.close();

            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (int i = 0; i < contents.size(); i++) {
                writer.write(contents.get(i));
                if (i != contents.size() - 1) {
                    writer.newLine();
                }
            }
            writer.flush();
        } catch (IOException e) {
            logger.info(String.format("读取流异常:%s", e.getMessage()));
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.info(String.format("关闭流异常:%s", e.getMessage()));
                }
            }
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    logger.info(String.format("关闭流异常:%s", e.getMessage()));
                }
            }
        }
    }

    /**
     * 将加密文件的输入流写入文件中
     * @param fileContents
     * @param fileName
     */
    public static void uploadEncrypFile(byte[] fileContents, String fileName) {
        FileOutputStream fos = null;
        try {
            // 如果指定的文件存在，则先删除，然后再新建
            File sourceFile = new File(fileName);
            if (sourceFile.exists() && sourceFile.isFile()) {
                sourceFile.delete();
            }

            fos = new FileOutputStream(getFile(fileName));
            fos.write(fileContents);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @Desc 获取输入流内容
     * @param is
     * @return 返回字符串
     */
    public static String getFileContent(InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        String tmp = null;

        try {
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while ((tmp = reader.readLine()) != null) {
                sb.append(tmp).append(lineSeparator);
            }
        } catch (IOException e) {
            logger.info(String.format("读取流异常:%s", e.getMessage()));
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    /**
     * @Desc 获取含有md5校验值的文件的正真内容(即：去除校验位后剩下的内容)
     * @param fileName
     * @return
     */
    public static String getFileContent(String fileName) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        String newFileName = "tmp" + System.currentTimeMillis() + fileType(fileName);

        try {
            List<String> contents = new ArrayList<String>();
            File file = getResourceFile(fileName, newFileName);
            if (file.exists() && file.isFile()) {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

                String tmp = null;
                while ((tmp = reader.readLine()) != null) {
                    contents.add(tmp);
                }

                for (int i = 0; i < contents.size(); i++) {
                    sb.append(contents.get(i));
                    if (i != contents.size() - 1) {
                        sb.append(lineSeparator);
                    }
                }
            }
        } catch (IOException e) {
            logger.info(String.format("读取流异常:%s", e.getMessage()));
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                // 删除临时文件
                File newFile = new File(newFileName);
                if (newFile.exists()) {
                    boolean isSuccess = newFile.delete();
                    logger.info(String.format("删除临时文件%s成功:%s", newFileName, isSuccess));
                }
            } catch (IOException e) {
                logger.info(String.format("关闭流异常:%s", e.getMessage()));
            }
        }
        return sb.toString();
    }

    /**
     * @Desc 获取没有追加md5校验值的文件(去除校验位),步骤:
     * 1)获取文件fileName除最后一行外的内容;
     * 2)将得到的内容生成新的文件newFileName并返回.
     * @param fileName 原文件名
     * @param newFileName 新文件名
     * @return
     */
    public static File getResourceFile(String fileName, String newFileName) {
        File file = getFile(fileName);
        File newFile = getFile(newFileName);
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            if (file.exists() && file.isFile()) {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
                List<String> list = new ArrayList<String>();
                String tmp = null;
                while ((tmp = reader.readLine()) != null) {
                    list.add(tmp);
                }
                // 删除最后一行的数据
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                }

                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFileName), "UTF-8"));
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i));
                    if (i != list.size() - 1) {
                        writer.newLine();
                    }
                }
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            logger.info(String.format("找不到指定的文件: %s", e.getMessage()));
        } catch (IOException ioe) {
            logger.info(String.format("文件操作内容失败: %s", ioe.getMessage()));
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.info(String.format("关闭流失败: %s", e.getMessage()));
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    logger.info(String.format("关闭流失败: %s", e.getMessage()));
                }
            }
        }
        return newFile;
    }

    /**
     * @Desc 向指定的文件末尾添加新一行的内容
     * @param fileName
     * @param context
     */
    public static void addContext2FileNewLine(String fileName, String context) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(FileUtils.lineSeparator);
            writer.write(context);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Desc 向指定的文件末尾写入新内容
     * @param fileName
     * @param context
     */
    public static void addContext2File(String fileName, String context) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(context);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据文件名获取文件实例
     * @param fileName 文件名
     * @return
     */
    public static File getFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                logger.info(String.format("创建文件失败:%s", e.getMessage()));
            }
        }
        return file;
    }

    public static void main(String[] args) throws IOException {
        // long begin = System.currentTimeMillis();

        // String fileName = "H:/license.rb";
        // String md5 = getFileMD5String(fileName);
        // System.out.println("文件md5为:" + md5 + ",加密之后为:" +
        // EncryptUtil.endcodingPassword(md5));
        //
        // addValidateFlag(fileName);
        // System.out.println(judgeFileValid(fileName));

        // System.out.println(getFileContent(fileName));
        //
        // System.out.println(FileUtilsBase.fileType(fileName));

        // long end = System.currentTimeMillis();
        // System.out.println("cost time:" + ((end - begin) / 1000) + "s");

        String dir = "C:\\Users\\HZJ\\Desktop\\开发";
        Set<String> result = getFileNames2Dir(dir);
        System.out.println(result.toString());
    }

    public static final byte[] input2byte(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    /**
     * 获取指定目录下的非目录的文件名
     * 
     * @param dir 目录
     * @return
     */
    public static Set<String> getFileNames2Dir(String dir) {
        Set<String> result = new HashSet<String>();
        File dirFile = new File(dir);
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            System.out.println(dir + " not exists or is invalid dir !");
        } else {
            File[] fileList = dirFile.listFiles();
            for (File file : fileList) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + " 是一个[目录]，不被获取！");
                } else {
                    result.add(file.getName());
                }
            }
        }
        return result;
    }

    /**
     * @Desc 私有内部类
     * @author HanZhijun
     * @version 1.0.0
     * @since 2017-03-17
     */
    public static class FileUtilsBase {
        /**
         * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
         */
        private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f' };

        protected static String bufferToHex(byte bytes[]) {
            return bufferToHex(bytes, 0, bytes.length);
        }

        private static String bufferToHex(byte bytes[], int m, int n) {
            StringBuffer stringbuffer = new StringBuffer(2 * n);
            int k = m + n;
            for (int l = m; l < k; l++) {
                appendHexPair(bytes[l], stringbuffer);
            }
            return stringbuffer.toString();
        }

        private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
            // 取字节中高 4 位的数字转换, >>>
            char c0 = hexDigits[(bt & 0xf0) >> 4];
            // 取字节中低 4 位的数字转换
            char c1 = hexDigits[bt & 0xf];
            stringbuffer.append(c0);
            stringbuffer.append(c1);
        }

        /**
         * @Desc 获取文件file最后一行的数据
         * @param file
         * @return 如果文件内容不为空，则返回最后一行的数据，其他返回null
         */
        public static String getLastLineContent(File file) {
            String result = null;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                List<String> list = new ArrayList<String>();
                String tmp = null;
                while ((tmp = reader.readLine()) != null) {
                    list.add(tmp);
                }
                result = list.get(list.size() - 1);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }

    }

    /**
     * 使用source2的内容替换source1内容
     * @param source1
     * @param fileContents
     */
    public static void replaceFile(String source1, byte[] fileContents) {
        uploadEncrypFile(fileContents, source1);
    }

    /** 
     * 获得指定文件的byte数组 
     */
    public static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}