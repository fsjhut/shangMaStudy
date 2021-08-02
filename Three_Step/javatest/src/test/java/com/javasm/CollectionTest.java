package com.javasm;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author SunHang
 * @className: CollectionTest
 * @description:
 * @createTime 2021/7/18 20:46
 */
public class CollectionTest {
    @Test
    public void test1() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(11);
        array.add(12);
        array.add(13);
        array.add(14);
        array.add(15);
        array.add(16);
//        String.valueOf(i)
        array.removeIf(integer -> integer > 15);
        array.remove(1);
        array.remove(Integer.valueOf(13));
//        System.out.println(remove);
        System.out.println(array.toString());
//        System.out.println(Arrays.toString(array));
        List collection = new ArrayList();
        //1.新增
        collection.add(100);//装箱
        collection.add("a");
        collection.add(new Object());
        collection.add(false);
        collection.add(null);
        collection.add(100);
        collection.add("a");
        collection.add("a");

        Object[] as = collection.toArray(new Object[]{"1"});
        System.out.println(Arrays.toString(as));
//        demo2(collection);
    }

    //    @Test
    private void demo2(Collection collection) {

        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            return;
        }
        for (Object o : collection) {
            if(o==null){
                continue;
            }
            if("a".equals(o)){
                collection.remove(o);
            }
        }
        System.out.println(collection.toString());
//        删除所有a
//        Exception in thread "main"
//        java.util.ConcurrentModificationException
//遍历集合元素: add 修改 删除 一定会出现异常 1.8- 不支持并行化处理
    }
    @Test
    public void test3(){
        int a = 10;
        float b = 10.0f;
        double c = 10.0;
        System.out.println(a==b);
        System.out.println(b==c);
        byte m  = 10;
        byte n = 20;
        m +=n;
        System.out.println();
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();


    }
}
