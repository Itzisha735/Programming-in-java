class Payment {

    public void makePayment(double amount) {
        System.out.println("Processing generic payment of Rs. " + amount);
    }

    public void makePayment(double amount, String transactionId) {
        System.out.println("Processing generic payment of Rs. " + amount
                + " with Transaction ID: " + transactionId);
    }
}

class CreditCardPayment extends Payment {

   @Override
    public void makePayment(double amount) {

        if (amount <= 0) {
            System.out.println("[Credit Card] Invalid amount: Rs. " + amount
                    + ". Payment amount must be greater than zero.");
            return;
        }

        System.out.println("[Credit Card] Payment of Rs. " + amount
                + " processed successfully via Credit Card gateway.");
    }
}

class UPIPayment extends Payment {

    @Override
    public void makePayment(double amount) {

        if (amount <= 0) {
            System.out.println("[UPI] Invalid amount: Rs. " + amount
                    + ". Payment amount must be greater than zero.");
            return;
        }

        System.out.println("[UPI] Payment of Rs. " + amount
                + " processed successfully via UPI.");
    }
}

class NetBankingPayment extends Payment {

    @Override
    public void makePayment(double amount) {

        if (amount <= 0) {
            System.out.println("[Net Banking] Invalid amount: Rs. " + amount
                    + ". Payment amount must be greater than zero.");
            return;
        }

        System.out.println("[Net Banking] Payment of Rs. " + amount
                + " processed successfully via Net Banking.");
    }
}

public class Paymentmanagement {

    public static void main(String[] args) {

        Payment payment;

        payment = new CreditCardPayment();
        payment.makePayment(5000.00);

        payment = new UPIPayment();
        payment.makePayment(1200.50);

        payment = new NetBankingPayment();
        payment.makePayment(8500.00);

        payment = new CreditCardPayment();
        payment.makePayment(2500.00, "TXN1001");

        Payment[] paymentMethods = {
                new CreditCardPayment(),
                new UPIPayment(),
                new NetBankingPayment()
        };

        for (Payment p : paymentMethods) {
            p.makePayment(1000.00);
        }

        payment = new CreditCardPayment();
        payment.makePayment(-1000.00);

        payment = new UPIPayment();
        payment.makePayment(0.00);

       payment = new NetBankingPayment();

        String emptyTxnId = "";

        if (emptyTxnId.trim().isEmpty()) {
            System.out.println("[Net Banking] Transaction ID is empty. "
                    + "Payment of Rs. 3000.0 cannot be processed "
                    + "without a valid Transaction ID.");
        } else {
            payment.makePayment(3000.00, emptyTxnId);
        }

        try {
            Payment nullPayment = null;
            nullPayment.makePayment(1000.00);
        }
        catch (NullPointerException e) {
            System.out.println("Error: NullPointerException caught - "
                    + "Cannot call makePayment() on a null Payment reference.");
        }

        payment = new CreditCardPayment();

        String txnId = "123";

        if (!txnId.matches("^TXN\\d+$")) {
            System.out.println("[Credit Card] Invalid Transaction ID format: \""
                    + txnId
                    + "\". Expected format like TXN1001. "
                    + "Payment of Rs. 4500.0 rejected.");
        } else {
            payment.makePayment(4500.00, txnId);
        }
    }
}