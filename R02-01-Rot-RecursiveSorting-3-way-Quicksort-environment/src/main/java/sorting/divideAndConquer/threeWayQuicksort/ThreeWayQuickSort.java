package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	Util U = new Util();

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex){
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
			if (pivo.compareTo(array[r]) == 0){
				pivo = array[leftIndex + 1];
			}
			else if (pivo.compareTo(array[r])>0){
				i+= 1;
				U.swap(array, i, r);
			}
		}
		U.swap(array, leftIndex, i);
		return i;
	}
}
