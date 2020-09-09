package p02_GettersAndSetters;

public class BankAccount {
    private int id;
    private double balance;


    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Please enter a positive amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
