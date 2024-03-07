package others.dynamicproxy.jdkImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-06 18:38:28
 */
public class HelloServiceHandler implements InvocationHandler {
    // 目标对象
    private Object target;

    public HelloServiceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before sayHello");
        // 执行目标对象的方法
        Object result = method.invoke(target, args);
        System.out.println("After sayHello");
        return result;
    }
}
