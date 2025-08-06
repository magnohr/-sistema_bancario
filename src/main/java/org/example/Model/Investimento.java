package org.example.Model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Investimento {
    private String nome;
    private double valorAplicado;
    private double rendimentoAnual; // Ex: 0.08 para 8% ao ano
}
