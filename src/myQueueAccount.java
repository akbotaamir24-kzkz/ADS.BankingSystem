public class myQueueAccount {

    class Node {
        BankAccount data;
        Node next;

        Node(BankAccount data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public void add(BankAccount data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public BankAccount poll() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return null;
        }

        BankAccount value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void show() {
        Node current = front;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}