class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public void deleteNode(int key) {
        if (head == null)
            return;

        Node temp = head;
        if (temp.data == key) {
            head = temp.next;
            if (head != null)
                head.prev = null;
            return;
        }

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null)
            return;

        temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    public void printList(Node node) {
        Node last = null;
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();

        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);

        System.out.println("Created Doubly Linked List is: ");
        dll.printList(dll.head);

        dll.deleteNode(3);

        System.out.println("Updated Doubly Linked List is: ");
        dll.printList(dll.head);
    }
}