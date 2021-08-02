package com.javasm;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author SunHang
 * @className: JavaTest
 * @description:
 * @createTime 2021/7/15 19:17
 */
public class JavaTest {
    @Test
    public void test1() {
        short a = 100;
        byte b = 100;
        Integer c = 110;
        byte m = 127;
        m += 1;
        System.out.println(m);

//        System.out.println(c==d);
        System.out.println(a + b);
    }

    @Test
    public void test2() {
//        System.out.println(((100<20)&&(100/0>1)));
//        System.out.println(((100<20)&(100/0>1)));
//        System.out.println(c==d);
//        System.out.println(a+b);
        byte a = 100;
        short b = 10;
        short c = (a > b) ? a : b;
        System.out.println(c);
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
    }

    @Test
    public void test3() {
//        手写一个冒泡排序
        int[] array = new int[]{4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22};
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int temp;
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test4() {
        // 选择排序算法
        // 选择排序：每论找出最大的数的索引，然后与最后一个交换
        int[] array = new int[]{4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22};
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int index = len - i - 1;
            int temp;
            int max = array[len - i - 1];
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > max) {
                    max = array[j];
                    index = j;
                }
            }
            temp = array[len - i - 1];
            array[len - i - 1] = max;
            array[index] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test5() {
        // 选择排序算法
        // 选择排序：每论找出最小的数的索引，然后与最后一个交换
        int[] array = new int[]{4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22};
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int index = i;
            int temp;
            int min = array[i];
            for (int j = i; j < len; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = min;
            array[index] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test6() {
        // 插入排序
        // 假定左侧元素有序，然后将一个元素a从右到左比较
        // 如果a比较小，则将比其大的右移，
        // 如果a比较大，则插入。
        int[] array = new int[]{-10, 4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22, -4};
        int len = array.length;
        int j = 0;
        int k = 0;
        for (int i = 0; i < len; i++) {
            j = k;
            int temp = array[i];
            while (j > 0 && array[j - 1] > temp) {
                // 不满足条件的需要右移
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
            k++;
        }
        System.out.println(Arrays.toString(array));

    }

    @Test
    public void test7() {
        // 插入排序
        // 假定左侧元素有序，然后将一个元素a从右到左比较
        // 如果a比较小，则将比其大的右移，
        // 如果a比较大，则插入。
        int[] array = new int[]{-10, 4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22, -4};
        int len = array.length;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int temp = array[i];
            while (j >= 0 && array[j] > temp) {
                // 不满足条件的需要右移
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    ////    @Test
//    public int test8(int[] array,int i,int j){
//        // 快速排序
//        // 找一个基准，然后从左右开始交换
//        int x = array[i];
//        while (i<j){
//            // 从后向前找
//            while (i<j && array[j]>=x){
//                j--;
//            }
//            if(i<j){
//                array[i] = array[j];
//                i++;
//            }
//            // 从前向后找
//            while (i<j && array[i]<x){
//                i++;
//            }
//            if(i<j){
//                array[j] = array[i];
//                j--;
//            }
//        }
//        array[i] = x;
//        System.out.println(Arrays.toString(array));
//        return i;
//    }
//
////    @Test
//    public void test9(int[] array,int i,int j){
//        // 如何实现递归的操作呢？
//        if(i<j){
//            int m = test8(array, i, j);//先成挖坑填数法调整s[]
//            test9(array, i, m - 1); // 递归调用
//            test9(array, m + 1, j);
//        }
//
//    }
    void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]);
            //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j) {
                    s[i++] = s[j];
                }
                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

    @Test
    public void test10() {
        int[] array = new int[]{5, -10, 4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22, -4};
//        test9(array,0,array.length-1);
        quick_sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort() {
        int[] array = new int[]{5, -10, 4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22, -4};
        int len = array.length;
        int left = 0;
        int right = len / 2;
        while (array[left] < array[right]) {
            left++;
        }
//        while (array[])
    }

    @Test
    public void test11() {
        int[] array = new int[]{5, -10, 4, 2, 3, 6, 3, 7, 9, 10, 8, -1, 99, 22, -4};
    }

    @Test
    public void test12() {
        int[] s = new int[]{1, 2, 8, 9, 11, 12, -3, 1, 7, 10, 14, 20};
        int l = 0;
        int r = 6;
        int len = s.length;
        int k = 0;
        int[] n = new int[len];
        while (l < 6 && r < 12) {
            int temp = s[l];
            while (s[r] < temp) {
                n[k] = s[r];
                r++;
                k++;
            }
            n[k] = temp;
            k++;
            l++;

            temp = s[r];
            while (s[l] < temp && l < 6) {
                n[k] = s[l];
                l++;
                k++;
            }
            n[k] = temp;
            k++;
            r++;
        }
        System.out.println(Arrays.toString(n));

    }

    public void mergeTest(int[] s, int[] n, int l, int r) {
        int k = 0;
        int m = r;
        while (l < m && r < s.length) {
//            int temp = s[l];
            while (s[r] < s[l] && r < s.length) {
                n[k++] = s[r++];
            }
            n[k++] = s[l++];
            while (s[l] < s[r] && l < m) {
                n[k++] = s[l++];
            }
            n[k++] = s[r++];
        }
        while (l < m) {//将左边剩余元素填充进temp中
            n[k++] = s[l++];
        }
        while (r < s.length) {//将右序列剩余元素填充进temp中
            n[k++] = s[r++];
        }
        System.arraycopy(n, 0, s, 0, s.length);
    }

    public void mergeTest2(int[] s, int[] n, int l, int m, int r) {
        int k = 0;
        int i = l;//左序列指针
        int j = m + 1;//右序列指针
//        int m = r;
        while (i <= m && j <= r) {
            if (s[i] <= s[j]) {
                n[k++] = s[i++];
            } else {
                n[k++] = s[j++];
            }
        }
        while (i <= m) {//将左边剩余元素填充进temp中
            n[k++] = s[i++];
        }
        while (j <= r) {//将右序列剩余元素填充进temp中
            n[k++] = s[j++];
        }
        k = 0;
        while (l <= r) {
            s[l++] = n[k++];
        }
    }

    @Test
    public void test13() {
        int[] s = new int[]{1, 2, 3, 9, 10, 70, 100, -3, 1, 7, 10, 14, 50};
        int[] n = new int[s.length];
        //r:另一个有序序列的开始的索引
//        mergeTest2(s, n, 0, 7);
        System.out.println(Arrays.toString(n));
    }

    public void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
//            int[] s, int[] n, int l, int r
            mergeTest2(arr, temp, left, mid, right);//将两个有序子数组合并操作
        }
    }

    public void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test16() {
        int[] arr = {9, 8, 7, 0, 6};
        sort(arr);
        System.out.println(arr.toString());
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test17(){
        String s = String.valueOf(10);
        Integer i = Integer.parseInt("150");
        Integer j = Integer.parseInt("150");
        Integer integer = Integer.valueOf(100);
        System.out.println(i==j);
        Integer.parseInt("150");
        int i1 = Character.charCount(150);
        System.out.println(i1);
//        Character.toUpperCase();
        int d = Character.getNumericValue('m');
        System.out.println(d);
        System.out.println(Math.random());
        int round = Math.round(20);
        System.out.println(round);
//        i.wait(100);
        Class<String> stringClass = String.class;
//        Class<? extends JavaTest> aClass = getClass(String);
//        Class.forName()
        Charset charset = Charset.forName("utf-8");
        System.out.println(charset);
        byte[] bytes = "尚马教育".getBytes();
        System.out.println(Arrays.toString(bytes));
        String a = new String(bytes,Charset.forName("utf-16"));
        System.out.println(a);
    }
    @Test
    public void test18(){
        String str = "bca12a33a44";
        //通过a进行分割
        String[] split = str.split("a", -4);
        System.out.println(Arrays.toString(split));
    }
}
