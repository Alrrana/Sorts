import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arrays {
    Scanner in = new Scanner(System.in);

    private int parser() {
        Pattern pattern = Pattern.compile("^[0-9]+?$");
        Matcher matcher;
        int n = 0;
        String str;
        while (n <= 0) {
            str = in.nextLine();
            matcher = pattern.matcher(str);
            if (matcher.matches()) {
                n = Integer.valueOf(str);
            } else {
                System.out.print("Введено не число или отрицательное число, попробуйте ещё раз \n");
            }
        }
        return n;
    }

    private int parserNegative() {
        Pattern pattern = Pattern.compile("^-?[0-9]+?$");
        Matcher matcher;
        int n = 0;
        boolean flag = false;
        String str;
        while (!flag) {
            str = in.nextLine();
            matcher = pattern.matcher(str);
            if (matcher.matches()) {
                n = Integer.valueOf(str);
                flag = true;
            } else {
                System.out.print("Введено не число , попробуйте ещё раз \n");
            }
        }
        return n;
    }

    public int[] CreateStandart() {
        System.out.print("Введите количество элементов массива: ");
        int n = parser();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент массива: ");
           array[i]=parserNegative();
        }
        return array;
    }

    public int[] CreateStandart(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент массива: ");
            array[i] = in.nextInt();
        }
        return array;
    }

    public ArrayList<Integer> CreateArList(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < n; i++) {

            array.add(in.nextInt());
        }
        return array;
    }

//    public int[] random(int n) {
//        int[] array = new int[n];
//        final Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            array[i] = random.nextInt(100);
//        }
//        return array;
//    }

    public int[] random() {
        System.out.print("Введите количество элементов рандомного заполняемого массива: ");
        int n = parser();

//            if(in.hasNext("^\\s?[0-9]+\\\n?$")){
//                n=in.nextInt();
//            } else{
//                System.out.print("Введено не число, попробуйте ещё раз \n");
//                String str = in.nextLine();
//            }
//            if (!in.hasNextInt()) {
//                System.out.print("Введено не число, попробуйте ещё раз\n ");
//                String str = in.nextLine();
//            } else {
//                n = in.nextInt();
//                if (n < 1) {
//                    System.out.print("Введенное число меньше 1 и не может быть длинной массива, попробуйте ещё раз\n ");
//                    n = 0;
//                }
//            }


//            if (in.hasNextInt()) {
//                if(in.nextInt()>1){
//                    n = in.nextInt();
//                }
//            } else {
//                System.out.print("Неверный ввод, попробуйте ещё раз\n ");
//                String str = in.nextLine();
//            }


        int[] array = new int[n];
        final Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


    public void print(int[] a) {
        System.out.println("Вывод массива: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public int[] copy(int[] a) {
        int[] array = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
        }
        return array;
    }
}
