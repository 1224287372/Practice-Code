package com.yym.nba2K;

public class GenerationYear {

    public void test() {

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double d = Math.random();
        int i = (int) (d * 123);
        System.out.println(i);

        int[] Past = {16, 17, 18, 19, 80, 89, 82, 84, 98, 87, 99, 7, 70, 8, 65, 4, 81, 86, 95, 97};
        int[] Now = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 99, 98, 97, 96, 95, 94, 93,
                92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 70, 69, 65, 60, 19, 18, 17,
                16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89,
                88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3,
                2, 1, 98, 97, 96, 95, 93, 92, 89, 85, 84, 82, 79, 78};

        System.out.println("总长度：" + Now.length);

        while (Judge(Now[i], Past)) {
            System.out.println("本次已存在，编号为：" + i + " 年代为：" + Now[i]);
            d = Math.random();
            i = (int) (d * 123);
        }

        System.out.println("成功生成年代，标号为：" + i + " 年代为：" + Now[i]);

    }

    public static boolean Judge(int a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (a == b[i])
                return true;
        }
        return false;
    }
}
