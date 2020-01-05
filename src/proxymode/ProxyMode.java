package proxymode;

/**
 * 其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，替原对象进行一些操作，
 * 比如，我们在租房的时候会去找中介，为什么呢？因为你对该地区房屋的信息掌握的不够全面，希望找一个更熟悉的人去帮你去做，
 * 此处的代理就是这个意思。再比如，我们有的时候打官司，我们需要请律师，因为律师在法律方面有专长，
 * 可以替我们进行操作，表达我们的想法
 *
 * @author: wangbingshuai
 * @create: 2020-01-05 13:14
 **/
public class ProxyMode {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.method();
    }
}

/**
 * 定义一个接口
 */
interface Proxyable {
    /**
     * 定义一个抽象方法
     */
    void method();
}

/**
 * 某个类实现该接口
 */
class ProxySource implements Proxyable {
    @Override
    public void method() {
        System.out.println("ProxySource:method");
    }
}

/**
 * 代理类实现接口，并且在构造器中创建实现同样接口的类的对象，它与装饰器模式非常相似，
 * 不同的是，类对象是在构造器中创建，而装饰器的类在外面构建传进来
 */
class Proxy implements Proxyable {
    private ProxySource proxySource;

    public Proxy() {
        this.proxySource = new ProxySource();
    }

    @Override
    public void method() {
        System.out.println("Proxy:before");
        proxySource.method();
        System.out.println("Proxy:after");
    }
}
