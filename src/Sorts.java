public class Sorts {

    private int comparisons;
    private int exchange;

    public void QuickSort(int[] a) {
        comparisons = 0;
        exchange = 0;
        int startIndex = 0;
        int endIndex = a.length - 1;
        QuickSortBody(startIndex, endIndex, a);
        System.out.print("\nQuickSort: \n   Количество сравнений: " + comparisons + "\n   Количество обменов(действий): " + exchange + "\n   Количество обменов(обменов): " + exchange / 3);

    }

    private void QuickSortBody(int startIndex, int endIndex, int[] a) {
        if (startIndex >= endIndex)
            return;
        int i = startIndex, j = endIndex;
        int mid = i - (i - j) / 2;

        while (i < j) {
            comparisons++;
            while (i < mid && (a[i] <= a[mid])) {
                i++;
                comparisons += 3;
            }
            while (j > mid && (a[mid] <= a[j])) {
                j--;
                comparisons += 3;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                if (i == mid)
                    mid = j;
                else if (j == mid)
                    mid = i;
                exchange += 3;
                comparisons++;
            }
        }
        QuickSortBody(startIndex, mid, a);
        QuickSortBody(mid + 1, endIndex, a);
    }

    public void Merge(int[] a) {
        comparisons = 0;
        exchange = 0;
        MergeSort(a);
        System.out.print("\nMergeSort: \n   Количество сравнений: " + comparisons + "\n   Количество обменов(обменов): " + exchange);
    }

    public void MergeSort(int[] a) {
        int mid = (a.length) / 2;
        int[] L = new int[mid];
        for (int i = 0; i < L.length; i++) {
            L[i] = a[i];
            exchange++;
        }
        int[] R = new int[a.length - mid];
        for (int i = 0; i < R.length; i++) {
            R[i] = a[i + mid];
            exchange++;
        }
        if (L.length > 1) {
            MergeSort(L);
        }
        if (R.length > 1) {
            MergeSort(R);
        }

        a = Merge(L, R, a);

    }

    private int[] Merge(int[] L, int[] R, int[] a) {
        int i = 0, j = 0, indexA = 0;
        while (i < L.length & j < R.length) {
            if (L[i] > R[j]) {
                a[indexA] = R[j];
                indexA++;
                j++;
                comparisons++;
                exchange++;
            } else {
                a[indexA] = L[i];
                indexA++;
                i++;
                exchange++;
            }
        }
        while (i < L.length) {
            a[indexA] = L[i];
            indexA++;
            i++;
            comparisons++;
            exchange++;
        }
        while (j < R.length) {
            a[indexA] = R[j];
            indexA++;
            j++;
            comparisons++;
            exchange++;
        }
        return a;
    }

    public void InsertionSortClassic(int[] a) {
        comparisons = 0;
        exchange = 0;

        int min, minIndx;
        boolean minFlag;

        for (int n = 0; n < a.length; n++) {
            comparisons++;
            min = a[n];
            minIndx = n;
            minFlag = false;
            for (int i = n; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                    minIndx = i;
                    minFlag = true;
                    comparisons++;
                }
                comparisons++;
            }
            if (minFlag) {
                int temp = a[n];
                a[n] = a[minIndx];
                a[minIndx] = temp;
                exchange += 3;
            }
        }


        System.out.print("\nInsertSort(Classic): \n   Количество сравнений: " + comparisons + "\n   Количество обменов(действий): " + exchange + "\n   Количество обменов(обменов): " + exchange / 3);

    }


    public void InsertionSort(int[] a) {
        comparisons = 0;
        exchange = 0;

        int min, max,
                minIndx, maxIndx;
        boolean minFlag, maxFlag;

        for (int n = 0; n < a.length / 2; n++) {
            min = a[n];
            max = a[n]; //a.length - 1 - n
            minIndx = n;
            maxIndx = n;
            minFlag = false;
            maxFlag = false;
            comparisons++;
            for (int i = n; i < a.length - n; i++) {
                if (a[i] < min) {
                    min = a[i];
                    minIndx = i;
                    minFlag = true;
                    comparisons++;
                } else if (a[i] > max) {
                    max = a[i];
                    maxIndx = i;
                    maxFlag = true;
                    comparisons++;
                }
                comparisons++;
            }
            if (minFlag) {
                int temp = a[n];
                a[n] = a[minIndx];
                a[minIndx] = temp;
                exchange += 3;
            }
            if (maxFlag) {
                int temp = a[a.length - n - 1];
                a[a.length - n - 1] = a[maxIndx];
                a[maxIndx] = temp;
                exchange += 3;
            }
        }
        System.out.print("\nInsertSort(Modified): \n   Количество сравнений: " + comparisons + "\n   Количество обменов(действий): " + exchange + "\n   Количество обменов(обменов): " + exchange / 3);

    }


}
