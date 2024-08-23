package sorter;

public class QuickSorter implements Sorter {
    public int[] sort(int[] values) {
        // quicksort implementation
        quickSort(values, 0, values.length - 1);
        return values;
    }

    private void quickSort(int[] values, int low, int high) {
        if (low < high) {
            int pi = partitionsort(values, low, high);
            quickSort(values, low, pi - 1);
            quickSort(values, pi + 1, high);
        }
    }

    public int partitionsort(int[] values, int low, int high) {
        int pivot = values[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (values[j] < pivot) {
                i++;
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
        int temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;

        return i + 1;
    }

    public int partition(int[] values, int low, int high) {
        int pivo = values[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && values[left] <= pivo) {
                left++;
            }
            while (left <= right && values[right] > pivo) {
                right--;
            }
            if (left < right) {
                int temp = values[left];
                values[left] = values[right];
                values[right] = temp;
            }
        }
        values[low] = values[high];
        values[high] = pivo;

        return right;
    }
    
}