/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecoes;

/**
 *
 * @author pedro
 */

public class SortedDoublyLinkedList<E extends Comparable<E>> extends DoublyLinkedList<E> {

    private Node<E> ceilingNode(E e) {
        Node<E> n = header.getNext();
        while (n != trailer && e.compareTo(n.getElement()) > 0) n = n.getNext();
        return n;
    }

    public E find(E e) {
        Node<E> n = ceilingNode(e);
        if (n != trailer && e.compareTo(n.getElement()) == 0) return n.getElement();
        else return null;
    }

    public void add(E e) {
        Node<E> n = ceilingNode(e);
        addBetween(e, n.getPrev(), n);
    }

    @Override
    public void addFirst(E e) {
        throw new UnsupportedOperationException("Método de inserção não permitido numa lista ordenada.");
    }

    @Override
    public void addLast(E e) {
        throw new UnsupportedOperationException("Método de inserção não permitido numa lista ordenada.");
    }

    public E put(E e) {
        Node<E> n = ceilingNode(e);
        if (n != trailer && e.compareTo(n.getElement()) == 0) {
            E old = n.getElement();
            n.setElement(e);
            return old;
        } else {
            addBetween(e, n.getPrev(), n);
            return null;
        }
    }

    public E remove(E e) {
        Node<E> n = ceilingNode(e);
        if (n != trailer && e.compareTo(n.getElement()) == 0) return remove(n);
        else return null;
    }
}
