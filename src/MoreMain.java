import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MoreMain {

    public static void main(String[] args) {

        ReentrantLock locker = new ReentrantLock();
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        service.setCorePoolSize(5);
        AtomicInteger current = new AtomicInteger(0);
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            final Integer cnt = i;
            System.out.println("Number of active threads is " + service.getActiveCount());
            service.submit(new Thread(() -> {
                try {
                    System.out.println("Создан " + cnt + "-ий поток");
                    while (current.get() <= cnt) {
                        System.out.println("cnt is " + cnt + "current is" + current.get());
                        locker.lock();
                        if (current.get() == cnt) {
                            try {

                                System.out.println("Начал выполняться " + cnt + "-ий поток");
                                Thread.sleep((rnd.nextInt(3)) * 1000 + 50);
                                System.out.println("Закончил выполняться " + cnt + "-й поток\n");
                                current.incrementAndGet();
                            } finally {
                                locker.unlock();
                            }
                        } else {
                            locker.unlock();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));

        }
        service.shutdown();


    }

}
