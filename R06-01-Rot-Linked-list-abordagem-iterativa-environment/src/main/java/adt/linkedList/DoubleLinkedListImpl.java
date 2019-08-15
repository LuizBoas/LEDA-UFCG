package adt.linkedList;

import java.util.DuplicateFormatFlagsException;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {

		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHeadNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
				new DoubleLinkedListNode<T>());
		newHeadNode.next = head;
		((DoubleLinkedListNode<T>) head).previous = newHeadNode;

		if (head.isNIL()) {
			last = newHeadNode;
		}

		head = newHeadNode;

	}

	@Override
	public void removeFirst() {
		if (!head.isNIL()) {
			head = head.getNext();

			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			}

			((DoubleLinkedListNode<T>) head).setPrevious(new DoubleLinkedListNode<T>());
		}

	}

	@Override
	public void insert(T element) {
		if (element != null) {

			if (this.isEmpty()) {

				this.head.setData(element);
				this.head.setNext(new DoubleLinkedListNode<T>());
				this.last.setNext(new DoubleLinkedListNode<T>());
				this.last.setPrevious(new DoubleLinkedListNode<T>());
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<T>());

			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;

				while (!aux.getNext().isNIL()) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}

				((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux);
				this.last = (DoubleLinkedListNode<T>) aux.getNext();
				aux.getNext().setData(element);
				aux.getNext().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!last.isNIL()) {
			last = last.getPrevious();

			if (last.isNIL()) {
				head = last;
			}
			last.setNext(new DoubleLinkedListNode<T>());
		}

	}

	public void inverteDOuble() {
		if(!isEmpty()){
			DoubleLinkedListNode<T> aux = last;
			while (!aux.isNIL()){
				DoubleLinkedListNode<T> tempPrevious = (DoubleLinkedListNode<T>) aux.previous;
				DoubleLinkedListNode<T> temp = (DoubleLinkedListNode<T>) aux.next;
				aux.next = aux.previous;
				aux.previous = temp;
				aux = tempPrevious;
			}
			DoubleLinkedListNode<T> temp = (DoubleLinkedListNode<T>) head;
			this.head = this.last;
			this.last = temp;
		}

	}




	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
