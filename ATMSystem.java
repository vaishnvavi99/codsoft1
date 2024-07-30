import java.util.Scanner;

public class ATMSystem {
    // Class to represent the user's bank account
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Successfully withdrew: $" + amount);
                    return true;
                } else {
                    System.out.println("Insufficient balance for withdrawal.");
                    return false;
                }
            } else {
                System.out.println("Withdrawal amount must be positive.");
                return false;
            }
        }
    }

    // ATM class to handle user interactions
    private BankAccount account;

    public ATMSystem(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performAction(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Current Balance: $" + account.getBalance());
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Have a nice day!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000); // Initial balance
        ATMSystem atm = new ATMSystem(account);

        while (true) {
            atm.displayMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            atm.performAction(choice);
            System.out.println();
        }
    }
}
