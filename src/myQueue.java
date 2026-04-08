public class myQueue {

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public void add(String data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String poll() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return null;
        }

        String value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    public String peek() {
        if (isEmpty()) return null;
        return front.data;
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