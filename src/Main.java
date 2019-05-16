public class Main {

    public static void main(String[] args) {
        Arrays arrayHelper = new Arrays();
        Sorts sortHelper = new Sorts();
//        int[] second = arrayHelper.random();
        int[] second = arrayHelper.CreateStandart();
//
        System.out.println("Введенный массив: ");

        arrayHelper.print(second);

        int[] third = arrayHelper.copy(second);
        int[] first = arrayHelper.copy(second);


        sortHelper.QuickSort(first);
        sortHelper.Merge(second);
        sortHelper.InsertionSortClassic(third);
        System.out.println("\nОтсортированные массивы(Метод QuickSort): ");
        arrayHelper.print(first);


        System.out.print("Отсортированные массивы(Метод MergeSort): ");
        arrayHelper.print(second);


        System.out.print("\nОтсортированные массивы(Метод InsertionSort): ");

        arrayHelper.print(third);
    }

}
