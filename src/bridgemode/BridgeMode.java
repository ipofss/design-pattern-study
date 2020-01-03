package bridgemode;

/**
 * 桥接模式
 * 桥接模式就是把事物和其实现分开，使他们可以各自独立的变化。
 * 桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化；
 * 像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，在各个数据库之间进行切换，
 * 基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了
 *
 * @author: wangbingshuai
 * @create: 2020-01-03 15:01
 **/
public class BridgeMode {
    public static void main(String[] args) {
        // 定义一个桥
        Bridge bridge = new MyBridge();

        // 定义实现接口的类1
        BridgeSource1 bridgeSource1 = new BridgeSource1();
        // 给桥传入类1的对象
        bridge.setBridgeable(bridgeSource1);
        // 通过桥统一的方法进去
        bridge.method();

        // 定义实现接口的类2
        BridgeSource2 bridgeSource2 = new BridgeSource2();
        // 给桥传入类2的对象
        bridge.setBridgeable(bridgeSource2);
        // 通过桥统一的方法进去
        bridge.method();

        /*以上逻辑的调用结果，其实简单的就可以调用到，但是这样就体现不出来两个实现类之间的任何关联关系，
        桥的作用其实就是提供统一的入口，至于如何实现的由传进来的具体实现类而定；
        简单粗暴做法就像下面这个使用：bridgeSource1.method(); bridgeSource2.method();*/
    }
}

/**
 * 定义一个接口
 */
interface Bridgeable {
    /**
     * method方法
     */
    void method();
}

/**
 * 某个类1实现该接口
 */
class BridgeSource1 implements Bridgeable {
    @Override
    public void method() {
        System.out.println("BridgeSource1:method");
    }
}

/**
 * 某个类2实现该接口
 */
class BridgeSource2 implements Bridgeable {
    @Override
    public void method() {
        System.out.println("BridgeSource2:method");
    }
}

/**
 * 定义一个抽象类桥，它持有接口的实例
 */
abstract class Bridge {
    /**
     * 接口对应的实例
     */
    Bridgeable bridgeable;

    /**
     * 定义和接口同名发方法
     */
    public void method() {
        bridgeable.method();
    }

    public Bridgeable getBridgeable() {
        return bridgeable;
    }

    public void setBridgeable(Bridgeable bridgeable) {
        this.bridgeable = bridgeable;
    }
}

/**
 * 定义一个普通类，它继承抽象类
 */
class MyBridge extends Bridge {
    @Override
    public void method() {
        getBridgeable().method();
    }
}
