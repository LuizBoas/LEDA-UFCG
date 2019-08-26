package problems;

/**
 * 
 * Dado um array ordenado de elementos comparaveis e um outro elemento comparavel, 
 * implemente o metodo que conte as ocorrências do elemento no array. 
 * 
 * Restricoes:
 * - a complexidade esperada é O (log.n). Soluções com tempo O(n) ou superiores serão desconsideradas.
 * - voce nao pode usar memoria extra
 * - voce nao pode usar metodos prontos da bilbioteca de arrays (exceto o metodo length)
 * - Dica: tente pensar numa forma eficiente (em log n) de descobrir a posicao de um 
 *   elemento no array e use essa ideia para contar as ocorrencias desse elemento no array
 * 
 * @author campelo
 *
 * @param <T>
 */
public class OccurrencesCounterImpl<T extends Comparable<T>> {
	/*
	 * Se elem está presente no array[], retorna a quantidade de ocorrências de elem.
	 * Caso contrário, retorna 0.
	 */
	public int count(T[] array, T elem) {
		int meio = array.length/2;
		int cont = 0;
		return findElemento(array, 0, meio, elem, cont) + findElemento(array, meio + 1, array.length - 1, elem, cont);

	}
	private int findElemento(T[] array, int left, int right, T elem, int cont) {
		if (array[left].compareTo(elem) == 0 ){
			if (left == right){
				return cont;
			}else {
				findElemento(array, left + 1, right, elem, cont);
			}
		}else if (array[left].compareTo(elem) > 0 || array[left].compareTo(elem) < 0){
			if (left == right) {
				return cont;
			}else {
				findElemento(array, left + 1, right, elem, cont);
			}
		}else if(left == right){
			return cont;
		}return findElemento(array, left + 1, right, elem, cont);
	}

}
