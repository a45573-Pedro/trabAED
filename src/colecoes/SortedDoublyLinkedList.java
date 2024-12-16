/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecoes;


import java.util.Comparator;
/**
 *
 * @author *****
 */



/** Lista duplamente ligada ordenada
 * Inclui métodos que assumem que a lista se encontra ordenada-
 */
public class SortedDoublyLinkedList<E extends Comparable<E>> extends DoublyLinkedList<E> {
    
    /** Método auxiliar privado que procura o nodo com o menor elemento que seja maior
    * ou igual a 'e'.
    * Devolve o nodo Trailer, se não existir na lista nenhum elemento maior ou igual a 'e'
    */
    private Node<E> ceilingNode(E e) {
        Node<E> n= header.getNext();
        while(n!=trailer && e.compareTo(n.getElement())>0) n=n.getNext();
        return n;
    }   
    /** Devolve o primeiro elemento da lista considerado igual a 'e' pelo comparador.
     * Devolve null, se não for encontrado qualquer valor condiderado igual.
     */
    public E find(E e) {
        Node<E> n = ceilingNode(e);
        if(n!=trailer && e.compareTo(n.getElement())==0) return n.getElement();
        else return null;
    }   
    
    // public update methods
    
    /** Inserção ordenada do elemento 'e', com acrescento.
     *  O elemento é inserido independentemente de já existirem elementos considerados
     *  iguais pelo comparador(para permitir coexistirem elemntos iguais). 
     */
    public void add(E e) {
        Node<E> n= ceilingNode(e);
        addBetween(e, n.getPrev(), n); // place just before the n
    }
    
    //Disabling inherited method
    @Override public void addFirst(E e) {throw new UnsupportedOperationException("Método de inserção não permitido numa lista ordenada.");}
    //Disabling inherited method
    @Override public void addLast(E e) {throw new UnsupportedOperationException("Método de inserção não permitido numa lista ordenada.");}
    
    /** Inserção ordenada do elemento e, com atualização.
     *  Caso já exista um elemento considerado igual pelo comparador, o mesmo é substituido
     *  pelo novo elemento e.
     *  Devolve o elemento anterior, caso exista, ou null caso contrário
     */
    public E put(E e) {
        Node<E> n= ceilingNode(e);
        if(n!=trailer && e.compareTo(n.getElement())==0){
            E old=n.getElement();
            n.setElement(e);
            return old;
        }else{
            addBetween(e, n.getPrev(), n); // place just before the n
            return null;
        }
    }    
    /** Devolve e remove o 1º elemento da lista considerado igual a 'e' pelo comparador*/
    public E remove(E e) {
        Node<E> n = ceilingNode(e);
        if(n!=trailer && e.compareTo(n.getElement())==0) return remove(n);
        else return null;
    }    
}
