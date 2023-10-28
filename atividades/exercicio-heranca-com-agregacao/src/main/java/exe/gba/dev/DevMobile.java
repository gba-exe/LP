package exe.gba.dev;

public class DevMobile extends Dev{
    private Integer qtdHoraMobile;
    private Double valorHoraMobile;

    public DevMobile(String nome, Integer qtdHoras, Double valorHora, Integer qtdHoraMobile, Double valorHoraMobile) {
        super(nome, qtdHoras, valorHora);
        this.qtdHoraMobile = qtdHoraMobile;
        this.valorHoraMobile = valorHoraMobile;
    }

    @Override
    public Double getSalario() {
        return qtdHoraMobile * valorHoraMobile;
    }

    @Override
    public String toString() {
        return "DevMobile{" +
                "qtdHoraMobile=" + qtdHoraMobile +
                ", valorHoraMobile=" + valorHoraMobile +
                ", nome='" + nome + '\'' +
                ", qtdHoras=" + qtdHoras +
                ", valorHora=" + valorHora +
                '}';
    }
}
