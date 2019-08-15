package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = this.head;
		while (!auxHead.isNIL()){
			size++;
			auxHead = auxHead.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		while (!auxHead.isNIL() && auxHead.data != element){
			auxHead = auxHead.next;
		}
		return auxHead.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if (this.head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode(element, this.head);
			this.head = newHead;
		} else {
			while (!auxHead.next.isNIL()){
				auxHead = auxHead.next;
			}
			SingleLinkedListNode newNode = new SingleLinkedListNode(element, auxHead.next);
			auxHead.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if (this.head.data == element){
			this.head = this.head.next;
		} else {
			SingleLinkedListNode auxHead = this.head;
			SingleLinkedListNode previous = this.head;
			while (!auxHead.isNIL() && auxHead.data != element){
				previous = auxHead;
				auxHead = auxHead.next;
			}
			if (!auxHead.isNIL()){
				previous.next = auxHead.next;
			}
		}

	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = this.head;

		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[this.size()];

		int i = 0;
		if (!this.isEmpty()) {
			while (!aux.isNIL()) {
				result[i] = aux.getData();
				aux = aux.getNext();
				i++;
			}
		}
		return result;
	}


	public int indexOf(T element){
		int index = -1;
		if(!isEmpty()){
			SingleLinkedListNode<T> aux = head;
			while(!aux.isNIL() && !aux.data.equals(element)){
				index ++;
				aux = aux.next;
			}
			if(!aux.isNIL()){
				index ++;
			}
		}
		return index;
	}

	public int lastIndexOf(T element){
		int index = -1;
		if(!isEmpty()){
			SingleLinkedListNode<T> aux = head;
			int auxindex = -1;
				while (!aux.isNIL()) {
					index ++;
					if (aux.data.equals(element)){
						auxindex = index;
					}
					aux = aux.next;
				}
		}
		return index;
	}

	public void inverte(){
		if(!isEmpty()){
			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> node;
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>();
			while (!aux.isNIL()){
				node = aux.next;
				aux.next = newHead;
				newHead = aux;
				aux = node;
			}
			this.head = newHead;
		}
	}

	public void removerIndex(int index){
		if(!isEmpty()){
			if (index == 0){
				this.head = head.next;
			}else {
				SingleLinkedListNode<T> auxBehind = head;
				SingleLinkedListNode<T> aux= head.next;
				while (!aux.isNIL() && index != 1) {
					auxBehind = aux;
					aux = aux.next;
					index --;
				}
				if (!aux.isNIL() && index == 1){
					auxBehind.next = aux.next;
				}

			}
		}
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
