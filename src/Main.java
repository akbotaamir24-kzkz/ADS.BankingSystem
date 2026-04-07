import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

public class Main {

    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequests = new LinkedList<>();

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
        for (BankAccount acc : accountRequests) {
            System.out.println(acc);
        }
    }


    public static void deposit() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {

                System.out.print("Enter deposit amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                acc.balance += amount;

                history.push("Deposit" + amount + "to" + acc.username);

                System.out.println("New balance: " + acc.balance);
                return;
            }
        }
        System.out.println("Account not found");
    }


    public static void withdraw() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {

                System.out.print("Enter withdraw amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                if (acc.balance >= amount) {
                    acc.balance -= amount;

                    history.push("Withdraw" + amount + "from" + acc.username);

                    System.out.println("New balance: " + acc.balance);
                } else {
                    System.out.println("Not enough balance!");
                }
                return;
            }
        }
        System.out.println("Account not found");
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
        System.out.println("Undo → " + removed + " removed");
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

        System.out.println("Current queue: " + billQueue);
    }

    public static void searchAccount() {
        System.out.print("Enter username to search: ");
        String name = sc.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {
                System.out.println("Found: " + acc);
                return;
            }
        }

        System.out.println("Account not found");
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
        if (accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }

        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
    }


    public static void bankMenu() {
        while (true) {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1 - Submit account request");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addRequest();
            } else if (choice == 2) {
                deposit();
            } else if (choice == 3) {
                withdraw();
            } else if (choice == 4) {
                break;
            }
        }
    }

    public static void atmMenu() {
        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1 - Check balance");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                showAccounts();
            } else if (choice == 2) {
                withdraw();
            } else if (choice == 3) {
                break;
            }
        }
    }

    public static void adminMenu() {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1 - Process account requests");
            System.out.println("2 - Show requests");
            System.out.println("3 - Show bill queue");
            System.out.println("4 - Back");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                processRequest();
            } else if (choice == 2) {
                showRequests();
            } else if (choice == 3) {
                showBills();
            } else if (choice == 4) {
                break;
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("=== Predefined Accounts (Array) ===");

        BankAccount[] predefinedAccounts = new BankAccount[3];

        predefinedAccounts[0] = new BankAccount("A001", "Ali", 150000);
        predefinedAccounts[1] = new BankAccount("A002", "Sara", 220000);
        predefinedAccounts[2] = new BankAccount("A003", "Dana", 180000);

        for (BankAccount acc : predefinedAccounts) {
            System.out.println(acc);
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
                break;
            }
        }

    }
}