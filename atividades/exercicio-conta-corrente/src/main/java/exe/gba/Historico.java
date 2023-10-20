package exe.gba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historico {
    private LocalDateTime dataHora;
    private String operacao;

    public Historico(LocalDateTime dataHora, String operacao) {
        this.dataHora = dataHora;
        this.operacao = operacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getOperacao() {
        return operacao;
    }

    @Override
    public String toString() {
        return """
                ================================================
                Data:  %s
                Operação: %s
                ================================================
                """.formatted(dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), operacao);
    }
}
