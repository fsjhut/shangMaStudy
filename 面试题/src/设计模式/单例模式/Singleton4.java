package 设计模式.单例模式;

/**
 * @author:sunhang
 * @className: Singleton4
 * @description: 静态内部类
 * @date: 2021-08-31 14:53
 * @version:0.1
 * @since: 1.8
 */
public class Singleton4 {
    private Singleton4(){

    }
    private static class InnerObject{
        private static Singleton4 single = new Singleton4();
    }
    public static Singleton4 getInstance(){
        return InnerObject.single;
    }
}
