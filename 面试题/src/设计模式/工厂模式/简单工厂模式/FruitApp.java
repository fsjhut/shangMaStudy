package 设计模式.工厂模式.简单工厂模式;

/**
 * @author:sunhang
 * @className: FruitApp
 * @description:
 * @date: 2021-08-31 17:32
 * @version:0.1
 * @since: 1.8
 */
public class FruitApp {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        Apple apple = (Apple) fruitFactory.createFruit("apple");
        Pear pear = (Pear)fruitFactory.createFruit("pear");
        apple.whatIm();
        pear.whatIm();
    }
}
