import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arrays {

    public int[] CreateStandart(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a number: ");
            array[i] = in.nextInt();
        }
        return array;
    }

    public ArrayList<Integer> CreateArList(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a number: ");
            array.add(in.nextInt());
        }
        return array;
    }

    public int[] random (int n) {
        int[] array = new int[n];
        final Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
     public void print(int[] a){
         System.out.println("Вывод массива: ");
         for (int i = 0; i < a.length; i++){
             System.out.print(a[i]);
         }
         System.out.println();
     }
}
