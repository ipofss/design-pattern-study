package adapterclassmode;

/**
 * 适配器类模式
 * 1、定义一个接口
 * 2、定义一个类1（不实现接口），类实现了接口中的一个方法
 * 3、定义一个类继承上类1，并且实现接口中类1没有实现的接口或者全部接口
 *
 * @author: wangbingshuai
 * @create: 2020-01-12 16:36
 **/
public class AdapterClassMode {
    public static void main(String[] args) {
        Targetable targetable = new AdapterClass();
        targetable.method1();
        targetable.method2();
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

class AdapterClass extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("这个是Adapter类实现接口的方法method2()");
    }
}
