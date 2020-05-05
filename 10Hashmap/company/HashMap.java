package com.company;
import java.util.HashSet;

public class HashMap<K, V extends Comparable<V>> {
    private final double loadfactor = 0.75;
    private int capacity = 5;
    private int size = 0;
    private Entity<K, V>[] hmap;

    public HashMap() { hmap = new Entity[capacity]; }

    public boolean isEmpty(){
        for (Entity<K, V> each : hmap)
            if (each != null)
                return false;
        return true;
    }
    public void clear(){
        capacity = 10;
        size = 0;
        hmap = new Entity[capacity];
    }

    public V get(K key){
        int hash_index = Math.abs(key.hashCode()) % capacity;
        for (int i = 0; i < capacity; i++){
            Entity n = get(key, hmap[index(hash_index + i)]);
            if (n !=null){
                return (V) n.getValue();
            }
        }
        return null;
    }
    private Entity get(K key, Entity cell){
       if (cell == null) return null;
       else if(cell.getKey().equals(key)) return cell;
       return get(key, cell.getNext());
    }

    public void remove(K key){
        int hash_index = Math.abs(key.hashCode()) % capacity;
        for (int i=0 ; i < capacity; i++){
            Entity entity = hmap[index(hash_index + i)];
            if (entity != null) {
                int n = entity.getHeight();
                hmap[index(hash_index + i)] = remove(key, entity);
                if (hmap[index(hash_index + i)] == null || hmap[index(hash_index + i)].getHeight() != n) break;
            }
        }
    }
    private Entity remove(K key, Entity cell){
        if (cell == null) return null;
        else if (cell.getKey().equals(key))
            return cell.getNext();
        cell.setNext(
                remove(key, cell.getNext())
        );
        cell.setHeight(
                1 + height(cell.getNext())
        );
        return cell;
    }

    public HashSet<K> keys(){
        HashSet<K> keys = new HashSet<>();
        for (Entity<K,V> each : hmap)
            if (each != null)
                keys.addAll(cellKeys(each));
        return keys;
    }
    private HashSet<K> cellKeys(Entity entity){
        HashSet<K> hashSet = new HashSet<>();
        if (entity == null) return hashSet;
        hashSet.add((K) entity.getKey());
        return cellKeys(entity.getNext());
    }

    public HashSet<V> values(){
        HashSet<V> values = new HashSet<>();
        for (Entity<K,V> each : hmap)
            if (each != null)
                values.addAll(cellValues(each));
        return values;
    }
    private HashSet<V> cellValues(Entity entity){
        HashSet<V> hashSet = new HashSet<>();
        if (entity == null) return hashSet;
        hashSet.add((V) entity.getValue());
        return cellValues(entity.getNext());
    }

    public void put(K key, V value){
        if (size / capacity >= loadfactor)
            rehash();

        if (
                put(
                        new Entity<>(key,value),
                        Math.abs(key.hashCode()) % capacity
                ))
        {size++;}
    }
    private boolean put(Entity entity, int hash_index){
        Entity cell = hmap[hash_index];
        if (cell == null)
            hmap[hash_index] = entity;
        else if (cell.getHeight() < cell_loadFactor()){
            hmap[hash_index] = addCell(cell, entity);
        }else {
            put(entity, (hash_index + 1) % capacity);
        }
        return true;
    }
    private void put(Entity entity){put(entity, Math.abs(entity.getKey().hashCode()) % capacity);}

    private Entity<K, V> addCell(Entity root, Entity next){
        if (root == null) return next;
        if (root.getKey().equals(next.getKey())){
            next.setNext(
                    root.getNext()
            );
            return next;
        }
        root.setNext(
                addCell(root.getNext(),next)
        );
        root.setHeight(
                1 + height(root.getNext())
        );
        return root;
    }

    private void rehash(){
        capacity += 10;
        Entity<K,V>[] old = hmap;
        hmap = new Entity[capacity];
        for (int i=0; i < old.length; i++)
            if (old[i] != null)
                if (old[i].getHeight() > 1)
                    reCell(old[i]);
                else
                    put(
                            new Entity((K)old[i].getKey(), (V)old[i].getValue())
                    );

    }
    private void reCell(Entity entity){
        if (entity == null)return;
        put(
                new Entity((K)entity.getKey(), (V)entity.getValue())
        );
        reCell(entity.getNext());
    }

    public void print(){
        for (int i = 0; i < capacity; i++){
            System.out.printf(i + "--->");
            if (hmap[i] != null){
                if (hmap[i].getHeight() > 1){
                    print(hmap[i]);
                }else{
                    System.out.println("["+hmap[i].getValue()+"]");
                }
            }else {System.out.println("null");}
        }
    }
    private void print(Entity entity){
        if (entity == null) {System.out.println(); return;}
        System.out.printf("[" + entity.getValue()+ "]" + " ");
        print(entity.getNext());
    }

    private int cell_loadFactor(){ return (int)(1.0 / (1.0 - loadfactor)); }
    private int height(Entity entity) {
        if (entity == null)
            return 0;
        return entity.getHeight();
    }
    private boolean isCouple(Entity x, Entity y){
        if (x == null) return false;
        return x.getKey().equals(y.getKey()) || isCouple(x.getNext(), y);
    }
    private int index(int n){return (n >= capacity) ? (n%capacity) : n;}
}
