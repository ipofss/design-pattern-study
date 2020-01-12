package adapterobjectmode;

/**
 * 适配器对象模式
 * 1、定义一个接口
 * 2、定义一个类1（不实现接口），类实现了接口中的一个方法
 * 3、定义一个类，其中一个数据成员是类1对象，由构造器初始化
 *
 * @author: wangbingshuai
 * @create: 2020-01-12 16:59
 **/
public class AdapterObjectMode {
    public static void main(String[] args) {
        Source source = new Source();
        AdapterObject adapterObject = new AdapterObject(source);
        adapterObject.method1();
        adapterObject.method2();
    }
}

interface Targetable {
    void method1();

    void method2();
}

class Source {
    public void method1() {
        System.out.println("这个是Source类实现接口中的方法method1()");
    }
}

class AdapterObject implements Targetable {
    private Source source;

    public AdapterObject(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        // 直接调用对象method1方法
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("这个是Adapter类实现接口的方法method2()");
    }
}
