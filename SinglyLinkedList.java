package Sync;
 class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void deleteNode(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        previous.next = current.next;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(40);

        list.printList(); // Output: 40 -> 20 -> 10 -> 30 -> null

        list.deleteNode(20);

        list.printList(); // Output: 40 -> 10 -> 30 -> null
    }
}