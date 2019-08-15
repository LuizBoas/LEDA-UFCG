package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();
		}
		tail++;
		elements++;
		array[tail] = element;
		if (tail == array.length){
			tail = -1;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){
			throw new QueueUnderflowException();
		}
		head++;
		T result = array[head];
		if (head == array.length){
			head = -1;
		}
		return result;
	}

	@Override
	public T head() {
		if (head == -1){
			return array[0];
		}
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		return (elements == 0);
	}

	@Override
	public boolean isFull() {
		return (elements == array.length);
	}

}
