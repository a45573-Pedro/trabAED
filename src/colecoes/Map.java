/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package colecoes;

/**
 *
 * @author pedro
 * @param <K>
 * @param <V>
 */
public interface Map<K,V> {
    int size();
    boolean isEmpty();
    V get(K key);
    V put (K key, V value);
    V remove (K key);
    Iterable<K> keySet();
    
}
