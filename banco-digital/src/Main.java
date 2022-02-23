public class Main {

    public static void main(String[] args) {
        Cliente igor = new Cliente();
        igor.setNome("Igor");

        Conta corrente = new ContaCorrente(igor);
        Conta poupanca = new ContaCorrente(igor);

        corrente.depositar(100);
        corrente.transferir(50, poupanca);

        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
