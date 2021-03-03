public class CheckingAccount {
    double balance;
    long accountNumber;
    String accountHolder;
    String type = "Checking Account";

    public void setInfo(double balance, long accountNumber, String accountHolder) {
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient fund in account");
        }
        return balance;
    }

    public double purchase(String item, double price) {
        if (price <= balance) {
            balance -= price;
        } else {
            balance -= (price + 35);
        }
        return balance;
    }

    public void withDraw_branch(double amount, boolean branch) {
        if (amount > 500 && !branch) {
            throw new IllegalArgumentException();
        }
    }
}
