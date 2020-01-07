package facademode;

/**
 * 外观模式没有涉及到接口，它是为了解决类和类之间的耦合性，每一个类单独创建，然后在统一总的类进行串联起来，
 * 就像Spring一样，类和类之间的关系放在配置文件中，而外观模式是将类之间的关系放在一个类中。这些类可能有具有同名的方法
 *
 * @author: wangbingshuai
 * @create: 2020-01-06 14:22
 **/
public class FacadeMode {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}

class Cpu {
    public void startup() {
        System.out.println("cpu startup!");
    }

    public void shutdown() {
        System.out.println("cpu shutdown!");
    }
}

class Disk {
    public void startup() {
        System.out.println("disk startup!");
    }

    public void shutdown() {
        System.out.println("disk shutdown!");
    }
}

class Memory {
    public void startup() {
        System.out.println("memory startup!");
    }

    public void shutdown() {
        System.out.println("memory shutdown!");
    }
}

class Computer {
    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        this.cpu = new Cpu();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    public void startup() {
        System.out.println("start the computer!");
        cpu.startup();
        disk.startup();
        memory.startup();
        System.out.println("start computer finished!");
    }

    public void shutdown() {
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        disk.shutdown();
        memory.shutdown();
        System.out.println("computer closed!");
    }
}
