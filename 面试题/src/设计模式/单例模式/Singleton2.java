package 设计模式.单例模式;

/**
 * @author:sunhang
 * @className: Singleton2
 * @description:
 * @date: 2021-08-31 13:27
 * @version:0.1
 * @since: 1.8
 */
public class Singleton2 {
    private volatile static Singleton2  single;
    private Singleton2(){

    }
    private static Singleton2 getInstance(){
        if(single==null){
            synchronized (Singleton2.class){
                if(single==null){
                    single = new Singleton2();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance1 = Singleton2.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}
