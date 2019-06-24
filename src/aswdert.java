public class aswdert {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {

                System.out.println("Начал выполняться 1-ий поток");
                Thread.sleep(1000);
                System.out.println("Закончил выполняться 1-й поток\n");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {

                System.out.println("Начал выполняться 2-ий поток");
                Thread.sleep(1000);
                System.out.println("Закончил выполняться 2-й поток\n");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {

                System.out.println("Начал выполняться 3-ий поток");
                Thread.sleep(1000);
                System.out.println("Закончил выполняться 3-й поток\n");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



        thread1.start();
        thread2.start();
        thread3.start();
    }
}
