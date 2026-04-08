import java.util.Scanner;

public class Main {

    static myLinkedList accounts = new myLinkedList();
    static myStack history = new myStack(100);
    static myQueue billQueue = new myQueue();
    static myQueueAccount accountRequests = new myQueueAccount();
    static Scanner sc = new Scanner(System.in);

    public static void addRequest() {
        System.out.print("Enter account number: ");
        String number = sc.nextLine();

        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        BankAccount request = new BankAccount(number, name, balance);
        accountRequests.add(request);

        System.out.println("Request added to queue");
    }

    public static void processRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("No requests to process");
            return;
        }

        BankAccount request = accountRequests.poll();
        accounts.add(request);

        System.out.println("Account created: " + request.username);
    }

    public static void showRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending requests");
            return;
        }

        System.out.println("Pending requests:");
        accountRequests.show();
    }

    public static void deposit() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        BankAccount acc = accounts.search(name);

        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            acc.balance += amount;
            history.push("Deposit " + amount + " to " + acc.username);

            System.out.println("New balance: " + acc.balance);
        } else {
            System.out.println("Account not found");
        }
    }

    public static void withdraw() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        BankAccount acc = accounts.search(name);

        if (acc != null) {
            System.out.print("Enter withdraw amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            if (acc.balance >= amount) {
                acc.balance -= amount;
                history.push("Withdraw " + amount + " from " + acc.username);
                System.out.println("New balance: " + acc.balance);
            } else {
                System.out.println("Not enough balance!");
            }
        } else {
            System.out.println("Account not found");
        }
    }

    public static void showLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet");
            return;
        }

        System.out.println("Last transaction: " + history.peek());
    }

    public static void undoTransaction() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        String removed = history.pop();
        System.out.println("Undo -> " + removed + " removed");
    }

    public static void addBill() {
        System.out.print("Enter bill name: ");
        String bill = sc.nextLine();

        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }

    public static void processBill() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills to process");
            return;
        }

        String processed = billQueue.poll();
        System.out.println("Processing: " + processed);
    }

    public static void showBills() {
        if (billQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Current queue:");
        billQueue.show();
    }

    public static void searchAccount() {
        System.out.print("Enter username to search: ");
        String name = sc.nextLine();

        BankAccount acc = accounts.search(name);

        if (acc != null) {
            System.out.println("Found: " + acc);
        } else {
            System.out.println("Account not found");
        }
    }

    public static void addAccount() {
        System.out.print("Enter account number: ");
        String number = sc.nextLine();

        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        BankAccount acc = new BankAccount(number, name, balance);
        accounts.add(acc);

        System.out.println("Account added successfully!");
    }

    public static void showAccounts() {
        if (accounts.size() == 0) {
            System.out.println("No accounts found");
            return;
        }

        accounts.showAccounts();
    }

    public static void bankMenu() {
        while (true) {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1 - Submit account request");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Add bill");
            System.out.println("5 - Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addRequest();
            } else if (choice == 2) {
                deposit();
            } else if (choice == 3) {
                withdraw();
            } else if (choice == 4) {
                addBill();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void atmMenu() {
        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1 - Check balance");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Search account");
            System.out.println("4 - Show last transaction");
            System.out.println("5 - Undo transaction");
            System.out.println("6 - Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                showAccounts();
            } else if (choice == 2) {
                withdraw();
            } else if (choice == 3) {
                searchAccount();
            } else if (choice == 4) {
                showLastTransaction();
            } else if (choice == 5) {
                undoTransaction();
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void adminMenu() {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1 - Process account requests");
            System.out.println("2 - Show requests");
            System.out.println("3 - Show bill queue");
            System.out.println("4 - Process bill");
            System.out.println("5 - Show accounts");
            System.out.println("6 - Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                processRequest();
            } else if (choice == 2) {
                showRequests();
            } else if (choice == 3) {
                showBills();
            } else if (choice == 4) {
                processBill();
            } else if (choice == 5) {
                showAccounts();
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Predefined Accounts (Array) ===");

        BankAccount[] predefinedAccounts = new BankAccount[3];

        predefinedAccounts[0] = new BankAccount("A001", "Ali", 150000);
        predefinedAccounts[1] = new BankAccount("A002", "Sara", 220000);
        predefinedAccounts[2] = new BankAccount("A003", "Dana", 180000);

        for (int i = 0; i < predefinedAccounts.length; i++) {
            System.out.println(predefinedAccounts[i]);
            accounts.add(predefinedAccounts[i]);
        }

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                bankMenu();
            } else if (choice == 2) {
                atmMenu();
            } else if (choice == 3) {
                adminMenu();
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}