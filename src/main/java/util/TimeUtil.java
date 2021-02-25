package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtil {

    public static String date(String fmt) {
        return new SimpleDateFormat(fmt).format(new Date());
    }

    public static String date(String fmt, long t) {
        return new SimpleDateFormat(fmt).format(new Date(t));
    }
    public static String date(String fmt, Date date) {
        return new SimpleDateFormat(fmt).format(date);
    }
    public static String date8() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String date8(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }
    public static String date8(Timestamp date) {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }
    public static String date10(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    public static String date10other(Date date) {
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }
    public static String time6() {
        return new SimpleDateFormat("HHmmss").format(new Date());
    }
    public static String time8(Date date) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    public static String time6(Date date) {
        return new SimpleDateFormat("HHmmss").format(date);
    }
    public static String time6(Timestamp date) {
        return new SimpleDateFormat("HHmmss").format(date);
    }

    public static String datetime14() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String datetime14(Date date) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }

    public static String datetime14(long t) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(t));
    }

    public static long toMilliSec(String time14) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(time14.substring(0, 4)), Integer
                        .parseInt(time14.substring(4, 6)) - 1, Integer.parseInt(time14
                        .substring(6, 8)), Integer.parseInt(time14.substring(8, 10)),
                Integer.parseInt(time14.substring(10, 12)), Integer
                        .parseInt(time14.substring(12, 14)));
        return cal.getTimeInMillis();
    }

    public static int getActualMaximum(String day8, int field) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(day8.substring(0, 4)), Integer.parseInt(day8
                .substring(4, 6)) - 1, Integer.parseInt(day8.substring(6, 8)));
        return cal.getActualMaximum(field);
    }

    public static int getActualMinimum(String day8, int field) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(day8.substring(0, 4)), Integer.parseInt(day8
                .substring(4, 6)) - 1, Integer.parseInt(day8.substring(6, 8)));
        return cal.getActualMinimum(field);
    }
    /**
     *
     * description: 获得当天是当年的第几周
     * @return
     */
    public static int getWeekIndex(){
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return c.get(Calendar.WEEK_OF_YEAR);
    }
    /**
     *
     * description: 在now基础上增加amount分钟
     * @param now
     * @param amount
     * @return
     */
    public static Date addMin(Date now, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, amount);
        return cal.getTime();
    }
    /**
     *
     * description: 在now基础上增加amount秒
     * @param now
     * @param amount
     * @return
     */
    public static Date addSec(Date now, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.SECOND, amount);
        return cal.getTime();
    }
    /**
     *
     * description: 在now基础上增加amount个日
     * @param now
     * @param amount
     * @return
     */
    public static Date addDay(Date now, int amount){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, amount);
        return cal.getTime();
    }
    /**
     *
     * description: 在now基础上增加amount个月
     * @param now
     * @param amount
     * @return
     */
    public static Date addMonth(Date now, int amount){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }
    /**
     *
     * description: 在now基础上增加amount个年
     * @param endDate
     * @param amount
     * @return
     */
    public static Date addYear(Date now, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.YEAR, amount);
        return cal.getTime();
    }
    /**
     *
     * description: 将8位的日期文本解析成Date
     * @param date 待解析的日期文本
     * @return
     */
    public static Date parseDate8(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            format.setLenient(false);
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     *
     * description: 校验date是否是合法的8位日期
     * @param date
     * @return 若合法返回true，否则返回false
     */
    public static boolean validateDate8(String date){
        Date d = parseDate8(date);
        return d != null && date8(d).equals(date);
    }

    /**
     * 校验14位时间日期格式
     * @param date
     * @return
     */
    public static boolean validateDateTime14(String date) {
        Date d = parseDatetime14(date);
        return d != null && datetime14(d).equals(date);
    }

    /**
     *
     * description: 将14位的日期时间字符串解析成Date
     * @param date 待解析的日期文本
     * @return
     */
    public static Date parseDatetime14(String datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            format.setLenient(false);
            return format.parse(datetime);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     *
     * description: 将8位的日期时间字符串解析成Date
     * @param date 待解析的日期文本
     * @return
     */
    public static Date parseDatetime6(String datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HHmmss");
            format.setLenient(false);
            return format.parse(datetime);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     *
     * description: 将6位的时间文本解析成Date
     * @param date 待解析的日期文本
     * @return
     */
    private static Date parseTime6(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HHmmss");
            format.setLenient(false);
            return format.parse(time);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     *
     * description: 校验time是否是合法的6位时间
     * @param time
     * @return 若合法返回true，否则返回false
     */
    public static boolean validateTime6(String time){
        Date d = parseTime6(time);
        return d != null && time6(d).equals(time);
    }
    /**
     *
     * description: 返回date是一周的第几天。周日：0，周一：1，周六：6
     * @param string
     * @return
     */
    public static int getDayOfWeek(String date) {
        Date day = parseDate8(date);
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }
    /**
     *
     * description: 返回d1-d2之间相差多少分钟
     * @param d1
     * @param d2
     * @return
     */
    public static int diffInMin(Date d1, Date d2){
        long t1 = d1.getTime();
        long t2 = d2.getTime();
        double unit = 60 * 1000;
        int absDiff = (int)Math.ceil(Math.abs((t1-t2))/unit);
        if(t1 > t2)
            return absDiff;
        else
            return -absDiff;
    }
    /**
     *
     * description: 返回d1-d2之间相差多少分钟
     * @param d1
     * @param d2
     * @return
     */
    public static int diffInSec(Date d1, Date d2){
        long t1 = d1.getTime();
        long t2 = d2.getTime();
        double unit = 1000;
        int absDiff = (int)Math.ceil(Math.abs((t1-t2))/unit);
        if(t1 > t2)
            return absDiff;
        else
            return -absDiff;
    }
    /**
     *
     * description: 将beginDate，endDate之间的时间按照interval切片
     * @param beginDate
     * @param endDate
     * @param interval_sec, 以秒为单位
     * @return 切成的小片时间, 每片时间形式为[begin, end]
     */
    public static List<Date[]> slice(Date beginDate, Date endDate, int interval_sec){
        List<Date[]> pieces = new ArrayList<Date[]>();
        while(beginDate.compareTo(endDate) <=0){
            Date nextEndDate = addSec(beginDate, interval_sec);
            if(nextEndDate.after(endDate))
                nextEndDate = endDate;
            Date[] piece = new Date[2];
            piece[0] = beginDate;
            piece[1] = nextEndDate;
            pieces.add(piece);
            beginDate = addSec(nextEndDate, 1);
        }
        return pieces;
    }

    public static void main(String[] args) {
        String dateTime = "20170515121300";

        System.out.println(validateDateTime14(dateTime));

        dateTime = "2017051512130";

        System.out.println(validateDateTime14(dateTime));

        dateTime = "201705151213008";

        System.out.println(validateDateTime14(dateTime));

        dateTime = "20170535131300";

        System.out.println(validateDateTime14(dateTime));

    }
}