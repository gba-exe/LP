package exe.gba.progressaoaritmetica;

public class ProgressaoAritmetica {
    private Double primeiroTermo;
    private Double razao;

    public void setPrimeiroTermo(Double primeiroTermo) {
        this.primeiroTermo = primeiroTermo;
    }

    public void setRazao(Double razao) {
        this.razao = razao;
    }

    public String calcularTermo(Integer n){
        Double termo = primeiroTermo + (n-1) * razao;
        return """
                Progressão Aritmetica
                
                Primeiro Termo: %.1f
                Razão: %.1f
                %d° Termo: %.1f
                """.formatted(primeiroTermo,razao,n,termo);
    }
}
