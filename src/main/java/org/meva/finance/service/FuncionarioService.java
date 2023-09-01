package org.meva.finance.service;

import org.meva.finance.model.Funcionario;
import org.meva.finance.view.FuncionarioView;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FuncionarioService {

    private final FuncionarioView funcionarioView = new FuncionarioView();

    public void BuscarAniversariantesMesDezEDoze(List<Funcionario> funcionarios) {
        funcionarioView.imprimir("Funcionários que fazem aniversário em outubro ou dezembro:\n\n");
        for (Funcionario funcionario : funcionarios) {
            Month mesAniversario = funcionario.getDataDeNascimento().getMonth();
            if (mesAniversario == Month.OCTOBER || mesAniversario == Month.DECEMBER) {
                funcionarioView.imprimir(funcionario);
            }
        }
        funcionarioView.imprimirDivisoria();
    }

    public void buscarFuncionarioComMaiorIdade(List<Funcionario> funcionarios) {
        Funcionario funcionarioMaiorIdade = buscaFuncionarioMaiorIdade(funcionarios);
        if (funcionarioMaiorIdade != null) {
            funcionarioView.imprimir("Funcionário com maior idade:\n");
            int idadeMaior = funcionarioMaiorIdade.calcularIdade();
            funcionarios.stream()
                    .filter(f -> f.calcularIdade() == idadeMaior)
                    .forEach(f -> funcionarioView.imprimir("Nome: " + f.getNome() + ", Idade: " + idadeMaior + " anos\n"));
        } else {
            funcionarioView.imprimir("Não foram encontrados funcionários na lista.\n");
        }
        funcionarioView.imprimirDivisoria();
    }

    private Funcionario buscaFuncionarioMaiorIdade(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .max(Comparator.comparing(Funcionario::calcularIdade))
                .orElse(null);
    }

    public void agruparPorFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosAgrupados = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        funcionarioView.imprimirDadosAgrupados(funcionariosAgrupados);
    }

    public void calcularTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal valor = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        funcionarioView.imprimirComDivisoria("Valor total de salários é: " + valor + "\n");
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        funcionarioView.imprimir("Salários em termos de salários mínimos:\n");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            funcionarioView.imprimir(funcionario.getNome() + ": " + salariosMinimos + " salários mínimos");
        }
    }

    public void listaPorOrdemAlfabetica(List<Funcionario> funcionarios) {
        List<Funcionario> listaOrdenada = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
        funcionarioView.imprimirComDivisoria("Lista em ordem alfabética:\n\n", listaOrdenada);
    }

    public void removerPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
        funcionarioView.imprimirComDivisoria("Funcionário " + nome + " removido:\n\n", funcionarios);
    }

    public void bonificacaoDeDezPorCento(List<Funcionario> funcionarios) {
        funcionarios.forEach(Funcionario::aumento);
        funcionarioView.imprimirComDivisoria("Funcionários bonificados:\n\n", funcionarios);
    }

    public void mostrarTodos(List<Funcionario> funcionarios) {
        funcionarioView.imprimirComDivisoria("\n\nPrimeira lista de funcionários: \n", funcionarios);
    }
}

