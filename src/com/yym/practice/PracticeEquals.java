package com.yym.practice;

import org.junit.Test;

/**
 * equals练习
 */
public class PracticeEquals {

    /**
     * ==和equals的区别
     */
    @Test
    public void practice1() {
        String a = new String("ab"); // a 为⼀个引⽤
        String b = new String("ab"); // b为另⼀个引⽤,对象的内容⼀样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，⾮同⼀对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
    }
}
