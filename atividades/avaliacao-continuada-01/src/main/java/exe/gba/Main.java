package exe.gba;

public class Main {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();

        conta1.depositar(10.0);
        conta1.depositar(10.0);
        conta1.depositar(10.0);
        System.out.println(conta1.getSaldo());

        conta1.depositar(-10.0);
        conta1.depositar(0.0);

        conta1.sacar(10.0);
        System.out.println(conta1.getSaldo());

        conta1.sacar(21.0);
        conta1.sacar(-10.0);

        System.out.println(conta2.getSaldo());
        System.out.println(conta1.getSaldo());
        conta1.transferir(10.0, conta2);
        System.out.println(conta2.getSaldo());
        System.out.println(conta1.getSaldo());

        conta1.transferir(11.0, conta2);
        conta1.transferir(-1.0, conta2);

        conta2.transferir(10.0, conta1);
        System.out.println(conta2.getSaldo());
        System.out.println(conta1.getSaldo());
    }
}