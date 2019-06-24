import java.util.Random;

public class Potok extends Thread {
    Random rnd = new Random();

    public Potok(String name) {
        super(name);
    }

    public void f() {
        start();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sleep(rnd.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    @Override
    public void run() {

        try {
            sleep(rnd.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName());
    }
}
