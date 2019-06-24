import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MoreMain {

    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        ExecutorService service = Executors.newCachedThreadPool();
        AtomicInteger current = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {

            service.submit(new Potok(locker));

        }

    }

}
