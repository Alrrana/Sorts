public class Sorts {

    private int comparisons;
    private int exchange;

    public void QuickSort(int[] a) {
        comparisons = 0;
        exchange = 0;
        int startIndex = 0;
        int endIndex = a.length - 1;
        QuickSortBody(startIndex, endIndex, a);
        System.out.print("QuickSort: \n   Количество сравнений: " + comparisons + "\n   Количество обменов(полных): " + exchange + "\n   /Количество обменов(/3): " + exchange / 3);
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
                exchange += 3;
                comparisons++;
            }
        }
        QuickSortBody(startIndex, mid, a);
        QuickSortBody(mid + 1, endIndex, a);
    }

    public void MergeSort(int[] a) {
        int startIndex = 0;
        int endIndex = a.length;
        MergeSortBody(startIndex, endIndex - 1, a);
    }

    private void MergeSortBody(int startIndex, int endIndex, int[] a) {
        if (endIndex - startIndex <= 1)
            return;

        int[] B = new int[endIndex - startIndex];
        for (int i = 0; i < endIndex - startIndex; i++) {
            B[i] = a[i + startIndex];
        }
        int i = startIndex;
        int mid = startIndex - (startIndex - endIndex) / 2;
        int j = mid;

        MergeSortBody(startIndex, mid, a);
        MergeSortBody(mid + 1, endIndex - 1, a);

        int indexA = i;
        while (i < mid & j < endIndex - 1) {
            if (B[i] > B[j]) {
                a[indexA] = B[j];
                indexA++;
                j++;
            } else {
                a[indexA] = B[i];
                indexA++;
                i++;
            }
        }
        while (i <= mid) {
            a[indexA] = B[i];
            indexA++;
            i++;
        }
        while (j <= endIndex - 1) {
            a[indexA] = B[j];
            indexA++;
            j++;
        }
    }
}
