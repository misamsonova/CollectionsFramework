package org.example;

public interface CarSet<T> extends CarCollection<T> {
    boolean add(T car);
    boolean remove(T car);
    int size();
    void clear();
    boolean contains(T car);
}
