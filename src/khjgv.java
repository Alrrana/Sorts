import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class khjgv {

    static protected Scanner in = new Scanner(System.in);

    public static double parserDouble(String Message) {
        Pattern pattern = Pattern.compile("^(-|\\+)?[0-9]+(\\.[0-9]+)?$");
        Matcher matcher;
        double n = 0;
        boolean flag = false;
        String str;
        while (!flag) {
            str = input();//input();
            matcher = pattern.matcher(str);
            if (matcher.matches()) {
                n = Double.valueOf(str);
                flag = true;
            } else {
                System.out.print(Message);//
            }
        }
        return n;
    }

    private static final Random random = new Random();

    public static double oneRandomDouble(int znakiDoZap, int znakiPosleZap) {
        int n = random.nextInt((int) Math.pow(10.0, (double) znakiDoZap));
        int m = random.nextInt((int) Math.pow(10.0, (double) znakiPosleZap));
        double f = n + m / Math.pow(10.0, (double) znakiPosleZap);
        return f;
    }

    public static String input() {
        return in.nextLine();
    }

    static class BooleanHolder {
        boolean holder;

        public BooleanHolder(boolean holder) {
            this.holder = holder;
        }

        public boolean isHolder() {
            return holder;
        }

        public void setHolder(boolean holder) {
            this.holder = holder;
        }
    }


    public static void main(String[] args) {

        Object o1 = new Object();

        BooleanHolder timefor1 = new BooleanHolder(true);
        BooleanHolder timefor2 = new BooleanHolder(false);
        BooleanHolder timefor3 = new BooleanHolder(false);

        Thread thread1 = new Thread(() -> {
            try {
                synchronized (o1) {
                    Thread.sleep(1000);

                    while (!timefor1.isHolder()) {
                        o1.notifyAll();
                        o1.wait();

                    }
                    System.out.println("Начал выполняться 1-й поток");
                    Thread.sleep(1000);
                    System.out.println("Закончил выполняться 1-й поток\n");
                    timefor1.setHolder(false);
                    timefor2.setHolder(true);
                    o1.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                synchronized (o1) {

                    while (!timefor2.isHolder()) {
                        o1.notifyAll();
                        o1.wait();

                    }
                    System.out.println("Начал выполняться 2-й поток");
                    Thread.sleep(1000);
                    System.out.println("Закончил выполняться 2-й поток\n");
                    timefor2.setHolder(false);
                    timefor3.setHolder(true);
                    o1.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                synchronized (o1) {

                    while (!timefor3.isHolder()) {
                        o1.notifyAll();
                        o1.wait();

                    }
                    System.out.println("Начал выполняться 3-ий поток");
                    Thread.sleep(1000);
                    System.out.println("Закончил выполняться 3-й поток\n");
                    timefor3.setHolder(false);
                    timefor1.setHolder(true);
                    o1.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//

    }


//


//        double a;
//        final Random random = new Random();
////        int[] g = new int[11];
////        for (int i = 0; i < 200; i++) {
////            //a = oneRandomDouble(random.nextInt(6), random.nextInt(8));
////            g[random.nextInt(10)]++;
////        }
////        for (int i = 0; i < 11; i++) {
////            //a = oneRandomDouble(random.nextInt(6), random.nextInt(8));
////            System.out.print(g[i] + "     ");//g[random.nextInt(10)]++;
////        }
//
////        String input = " 1 0 2\n 5 0 3 \n 45 5 6\n";
////        String[] input1 = input.split("\n");
////        for (int i = 0 ; i < input1.length;i++){
////            //a = oneRandomDouble(random.nextInt(6), random.nextInt(8));
////            System.out.print(input1[i]+"   ");
////        }
//
//        String input1 = "[{\"value\":\"1\",\"row\":\"0\",\"col\":\"0\"},{\"value\":\"4\",\"row\":\"1\",\"col\":\"0\"},{\"value\":\"7\",\"row\":\"2\",\"col\":\"0\"},{\"value\":\"10\",\"row\":\"3\",\"col\":\"0\"},{\"value\":\"13\",\"row\":\"4\",\"col\":\"0\"},{\"value\":\"16\",\"row\":\"5\",\"col\":\"0\"},{\"value\":\"2\",\"row\":\"0\",\"col\":\"1\"},{\"value\":\"5\",\"row\":\"1\",\"col\":\"1\"},{\"value\":\"8\",\"row\":\"2\",\"col\":\"1\"},{\"value\":\"11\",\"row\":\"3\",\"col\":\"1\"},{\"value\":\"14\",\"row\":\"4\",\"col\":\"1\"},{\"value\":\"17\",\"row\":\"5\",\"col\":\"1\"},{\"value\":\"3\",\"row\":\"0\",\"col\":\"2\"},{\"value\":\"6\",\"row\":\"1\",\"col\":\"2\"},{\"value\":\"9\",\"row\":\"2\",\"col\":\"2\"},{\"value\":\"12\",\"row\":\"3\",\"col\":\"2\"},{\"value\":\"15\",\"row\":\"4\",\"col\":\"2\"},{\"value\":\"18\",\"row\":\"5\",\"col\":\"2\"}]\n" +
//                "1";
//        String input = "[{\"value\":\"\"},{\"value\":\"1\",\"row\":\"0\",\"col\":\"0\"},{\"value\":\"3\",\"row\":\"1\",\"col\":\"0\"},{\"value\":\"5\",\"row\":\"2\",\"col\":\"0\"},{\"value\":\"2\",\"row\":\"0\",\"col\":\"1\"},{\"value\":\"4\",\"row\":\"1\",\"col\":\"1\"},{\"value\":\"6\",\"row\":\"2\",\"col\":\"1\"}]\n";
//        String[] parsed1 = input1.split("\"");
//        String[] parsed = input.split("\"");
////        System.out.println(input1);
////        for (int i = 0; i < parsed1.length; i ++) {
////            System.out.println(parsed1[i]);
////        }
//        for (int i = 3; i < parsed1.length; i += 12) {
//            System.out.println(parsed1[i] + " " + parsed1[i + 4] + " " + parsed1[i + 8] + " " + i);
//        }
////        System.out.println(parsed1.length + " " + parsed1[parsed1.length - 2] + " " + parsed1[parsed1.length - 6]);
////        System.out.println(parsed.length + " " + parsed[parsed.length - 2] + " " + parsed[parsed.length - 6]);
//
//        int col = Integer.valueOf(parsed[parsed.length - 2])+1;
//        int row = Integer.valueOf(parsed[parsed.length - 6])+1;
//        String[][] res = new String[row][col];
////        for (int i = 3; i < parsed.length; i += 12) {
////            res[Integer.valueOf(parsed[i + 4])][Integer.valueOf(parsed[i + 8])] = parsed[i];
////        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(res[i][j]);
//            }
//            System.out.println();
//        }
//
//        String d ="1dsfgrdstge4e1111112";
//        try{
//            double temp =  Double.valueOf(d);
//        }catch (Exception ex){
//            System.out.println(ex);
//        }
//

}

