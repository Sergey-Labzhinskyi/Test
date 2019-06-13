package Test;

import Test.MyLinkedList.Node;


public class ReverseMyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.add(new Node(3));
        myList.add(new Node(15));
        myList.add(new Node(6));


        printLinkedList(myList);
        //  reverseLinkedList(myLinkedList);
        //printLinkedList(myList);

        myList.head = recursiveReverseLinkedList(myList.head);
        printLinkedList(myList);

    }

    public static void printLinkedList(MyLinkedList linkedList) {
        Node h = linkedList.head;
        while (linkedList.head != null) {
            System.out.print(linkedList.head.data + " ");
            linkedList.head = linkedList.head.next;
        }
        System.out.println();
        linkedList.head = h;
    }

    public static void reverseLinkedList(MyLinkedList linkedList) {
        Node previous = null;
        Node current = linkedList.head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        linkedList.head = previous;
    }


    public static Node recursiveReverseLinkedList(Node head) {
        Node first;

        if (head == null || head.next == null)
            return head;

        first = recursiveReverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return first;
    }


}

class MyLinkedList {

    public Node head;

    public static class Node {

        public Node next;
        public Integer data;

        Node(Integer data) {
            this.data = data;
            next = null;
        }
    }

    public void add(Node n) {
        if (head == null)
            head = n;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = n;
        }
    }
}