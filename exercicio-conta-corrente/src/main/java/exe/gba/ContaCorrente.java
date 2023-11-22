package exe.gba;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {
    private String titular;
    private Double saldo;
    private List<Historico> historicos;

    public ContaCorrente(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.historicos = new ArrayList<>();
    }

    public void depositar(Double deposito, Historico historico) {
        if (deposito > 0) {
            this.saldo += deposito;
            this.historicos.add(historico);
        }
    }

    public void sacar(Double saque, Historico historico) {
        if (saque > 0 && saldo > saque) {
            this.saldo -= saque;
            this.historicos.add(historico);
        }
    }

    public void exibirExtrato() {
        System.out.println("Extrato");
        for (Historico historicoAtual:
             historicos) {
            System.out.println(historicoAtual);
        }
    }

    @Override
    public String toString() {
        return """
                Conta
                ================================================
                Titular: %s
                Saldo: %.2f
                ================================================
                """.formatted(titular, saldo);
    }
}
