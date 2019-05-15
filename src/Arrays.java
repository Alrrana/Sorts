import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arrays {
    Scanner in = new Scanner(System.in);

    public int[] CreateStandart() {
        System.out.print("Введите количество элементов массива: ");
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент массива: ");
            array[i] = in.nextInt();
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
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент массива: ");
            array.add(in.nextInt());
        }
        return array;
    }

    public int[] random(int n) {
        int[] array = new int[n];
        final Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public int[] random() {
        System.out.print("Введите количество элементов рандомного заполняемого массива: ");
        int n = in.nextInt();
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
}
