import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class OneMoreMain {


    private static final CountDownLatch START1 = new CountDownLatch(1);
    private static final CountDownLatch START2 = new CountDownLatch(1);
    private static final CountDownLatch START3 = new CountDownLatch(1);


    public static void main(String[] args) {

        Random rnd = new Random();
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Создан 1-ий поток");
                START1.await();
                System.out.println("Начал выполняться 1-ий поток");
                Thread.sleep( (rnd.nextInt(3)) * 1000 + 50);
                System.out.println("Закончил выполняться 1-й поток\n");
                START2.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Создан 2-ий поток");
                START2.await();
                System.out.println("Начал выполняться 2-ий поток");
                Thread.sleep( (rnd.nextInt(3)) * 1000 + 50);
                System.out.println("Закончил выполняться 2-й поток\n");
                START3.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("Создан 3-ий поток");
                START3.await();
                System.out.println("Начал выполняться 3-ий поток");
                Thread.sleep( (rnd.nextInt(3)) * 1000 + 50);
                System.out.println("Закончил выполняться 3-й поток\n");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        START1.countDown();
    }
}
