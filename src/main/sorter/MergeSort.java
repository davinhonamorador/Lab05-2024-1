package sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] values) {
        // mergesort implementation
        if (values.length <= 1) {
            return values;
        }
        int mid = values.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[values.length - mid];

        System.arraycopy(values, 0, leftArray, 0, mid);
        System.arraycopy(values, mid, rightArray, 0, values.length - mid);

        return merge(sort(leftArray), sort(rightArray));
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}