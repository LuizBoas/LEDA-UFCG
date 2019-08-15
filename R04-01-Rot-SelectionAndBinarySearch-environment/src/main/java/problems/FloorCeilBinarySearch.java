package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array[0] > x){
			return null;
		}
		if (array[array.length-1] < x){
			return array[array.length-1];
		}
		return floorRecursivo(array,0, array.length -1, x);
	}

	public Integer floorRecursivo(Integer[] array, Integer left , Integer rigth, Integer x){
		Integer numberAnd = null;
		int middle = array.length / 2;
		if (x.equals(array[middle])) {
			numberAnd = x;
		} else if (x < array[middle]) {
			if (array[middle - 1] < x) {
				numberAnd = array[middle - 1];
			} else {
				numberAnd = floorRecursivo(array, left, middle -1, x);
			}
		} else {
			numberAnd = floorRecursivo(array, left, middle +1, x);
		}
		return numberAnd;
	}


	@Override
	public Integer ceil(Integer[] array, Integer x) {
		if (array[0] > x){
			return array[0];
		}
		if (array[array.length-1] > x){
			return null;
		}
		return ceilRecursivo(array,0, array.length -1, x);
	}

	public Integer ceilRecursivo(Integer[] array, Integer left , Integer rigth, Integer x){
		Integer numberAnd = null;
		if(left <= rigth) {
			int middle = array.length / 2;
			if (x.equals(array[middle])) {
				numberAnd = x;
			} else if (x > array[middle]) {
				if (array[middle + 1] > x) {
					numberAnd = array[middle + 1];
				} else {
					numberAnd = ceilRecursivo(array, middle + 1, rigth, x);
				}
			} else {
				numberAnd = ceilRecursivo(array, left, middle - 1, x);
			}
		}
		return numberAnd;
	}

}
