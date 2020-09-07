package single_linked_lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* 
 * 		Implementation of a simple single-linked list in order to understand the concept.
 * 		Only the methods covered in the course litterature (Data structures - Abstraction 
 * 		and Design Using Java 3rd ed. by Koffman, Wolfgang) that were left as exercies have 
 * 		been implemented. 
 * 
 * 		(Probably an unnecessary disclaimer) 
 * 		Due to it being an implementation based on their examples this is
 * 		only an educational aspiration to understand the theory of the course, 
 * 		nothing else. 
 * 
 * 		Null elements are permitted in this implementation of a single-linked list. 
 */

public class SingleLinkedList<E> implements List<E> {

	private Node<E> first;
	private int size;

	/*
	 * ---------- Implemented methods ----------
	 */

	public SingleLinkedList() {
		first = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (size == 0) {
			return false;
		}

		Node<E> node = first;
		while (node.next != null) {
			node = node.next;
			if (node.data.equals(o)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean add(E e) {
		size++;
		Node<E> node = first;

		if (node == null) {
			first = new Node<E>(e);
			first.next = null;
			return true;
		}

		while (node.next != null) {
			node = node.next;
		}

		node.next = new Node<E>(e);
		node.next.next = null;
		return true;
	}

	@Override
	public E get(int index) {

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> node = first;

		for (int i = 0; i < index; i++) {
			node = node.next;
		}

		return node.data;
	}

	@Override
	public E set(int index, E element) {
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> node = first;

		for (int i = 0; i < index; i++) {
			node = node.next;
		}

		E formerData = node.data;
		node.data = element;
		return formerData;
	}

	@Override
	public void add(int index, E element) {
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> node = first;
		size++;

		Node<E> newNode = new Node<E>(element);

		/*
		 * Handles the special case with index 0, due to issues with nullpointers for
		 * empty list.
		 */
		if (index == 0) {
			newNode.next = first;
			first = newNode;
			return;
		}

		for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}

		newNode.next = node.next;
		node.next = newNode;
	}

	@Override
	public E remove(int index) {
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> node = first;

		if (node != null && index == 0) {
			size--;
			E data = node.data;
			first = first.next;
			return data;
		}

		for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}

		E formerData = null;

		try {
			formerData = node.next.data;
			node.next = node.next.next;
			size--;
		} catch (Exception e) {
			node.next = null;
		}

		return formerData;
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		Node<E> node = first;

		if (first.data.equals(o)) {
			return index;
		}

		while (node.next != null) {
			node = node.next;
			index++;
			if (node.data.equals(o)) {
				return index;
			}
		}

		return -1;
	}

	/*
	 * ---------- Unimplemented methods ----------
	 */

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	/*
	 * ---------- Inner node class ----------
	 */

	/** A Node is the building block for a single‐linked list. */
	private static class Node<E> {
		// Data Fields
		/** The reference to the data. */
		private E data;
		/** The reference to the next node. */
		private Node<E> next;

		// Constructors
		/**
		 * Creates a new node with a null next field.
		 * 
		 * @param dataItem The data stored
		 */
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		/**
		 * Creates a new node that references another node. @param dataItem The data
		 * stored
		 * 
		 * @param nodeRef The node referenced by new node
		 */
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

}
