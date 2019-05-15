public class Main {

    public static void main(String[] args) {
        Arrays example = new Arrays();
        Sorts sortHelper = new Sorts();
        int[] first = example.random(10);
        int[] second = example.CreateStandart(4);

        example.print(first);
        example.print(second);
    }
}
