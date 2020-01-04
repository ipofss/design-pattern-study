package decoratormode;

/**
 * 装饰器模式，用于给现有的类添加一些额外的属性，它不同于是继承，
 * 继承是直接覆盖基类的方法，而装饰器是要使用原类的方法
 *
 * @author: wangbingshuai
 * @create: 2020-01-04 17:50
 **/
public class DecoratorMode {
    public static void main(String[] args) {
        DecoratorSource decoratorSource = new DecoratorSource();
        Decorator decorator = new Decorator(decoratorSource);
        decorator.method();
    }
}

/**
 * 声明一个接口
 */
interface Decoratorable {
    /**
     * 定义一个方法
     */
    void method();
}

/**
 * 某个类实现该接口
 */
class DecoratorSource implements Decoratorable {
    @Override
    public void method() {
        System.out.println("DecoratorSource:method");
    }
}

/**
 * 装饰器类实现接口并且使用某个实现了该接口的类
 */
class Decorator implements Decoratorable {
    private DecoratorSource decoratorSource;

    public Decorator(DecoratorSource decoratorSource) {
        this.decoratorSource = decoratorSource;
    }

    @Override
    public void method() {
        System.out.println("Decorator:before");
        decoratorSource.method();
        System.out.println("Decorator:after");
    }
}