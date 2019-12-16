package com;


/**
 * @author zhangchi
 * @create 2019-04-10
 */
public class HashMap<K, V> implements Map<K, V> {

    private static int defalutLength = 16;
    private static Double defalutLoader = 0.75;
    private Entity[] table = null;
    private int size = 0;

    public HashMap(int length, Double loader) {
        this.defalutLength = length;
        this.defalutLoader = loader;
        table = new Entity[defalutLength];
    }

    public HashMap() {
        this(defalutLength, defalutLoader);
    }

    @Override
    public V put(K k, V v) {
        size++;
        int index = hash(k);//获取哈希值
        Entity<K, V> entity = table[index];
        if (entity == null) {
            table[index] = newEntity(k, v, null);
        } else {
            table[index] = newEntity(k, v, entity);
        }
        return (V) table[index].next.getValue();
    }


    @Override
    public V get(K k) {
        int index = hash(k);
        if (table[index] == null) {
            return null;
        }
        return find(k, table[index]);

    }

    @Override
    public int size() {
        return size;
    }

    public int hash(K k) { //hash算法
        int m = defalutLength;
        int i = k.hashCode() % m;
        return i >= 0 ? i : -i;
    }

    //创建一个新的enttiy
    private Entity newEntity(K k, V v, Entity next) {

        return new Entity(k, v, next);
    }

    private V find(K k, Entity entity) {
        if (k == entity.getKey() || k.equals(entity.getKey())) {
            return (V) entity.getValue();
        } else {
            if (entity.next != null) {
                return (V) find(k, entity.next);
            }
        }
        return null;
    }

    class Entity<K, V> implements Map.Entity<K, V> {
        K k;
        V v;
        Entity<K, V> next;

        public Entity(K k, V v, Entity<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

}
