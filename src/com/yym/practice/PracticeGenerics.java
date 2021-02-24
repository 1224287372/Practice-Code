package com.yym.practice;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
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
        //创建不同类型数组：Integer, Double和Character
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        printArray(intArray);
        printArray(stringArray);
    }

    /**
     * 泛型方法
     */
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.println(element);
        }
        System.out.println();
    }

    /**
     * 证明Java类型的类型擦除1
     */
    @Test
    public void practice7() {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass());
        /*在这个例子中，我们定义了两个ArrayList数组，不过一个是ArrayList<String>泛型类型的，只能存储字符串；一个是ArrayList<Integer>泛型
        类型的，只能存储整数，最后，我们通过list1对象和list2对象的getClass()方法获取他们的类的信息，最后发现结果为true。说明泛型类型String
        和Integer都被擦除掉了，只剩下原始类型。*/
    }

    /**
     * 证明Java类型的类型擦除2
     *
     * @throws Exception
     */
    @Test
    public void practice8() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer
        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        /*在程序中定义了一个ArrayList泛型类型实例化为Integer对象，如果直接调用add()方法，那么只能存储整数数据，不过当我们利用反射调用add()方
        法的时候，却可以存储字符串，这说明了Integer泛型实例在编译之后被擦除掉了，只保留了原始类型。*/
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x, T y) {
        return y;
    }

    /**
     * 类型擦除后保留的原始类型
     */
    @Test
    public void practice9() {
        /**不指定泛型的时候*/
        int i = PracticeGenerics.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        System.out.println(i);
        Number f = PracticeGenerics.add(1, 1.2); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        System.out.println(f);
        Object o = PracticeGenerics.add(1, "asd"); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object
        System.out.println(o);

        /**指定泛型的时候*/
        int a = PracticeGenerics.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
        System.out.println(a);
        //int b = PracticeGenerics.<Integer>add(1, 2.2); //编译错误，指定了Integer，不能为Float
        Number c = PracticeGenerics.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
        System.out.println(c);
    }

    /**
     * Object泛型
     */
    @Test
    public void practice10() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("121");
        list.add(new Date());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        /*其实在泛型类中，不指定泛型的时候，也差不多，只不过这个时候的泛型为Object，就比如ArrayList中，如果不指定泛型，那么这个ArrayList
        可以存储任意的对象。*/
    }

    /**
     * Java编译器是通过先检查代码中泛型的类型，然后在进行类型擦除，再进行编译。
     */
    @Test
    public void practice11() {
        ArrayList<String> list1 = new ArrayList();
        list1.add("1"); //编译通过
        //list1.add(1); //编译错误
        String str1 = list1.get(0); //返回类型就是String

        ArrayList list2 = new ArrayList<String>();
        list2.add("1"); //编译通过
        list2.add(1); //编译通过
        Object object = list2.get(0); //返回类型就是Object

        new ArrayList<String>().add("11"); //编译通过
        //new ArrayList<String>().add(22); //编译错误

        String str2 = new ArrayList<String>().get(0); //返回类型就是String
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

/**
 * 泛型在静态方法和静态类中的问题
 *
 * @param <T>
 */
class Test2<T> {
//    泛型类中的静态方法和静态变量不可以使用泛型类所声明的泛型类型参数
//    public static T one;   //编译错误
//
//    public static T show(T one) { //编译错误
//        return null;
//    }

    //因为这是一个泛型方法，在泛型方法中使用的T是自己在方法中定义的 T，而不是泛型类中的T。
    public static <T> T show(T one) { //这是正确的
        return null;
    }
}