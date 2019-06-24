import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class wetgrf {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Random rnd = new Random();
        AtomicInteger current = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Создан 1-ий поток");
                while (current.get() <= 3) {
                    locker.lock();
                    if (current.get() == 1) {
                        try {

                            System.out.println("Начал выполняться 1-ий поток");
                            Thread.sleep((rnd.nextInt(3)) * 1000 + 50);
                            System.out.println("Закончил выполняться 1-й поток\n");
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

        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Создан 2-ий поток");
                while (current.get() <= 3) {
                    locker.lock();
                    if (current.get() == 2) {
                        try {

                            System.out.println("Начал выполняться 2-ий поток");
                            Thread.sleep((rnd.nextInt(3)) * 1000 + 50);
                            System.out.println("Закончил выполняться 2-й поток\n");
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
        });
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("Создан 3-ий поток");
                while (current.get() <= 3) {
                    locker.lock();
                    if (current.get() == 3) {
                        try {

                            System.out.println("Начал выполняться 3-ий поток");
                            Thread.sleep((rnd.nextInt(3)) * 1000 + 50);
                            System.out.println("Закончил выполняться 3-й поток\n");
                            current.set(1);
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
        });

        thread1.start();
        thread2.start();
        thread3.start();
        current.incrementAndGet();
    }
}
