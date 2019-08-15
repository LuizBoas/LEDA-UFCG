package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return hRecursivo(this.root, -1);
	}

	private int hRecursivo(BSTNode<T> node, int cont) {

		if (!node.isEmpty()) {
			int left = hRecursivo((BSTNode<T>) node.getLeft(), cont + 1);
			int right = hRecursivo((BSTNode<T>) node.getRight(), cont + 1);

			cont = Math.max(left, right);
		}
		return cont;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (!isEmpty()) {
			return searchRecursivo(this.root, element);
		} else {
			return new BSTNode.Builder().build();
		}
	}

	protected  BSTNode<T> searchRecursivo(BSTNode<T> node, T element) {
		BSTNode<T> result;

		if (node.isEmpty()) {
			result = new BSTNode.Builder().build();
		}
		else if (element.compareTo(node.getData()) > 0) {
			result = searchRecursivo((BSTNode<T>) node.getRight(), element);
		}
		else if (element.compareTo(node.getData()) == 0) {
			result= node;
		}
		else {
			result = searchRecursivo((BSTNode<T>) node.getLeft(), element);
		}
		return result;
	}

	@Override
	public void insert(T element) {
		insertRecursivo(this.root, element);
	}

	protected void insertRecursivo(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder().parent(node).build());
			node.setRight(new BSTNode.Builder().parent(node).build());
		} else {
			if (element.compareTo(node.getData()) > 0)
				insertRecursivo((BSTNode<T>) node.getRight(), element);

			else if (element.compareTo(node.getData()) < 0)
				insertRecursivo((BSTNode<T>) node.getLeft(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if (isEmpty()) {
			return null;
		}else {
			return maximumRec(this.root);
		}
	}

	protected BSTNode<T> maximumRec(BSTNode<T> node) {
		if (!node.getRight().isEmpty()) {
			return maximumRec((BSTNode<T>) node.getRight());
		} else
			return node;
	}


	@Override
	public BSTNode<T> minimum() {
		if (isEmpty()) {
			return null;
		}
		else {
			return minimumRec(this.root);
		}
	}

	protected BSTNode<T> minimumRec(BSTNode<T> node) {
		if (!node.getLeft().isEmpty()) {
			return minimumRec((BSTNode<T>) node.getLeft());
		}else {
			return node;
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				return minimumRec((BSTNode<T>) node.getRight());
			}
			else {
				BSTNode<T> sucessorNode = (BSTNode<T>) node.getParent();
				while (sucessorNode != null && sucessorNode.getData().compareTo(node.getData()) < 0) {
					node = sucessorNode;
					sucessorNode = (BSTNode<T>) node.getParent();
				}
				return sucessorNode;
			}
		}
		return null;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty())
				return maximumRec((BSTNode<T>) node.getLeft());
			else {
				BSTNode<T> predecessorNode = (BSTNode<T>) node.getParent();

				while ( predecessorNode != null &&  predecessorNode.getData().compareTo(node.getData()) > 0) {
					node =  predecessorNode;
					predecessorNode = (BSTNode<T>) node.getParent();
				}
				return  predecessorNode;
			}
		}
		return null;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);

			} else if (removerAux(node)) {
				if (node.getParent() != null) {
					if (!node.getParent().getLeft().equals(node)) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}

					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getRight();
					} else {
						this.root = (BSTNode<T>) node.getLeft();
					}
					this.root.setParent(null);
				}
			} else {
				T sucessorNode = sucessor(node.getData()).getData();
				remove(sucessorNode);
				node.setData(sucessorNode);
			}
		}
	}

	private boolean removerAux(BSTNode<T> node) {
		return ((node.getRight().isEmpty() && !node.getLeft().isEmpty()
				|| node.getLeft().isEmpty() && !node.getRight().isEmpty()));
	}

	@Override
	public T[] preOrder() {

		@SuppressWarnings("unchecked")
		T[] arrayResult = (T[]) new Comparable[this.size()];
		List<T> aux = new ArrayList<T>();

		if (!this.isEmpty()) {
			preOrderRecursivo(this.root, aux);

			aux.toArray(arrayResult);
		}
		return arrayResult;
	}

	private void preOrderRecursivo(BSTNode<T> node, List<T> aux) {
		if (!node.isEmpty()) {
			aux.add(node.getData());
			preOrderRecursivo((BSTNode<T>) node.getLeft(), aux);
			preOrderRecursivo((BSTNode<T>) node.getRight(), aux);
		}
	}

	@Override
	public T[] order() {
		@SuppressWarnings("unchecked")
		T[] arrayResult = (T[]) new Comparable[this.size()];
		List<T> aux = new ArrayList<T>();

		if (!this.isEmpty()) {
			OrderRecursivo(this.root, aux);

			aux.toArray(arrayResult);
		}
		return arrayResult;
	}

	private void OrderRecursivo(BSTNode<T> node, List<T> aux) {
		if (!node.isEmpty()) {
			OrderRecursivo((BSTNode<T>) node.getLeft(), aux);
			aux.add(node.getData());
			OrderRecursivo((BSTNode<T>) node.getRight(), aux);
		}
	}

	@Override
	public T[] postOrder() {

		@SuppressWarnings("unchecked")
		T[] arrayResult = (T[]) new Comparable[this.size()];
		List<T> aux = new ArrayList<T>();
		if (!this.isEmpty()) {
			postOrderRec(this.root, aux);
			aux.toArray(arrayResult);
		}

		return arrayResult;
	}

	private void postOrderRec(BSTNode<T> node, List<T> array) {

		if (!node.isEmpty()) {
			postOrderRec((BSTNode<T>) node.getLeft(), array);
			postOrderRec((BSTNode<T>) node.getRight(), array);
			array.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
