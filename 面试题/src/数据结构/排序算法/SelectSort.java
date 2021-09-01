package 数据结构.排序算法;

import java.util.Arrays;

/**
 * @author:sunhang
 * @className: SelectSort
 * @description:
 * @date: 2021-08-30 19:33
 * @version:0.1
 * @since: 1.8
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] data = {3, 44, 5, 45, 47, 34, 2, 15, 33, 19, 25, 40, 60, 4};
        System.out.println("排序之前：" + Arrays.toString(data));
        selectSort(data);
        System.out.println("排序之后：" + Arrays.toString(data));
    }

    // 选择排序
    // 每次比较两个，比较后不要交换，找到最小的后放入第一个位置
    private static void selectSort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = data[i];
            int index = i;
            for (int j = i; j < length; j++) {
                if (data[j] < temp) {
                    temp = data[j];
                    index = j;
                }
            }
            // 交换
            int temp2 = data[i];
            data[i] = temp;
            data[index] = temp2;
        }
    }
}
