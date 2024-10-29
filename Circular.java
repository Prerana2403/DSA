package hw;

class CircularNode {
    int data;
    CircularNode next;

    CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularList {
    CircularNode head;

    void insert(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            CircularNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void delete(int key) {
        if (head == null) {
            return;
        }

        CircularNode temp = head;
        CircularNode prev = null;
        do {
            if (temp.data == key) {
                if (prev == null) {
                    // Deleting the only node
                    if (temp.next == temp) {
                        head = null;
                    } else {
                        head = temp.next;
                    }
                    temp.next = null;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void printList() {
        if (head == null) {
            return;
        }

        CircularNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.insert(12);
        list.insert(15);
        list.insert(10);

        list.printList();

        list.delete(15);

        list.printList();
    }
}