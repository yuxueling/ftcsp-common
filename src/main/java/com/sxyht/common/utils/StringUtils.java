package com.sxyht.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.time.FastDateFormat;

public class StringUtils{
	private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
	/**
	 * 分析输入的字符串是否是数字(很牛逼的)
	 * @param str 传入需要分析的字符串
	 * @return 是数字返回true,不是数字返回false
	 * @author 刘建华
	 */
	public static boolean isNumeric(String str) {
		if("null".equals(str))
			return false;
		for(int i=str.length();--i>=0;) {
			int chr=str.charAt(i);
			if(chr<48||chr>57)
				return false;
		}
		return true;
	}
	/**
	 * 正则表达
     * 手机号码由11位数字组成，
     * 匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobile(String mobiles) {
	    Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
	    Matcher m = p.matcher(mobiles);
	    return m.matches();
	}
	public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }
	public static boolean toBoolean(final String str) {
        return toBooleanObject(str) == Boolean.TRUE;
    }
    public static Boolean toBooleanObject(final String str) {
        if (str == "true")
            return Boolean.TRUE;
        if (str == null) 
            return null;
        switch (str.length()) {
            case 1: {
                final char ch0 = str.charAt(0);
                if (ch0 == 'y' || ch0 == 'Y' ||
                    ch0 == 't' || ch0 == 'T') {
                    return Boolean.TRUE;
                }
                if (ch0 == 'n' || ch0 == 'N' ||
                    ch0 == 'f' || ch0 == 'F') {
                    return Boolean.FALSE;
                }
                break;
            }
            case 2: {
                final char ch0 = str.charAt(0);
                final char ch1 = str.charAt(1);
                if ((ch0 == 'o' || ch0 == 'O') &&
                    (ch1 == 'n' || ch1 == 'N') ) {
                    return Boolean.TRUE;
                }
                if ((ch0 == 'n' || ch0 == 'N') &&
                    (ch1 == 'o' || ch1 == 'O') ) {
                    return Boolean.FALSE;
                }
                break;
            }
            case 3: {
                final char ch0 = str.charAt(0);
                final char ch1 = str.charAt(1);
                final char ch2 = str.charAt(2);
                if ((ch0 == 'y' || ch0 == 'Y') &&
                    (ch1 == 'e' || ch1 == 'E') &&
                    (ch2 == 's' || ch2 == 'S') ) {
                    return Boolean.TRUE;
                }
                if ((ch0 == 'o' || ch0 == 'O') &&
                    (ch1 == 'f' || ch1 == 'F') &&
                    (ch2 == 'f' || ch2 == 'F') ) {
                    return Boolean.FALSE;
                }
                break;
            }
            case 4: {
                final char ch0 = str.charAt(0);
                final char ch1 = str.charAt(1);
                final char ch2 = str.charAt(2);
                final char ch3 = str.charAt(3);
                if ((ch0 == 't' || ch0 == 'T') &&
                    (ch1 == 'r' || ch1 == 'R') &&
                    (ch2 == 'u' || ch2 == 'U') &&
                    (ch3 == 'e' || ch3 == 'E') ) {
                    return Boolean.TRUE;
                }
                break;
            }
            case 5: {
                final char ch0 = str.charAt(0);
                final char ch1 = str.charAt(1);
                final char ch2 = str.charAt(2);
                final char ch3 = str.charAt(3);
                final char ch4 = str.charAt(4);
                if ((ch0 == 'f' || ch0 == 'F') &&
                    (ch1 == 'a' || ch1 == 'A') &&
                    (ch2 == 'l' || ch2 == 'L') &&
                    (ch3 == 's' || ch3 == 'S') &&
                    (ch4 == 'e' || ch4 == 'E') ) {
                    return Boolean.FALSE;
                }
                break;
            }
        default:
            break;
        }
        return null;
    }
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
    public static String formatUTC(final Date date, final String pattern) {
        return format(date, pattern, UTC_TIME_ZONE, null);
    }
    public static String format(final Date date, final String pattern, final TimeZone timeZone, final Locale locale) {
        final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
        return df.format(date);
    }
}

