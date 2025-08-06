package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.Model.TipoTransacao;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class Transacao {
    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime dataHora;

    public Transacao(TipoTransacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }
}
