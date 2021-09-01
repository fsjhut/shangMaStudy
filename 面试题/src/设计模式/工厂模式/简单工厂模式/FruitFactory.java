package 设计模式.工厂模式.简单工厂模式;

/**
 * @author:sunhang
 * @className: FruitFactory
 * @description:
 * @date: 2021-08-31 17:32
 * @version:0.1
 * @since: 1.8
 */
public class FruitFactory {
    public Fruit createFruit(String type){
        if(type.equals("apple")){
            return new Apple();
        }else if(type.equals("pear")){
            return new Pear();
        }
        return null;
    }
}
