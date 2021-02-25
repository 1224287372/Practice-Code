package com.yym.practice;

import org.junit.Test;

/**
 * 常量池练习
 */
public class PracticeConstantPool {

    /**
     * 两种浮点数类型的包装类Float,Double并没有实现常量池技术。
     */
    @Test
    public void practice1() {
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);// 输出 true
        Integer i11 = 333;
        Integer i22 = 333;
        System.out.println(i11 == i22);// 输出 false
        Double i3 = 1.2;
        Double i4 = 1.2;
        System.out.println(i3 == i4);// 输出 false
    }

    @Test
    public void practice2() {
        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1 == i2);//输出 false
    }

    @Test
    public void practice3() {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2 " + (i1 == i2));
        System.out.println("i1=i2+i3 " + (i1 == i2 + i3));
        System.out.println("i1=i4 " + (i1 == i4));
        System.out.println("i4=i5 " + (i4 == i5));
        System.out.println("i4=i5+i6 " + (i4 == i5 + i6));
        System.out.println("40=i5+i6 " + (40 == i5 + i6));
    }
}
