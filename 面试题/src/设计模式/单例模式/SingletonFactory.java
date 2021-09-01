package 设计模式.单例模式;

/**
 * @author:sunhang
 * @className: Singleton5
 * @description:
 * @date: 2021-08-31 15:26
 * @version:0.1
 * @since: 1.8
 */
public class SingletonFactory {
    // 内部的枚举类
    private enum EnumSingleton{
        SINGLETON;
        private Singleton6 singleton;
        //枚举类的构造方法在类加载是被实例化的
        private EnumSingleton(){
            singleton = new Singleton6();
        }
        public Singleton6 getInstance(){
            return singleton;
        }
    }
    public static Singleton6 getInstance(){
        return EnumSingleton.SINGLETON.getInstance();
    }
}
class Singleton6{
    public Singleton6(){}

}
