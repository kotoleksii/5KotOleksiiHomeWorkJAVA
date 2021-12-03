package edu.itstep;

public class Node<T> {
    public Node next;
    public T data;

    public void displayNodeData() {
        System.out.print("\t" + data + "\t");
    }
}
