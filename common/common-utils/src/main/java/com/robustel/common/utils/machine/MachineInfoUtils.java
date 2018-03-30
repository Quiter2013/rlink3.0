package com.robustel.common.utils.machine;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * 服务器信息
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-07-20
 */
public class MachineInfoUtils {
    public static void main(String[] args) {
        System.out.println(getMachineInfo().toString());
        // print();
    }

    /**
     * 获取机器信息
     * 
     * @return
     */
    public static Map<String, Object> getMachineInfo() {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Properties properties = System.getProperties();

        // Operating system name
        String os_name = properties.getProperty("os.name");
        data.put("os.name", os_name);

        // Operating system version
        String os_version = properties.getProperty("os.version");
        data.put("os.version", os_version);

        // os encoding
        String os_encoding = properties.getProperty("sun.jnu.encoding");
        data.put("sun.jnu.encoding", os_encoding);

        // CPU
        String sun_cpu_isalist = properties.getProperty("sun.cpu.isalist");
        data.put("sun.cpu.isalist", sun_cpu_isalist);

        // Java Runtime Environment version
        String java_version = properties.getProperty("java.version");
        data.put("java.version", java_version);

        // Java Runtime Environment vendor
        String java_vendor = properties.getProperty("java.vendor");
        data.put("java.vendor", java_vendor);

        // Java vendor URL
        String java_vendor_url = properties.getProperty("java.vendor.url");
        data.put("java.vendor.url", java_vendor_url);

        // Java installation directory
        String java_home = properties.getProperty("java.home");
        data.put("java.home", java_home);

        // Java class path
        // String java_class_path = properties.getProperty("java.class.path");
        // data.put("java.class.path", java_class_path);

        // sun.desktop
        String sun_desktop = properties.getProperty("sun.desktop");
        data.put("sun.desktop", sun_desktop);

        // MAC
        String mac = getLocalPcMac();
        data.put("mac", mac);

        return data;
    }

    public static void print() {
        Properties properties = System.getProperties();
        Iterator<Entry<Object, Object>> it = properties.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Object, Object> en = it.next();
            String key = en.getKey().toString();
            System.out.println(key + " --" + properties.getProperty(key));
        }
    }

    /**
     * 获取本机的mac地址
     * @return
     */
    public static String getLocalPcMac() {
        String mac = null;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            mac = getMACAddress(ia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mac;
    }

    /**
     * 获取MAC地址的方法
     * @param ia
     * @return
     * @throws Exception
     */
    public static String getMACAddress(InetAddress ia) throws Exception {
        // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

        // 下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }
            // mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length() == 1 ? 0 + s : s);
        }

        // 把字符串所有小写字母改为大写成为正规的mac地址并返回
        return sb.toString().toUpperCase();
    }
}
