package LinkedList;

import java.util.NoSuchElementException;

public class myLinkedList {

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;

    public int size;

    public myLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addLast(int item) {
        var node = new Node(item);
        System.out.println("adding an item: " + item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        System.out.println("deleting an item from the last: ");
        if (first == last) first = last = null;
        else {
            var previous = first;
            var current = first;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            last = previous;
        }
        size--;
    }

    public void printLinkedList() {
        if (isEmpty()) System.out.println("EMPTY");
        ;

        var current = first;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }


    public static void main(String[] args) {
        var link = new myLinkedList();
        System.out.println(link.isEmpty());
        link.printLinkedList();
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.printLinkedList();

    }


}
