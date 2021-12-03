package edu.itstep;

public class ArrayListUser<T> implements IMyList<T> {
    private Object[] data;
    private int size = 0;
    private int globalSize = 2;
    private int pointer;

    public ArrayListUser() {
        data = new Object[globalSize];
        pointer = globalSize / 2;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        final T result = (T) data[indexMask(index)];
        return result;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void insertFirst(T item) {
        checkResize();
        ++size;
        data[pointer - size] = item;
    }

    @Override
    public void insertLast(T item) {
        checkResize();
        ++size;
        data[pointer] = item;
        ++pointer;
    }

    public void set(int index, T item) {
        checkIndex(index);
        data[indexMask(index)] = item;
    }

    @Override
    public void removeFirst() {
        this.remove(0);
    }

    @Override
    public void removeLast() {
        this.remove(size - 1);
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = indexMask(index) + 1; i < pointer; ++i)
            data[i - 1] = data[i];
        data[pointer - 1] = null;
        --pointer;
        --size;
    }

    private int indexMask(int index) {
        return pointer - size + index;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error!");
        }
    }

    private void checkResize() {
        if (pointer - size == 0 || pointer == globalSize) {
            int tmpPointer = pointer;
            globalSize *= 2;
            pointer = globalSize / 2 - (int) Math.round((double) size / 2) + size;
            Object[] temp = new Object[globalSize];
            for (int i = pointer - size, j = 0; i < pointer; ++i, ++j) {
                final T result = (T) data[tmpPointer - size + j];
                temp[i] = result;
            }
            data = temp;
        }
    }
}