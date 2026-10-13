class BankAccount {
    int accountNumber;
    String accountHolderName;
    double balance;
    BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = name;
        this.balance = balance;
    }
    synchronized void deposit(String user, double amount) {
        if (amount <= 0) {
            System.out.println(user + ": Invalid deposit amount");
            return;
        }
        balance = balance + amount;
        System.out.println(user + " deposited: Rs." + amount);
        System.out.println("Updated Balance: Rs." + balance);
    }
    synchronized void withdraw(String user, double amount) {
        if (amount <= 0) {
            System.out.println(user + ": Invalid withdrawal amount");
            return;
        }
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println(user + " withdrew: Rs." + amount);
            System.out.println("Updated Balance: Rs." + balance);
        } else {
            System.out.println(user + ": Insufficient Balance");
            System.out.println("Available Balance: Rs." + balance);
        }
    }
    synchronized void displayBalance() {
        System.out.println("Final Account Balance: Rs." + balance);
    }
}
class UserTransaction extends Thread {
    BankAccount account;
    String userName;
    String transactionType;
    double amount;
    UserTransaction(BankAccount account, String userName,
                    String transactionType, double amount) {
        this.account = account;
        this.userName = userName;
        this.transactionType = transactionType;
        this.amount = amount;
    }
    @Override
    public void run() {
        if (transactionType.equalsIgnoreCase("Deposit")) {
            account.deposit(userName, amount);
        } else if (transactionType.equalsIgnoreCase("Withdrawal")) {
            account.withdraw(userName, amount);
        } else {
            System.out.println("Invalid transaction type");
        }
    }
}
public class OnlineBanking {
    public static void main(String[] args) {
        BankAccount account =
                new BankAccount(1001, "Rahul", 10000);
        UserTransaction t1 =
                new UserTransaction(account, "User1", "Deposit", 2000);
        UserTransaction t2 =
                new UserTransaction(account, "User2", "Withdrawal", 3000);
        UserTransaction t3 =
                new UserTransaction(account, "User3", "Deposit", 1000);
        UserTransaction t4 =
                new UserTransaction(account, "User4", "Withdrawal", 2000);
        System.out.println("Online Banking System Started");
        System.out.println("Initial Balance: Rs.10000");
        System.out.println("--------------------------------");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
            return;
        }
        System.out.println("--------------------------------");
        account.displayBalance();
        System.out.println("All transactions completed.");
    }
}
