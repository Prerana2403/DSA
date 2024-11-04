public class Queue {
    private int[] arr;
    private int front, rear, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = rear = -1;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = x;
        System.out.println(x + " enqueued to queue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int x = arr[front];
        if (front == rear) {
            front = rear = -1; // Reset queue if only one element
        } else {
            front = (front + 1) % capacity;
        }
        return x;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(100);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue() + " dequeued from queue\n");

        System.out.println("Front element is " + queue.front());
        System.out.println("Rear element is " + queue.rear());
    }
}