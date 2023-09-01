package org.meva.finance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void aumento() {
        this.salario = this.salario.multiply(new BigDecimal("1.10"));
    }

    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        return Period.between(super.getDataDeNascimento(), hoje).getYears();
    }

    @Override
    public String toString() {

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00", decimalFormatSymbols);

        return "\nNome: " + getNome() +
                "\nData de Nascimento: " + getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\nSalário: " + decimalFormat.format(salario) +
                "\nFunção: " + funcao +
                "\n";
    }
}
