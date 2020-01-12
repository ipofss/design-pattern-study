package strategymode;

/**
 * 策略模式定义了一系列算法，并将每个算法封装起来，使它们互相替换，且算法的变化不会影响到使用算法的客户。
 * 需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，
 * 设计一个抽象类（可有可无，属于辅助类），提供辅助函数
 *
 * @author: wangbingshuai
 * @create: 2020-01-12 18:41
 **/
public class StrategyMode {
    public static void main(String[] args) {
        ICalculator calculator = new Plus();
        int result = calculator.calculate("2+8");
        System.out.println("result:" + result);

        calculator = new Minus();
        result = calculator.calculate("10-3");
        System.out.println("result:" + result);

        calculator = new Multiply();
        result = calculator.calculate("3*3");
        System.out.println("result:" + result);
    }
}

interface ICalculator {
    int calculate(String exp);
}

/**
 * 公共抽象类：不想让它有对象，但是对外提供公共方法
 */
abstract class AbstractCalculator {
    public int[] split(String exp, String opt) {
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}

/**
 * 实现接口，会用到抽象类的公共方法
 */
class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}

class Minus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp, "\\-");
        return arrayInt[0] - arrayInt[1];
    }
}

class Multiply extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp, "\\*");
        return arrayInt[0] * arrayInt[1];
    }
}
