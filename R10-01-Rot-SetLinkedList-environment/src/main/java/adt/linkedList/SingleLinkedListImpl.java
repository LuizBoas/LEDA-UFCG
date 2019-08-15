package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (this.head.isNIL());
	}

	@Override
	public int size() {
		int cont = 0;
		if(!isEmpty()){
			SingleLinkedListNode aux = this.head;
			while (!aux.isNIL()){
				cont ++;
				aux = aux.next;
			}
		}
		return cont;
	}

	@Override
	public T search(T element) {
		T result = null;
		SingleLinkedListNode aux = head;
		while(!aux.isNIL() && !aux.data.equals(element)){
			aux = aux.next;
		}if(!aux.isNIL()){
			result = (T) aux.data;
		}
		return result;

	}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			SingleLinkedListNode newHead = new SingleLinkedListNode(element, head);
			head = newHead;
		}else {
			SingleLinkedListNode aux = head;
			while (!aux.next.isNIL()){
				aux = aux.next;
			}
			SingleLinkedListNode newElement = new SingleLinkedListNode(element, aux.next);
			aux.next = newElement;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (head.data.equals(element)){
				head = head.next;
			}else {
				SingleLinkedListNode aux = head;
				SingleLinkedListNode previous = new SingleLinkedListNode();
				while (!aux.isNIL() && !aux.data.equals(element)) {
					previous = aux;
					aux = aux.next;
				}
				if (!aux.isNIL()) {
					previous.next = aux.next;
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[this.size()];
		SingleLinkedListNode aux = head;
		int cont = 0;
		while(!aux.isNIL()){
			result[cont] = (T) aux.data;
			cont++;
			aux = aux.next;
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
