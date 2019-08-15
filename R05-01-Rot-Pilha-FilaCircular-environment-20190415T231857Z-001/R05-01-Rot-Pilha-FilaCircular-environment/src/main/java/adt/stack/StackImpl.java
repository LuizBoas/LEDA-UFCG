package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public boolean isFull() {
		if (top == array.length -1){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
		}
		top = top + 1;
		array[top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()){
			throw new StackUnderflowException();
		}
		top = top -1;
		return array[top + 1];
	}

}
