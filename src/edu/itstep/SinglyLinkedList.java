package edu.itstep;

public class SinglyLinkedList<T> implements IMyList<T> {
    private Node head;

    @Override
    public void insertFirst(T item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void insertLast(T item) {
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        Node newNode = new Node();
        newNode.data = item;
        current.next = newNode;
    }

    @Override
    public void removeFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
    }

    @Override
    public void removeLast() {
        if (this.head != null) {
            if (this.head.next == null) {
                this.head = null;
            } else {
                Node temp = new Node();
                temp = this.head;
                while (temp.next.next != null)
                    temp = temp.next;
                Node lastNode = temp.next;
                temp.next = null;
                lastNode = null;
            }
        }
    }

    public void displayAllItems() {
        System.out.println("LinkedList (head --> last) ");
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }
}
