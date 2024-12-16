/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecoes;

import java.util.Set;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author pedro
 * @param <E>
 */


public class DoublyLinkedList<E> implements Iterable<E> {
    protected static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setElement(E e) { element = e; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }

    protected Node<E> header;
    protected Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() {
        return header.getNext().getElement();
    }
    public E last() {
        return trailer.getPrev().getElement();
    }
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }
    protected void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    protected E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public Iterator<E> iterator() { return new DLLIterator(); }

    private class DLLIterator implements Iterator<E> {
        private Node<E> cursor = header.getNext();
        public boolean hasNext() { return cursor != trailer; }
        public E next() {
            if (cursor == trailer) throw new NoSuchElementException("Sem próximo elemento");
            Node<E> current = cursor;
            cursor = cursor.getNext();
            return current.getElement();
        }
    }
}
