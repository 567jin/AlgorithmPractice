package others.designPattern;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-04-01 19:28:11
 */

// 单例模式的四种写法


import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * 饿汉式
 */
public class Singleton {
    private static Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

/**
 * 懒汉式 + double check lock
 * <p>
 * 创建内存空间。
 * 在内存空间中初始化对象 Singleton。
 * 将内存地址赋值给 instance 对象（执行了此步骤，instance 就不等于 null 了）。
 * <p>
 * 如果第三步和第二步反过来了，则可能某个线程拿到的是半初始化的对象，即还未进行初始化(执行静态代码块的内容)
 */
class Singleton2 {
    private static volatile Singleton2 INSTANCE;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }

}

/**
 * 静态内部类
 * 当第一次加载 Singleton 类时并不会初始化 SingletonHolder，
 * 只有在第一次调用 getInstance 方法时才会导致 SingletonHolder 被加载，从而实例化 instance。
 * 这个只加载一次的安全性是由JVM保证的，因此是线程安全的。
 */

class Singleton3 {
    private Singleton3() {
    }

    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}


/**
 * 使用 枚举类
 * 枚举类是线程安全的，并且由于没有构造函数，所以还可以防止反射攻击
 */

enum Singleton4 {
    INSTANCE;  // 这个类就属于Singleton 当只有调用INSTANCE时 才会初始化 并且由于JVM类加载机制保证线程安全

    public void tt() {
//        Singleton3.INSTANCE.tt();  // 调用方法
        System.out.println("调用方法");
    }
}


