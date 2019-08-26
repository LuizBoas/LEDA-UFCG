package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FamilyBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FamilyBST<T>{	
	
	@Override
	public boolean primosPrimeiroGrau(T elem1, T elem2) {
		boolean result = false;
		if (!isEmpty() && elem1 != null && elem2 != null) {
			BSTNode<T> node1 = search(root, elem1);
			BSTNode<T> node2 = search(root, elem2);
			if (!node1.isEmpty() && !node2.isEmpty() && !(node1.getData().compareTo(node2.getData()) == 0)){
				return foundGrau(node1, node2);
			}
		}
		return result;
	}

	@Override
	public boolean primosSegundoGrau(T elem1, T elem2) {
		boolean result = false;
		if (!isEmpty() && elem1 != null && elem2 != null) {
			BSTNode<T> node1 = search(root, elem1);
			BSTNode<T> node2 = search(root, elem2);
			if (!node1.isEmpty() && !node2.isEmpty() && !(node1.getData().compareTo(node2.getData()) == 0)){
				return foundGrau((BSTNode<T>) node1.getParent(), node2);
			}
		}
		return result;
	}

	private boolean foundGrau(BSTNode<T> node1, BSTNode<T> node2) {
		BSTNode<T> father1 = (BSTNode<T>) node1.getParent();
		BSTNode<T> father2 = (BSTNode<T>) node2.getParent();
		if (father1.getData().compareTo(father2.getData()) == 0){
			return false;
		}
		if (father1.getParent().isEmpty() || father2.getParent().isEmpty()){
			return false;
		}
		if((father1.getParent().getData().compareTo(father2.getParent().getData())== 0)){
			return true;
		}
		return false;
	}

	/**
	 * NAO ALTERAR OS METODOS ABAIXO PORQUE SERAO UTULIZADOS PELOS TESTES
	 */
	@Override
	public void insert(T element) {
		insert(root, element);
	}

	protected void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
	}
	
	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}

	protected BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> result = node;
		if (element != null) {
			if (!node.isEmpty()) {
				if (element.compareTo(node.getData()) == 0) {
					result = node;
				} else if (element.compareTo(node.getData()) < 0) {
					result = search((BSTNode<T>)node.getLeft(), element);
				} else {
					result = search((BSTNode<T>)node.getRight(), element);
				}
			}
		}

		return result;
	}
}
