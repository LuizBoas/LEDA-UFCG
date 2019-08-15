package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	Util U = new Util();

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex>= rightIndex){
			return;
		}
		int z = quick(array, leftIndex,rightIndex);

		sort(array, leftIndex, z-1);
		sort(array, z+1, rightIndex);
	}

	private int quick(T[] array, int leftIndex, int rightIndex){
		T pivo = array[leftIndex];
		int i = leftIndex;

		for (int r= leftIndex +1; r<=rightIndex; r++){
			if (pivo.compareTo(array[r])>0){
				i+= 1;
				U.swap(array, i, r);
			}
		}
		U.swap(array, leftIndex, i);
		return i;
	}
}



