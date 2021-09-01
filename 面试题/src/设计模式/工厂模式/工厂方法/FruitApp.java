package 设计模式.工厂模式.工厂方法;

/**
 * @author:sunhang
 * @className: FruitApp
 * @description:
 * @date: 2021-08-31 17:34
 * @version:0.1
 * @since: 1.8
 */
public class FruitApp {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        PearFactory pearFactory = new PearFactory();
        Apple apple = appleFactory.createFruit();
        Pear pear = pearFactory.createFruit();
        apple.whatIm();
        pear.whatIm();
    }
}
