package prototypemode;

import java.io.*;

/**
 * 原型模式：用于对象的浅拷贝或者深度拷贝。浅拷贝：基本数据类型复制，对象实现引用；深度拷贝：基本数据类型和对象类型读复制
 *
 * @author: wangbingshuai
 * @create: 2020-01-09 11:12
 **/
public class PrototypeMode {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype = new Prototype(100, "abcd");
        // 浅拷贝
        Prototype shallowPrototype = (Prototype) prototype.shallowCopy();
        if (shallowPrototype.getString() == prototype.getString()) {
            System.out.println("浅拷贝：对象只进行引用，不进行拷贝");
        } else {
            if (shallowPrototype.getString().equals(prototype.getString())) {
                System.out.println("浅拷贝：对象也进行的拷贝");
            } else {
                System.out.println("浅拷贝：对象不进行任何操作");
            }
        }

        // 深度拷贝
        Prototype deepPrototype = (Prototype) prototype.deepCopy();
        if (deepPrototype.getString() == prototype.getString()) {
            System.out.println("深拷贝：对象只进行引用，不进行拷贝");
        } else {
            if (deepPrototype.getString().equals(prototype.getString())) {
                System.out.println("深拷贝：对象也进行的拷贝");
            } else {
                System.out.println("深拷贝：对象不进行任何操作");
            }
        }
    }
}

class Prototype implements Cloneable, Serializable {
    private int i = 0;
    private String string = "";

    public Prototype(int i, String string) {
        this.i = i;
        this.string = string;
    }

    // 浅拷贝
    public Object shallowCopy() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    // 深度拷贝
    public Object deepCopy() throws IOException, ClassNotFoundException {
        // 写入当前对象的二进制流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        // 读出二进制流产生的新对象
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }

    public int getI() {
        return i;
    }

    public String getString() {
        return string;
    }
}
