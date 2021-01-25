package com.yym.niuke;

import java.util.Scanner;

public class NC105 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] ss = s.split(",");
//        处理输入数据
        ss[2] = ss[2].substring(1);
        ss[ss.length - 1] = ss[ss.length - 1].substring(0, ss[ss.length - 1].length() - 1);
//        for(String sss : ss){
//            System.out.println(sss);
//        }
        int n = Integer.parseInt(ss[0]);
        int v = Integer.parseInt(ss[1]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ss[i + 2]);
        }
//        for(int x : a){
//            System.out.println(x);
//        }

        System.out.println(upper_bound_(n, v, a));
    }

    public static int upper_bound_(int n, int v, int[] a) {
        int left = 0, right = n - 1;
        if (a[n - 1] <= v) {
            return n + 1;
        }
        if (a[0] > v) {
            return 1;
        }
        while (true) {
            int mid = (right + left) / 2;
            if (left == mid) {
                return right + 1;
            }
            if (a[mid] < v) {
                left = mid;
            } else if (a[mid] >= v) {
                right = mid;
            }

        }

    }
}
