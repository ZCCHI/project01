package com;

/**
 * @author zhangchi
 * @create 2019-04-10
 */
interface Map<K,V>{

    public V put(K k,V v);

    public V get(K k);

    public int size();//大小

    public interface Entity<K,V>{

        public K getKey();

        public V getValue();

    }


}
