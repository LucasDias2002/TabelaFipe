package com.projetos.TabelaFipe.models;

public record Dados(String codigo,
                    String nome) {
    @Override
    public String toString() {
        return "Cod: " + codigo + " Descrição: " + nome;
    }
}
