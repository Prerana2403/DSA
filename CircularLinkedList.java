class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            last.next = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
        }
    }

    public void deleteNode(int key) {
        Node temp = head, prev = null;

        if (head == null)
            return;

        if (head.data == key && head.next == head) {
            head = null;
            return;
        }

        // Find the node to be deleted
        do {
            if (temp.data == key)
                break;
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        // If key was not present in linked list
        if (temp == head)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;

        // If the node to be deleted was the head node
        if (temp == head)
            head = prev.next;
    }

    public void printList() {
        if (head == null)
            return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insertAtEnd(12);
        list.insertAtEnd(56);
        list.insertAtBeginning(2);

        System.out.println("Contents of Circular Linked List");
        list.printList();

        list.deleteNode(12);

        System.out.println("Contents of Circular Linked List After Deletion");
        list.printList();
    }
}