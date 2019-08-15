package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return (data == null);
	}

	@Override
	public int size() {
		if(isEmpty()){
			return 0;
		} else {
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		if(isEmpty()){
			return null;
		} else {
			if (data == element){
				return data;
			}else{
				return next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!isEmpty()) {
				if (data == element){
					data = next.data;
					next = next.next;
				}else {
					next.remove(element);
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];

		toArrayRecursive(result, this, 0);
		return result;

	}

	protected void toArrayRecursive(T[] result, RecursiveSingleLinkedListImpl<T> node, int cont) {
		if(!node.isEmpty()) {
			result[cont] = node.getData();
			toArrayRecursive(result, node.next, ++cont);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
