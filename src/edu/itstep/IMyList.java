package edu.itstep;

public interface IMyList<T> {

    void insertFirst(T item);

    void insertLast(T item);

    void removeFirst();

    void removeLast();
}
