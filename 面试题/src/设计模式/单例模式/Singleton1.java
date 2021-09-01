package 设计模式.单例模式;

/**
 * @author:sunhang
 * @className: Singleton1
 * @description:
 * @date: 2021-08-31 13:20
 * @version:0.1
 * @since: 1.8
 */
public class Singleton1 {
    private static Singleton1 single = new Singleton1();
    private Singleton1(){
        System.out.println("私有的构造器");
    }
    private static Singleton1 getInstance(){
        System.out.println("get instance");
        return single;
    }

    public static void main(String[] args) {
        System.out.println("初始化");
        Singleton1 single = Singleton1.getInstance();
        System.out.println(single);
    }
}
