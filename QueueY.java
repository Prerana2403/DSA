package dsa;

public class QueueY {
    class Queue {
        private int[] arr;
        private int size;
        private int front;
        private int rear;

        public Queue(int size) {
            this.size = size;
            arr = new int[size];
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % size;
            }
            arr[rear] = data;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            int i = front;
            do {
                System.out.print(arr[i] + " ");
                i = (i + 1) % size;
            } while (i != (rear + 1) % size);
            System.out.println();
        }
    }

    public static void main(String[] args) {
       
        QueueY queueY = new QueueY();  

        
        QueueY.Queue q = queueY.new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.dequeue();
        }

        q.enqueue(6);
        System.out.println("The queue's elements are:");
        q.print();
    }
}