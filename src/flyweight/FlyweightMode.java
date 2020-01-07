package flyweight;

import java.util.HashMap;

/**
 * 说到享元模式，第一个想到的应该就是池技术了，String常量池、数据库连接池、缓冲池等等都是享元模式的应用，
 * 所以说享元模式是池技术的重要实现方式。
 * <p>
 * 比如我们每次创建字符串对象时，都需要创建一个新的字符串对象的话，内存开销会很大，
 * 所以说如果第一次创建了字符串对象"hello"，下次再创建相同的字符串"hello"时，
 * 只是把它的引用执行"hello"，这样就实现了"hello"字符串在内存中的共享。
 * <p>
 * 举个简单的例子，网络联机下棋的时候，一台服务器连接了多个客户端（玩家），如果我们每个棋子都要创建对象，
 * 那一盘棋可能就是上百个对象产生，玩家多点的话，因为内存空间有效，一台服务器就难以支持了，
 * 所以这里要使用享元模式，将棋子对象减少到几个实例。下面给出享元模式的定义。
 * <p>
 * 其中，Flyweight是抽象享元角色。它是产品的抽象类，同时定义出对象的外部状态和内部状态（外部状态及内部状态相关内容见后方）的接口或实现；
 * ConcreteFlyweight是具体享元角色，是具体的产品类，实现抽象角色定义的业务；
 * UnsharedConcreteFlyweight是不可共享的享元角色，一般不会出现在享元工厂中；
 * FlyweightFactory是享元工厂，它用于构造一个池容器，同时提供从池中获得对象的方法。
 *
 * @author: wangbingshuai
 * @create: 2020-01-07 21:07
 **/
public class FlyweightMode {
    public static void main(String[] args) {
        Flyweight flyweight = FlyweightFactory.getFlyweight("a");
        flyweight.operate(1);
        flyweight = FlyweightFactory.getFlyweight("b");
        flyweight.operate(2);
        flyweight = FlyweightFactory.getFlyweight("c");
        flyweight.operate(3);
        flyweight = FlyweightFactory.getFlyweight("a");
        flyweight.operate(4);
    }
}

/**
 * 抽象类
 */
abstract class Flyweight {
    /**
     * 内部状态
     */
    private String intrinsic;
    /**
     * 外部状态：参数化后不能修改
     */
    private final String extrinsic;

    // 要求享元角色必须接受外部状态
    public Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }

    // 定义业务操作
    public abstract void operate(int opt);
}

/**
 * 需要共享的类
 */
class ConcreteFlyweight extends Flyweight {

    // 接守外部状态
    public ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    // 根据外部状态进行逻辑处理
    @Override
    public void operate(int opt) {
        System.out.println("具体Flyweight：" + opt);
    }
}

/**
 * 不需要共享的类
 */
class UnsharedConcreteFlyweight extends Flyweight {

    public UnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate(int opt) {
        System.out.println("不共享的具体Flyweight：" + opt);
    }
}

/**
 * 定义共享池
 */
class FlyweightFactory {
    // 定义一个池容器
    private static HashMap<String, Flyweight> pool = new HashMap<>();

    // 享元工厂
    public static Flyweight getFlyweight(String extrinsic) {
        Flyweight flyweight;
        if (pool.containsKey(extrinsic)) {   // 池中有该对象
            flyweight = pool.get(extrinsic);
            System.out.println("已有 " + extrinsic + " 直接从池中取---->");
        } else {
            // 根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight(extrinsic);
            // 放入池中
            pool.put(extrinsic, flyweight);
            System.out.println("创建 " + extrinsic + " 并从池中取出---->");
        }
        return flyweight;
    }
}
