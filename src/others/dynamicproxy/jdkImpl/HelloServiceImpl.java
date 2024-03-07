package others.dynamicproxy.jdkImpl;

import java.lang.reflect.Proxy;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-06 18:37:56
 */
public class HelloServiceImpl implements HelloService {
    //通过 Proxy.newProxyInstance 方法动态创建接口的代理对象
    public static void main(String[] args) {
        // 创建目标对象
        HelloService target = new HelloServiceImpl();
        // 创建调用处理器对象
        HelloServiceHandler handler = new HelloServiceHandler(target);
        // 创建代理对象
        HelloService proxyInstance = (HelloService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        // 通过代理对象调用方法
        proxyInstance.sayHello("World");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}
