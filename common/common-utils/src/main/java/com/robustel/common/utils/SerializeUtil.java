package com.robustel.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 序列化与反序列化
 * @author gaolinlou
 * @time 2016年4月7日 下午4:00:41
 */
public class SerializeUtil {

    private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);

    /**
     * 序列化操作
     * 功能详细描述
     * @param  object 需要序列化的对象
     * @return byte[]	序列化返回的字节数组
     * @exception/throws [违例类型] [违例说明]
     * @see   [类、类#方法、类#成员]
     * @author gaolinlou
     * @time 2016年4月7日 下午4:00:43
     * @update 2016年4月7日 下午4:00:43
     */
    public static byte[] serialize(Object object) {
        if (null == object)
            return null;
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     * @param  bytes 序列化的字节数组
     * @return Object	[返回类型说明]
     * @exception/throws [违例类型] [违例说明]
     * @see   [类、类#方法、类#成员]
     * @author gaolinlou
     * @time 2016年4月7日 下午4:01:39
     * @update 2016年4月7日 下午4:01:39
     */
    public static Object unserialize(byte[] bytes) {
        if (null == bytes)
            return null;
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Desc 将对象实例obj序列化到指定文件file
     * @param file
     * @param obj
     */
    public static void Serialize(File file, Object obj) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.info("找不到 " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param file
     * @param clazz
     * @return
     */
    public static Object deserialization(File file) {
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            logger.error("找不到 " + file.getAbsolutePath());
        } catch (IOException ioe) {
            logger.info(String.format("发生IOException，信息是%", ioe.getMessage()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.info(String.format("发生ClassNotFoundException异常，信息是%", e.getMessage()));
        }

        return obj;
    }
}
