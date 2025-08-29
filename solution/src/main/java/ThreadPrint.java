import java.util.concurrent.Semaphore;

public class ThreadPrint {
    private static int count = 1;
    private static Semaphore semaphoreA = new Semaphore(1); // A先执行
    private static Semaphore semaphoreB = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> print("A", semaphoreA, semaphoreB)).start();
        new Thread(() -> print("B", semaphoreB, semaphoreA)).start();
    }

    private static void print(String name, Semaphore self, Semaphore next) {
        while (count <=99) {
            try {
                self.acquire(); // 获取自己的信号量
                System.out.println(name + ": " + count++);
                next.release(); // 释放下一个线程的信号量
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}