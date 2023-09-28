package exe.gba;

import java.util.concurrent.ThreadLocalRandom;

public class Cofre {
    /*
        public
        private
        protected
        default
    */
    private Boolean isBroken;
    private Double saldo;
    private String meta;

    //    CONSTRUTORES
//    metodos em camelcase, mas construtor em Pascal case com o nome da classe
    public Cofre(String meta, Double saldo){
        this.saldo = 0.0;
        this.isBroken = false;
        this.meta = meta;
    }

//    @Override
//    public String toString() {
//        return "Cofre{" +
//                "isBroken=" + isBroken +
//                ", saldo=" + saldo +
//                ", meta='" + meta + '\'' +
//                '}';
//    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public void depositar(Double valor){
        if (!isBroken) {
            saldo += valor;
            System.out.println(String.format("Valor depositado com sucesso! \nSeu saldo é de R$ %.2f", saldo));
        }
    }

    public void balancar(){
        if (saldo > 0){
            Double valorRetirado = ThreadLocalRandom.current().nextDouble(saldo+1);
            saldo -= valorRetirado;
            System.out.println(String.format("Você retirou R$ %.2f \nSeu saldo é de R$ %.2f", valorRetirado, saldo));
        } else {
            System.out.println("Você não tem dinheiro neste cofre!");
        }
    }
    public void quebrar(){
        isBroken = true;
        System.out.println(String.format("Você retirou R$ %.2f! \nSeu saldo é de R$ 0.00", saldo));
        saldo = 0.0;
    }
}