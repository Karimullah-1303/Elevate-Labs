import java.util.ArrayList;
import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        Account acc = new Account("John Doe", 1000);

        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(1500); // will show insufficient balance

        System.out.println("Current Balance: " + acc.getBalance());

        acc.printTransactionHistory();
    }
}

class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | New Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History for " + accountHolder + " ---");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}