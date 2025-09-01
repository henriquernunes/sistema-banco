# Sistema Bancário - Trabalho Acadêmico

## 📋 Descrição do Projeto

Este projeto implementa um sistema bancário em Java que gerencia contas bancárias, permitindo leitura de dados de arquivos de texto e análise estatística.

## 👥 Integrantes do Grupo

- [Nome dos integrantes do grupo]

## 🏦 Tipo de Dados Escolhido

**Sistema Bancário** - Gerenciamento de contas bancárias com informações sobre:
- Nome do titular da conta
- Número da conta
- Saldo atual
- Tipo de conta (Corrente, Poupança, Salário, Jurídica)

## 📁 Estrutura do Projeto

```
src/
├── App.java              # Classe principal da aplicação
├── dados.txt             # Arquivo com 10 contas bancárias
├── dados2.txt            # Segundo arquivo com 10 contas diferentes
└── entities/
    ├── Account.java      # Classe que representa uma conta bancária
    └── Type.java         # Enum com tipos de conta
```

## 🚀 Como Executar

### Compilação
```bash
javac -cp src src/App.java src/entities/*.java
```

### Execução
```bash
java -cp src App
```

## 🎮 Interface de Seleção

### Seleção de Arquivo
```
=== SISTEMA BANCÁRIO ===
Escolha qual arquivo de dados usar:
1 - dados.txt (10 contas)
2 - dados2.txt (10 contas diferentes)
Digite sua escolha (1 ou 2):
```

## 📊 Funcionalidades Implementadas

### 1. Leitura de Arquivos
- ✅ Interface para escolha do arquivo
- ✅ Leitura de arquivos de texto com dados de contas bancárias
- ✅ Validação de formato dos dados
- ✅ Tratamento de erros de arquivo

### 2. Processamento de Dados
- ✅ Cálculo de saldo total
- ✅ Cálculo de saldo médio
- ✅ Identificação de maior saldo
- ✅ Identificação de menor saldo
- ✅ Contagem total de contas

### 3. Gerenciamento de Contas
- ✅ Adição programática de novos usuários
- ✅ Validação de números de conta duplicados
- ✅ Exibição de todas as contas carregadas

## 📈 Análise Estatística

O sistema extrai os seguintes dados significativos:
- **Valor mínimo**: Menor saldo entre todas as contas
- **Valor máximo**: Maior saldo entre todas as contas
- **Média**: Saldo médio de todas as contas
- **Total**: Soma de todos os saldos
- **Quantidade**: Número total de contas

## 📝 Formato dos Arquivos de Dados

Os arquivos devem seguir o formato:
```
nome;numeroConta;saldo;tipoConta
```

### Tipos de Conta Disponíveis:
- `CORRENTE` - Conta corrente
- `POUPANCA` - Conta poupança
- `SALARIO` - Conta salário
- `JURIDICA` - Conta jurídica

### Exemplo de Dados:
```
Henrique Rosa Nunes;19102604;15000.50;CORRENTE
Maria Silva Santos;45678912;8500.75;POUPANCA
João Pedro Oliveira;23456789;3200.25;SALARIO
```

## 🔧 Tecnologias Utilizadas

- **Linguagem**: Java
- **Estruturas de Dados**: ArrayList
- **Entrada/Saída**: BufferedReader, FileReader, Scanner
- **Tratamento de Exceções**: IOException, NumberFormatException

## 🛡️ Validações Implementadas

- ✅ Verificação de números de conta duplicados
- ✅ Validação de tipos de conta válidos
- ✅ Tratamento de entradas inválidas
- ✅ Verificação se a lista está vazia antes de calcular estatísticas
- ✅ Tratamento de erros de arquivo

## 📋 Requisitos Atendidos

- ✅ Escolha de tabela de dados real (Sistema Bancário)
- ✅ Implementação da classe Account representando os dados
- ✅ Criação de arquivo com mínimo 10 registros (dados.txt)
- ✅ Criação de segundo arquivo com dados diferentes (dados2.txt)
- ✅ Aplicação com interface para escolha de arquivo
- ✅ Leitura para ArrayList
- ✅ Processamento para extrair dados significativos (mínimo, máximo, média, etc.)
- ✅ Adição programática de novos usuários

## 🎯 Características do Sistema

- **Simplicidade**: Interface clara e objetiva
- **Flexibilidade**: Escolha do arquivo em tempo de execução
- **Robustez**: Validação de dados e tratamento de erros
- **Eficiência**: Processamento rápido e organizado
- **Documentação**: Código bem documentado com JavaDoc

