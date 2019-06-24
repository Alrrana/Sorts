public class Main {

    public static void main(String[] args) {
        Arrays arrayHelper = new Arrays();
        Sorts sortHelper = new Sorts();
//        int[] second = arrayHelper.random();
//        int[] second = arrayHelper.CreateStandart();
        int[] second = {1, 2, 3, 7, 5, 4, 3, 2, 1};
//
        System.out.println("Введенный массив: ");

        arrayHelper.print(second);

        int[] third = arrayHelper.copy(second);
        int[] first = arrayHelper.copy(second);


        int mainAlive = 0;
        final int mainFinalAlive = 1;
        class B {

            int outerAlive = 0;
            final int outerFinalAlive = 1;
            Runnable runnable = new Runnable() {
                int innerAlive = 0;
                final int innerFinalAlive = 1;

                @Override
                public void run() {
                    {
                        // mainAlive = 1+mainFinalAlive;
                        outerAlive = 1 + outerFinalAlive;
                        innerAlive = 1 + innerFinalAlive;
                        System.out.println("mainAlive is can be reached, but mainFinalAlive is " + mainFinalAlive + "\nouterAlive is " + outerAlive + "\ninnerAlive is " + innerAlive);
                    }
                }
            };


            public void launchIt() {
                runnable.run();
            }


        }
        B b = new B();
        b.launchIt();


        sortHelper.QuickSort(first);
        sortHelper.Merge(second);
        sortHelper.InsertionSort(third);
        System.out.println("\nОтсортированные массивы(Метод QuickSort): ");
        arrayHelper.print(first);


        System.out.print("Отсортированные массивы(Метод MergeSort): ");
        arrayHelper.print(second);


        System.out.print("\nОтсортированные массивы(Метод InsertionSort): ");

        arrayHelper.print(third);
    }

}
