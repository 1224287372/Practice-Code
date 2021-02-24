package com.yym.practice;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型练习
 */
public class PracticeGenerics {
    @Test
    public void practice1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //这里直接添加会报错
        //list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list, "kl");

        System.out.println(list);
        practice2();
    }

    /**
     * 实例化泛型类
     */
    @Test
    public void practice2() {
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        System.out.println(genericInteger.getKey());
    }

    /**
     * 实现泛型接口，不指定类型
     */
    @Test
    public void practice3() {
        class GeneratorImpl<T> implements Generator<T> {
            @Override
            public T method() {
                return null;
            }
        }
    }

    /**
     * 实现泛型接口，指定类型
     */
    @Test
    public void practice4() {
        class GeneratorImpl<T> implements Generator<String> {
            @Override
            public String method() {
                return "hello";
            }
        }
    }

    @Test
    public void practice5() {
        class GeneratorImpl1<T> implements Generator<String> {
            @Override
            public String method() {
                return "hello";
            }
        }
        class GeneratorImpl2 implements Generator<String> {
            @Override
            public String method() {
                return "hello";
            }
        }

        GeneratorImpl1 imp1 = new GeneratorImpl1();
        GeneratorImpl2 imp2 = new GeneratorImpl2();
        System.out.println(imp1.method());
        System.out.println(imp2.method());
    }

    /**
     * 泛型方法
     */
    @Test
    public void practice6() {
//        public staric<E> void printArray(E[] inputArray){
//
//        }
    }
}

/**
 * 泛型类
 *
 * @param <T>
 */
//此处T可以随便写为任意标识符，常见的如T、E、k、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}

/**
 * 泛型接口
 *
 * @param <T>
 */
interface Generator<T> {
    public T method();
}