public class Main {

    public static void main(String[] args) {
        Arrays example = new Arrays();
        Sorts sortHelper = new Sorts();
        int[] first = example.random();
        int[] second = example.CreateStandart();

        System.out.print("Введенные массивы: ");

        example.print(first);
        example.print(second);

        sortHelper.QuickSort(first);
        sortHelper.QuickSort(second);

        System.out.print("Отсортированные массивы(Метод QuickSort): ");

        example.print(first);
        example.print(second);
    }

}
