public class Sorts {

    public void QuickSort(int[] a) {
        int startIndex = 0;
        int endIndex = a.length - 1;
        QuickSortBody(startIndex, endIndex, a);
    }

    private void QuickSortBody(int startIndex, int endIndex, int[] a) {
        if (startIndex >= endIndex)
            return;
        int i = startIndex, j = endIndex;
        int k = i - (i - j) / 2;
        while (i < j) {
            while (i < k && (a[i] <= a[k])) {
                i++;
            }
            while (j > k && (a[k] <= a[j])) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        QuickSortBody(startIndex, k, a);
        QuickSortBody(k + 1, endIndex, a);
    }

    public void MergeSort(int[]a){

    }

    private void MergeSortBody(int startIndex, int endIndex, int[] a){
        if (startIndex >= endIndex)
            return;
        
    }
}
