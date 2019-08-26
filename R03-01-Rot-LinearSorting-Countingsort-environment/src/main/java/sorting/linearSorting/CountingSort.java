package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (pablwoValidation(array, leftIndex, rightIndex) == true) {
			int maior = array[0];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (maior < array[i]) {
					maior = array[i];
				}
			}
			int[] arrayAux = new int[maior + 1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAux[array[i]] += 1;
			}
			for (int i = 0; i < arrayAux.length - 1; i++) {
				arrayAux[i + 1] = arrayAux[i] + arrayAux[i + 1];
			}

			int[] arraySolucao = new int[array.length];

			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayAux[array[i]] -= 1;
				arraySolucao[arrayAux[array[i]]] = array[i];
			}
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arraySolucao[i];
			}

		}
	}


	public Boolean pablwoValidation(Integer[] array, int leftIndex, int rightIndex) {
		if (array == null) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return false;
			}
		}
		if (rightIndex >= array.length || leftIndex >= array.length) {
			return false;
		}
		if (leftIndex < 0 || rightIndex < 0) {
			return false;
		}
		if (leftIndex >= rightIndex) {
			return false;
		}
		return true;
	}

}


