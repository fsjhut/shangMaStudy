package 数据结构.查找算法;

import java.util.ArrayList;

/**
 * @author:sunhang
 * @className: BinarySearch2
 * @description:
 * @date: 2021-08-31 10:35
 * @version:0.1
 * @since: 1.8
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        //需要对已经排序的数组进行二分查找
        int[] data = {-49, -30, -16, 9,21, 21,21, 21, 23, 30, 30};
        ArrayList<Integer> integers = binarySearch(data, 0, data.length, 21);
        System.out.println(integers);
    }

    // 需要查找出所有符合条件的数据
    private static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        ArrayList<Integer> list = new ArrayList<>();
        if (left > right) {
            return list;
        }
        int minIndex = (left + right) / 2;
        int midVal = arr[minIndex];
        if (findVal < midVal) {
            return binarySearch(arr, left, minIndex - 1, findVal);
        } else if (findVal > midVal) {
            return binarySearch(arr, minIndex + 1, right, findVal);
        } else {
            System.out.println("midIndex=" + minIndex);
            // 将找到的这个中间索引加入
            list.add(minIndex);
            // 向左扫描
            int temp = minIndex - 1;
            while (temp >= 0 && arr[temp] == findVal) {
                list.add(temp);
                temp -= 1;
            }
            temp = minIndex + 1;
            while (temp <= arr.length - 1 && arr[temp] == findVal) {
                list.add(temp);

                temp += 1;
            }
            return list;
        }
    }
}
