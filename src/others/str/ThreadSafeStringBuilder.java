package others.str;

import org.junit.Test;

/**
 * @author jzy
 * @GitHub <a href="https://github.com/567jin">567jin</a>
 * @since 2024-03-07 16:38:49
 * 如果要使用安全的StringBuilder 则可以通过结合ThreadLocal来实现 为每一个线程独立的创建一个StringBuilder。
 * 因为StringBuffer中的方法都是synchronized的，执行效率不高，而实际开发中单线程最常用。因此一般就只使用StringBuilder就足够了
 */
public class ThreadSafeStringBuilder {
    // 使用ThreadLocal为每个线程提供独立的StringBuilder对象
    private static final ThreadLocal<StringBuilder> threadLocalStringBuilder = ThreadLocal.withInitial(StringBuilder::new);
    private static StringBuilder sb = new StringBuilder();  // 并发不安全

    public static void appendString(String str) {
        // 获取当前线程的StringBuilder对象
        StringBuilder stringBuilder = threadLocalStringBuilder.get();
        // 在StringBuilder对象上执行字符串拼接操作
        stringBuilder.append(str);
    }

    public static String getString() {
        // 获取当前线程的StringBuilder对象
        StringBuilder stringBuilder = threadLocalStringBuilder.get();
        // 返回StringBuilder对象的字符串表示
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
//                sb.append(Thread.currentThread().getName()).append("-").append(i).append(" ");
                appendString(Thread.currentThread().getName() + "-" + i + " ");
            }
            // 输出当前线程的字符串结果
            System.out.println(Thread.currentThread().getName() + ": " + getString());
//            System.out.println(Thread.currentThread().getName() + ": " + sb.toString());
            // 清空当前线程的StringBuilder对象，以便下次使用
            threadLocalStringBuilder.get().setLength(0);

        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        // 等待所有线程执行完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void sbTest() {
        StringBuilder sb = new StringBuilder();
        String str = null;
        sb.append(str);
        System.out.println(sb.toString());
    }

}
