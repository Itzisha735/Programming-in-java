class BankAccount {
    // Data members
    String accountHolderName;
    int accountNumber;
    String accountType;
    double accountBalance;

    // Parameterized constructor
    BankAccount(String accountHolderName, int accountNumber,
                String accountType, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposited Amount: " + amount);
            System.out.println("New Balance: " + accountBalance);
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
        } else if (amount > accountBalance) {
            System.out.println("Insufficient Balance");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("New Balance: " + accountBalance);
        }
    }

    // Balance enquiry method
    void balanceEnquiry() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Available Balance: " + accountBalance);
    }

    // Main method
    public static void main(String[] args) {

        // Creating objects using new keyword
        BankAccount account1 =
            new BankAccount("Ravi", 1001, "Savings", 10000);

        System.out.println("----- Account Details -----");
        account1.balanceEnquiry();

        System.out.println("\n----- Deposit -----");
        account1.deposit(5000);

        System.out.println("\n----- Withdrawal -----");
        account1.withdraw(3000);

        System.out.println("\n----- Balance Enquiry -----");
        account1.balanceEnquiry();

        System.out.println("\n----- Insufficient Balance Test -----");
        account1.withdraw(15000);
    }
}