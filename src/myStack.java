public class myStack {
    private String[] arr;
    private int capacity;
    private int top;

    public myStack(int cap) {
        capacity = cap;
        arr = new String[capacity];
        top = -1;
    }

    public void push(String x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    public String pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top--];
    }

    public String peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return null;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}