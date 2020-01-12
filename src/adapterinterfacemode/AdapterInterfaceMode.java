package adapterinterfacemode;

/**
 * 适配器接口模式
 * 1、定义一个接口
 * 2、抽象类实现接口全部方法
 * 3、其他类重写抽象类方法
 *
 * @author: wangbingshuai
 * @create: 2020-01-12 17:08
 **/
public class AdapterInterfaceMode {
    public static void main(String[] args) {
        Source1 source1 = new Source1();
        source1.method1();
        source1.method2();

        Source2 source2 = new Source2();
        source2.method1();
        source2.method2();
    }
}

interface Targetable {
    void method1();

    void method2();
}

abstract class TargetAbstract implements Targetable {
    @Override
    public void method1() {
        System.out.println("TargetAbstract:method1()");
    }

    @Override
    public void method2() {
        System.out.println("TargetAbstract:method2()");
    }
}

/**
 * 类1重新抽象类的部分方法
 */
class Source1 extends TargetAbstract {
    @Override
    public void method1() {
        System.out.println("Source1中的method1()");
    }
}

/**
 * 类2重新抽象类的部分方法
 */
class Source2 extends TargetAbstract {
    @Override
    public void method2() {
        System.out.println("Source2种的method2()");
    }
}
