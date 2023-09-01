package org.meva.finance.view;

import org.meva.finance.model.Funcionario;

import java.util.List;
import java.util.Map;

public class FuncionarioView {

    public void imprimir(String texto) {
        System.out.println(texto);
    }

    public void imprimirComDivisoria(String texto) {
        imprimir(texto);
        imprimirDivisoria();
    }

    public void imprimirComDivisoria(String texto, Object objeto) {
        imprimir(texto);
        imprimir(objeto);
        imprimirDivisoria();
    }

    public void imprimir(Object objeto) {
        System.out.println(objeto);
    }

    public void imprimirLista(List<Funcionario> funcionarios) {
        imprimir("Lista impressa:\n\n");
        funcionarios.forEach(this::imprimir);
        imprimirDivisoria();
    }

    public <K, V> void imprimirDadosAgrupados(Map<K, V> map) {
        imprimir("Imprimindo o agrupamento de dados:\n");
        map.forEach((chave, valor) -> imprimir("\nFunção" + ": " + chave +
                "\nFuncionários: " + valor.toString()));
        imprimirDivisoria();
    }

    public void imprimirDivisoria() {
        System.out.println("\n############################################\n");
    }
}
