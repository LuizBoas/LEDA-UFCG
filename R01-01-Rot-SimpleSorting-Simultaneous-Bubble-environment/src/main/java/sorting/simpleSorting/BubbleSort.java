package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	Util U = new Util();

	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex; i < rightIndex + 1; ++i) {
			for(int j = leftIndex; j < rightIndex; ++j) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					U.swap(array, j, j + 1);
				}
			}
		}

	}
}

