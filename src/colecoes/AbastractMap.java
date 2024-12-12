/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecoes;

/**
 *
 * @author pedro
 * @param <K>
 * @param <V>
 */

public abstract class AbastractMap<K,V> implements Map<K,V> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    protected static class Entry<K extends Comparable<K>,V> implements Comparable<Entry<K,V>> {
        private K k;
        private V v;
    
        public Entry(K key, V value){
            k = key;
            v = value;
        }
        
        public K getKey(){
            return k;
        }
        
        public V getValue(){
            return v;
        }
        
        public void setKey(K key){
            k = key;
        }
        
        public V setValue(V value){
            V old =v;
            v = value;
            return old;
        }
        
        @Override
        public int compareTo(Entry<K, V> outra){
            return k.compareTo(outra.k);
        }
    }    
}