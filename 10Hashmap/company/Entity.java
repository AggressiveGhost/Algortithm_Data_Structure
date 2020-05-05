package com.company;

import java.util.Objects;

public class Entity<K, V extends Comparable<V>> {
    private K key;
    private V value;
    private Entity<K, V> next = null;
    private int height = 1;

    public Entity(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Entity() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entity<K, V> getNext() {
        return next;
    }

    public void setNext(Entity<K, V> next) {
        this.next = next;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?, ?> entity = (Entity<?, ?>) o;
        return Objects.equals(key, entity.key) &&
                Objects.equals(value, entity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
