package exe.gba.mensalidades;

public class Estudante {
    private String nome;
    private String curso;
    private Double mensalidade;
    private Boolean isAtivo;

    public Estudante(String nome, String curso, Double mensalidade){
        this.nome = nome;
        this.curso = curso;
        this.mensalidade = mensalidade;
        this.isAtivo = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public void aplicarDesconto(Double porcentagem){
        if (isAtivo){
            mensalidade -= mensalidade * (porcentagem / 100);
        } else {
            System.out.println("Não é possível aplicar o desconto (matrícula inativa)");
        }
    }

    public void trancarMatricula(){
        this.isAtivo = false;
    }
}
