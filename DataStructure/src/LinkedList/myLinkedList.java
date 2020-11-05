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
        var current = first;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void reverse() {
        var previous = first;
        var current = first.next;

        while (current != null) {
            var nextNote = current.next;
            current.next = previous;
            previous = current;
            current = nextNote;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKhFromTheEnd(int k) {
        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public int getKhFromTheEnd2(int k) {
        var b = first;
        for (int i = 0; i < (this.size) - k; i++) {
            b = b.next;
        }
        return b.value;
    }


    public void printMiddle() {
        var a = first;
        var b = first;

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last) {
            System.out.println(a.value);
        } else
            System.out.println(a.value + " " + a.next.value);
    }


    public static void main(String[] args) {
        var link = new myLinkedList();
//        System.out.println(link.isEmpty());
//        link.printLinkedList();
        link.addLast(543);
        link.addLast(32);
        link.addLast(35);
        link.addLast(234);
        link.addLast(4565);
        link.addLast(456234234);
//        link.printLinkedList();
//        System.out.println();
//        link.reverse();
//        link.printLinkedList();
        System.out.println(link.getKhFromTheEnd(4));
        System.out.println(link.getKhFromTheEnd2(4));
        link.printMiddle();
    }


}
