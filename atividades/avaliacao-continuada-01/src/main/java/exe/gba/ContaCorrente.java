package exe.gba;

public class ContaCorrente {
    private Double saldo = 0.0;

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor){
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor inválido, insira um valor maior do que 0.");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Operação inválida, insira um valor maior que 0 e menor que o saldo atual");
            System.out.println("Você sacou R$ 0.00");
        }
    }

    public void transferir(Double valor, ContaCorrente contaDestino) {
        if (valor > 0 && valor <= saldo) {
            contaDestino.saldo += valor;
            saldo -= valor;
        } else {
            System.out.println("Operação inválida, insira um valor maior que 0 e menor que o saldo atual");
        }
    }
}
