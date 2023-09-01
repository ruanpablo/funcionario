package org.meva.finance;

import org.meva.finance.model.Funcionario;
import org.meva.finance.service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FuncionarioService funcionarioService = new FuncionarioService();
        List<Funcionario> funcionarios = new ArrayList<>();

        // Inserir funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        //Lista Atual
        funcionarioService.mostrarTodos(funcionarios);

        //removeu funcionário por nome e imprimiu
        funcionarioService.removerPorNome(funcionarios, "João");

        //aumento de 10% no salário de cada funcionário e imprime com valores alterados
        funcionarioService.bonificacaoDeDezPorCento(funcionarios);

        //agrupando lista por função e imprime lista agrupada
        funcionarioService.agruparPorFuncao(funcionarios);

        //imprimindo funcionario do mês 10 e 12
        funcionarioService.BuscarAniversariantesMesDezEDoze(funcionarios);

        //imprimindo o funcionário com a maior idade, exibindo nome e idade.
        funcionarioService.buscarFuncionarioComMaiorIdade(funcionarios);

        //imprimir lista em ordem alfabética
        funcionarioService.listaPorOrdemAlfabetica(funcionarios);

        //imprimir total de salários
        funcionarioService.calcularTotalSalarios(funcionarios);

        //imprime salários mínimos de cada funcionário
        funcionarioService.imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));

    }
}