package 数据结构.排序算法;

import java.util.Arrays;

/**
 * @author:sunhang
 * @className: MergeSort
 * @description:
 * @date: 2021-08-30 18:35
 * @version:0.1
 * @since: 1.8
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {3, 44, 5, 45, 47, 34, 2, 15, 33, 19, 25, 40, 60, 4};
        System.out.println("排序之前：" + Arrays.toString(data));
        mergeSort(data);
        System.out.println("排序之后：" + Arrays.toString(data));
    }

    private static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int l, int r) {
        // 递归结束条件
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(data, l, mid);
        sort(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    private static void merge(int[] data, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        // 比较左右两部分元素，哪个小 ，填入到temp中
        while (p1 <= mid && p2 <= r) {
            temp[i++] = data[p1] < data[p2] ? data[p1++] : data[p2++];
        }
        // 循环退出后将剩余元素填入到temp中
        while (p1 <= mid) {
            temp[i++] = data[p1++];
        }
        while (p2 <= r) {
            temp[i++] = data[p2++];
        }
        for (i = 0; i < temp.length; i++) {
            data[l + i] = temp[i];
        }
    }
}
