package 数据结构.排序算法;


import java.util.Arrays;

/**
 * @author:sunhang
 * @className: BubbleSort
 * @description:
 * @date: 2021-08-30 18:34
 * @version:0.1
 * @since: 1.8
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {3, 44, 5, 45, 47, 34, 2, 15, 33, 19, 25, 40, 60, 4};
        System.out.println("排序之前：" + Arrays.toString(data));
        bubbleSort(data);
        System.out.println("排序之后：" + Arrays.toString(data));
    }

    // 冒泡排序算法
    // 比较相邻元素，进行交换
    private static void bubbleSort(int[] data) {
        int length = data.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if(data[j]>data[j+1]){
                    int temp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
