package entities;

public class Account {
    private String accountOwner;
    private int accountNumber;
    private double balance;
    private Type accountType;

    public Account(String accountOwner, int accountNumber, double balance, Type accountType) {
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Type getAccountType() {
        return accountType;
    }

    public void setAccountType(Type accountType) {
        this.accountType = accountType;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount){
        if(amount <= 0){
            return false;
        } else {
            balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount){
        if(amount < balance){
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}
