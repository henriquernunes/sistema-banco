package entities;

import java.util.List;

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

    // Calcula saldo total do banco
    public static double totalBalance(List<Account> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getBalance();
        }
        return sum;
    }

    // Calcula a média dos saldos
    public static double averageBalance(List<Account> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getBalance();
        }
        sum = sum / list.size();
        return sum;
    }

    // Retorna conta com maior saldo
    public static double biggerAccount(List <Account> list){
        double aux = 0;
        for (int i = 0; i < list.size(); i++){
            if(aux < list.get(i).getBalance()){
                aux = list.get(i).getBalance();
            }
        }
        return aux;
    }

    // Retorna conta com menor saldo
    public static double smallerAccount(List <Account> list){
        double aux = 1000000;
        for (int i = 0; i < list.size(); i++){
            if(aux > list.get(i).getBalance()){
                aux = list.get(i).getBalance();
            }
        }
        return aux;
    }
}
