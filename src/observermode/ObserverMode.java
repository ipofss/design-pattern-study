package observermode;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 观察者模式，类似于邮件订阅和RSS订阅，当我们浏览一些博客或wiki时，经常会看到RSS图片，就是这个意思，
 * 当你订阅了该文章，如果后续有更新，会及时通知你。其实，简单来说就一句话：
 * 当一个对象变化时，其他依赖该对象的对象都会收到通知，并且随着变化。对象之间是一种一对多的关系。
 *
 * @author: wangbingshuai
 * @create: 2020-01-13 14:39
 **/
public class ObserverMode {
    public static void main(String[] args) {
        // 定义观察者
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        // 定义主题
        Subject subject = new MySubject();
        // 观察者订阅主题
        subject.add(observer1);
        subject.add(observer2);
        // 主题变化
        subject.operation();
    }
}

/**
 * 观察者接口
 */
interface Observer {
    void update();
}

class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}

class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}

/**
 * 主题接口
 */
interface Subject {
    /**
     * 增加观察者
     *
     * @param observer
     */
    void add(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer
     */
    void del(Observer observer);

    /**
     * 通知所有的观察者
     */
    void notifyObservers();

    /**
     * 自身的操作
     */
    void operation();
}

/**
 * 抽象类实现主题接口，并且保留部分接口不进行实现，留着给具体的类主题类实现
 */
abstract class AbstractSubject implements Subject {
    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enums = vector.elements();
        while (enums.hasMoreElements()) {
            enums.nextElement().update();
        }
    }
}

/**
 * 实现主题类
 */
class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("MySubject发生变化");
        // 通知所有的观察者
        notifyObservers();
    }
}
