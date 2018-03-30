package com.robustel.common.utils.date;

import com.robustel.common.utils.AppUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间帮助类
 * @author jingfangnan
 *
 */
public class TimeUtil {

    public static final String CM_LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 
     * @param date
     * @param iso
     * @return
     */
    public static String DateToString(Date date, String iso) {
        SimpleDateFormat format = new SimpleDateFormat(iso);
        return format.format(date);
    }

    /**
     * get format date 
     * @param argDate
     * @return
     */
    public static String getFormatDate(Date argDate) {
        if (argDate == null)
            return null;
        String date = TimeUtil.DateToString(argDate, TimeUtil.CM_LONG_DATE_FORMAT);
        return date;
    }

    /**
     * 日期往后推延7天
     * @return
     */
    public static Date generatorDay(Date date,int expiredDay ) {
        Calendar c = Calendar.getInstance();
        c.setTime(date); // 设置当前日期
        c.add(Calendar.DATE, expiredDay); // 日期加1
        return c.getTime();
    }

    public static Date beforeMinuteTime(Double rate) {
        if (AppUtils.isBlank(rate))
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // 设置当前时间
        c.add(Calendar.SECOND, -new Double(rate * 60).intValue()); // 日期加1
        return c.getTime();
    }

    /**
     * 获取date日期后days天的日期
     * @param date
     * @param days 如果是正整数，则为date后days天数，如果是负整数，则为date前days天数
     * @return
     * @throws ParseException 
     */
    public static Date apartDay(String date, int days) throws ParseException {

        String pattern = "yyyy-MM-dd HH:mm:ss";
        if (date.length() == 10) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(date));
        cal.add(Calendar.DAY_OF_MONTH, days);

        return cal.getTime();
    }
    
    public static boolean jecketLongTime(Long time){
    	boolean isSecond = false;
    	if(time == null)
    		return isSecond;
    	if(new Date(time).getYear() <= 70){
    		isSecond = true;
    	}
    	return isSecond;
    }

    /**
     * 将日期字符串转换为Date
     * @param dateString
     * @return
     * @throws ParseException 
     */
    public static Date string2Date(String dateString) throws ParseException {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        if (dateString.length() == 10) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateString);
    }

    public static void main(String[] args) throws ParseException {
        String deadline = "2017-07-14";
        System.out.println(apartDay(deadline, -16));
        
        Date when = new Date(1970);
        System.out.println(new Date(1504919349).getYear()<=70);
        System.out.println(new Date(1510553373000L).getYear()<=70);
        System.out.println(jecketLongTime(1510554403L));
        
        Long time = Long.parseLong("1510554403");
        System.out.println(jecketLongTime(time));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(beforeMinuteTime(5.0)));
    }
}
