package sorting.divideAndConquer;

import sorting.AbstractSorting;
import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int cpe = (leftIndex + rightIndex) / 2;
            sort(array, leftIndex, cpe);
            sort(array, (cpe + 1), rightIndex);
            mergeS(array, leftIndex, cpe, rightIndex);
        }
    }

    private void mergeS(T[] array, int leftIndex, int cpe, int rightIndex) {
        T[] auxArray = Arrays.copyOf(array, array.length);
        for (int z = leftIndex; z <= rightIndex; z++) {
            auxArray[z] = array[z];
        }

        int i = leftIndex;
        int j = cpe + 1;

        for (int k = leftIndex; k <= rightIndex; k++) {
            if (i > cpe) {
                array[k] = auxArray[j++];
            } else if (j > rightIndex) {
                array[k] = auxArray[i++];
            } else if (auxArray[i].compareTo(auxArray[j]) < 0) {
                array[k] = auxArray[i++];
            } else if (auxArray[i].compareTo(auxArray[j]) >= 0) {
                array[k] = auxArray[j++];
            }

        }
    }
}
