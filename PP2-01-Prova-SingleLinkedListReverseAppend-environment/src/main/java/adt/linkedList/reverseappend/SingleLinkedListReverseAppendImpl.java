package adt.linkedList.reverseappend;

import adt.linkedList.SingleLinkedListNode;

/**
 * 
 * @see SingleLinkedListReverseAppend
 * 
 * @author campelo
 *
 * @param <T>
 */
public class SingleLinkedListReverseAppendImpl<T> implements SingleLinkedListReverseAppend<T> {
	
	/*
	 * Nao remover esse atributo nem criar outros
	 */
	protected SingleLinkedListNode<T> head;
	
	/*
	 * Nao modifique o construtor
	 * @param head
	 */
	public SingleLinkedListReverseAppendImpl() {
		head = new SingleLinkedListNode<T>();
	}

	/* (non-Javadoc)
	 * @see adt.linkedList.reverseappend.SingleLinkedListReverseAppend#doIt(java.lang.Object)
	 * 
	 * Implemente apenas este metodo de acordo com os comentários da interface.
	 * 
	 */
	@Override
    public void doIt(T elem) {
		if (elem != null){
			if (head.isNIL()){
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode(elem, new SingleLinkedListNode());
				head = newHead;
			}else {
				SingleLinkedListNode previous = new SingleLinkedListNode();
				SingleLinkedListNode aux = head;
				SingleLinkedListNode node = new SingleLinkedListNode();
				while(!aux.isNIL()){
					node = aux.getNext();
					aux.setNext(previous);
					previous = aux;
					aux = node;
				}
				head = previous;
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode(elem, head);
				head = newHead;
			}
		}
	}
	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     */
	@Override
    public String toString() {
    	String retorno = "";
    	SingleLinkedListNode<T> currentNode = this.head;
    	while (currentNode!=null) {
    		if (!retorno.equals("")) {
    			retorno += " ";
    		}
    		retorno += currentNode;
    		currentNode = currentNode.getNext();
    	}
		return retorno;
    }
    
}