package entities;

import java.util.List;

/**
 * Representa uma conta bancaria com informações sobre o titular da conta.
 * 
 * além dos atributos de uma conta, a classe contem metodos para calcular e obter estatísticas como 
 * valor total, média, menor saldo e menor saldo em uma lista de contas.
 */
public class Account {
    private String accountOwner;
    private int accountNumber;
    private double balance;
    private Type accountType;

    /*
     * Construtor para inicializar uma conta bancaria.
     */
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

    /**
     * @param lista de contas.
     *              Percorre a lista somando os saldos de cada conta.
     * @return valor total dos saldos das contas.
     */

    public static double totalBalance(List<Account> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getBalance();
        }
        return sum;
    }

    /**
     * @param lista de contas.
     *              Percorre a lista somando os saldos de cada conta.
     *              Calcula a média dividindo a soma pelo número de contas.
     * @return valor médio dos saldos das contas.
     */
    public static double averageBalance(List<Account> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getBalance();
        }
        sum = sum / list.size();
        return sum;
    }

    /**
     * @param lista de contas.
     *              Inicializa o auxiliar com o menor valor possível.
     *              Percorre a lista comparando cada saldo com o maior já encontrado.
     * @return valor conta com maior saldo.
     */
    public static double biggerAccount(List<Account> list) {
        double aux = 0;
        for (int i = 0; i < list.size(); i++) {
            if (aux < list.get(i).getBalance()) {
                aux = list.get(i).getBalance();
            }
        }
        return aux;
    }

    /**
     * @param lista de contas
     *              Inicializa o auxiliar com o saldo da primeira conta da lista.
     *              Percorre a lista comparando cada saldo com o menor já encontrado.
     * @return valor conta com menor saldo.
     */
    public static double smallerAccount(List<Account> list) {
        double aux = list.get(0).getBalance();
        for (int i = 0; i < list.size(); i++) {
            if (aux > list.get(i).getBalance()) {
                aux = list.get(i).getBalance();
            }
        }
        return aux;
    }
}
