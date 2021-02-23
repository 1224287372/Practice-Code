package com.yym.util;

public class StringUtil {

    /**
     * 自己实现去掉尾部空字符的方法
     *
     * @param s 待处理字符串
     * @return 去除尾部空字符的字符串
     */
    public static String deletTailChar0(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            Character ch = c;
            if (0 == ch.hashCode()) { //如果到了字符串结束，则跳出循环
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
