public class myLinkedList {

    class Node {
        BankAccount data;
        Node next;

        Node(BankAccount data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void add(BankAccount acc) {
        Node newNode = new Node(acc);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    public void showAccounts() {
        Node current = head;
        int i = 1;

        while (current != null) {
            System.out.println(i + ". " + current.data.username +
                    " - Balance: " + current.data.balance);
            current = current.next;
            i++;
        }
    }

    public BankAccount search(String username) {
        Node current = head;

        while (current != null) {
            if (current.data.username.equalsIgnoreCase(username)) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public BankAccount get(int index) {
        Node current = head;
        int i = 0;

        while (current != null) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
            i++;
        }

        return null;
    }
}