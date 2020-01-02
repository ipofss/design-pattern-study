package factorymode;

/**
 * 工厂模式
 *
 * @author: wangbingshuai
 * @create: 2020-01-02 11:47
 **/
public class FactoryMode {
    public static void main(String[] args) {
        // mail工厂
        ServiceFactory serviceFactory = new SendMailFactory();
        serviceFactory.sender().send();

        // sms工厂
        serviceFactory = new SendSmsFactory();
        serviceFactory.sender().send();
    }
}

/**
 * 某类操作接口
 */
interface Sender {
    /**
     * 发送消息
     */
    void send();
}

/**
 * 实现接口
 */
class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("MailSender实现类");
    }
}

/**
 * 实现接口
 */
class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("SmsSender实现类");
    }
}

/**
 * 服务接口：声明一堆方法，每一个方法返回一种接口
 */
interface ServiceFactory {
    /**
     * 返回一个发送类接口
     *
     * @return
     */
    Sender sender();
}

/**
 * 工厂1实现服务接口
 */
class SendMailFactory implements ServiceFactory {
    @Override
    public Sender sender() {
        return new MailSender();
    }
}

/**
 * 工厂2实现服务接口
 */
class SendSmsFactory implements ServiceFactory {
    @Override
    public Sender sender() {
        return new SmsSender();
    }
}