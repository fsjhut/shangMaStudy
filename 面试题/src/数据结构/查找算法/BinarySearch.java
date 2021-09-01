package 数据结构.查找算法;


/**
 * @author:sunhang
 * @className: BinarySearch
 * @description:
 * @date: 2021-08-30 18:36
 * @version:0.1
 * @since: 1.8
 */
public class BinarySearch {
    public static void main(String[] args) {
        //需要对已经排序的数组进行二分查找
        int[] data = {-49,-30,-16,9,21,23,30,30};
        int i = binarySearch(data,0,data.length,30);
        System.out.println(i);
    }

    private static int binarySearch(int[] data, int left, int right, int findVal) {
        if(left>right){
            return -1;
        }
        int midIndex = (left+right)/2;
        // 向左递归查找
        if(findVal<data[midIndex]){
            return binarySearch(data,left,midIndex-1,findVal);
        }else if(findVal>data[midIndex]){
            return binarySearch(data,midIndex,right+1,findVal);
        }else {
            return midIndex;
        }
    }
}
