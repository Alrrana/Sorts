import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Potok extends Thread {
    Random rnd = new Random();


    ReentrantLock locker;
    Potok(ReentrantLock locker){
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try{

            System.out.println("Начал выполняться "+this.getName()+"-ий поток");
            Thread.sleep(1000);
            System.out.println("Закончил выполняться  "+this.getName()+"-й поток\n");
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock(); // снимаем блокировку
        }

    }
}
