package 数据结构.排序算法;

import java.util.Arrays;

/**
 * @author:sunhang
 * @className: InsertSort
 * @description:
 * @date: 2021-08-30 19:49
 * @version:0.1
 * @since: 1.8
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = {3, 44, 5, 45, 47, 34, 2, 15, 33, 19, 25, 40, 60, 4};
        System.out.println("排序之前：" + Arrays.toString(data));
        insertSort(data);
        System.out.println("排序之后：" + Arrays.toString(data));
    }
    // 插入排序
    // 两个比较后，插入到前面已经排序后合适的位置
    private static void insertSort(int[] data) {
        int length = data.length;
        for (int i = 1; i < length; i++) {
            int temp = data[i];
            int j = i-1;
            while (j>=0&&data[j]>=temp){
                // 需要执行后移操作
                data[j+1] = data[j];
                j--;
            }
            // 不满足条件时就是合适的位置
            data[j+1] = temp;
        }
    }
}
