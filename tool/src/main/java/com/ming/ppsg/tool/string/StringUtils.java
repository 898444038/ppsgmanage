package com.ming.ppsg.tool.string;

public class StringUtils {
    public static boolean isEmpty(final CharSequence cs){
        return cs == null || cs.length() == 0;
    }
    public static boolean isNotEmpty(final CharSequence cs){
        return !isEmpty(cs);
    }

    /**
     * 判空操作
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }
}
