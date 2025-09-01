package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.Type;

public class App {
  /** Lista que armazena todas as contas bancárias carregadas do arquivo */
  private static List<Account> accounts = new ArrayList<>();
  /**
   * Método principal que inicia a aplicação do sistema bancário.
   * 
   * Este método implementa o fluxo principal da aplicação:
   *  - Apresenta menu de seleção de arquivo
   *  - Carrega os dados do arquivo escolhido
   *  - Exibe as contas e estatísticas
   *  - Oferece opção de adicionar novos usuários
   *  - Exibe resultado final
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("=== SISTEMA BANCÁRIO ===");
    System.out.println("Escolha qual arquivo de dados usar:");
    System.out.println("1 - dados.txt (10 contas)");
    System.out.println("2 - dados2.txt (10 contas diferentes)");
    System.out.print("Digite sua escolha (1 ou 2): ");
    
    int escolha = sc.nextInt();
    String fileName;
    
    switch (escolha) {
      case 1:
        fileName = "dados.txt";
        break;
      case 2:
        fileName = "dados2.txt";
        break;
      default:
        System.out.println("[ERROR] Opção inválida! Usando dados.txt por padrão.");
        fileName = "dados.txt";
        break;
    }
    
    readFile(fileName);

    displayAccounts();

    displayStatistics();

    // addUser("TESTE 1", 30001, 25000, Type.CORRENTE);
    // addUser("TESTE 2", 30002, 19000, Type.POUPANCA);
    // addUser("TESTE 3", 30003, 15000, Type.SALARIO);

    // System.out.println("\n=== CONTAS APÓS ADICIONAR NOVOS USUÁRIOS ===");
    // displayAccounts();
    // displayStatistics();
    
    sc.close();
  }

  /**
   * Lê um arquivo de texto e carrega as contas bancárias no ArrayList.
   * 
   * Este método lê linha por linha do arquivo especificado, parseia os dados
   * e cria objetos Account que são adicionados à lista de contas.
   * 
   * Formato esperado do arquivo:
   * nome;numeroConta;saldo;tipoConta
   * 
   * Exemplo de linha válida:
   * João Silva;12345678;5000.50;CORRENTE
   * 
   * @param fileName Nome do arquivo a ser lido (deve estar no diretório src/)
   * @throws IOException Se houver erro na leitura do arquivo
   */
  private static void readFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader("src/" + fileName))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] parts = line.split(";");

        if (parts.length == 5) {
          String accountOwner = parts[0];
          int accountNumber = Integer.parseInt(parts[1]);
          double balance = Double.parseDouble(parts[2]);
          Type accountType = Type.valueOf(parts[3]);
          LocalDate createDate = LocalDate.parse(parts[4]);

          Account account = new Account(accountOwner, accountNumber, balance, accountType, createDate);
          accounts.add(account);
        }
      }
      System.out.println("\n[INFO] Arquivo '" + fileName + "' carregado com sucesso! " + accounts.size() + " contas encontradas.");
    } catch (IOException e) {
      System.out.println("[ERROR] Erro ao ler o arquivo '" + fileName + "': " + e.getMessage());
    }
  }


  /**
   * Adiciona um novo usuário ao sistema bancário.
   * 
   * <p>Este método valida se o número da conta já existe antes de adicionar
   * o novo usuário. Se o número já existir, exibe uma mensagem de erro e
   * não adiciona a conta.
   * 
   * @param name Nome completo do titular da conta
   * @param accountNumber Número da conta (deve ser único)
   * @param balance Saldo inicial da conta
   * @param accountType Tipo da conta (CORRENTE, POUPANCA, SALARIO, JURIDICA)
   */
  private static void addUser(String name, int accountNumber, double balance, Type accountType) {
    for (Account account : accounts) {
      if (account.getAccountNumber() == accountNumber) {
        System.out.println("[ERROR] Conta número " + accountNumber + " já existe!");
        return;
      }
    }

    Account newAccount = new Account(name, accountNumber, balance, accountType, LocalDate.now());
    accounts.add(newAccount);
    System.out.println("[INFO] Usuário " + name + " adicionado com sucesso! Conta: " + accountNumber);
  }

  /**
   * Exibe todas as contas bancárias carregadas no sistema.
   */
  private static void displayAccounts() {
    System.out.println("=== CONTAS CARREGADAS ===");
    for (Account account : accounts) {
      System.out.println("Titular: " + account.getAccountOwner() +
          " | Conta: " + account.getAccountNumber() +
          " | Saldo: R$ " + String.format("%.2f", account.getBalance()) +
          " | Tipo: " + account.getAccountType() +
          " | Data de criação: " + account.getCreateDate());
    }
  }

  /**
   * Exibe estatísticas gerais das contas bancárias.
   */
  private static void displayStatistics() {
    if (accounts.isEmpty()) {
      System.out.println("[ERROR] Nenhuma conta carregada para exibir estatísticas.");
      return;
    }

    System.out.println("\n=== ESTATÍSTICAS ===");
    System.out.println("Total de contas: " + accounts.size());
    System.out.println("Saldo total: R$ " + String.format("%.2f", Account.totalBalance(accounts)));
    System.out.println("Saldo médio: R$ " + String.format("%.2f", Account.averageBalance(accounts)));
    System.out.println("Maior saldo: R$ " + String.format("%.2f", Account.biggerAccount(accounts)));
    System.out.println("Menor saldo: R$ " + String.format("%.2f", Account.smallerAccount(accounts)));
  }
}
