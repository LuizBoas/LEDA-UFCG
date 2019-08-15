package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.stack.StackOverflowException;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		}else {
			list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T aux;
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}else {
			aux = list.toArray()[0];
			list.removeFirst();
		}
		return aux;
	}

	@Override
	public T head() {
		T aux;
		if (this.isEmpty()){
			aux = null;
		}else {
			aux = list.toArray()[0];
		}
		return aux;

	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}

}
