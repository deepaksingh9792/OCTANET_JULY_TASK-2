import java.util.ArrayList;
import java.util.Scanner;

// Define a class for the ATM
class ATM {
    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize the ATM with a balance and default PIN
    public ATM(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }

    // Method to withdraw cash
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount);
            return true;
        } else {
            return false;
        }
    }

    // Method to deposit cash
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: $" + amount);
        }
    }

    // Method to change PIN
    public void changePin(String newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Method to simulate ATM operations
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM MENU:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + checkBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdraw(withdrawAmount)) {
                        System.out.println("Please take your cash.");
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 4:
                    System.out.print("Enter current PIN: ");
                    String currentPin = scanner.next();
                    if (currentPin.equals(pin)) {
                        System.out.print("Enter new PIN: ");
                        String newPin = scanner.next();
                        changePin(newPin);
                    } else {
                        System.out.println("Incorrect PIN.");
                    }
                    break;
                case 5:
                    displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}

// Main class to run the ATM simulation
public class Main {
    public static void main(String[] args) {
        // Create an instance of the ATM with an initial balance and PIN
        ATM atm = new ATM(1000.0, "1234");

        // Run the ATM simulation
        atm.run();
    }
}