import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao, contaPropria, contaTransferencia, tipoConta, tipoContaTransferencia;

        double valor;
        String nome;

        List<Conta> contas = new ArrayList<>();

        ContaCorrente corrente = null;
        ContaPoupanca poupanca = null;
        Banco banco = new Banco();

        //Cliente igor = new Cliente();
        //igor.setNome("Igor");

        //Conta corrente = new ContaCorrente(igor);
        //Conta poupanca = new ContaCorrente(igor);

        //corrente.depositar(100);
        //corrente.transferir(50, poupanca);

        //corrente.imprimirExtrato();
        //poupanca.imprimirExtrato();

        do{
            System.out.println("===BANCO DIGITAL===\n");
            System.out.println("===Opções disponíveis:");
            System.out.println("1: Criar uma Conta Corrente");
            System.out.println("2: Criar uma Conta Poupança");
            System.out.println("3: Depositar em uma conta existente");
            System.out.println("4: Sacar de uma conta existente");
            System.out.println("5: Transferir de uma conta para outra");
            System.out.println("6: Verificar extrato");
            System.out.println("0: Sair");
            System.out.println("Insira a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("\nInsira seu nome: ");
                    nome = scanner.nextLine();
                    Cliente $nome = new Cliente();
                    $nome.setNome(nome);
                    corrente = new ContaCorrente($nome);
                    corrente.imprimirExtrato();
                    contas.add(corrente);
                    banco.setContas(contas);
                break;
                case 2:
                    System.out.println("\nInsira seu nome: ");
                    nome = scanner.nextLine();
                    $nome = new Cliente();
                    $nome.setNome(nome);
                    poupanca = new ContaPoupanca($nome);
                    poupanca.imprimirExtrato();
                    contas.add(poupanca);
                    banco.setContas(contas);
                break;
                case 3:
                    if (banco.getContas() == null) {
                        System.out.println("Nenhuma conta registrada.");
                        break;
                    }
                    do {
                        System.out.println("\nInsira 1 para Conta Corrente ou 2 para Conta Poupança: ");
                        tipoConta = scanner.nextInt();
                        scanner.nextLine();
                    } while(tipoConta != 1 && tipoConta != 2);
                    System.out.println("Insira o número da conta que voce deseja depositar: ");
                    contaPropria = scanner.nextInt();
                    scanner.nextLine();
                    if(tipoConta == 1) {
                        assert corrente != null;
                        if (corrente.getNumeroConta() != contaPropria) {
                            System.out.println("Conta Corrente inexistente.");
                            break;
                        }
                    }
                    if(tipoConta == 2) {
                        assert poupanca != null;
                        if (poupanca.getNumeroConta() != contaPropria) {
                            System.out.println("Conta Poupança inexistente.");
                            break;
                        }
                    }
                    do {
                        System.out.println("Insira o valor que deseja depositar: ");
                        valor = scanner.nextDouble();
                    } while (valor < 0);
                    if(tipoConta == 1){
                        if (banco.getContas().contains(corrente)) {
                            if(corrente.getNumeroConta() == contaPropria){
                                corrente.depositar(valor);
                            }
                        }
                    } else {
                        if (banco.getContas().contains(poupanca)) {
                            if(poupanca.getNumeroConta() == contaPropria){
                                poupanca.depositar(valor);
                            }
                        }
                    }
                break;
                case 4:
                    if (banco.getContas() == null) {
                        System.out.println("Nenhuma conta registrada.");
                        break;
                    }
                    do {
                        System.out.println("\nInsira 1 para Conta Corrente ou 2 para Conta Poupança: ");
                        tipoConta = scanner.nextInt();
                        scanner.nextLine();
                    } while(tipoConta != 1 && tipoConta != 2);
                    System.out.println("Insira o número da conta que voce deseja sacar: ");
                    contaPropria = scanner.nextInt();
                    scanner.nextLine();
                    if(tipoConta == 1) {
                        assert corrente != null;
                        if (corrente.getNumeroConta() != contaPropria) {
                            System.out.println("Conta Corrente inexistente.");
                            break;
                        }
                    }
                    if(tipoConta == 2) {
                        assert poupanca != null;
                        if (poupanca.getNumeroConta() != contaPropria) {
                            System.out.println("Conta Poupança inexistente.");
                            break;
                        }
                    }
                    do {
                        System.out.println("Insira o valor que deseja sacar: ");
                        valor = scanner.nextDouble();
                    } while (valor < 0);
                    if(tipoConta == 1){
                        if (banco.getContas().contains(corrente)) {
                            if(corrente.getNumeroConta() == contaPropria){
                                corrente.sacar(valor);
                            }
                        }
                    } else {
                        if (banco.getContas().contains(poupanca)) {
                            if(poupanca.getNumeroConta() == contaPropria){
                                poupanca.sacar(valor);
                            }
                        }
                    }
                break;
                case 5:
                    if (banco.getContas() == null) {
                        System.out.println("Nenhuma conta registrada.");
                        break;
                    }
                    do {
                        System.out.println("\nInsira 1 caso sua conta seja Corrente ou 2 caso seja Poupança: ");
                        tipoConta = scanner.nextInt();
                        scanner.nextLine();
                    } while(tipoConta != 1 && tipoConta != 2);
                    System.out.println("Insira o número da sua conta: ");
                    contaPropria = scanner.nextInt();
                    scanner.nextLine();
                    if(tipoConta == 1) {
                        assert corrente != null;
                        if (corrente.getNumeroConta() != contaPropria) {
                            System.out.println("Conta Corrente inexistente.");
                            break;
                        }
                    }
                    if(tipoConta == 2) {
                        assert poupanca != null;
                        if (poupanca.getNumeroConta() != contaPropria) {
                            System.out.println("Conta Poupança inexistente.");
                            break;
                        }
                    }
                    do {
                        System.out.println("\nInsira 1 caso a conta que vá receber a transferência seja Corrente ou 2 caso seja Poupança: ");
                        tipoContaTransferencia = scanner.nextInt();
                        scanner.nextLine();
                    } while(tipoContaTransferencia != 1 && tipoContaTransferencia != 2);
                    System.out.println("Insira o número da conta que receberá a transferência: ");
                    contaTransferencia = scanner.nextInt();
                    scanner.nextLine();
                    if(tipoContaTransferencia == 1) {
                        assert corrente != null;
                        if (corrente.getNumeroConta() != contaTransferencia) {
                            System.out.println("Conta Corrente inexistente.");
                            break;
                        }
                    }
                    if(tipoContaTransferencia == 2) {
                        assert poupanca != null;
                        if (poupanca.getNumeroConta() != contaTransferencia) {
                            System.out.println("Conta Poupança inexistente.");
                            break;
                        }
                    }
                    do {
                        System.out.println("Insira o valor que deseja tranferir: ");
                        valor = scanner.nextDouble();
                    } while (valor < 0);
                    if(tipoConta == 1){
                        if (banco.getContas().contains(corrente)) {
                            if(corrente.getNumeroConta() == contaPropria && contaPropria != contaTransferencia){
                                if(corrente.getNumeroConta() == contaTransferencia){
                                    corrente.transferir(valor, corrente);
                                } else {
                                    assert poupanca != null;
                                    corrente.transferir(valor, poupanca);
                                }

                            }
                        }
                    } else {
                        if (banco.getContas().contains(poupanca)) {
                            if(poupanca.getNumeroConta() == contaPropria  && contaPropria != contaTransferencia){
                                if(poupanca.getNumeroConta() == contaTransferencia){
                                    assert corrente != null;
                                    poupanca.transferir(valor, corrente);
                                } else {
                                    poupanca.transferir(valor, poupanca);
                                }
                            }
                        }
                    }

                break;
                case 6:
                    if (banco.getContas() == null) {
                        System.out.println("Nenhuma conta registrada.");
                        break;
                    }
                    do {
                        System.out.println("\nInsira 1 para Conta Corrente ou 2 para Conta Poupança: ");
                        tipoConta = scanner.nextInt();
                        scanner.nextLine();
                    } while(tipoConta != 1 && tipoConta != 2);

                    if(tipoConta == 1) {
                        assert corrente != null;
                        if (!banco.getContas().contains(corrente)) {
                            System.out.println("Não há Contas Corrente cadastradas.");
                            break;
                        }
                    }
                    if(tipoConta == 2) {
                        assert poupanca != null;
                        if (!banco.getContas().contains(poupanca)) {
                            System.out.println("Não há Contas Poupança cadastradas.");
                            break;
                        }
                    }
                    System.out.println("Insira o número da conta que voce deseja ver o extrato: ");
                    contaPropria = scanner.nextInt();
                    scanner.nextLine();
                    if(tipoConta == 1){
                        if(corrente.getNumeroConta() == contaPropria){
                            corrente.imprimirExtrato();
                        } else {
                            System.out.println("Conta Corrente não encontrada");
                        }
                    } else {
                        if(poupanca.getNumeroConta() == contaPropria){
                            poupanca.imprimirExtrato();
                        } else {
                            System.out.println("Conta Poupança não encontrada");
                        }
                    }

                break;
                case 0:
                    System.out.println("Nosso banco agradece a sua preferência.\n");
                break;
                default:
                    System.out.println("Opção inválida, favor inserir uma opção do Menu.\n");
                break;
            }
            System.out.println(banco.getContas());

        } while(opcao != 0);


    }
}
