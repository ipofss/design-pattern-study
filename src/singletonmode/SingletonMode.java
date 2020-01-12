package singletonmode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 单例模式
 *
 * @author: wangbingshuai
 * @create: 2020-01-12 16:09
 **/
public class SingletonMode {
    public static void main(String[] args) {
        // 多线程测试
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SingletonCreate());
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class Singleton {
    // 唯一的单例
    private static Singleton singleton = null;

    // 私有构造器
    private Singleton() {
        System.out.println(Thread.currentThread() + "：创建Singleton对象");
    }

    // 静态方法创建实例：不满足线程安全
    public static Singleton getInstance1() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    // 静态方法创建实例：满足线程安全，但是性能低
    public static synchronized Singleton getInstance2() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    // 静态方式创建实例：满足线程安全，满足性能要求，但是可能基于jvm优化策略，内存会延迟分配
    public static Singleton getInstance3() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // 静态类方式：利用类在加载时线程互相排斥的属性进行唯一初始化对象
    private static class SingletonFactory {
        private static Singleton singleton = new Singleton();
    }

    // 利用静态类方式
    public static Singleton getInstance4() {
        return SingletonFactory.singleton;
    }
}

/**
 * 创建多线程
 */
class SingletonCreate implements Runnable {
    @Override
    public void run() {
        // 执行方法创建对象
//        Singleton.getInstance1();
//        Singleton.getInstance2();
//        Singleton.getInstance3();
        Singleton.getInstance4();
    }
}
