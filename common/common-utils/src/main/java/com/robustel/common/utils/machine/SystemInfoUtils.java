package com.robustel.common.utils.machine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Who;

public class SystemInfoUtils {

    public static void main(String[] arguments) throws Exception {

        InetAddress ia = InetAddress.getLocalHost();// 获取本地IP对象
        System.out.println("MAC ......... " + getMACAddress(ia));

        System.out.println(getSystemInfo().toString());

        System.out.println("===================== 硬盘信息 =====================");
        List<Map<String, Object>> list = getDiskInfo();
        for (Map<String, Object> temp : list) {
            System.out.println(temp.toString());
        }

        System.out.println("===================== CPU 信息 =====================");
        System.out.println(getCpuInfo().toString());

        System.out.println("====================== WHO ========================");
        Who who = new Who();
        // who.gather(SigarUtils.sigar);
        System.out.println(who.getDevice());

        System.out.println("====================== 获取主板序列号 ========================");
        System.out.println(getMotherboardSN());

        System.out.println("====================== 获取CPU序列号 ========================");
        System.out.println(getCPU());

        System.out.println("====================== 获取磁盘标识符 ========================");
        System.out.println(getHardDiskSN("C"));
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

    // 获取MAC地址的方法
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

    /**
     * 获取当前服务器的系统信息
     * @return
     * @throws SigarException 
     */
    public static Map<String, Object> getSystemInfo() throws SigarException {
        Map<String, Object> systemInfo = new HashMap<String, Object>();
        systemInfo.putAll(getCpuInfo());
        return systemInfo;
    }

    /**
     * 获取cpu信息
     * 
     * @return
     * @throws SigarException
     */
    public static Map<String, Object> getCpuInfo() throws SigarException {
        Map<String, Object> cpuInfo = new HashMap<String, Object>();
        // CPU的总量（单位：HZ）及CPU的相关信息
        Sigar sigar = SigarUtils.sigar;
        CpuInfo infos[] = sigar.getCpuInfoList();
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
            CpuInfo info = infos[i];
            // CPU的总量MHz
            cpuInfo.put("mhz", info.getMhz());
            // 获得CPU的卖主，如：Intel
            cpuInfo.put("vendor", info.getVendor());
            // 获得CPU的类别，如：Celeron
            cpuInfo.put("model", info.getModel());
            // 缓冲存储器数量
            cpuInfo.put("cacheSize", info.getCacheSize());
            // 缓冲存储器数量
            cpuInfo.put("cacheSize", info.getCacheSize());
        }
        return cpuInfo;
    }

    /**
     * 获取磁盘信息
     * @return
     * @throws SigarException 
     */
    public static List<Map<String, Object>> getDiskInfo() {
        List<Map<String, Object>> diskInfos = new ArrayList<Map<String, Object>>();
        try {
            Sigar sigar = SigarUtils.sigar;
            FileSystem fslist[] = sigar.getFileSystemList();
            for (int i = 0; i < fslist.length; i++) {
                Map<String, Object> diskInfo = new HashMap<String, Object>();
                // 当前用户文件夹路径
                diskInfo.put("user.home", System.getProperty("user.home"));

                FileSystem fs = fslist[i];
                // 分区的盘符名称
                diskInfo.put("devName", fs.getDevName());
                // 分区的盘符名称
                diskInfo.put("dirName", fs.getDirName());
                diskInfo.put("serial", getHDSerial(fs.getDirName()));
                diskInfo.put("flags", fs.getFlags());
                // 文件系统类型，比如 FAT32、NTFS
                diskInfo.put("sysTypeName", fs.getSysTypeName());
                // 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
                diskInfo.put("typeName", fs.getTypeName());
                // 文件系统类型
                diskInfo.put("type", fs.getType());
                FileSystemUsage usage = null;
                try {
                    usage = sigar.getFileSystemUsage(fs.getDirName());
                } catch (SigarException e) {
                    if (fs.getType() == 2) {
                        throw e;
                    }
                    continue;
                }
                switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    // 文件系统总大小
                    diskInfo.put("total", usage.getTotal() + "KB");
                    // 文件系统剩余大小
                    diskInfo.put("free", usage.getFree() + "KB");
                    // 文件系统可用大小
                    diskInfo.put("avail", usage.getAvail() + "KB");
                    // 文件系统已经使用量
                    diskInfo.put("used", usage.getUsed() + "KB");
                    // 文件系统资源的利用率
                    double usePercent = usage.getUsePercent() * 100D;
                    diskInfo.put("usage", usePercent + "%");
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
                default:
                    break;
                }
                diskInfo.put("diskReads", usage.getDiskReads());
                diskInfo.put("diskWrites", usage.getDiskWrites());

                diskInfos.add(diskInfo);
            }
        } catch (Exception e) {

        }
        return diskInfos;
    }

    private static String getHDSerial(String drive) {
        String result = "";
        try {
            File file = File.createTempFile("tmp_02", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    + "Set colDrives = objFSO.Drives\n" + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                    + "Wscript.Echo objDrive.SerialNumber";
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
            file.delete();
        } catch (Exception e) {
        }
        if (result.trim().length() < 1 || result == null) {
            result = "";
        }
        return result.trim();
    }

    /**
    * 获取主板序列号
    * 
    * @return
    */
    public static String getMotherboardSN() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);

            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n" + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n" + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }

    public static String getCPU() {
        Process process;
        String serial = null;

        try {
            process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
            process.getOutputStream().close();

            @SuppressWarnings("resource")
            Scanner sc = new Scanner(process.getInputStream());
            serial = sc.next();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serial;
    }

    /**
     * 磁盘序列号
     * @param drive
     * @return
     */
    public static String getHardDiskSN(String drive) {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    + "Set colDrives = objFSO.Drives\n" + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                    + "Wscript.Echo objDrive.SerialNumber"; // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }
}
