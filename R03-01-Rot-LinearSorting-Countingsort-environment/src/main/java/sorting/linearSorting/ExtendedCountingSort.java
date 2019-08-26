package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (pablwoValidation(array, leftIndex, rightIndex) == true) {
			int maior = array[0];
			int menor = array[0];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (maior < array[i]) {
					maior = array[i];
				}
				if (menor > array[i]) {
					menor = array[i];
				}
			}
			int[] arrayAux = new int[maior - menor + 1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAux[array[i] - menor] += 1;
			}
			for (int i = 0; i < arrayAux.length - 1; i++) {
				arrayAux[i + 1] = arrayAux[i] + arrayAux[i + 1];
			}

			int[] arraySolucao = new int[array.length];

			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayAux[array[i] - menor] -= 1;
				arraySolucao[arrayAux[array[i] - menor]] = array[i];
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
