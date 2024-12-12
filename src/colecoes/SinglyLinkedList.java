/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecoes;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author pedro    
 * @param <E>    
 */
public class SinglyLinkedList<E> implements Iterable<E>{
    
    private static class Node<E>{
    private  E element;
    private Node<E> next;
    
    public Node(E e, Node<E> n){
        element = e;
        next = n;
    } 
    
    public E getElement(){
        return element;
    }
    
    public Node<E> getNext(){
        return next;
    }
    
    public void setNext(Node<E> n){
        next = n;
    }
    }
    
    
    
    private Node<E> head = null;
    
    private Node<E> tail = null;
    
    private int size = 0;
    
    public SinglyLinkedList() {}
    
    public int size(){ 
        return size;
    }
    
    public boolean isEmpty(){ 
        return size == 0;
    }
    
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    
    
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    
    public void addFirst(E e){
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }
    
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }    
         
   public E removeFirst(){
       if(isEmpty()) return null;
       E answer = head.getElement();
       head = head.getNext();
       size--;
       if(size == 0)
           tail = null;
       return answer;
   }
    
    /**
     *
     * @return
     */
   
    @Override
    public Iterator<E> iterator() { 
        return new SLLIterator();
    }
   
    private class SLLIterator implements Iterator<E> {
        private Node<E> cursor = head;
        
        @Override
        public boolean hasNext() {
            return cursor != null;
        }
        
        @Override
        public E next(){
            if(cursor == null) throw new NoSuchElementException("Sem proximo elemento");
            Node<E> current = cursor;
            cursor = cursor.getNext();
            return current.getElement();
        }
    }
    
    
    
    
}
