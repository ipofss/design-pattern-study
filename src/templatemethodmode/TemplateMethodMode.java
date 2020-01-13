package templatemethodmode;

/**
 * 模板方法模式：一般是定义一个抽象类，抽象类中定义一个final方法，然后找个final方法调用抽象类中的抽象方法或者非抽象方法
 * 因为抽象类的final方法不能被覆盖，所以通过向上转型后调用的方法依然是实现类的方法，不会是抽象类的方法
 *
 * @author: wangbingshuai
 * @create: 2020-01-13 11:52
 **/
public class TemplateMethodMode {
    public static void main(String[] args) {
        AbstractTemplateMethod templateMethod = new TemplateMethodPlus();
        int result = templateMethod.calculate("15+3", "\\+");
        System.out.println("result=" + result);
        templateMethod = new TemplateMethodSub();
        result = templateMethod.calculate("15-3", "\\-");
        System.out.println("result=" + result);
    }
}

/**
 * 定义一个抽象类
 */
abstract class AbstractTemplateMethod {

    /**
     * 主方法，实现对本类其他方法的调用
     *
     * @param exp
     * @param opt
     * @return
     */
    public final int calculate(String exp, String opt) {
        int[] split = split(exp, opt);
        return calculate(split[0], split[1]);
    }

    /**
     * 被子类重新的抽象方法
     *
     * @param num1
     * @param num2
     * @return
     */
    abstract public int calculate(int num1, int num2);

    public int[] split(String exp, String opt) {
        String[] split = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(split[0]);
        arrayInt[1] = Integer.parseInt(split[1]);
        return arrayInt;
    }
}

/**
 * 继承抽象类
 */
class TemplateMethodPlus extends AbstractTemplateMethod {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class TemplateMethodSub extends AbstractTemplateMethod {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
