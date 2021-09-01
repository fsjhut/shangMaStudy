package 数据结构.排序算法;

import java.util.Arrays;

/**
 * @author:sunhang
 * @className: QuickSort
 * @description:
 * @date: 2021-08-30 18:35
 * @version:0.1
 * @since: 1.8
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {3, 44, 5, 45, 47, 34, 2, 15, 33, 19, 25, 40, 60, 4};
        System.out.println("排序之前：" + Arrays.toString(data));
        quickSort(data,0,data.length-1);
        System.out.println("排序之后：" + Arrays.toString(data));
    }
    // 需要使用递归进行排序
    // 将数据根据一个基准划分，前面都是小于该数的，后面都是大于该数的
    private static void quickSort(int[] data,int low,int high) {
        int i, j,temp,t;
        // 递归的退出条件
        if(low>high){
            return;
        }
        i = low;
        j = high;
        temp = data[low];
        while (i<j){
            // 在右边找到一个数比基准小的
            while (temp<data[j]&&i<j){
                j--;
            }
            // 在左边找到一个数比基准大的
            while (temp>=data[i]&&i<j){
                i++;
            }
            // 左边找了一个比基准大的，右边找到一个比基准小的
            // 进行交换
            if(i<j){
                System.out.println("交换：" + data[i]+"和"+data[j]);
                t = data[j];
                data[j] = data[i];
                data[i] = t;
                System.out.println(Arrays.toString(data));
            }
        }
        // 第一次完成后数据变成左边全比基准小，右边全比基准大
        System.out.println("基准位："+temp+"和i,j相遇的位置"+data[i]+"交换");
        data[low] = data[i];
        data[i] = temp;
        System.out.println(Arrays.toString(data));
        quickSort(data,low,j-1);
        quickSort(data,j+1,high);
    }
}
