package com.projetos.TabelaFipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.text.MessageFormat;

public record Veiculo(String TipoVeiculo, String Valor, String Marca, String Modelo, String AnoModelo, String Combustivel, String CodigoFipe, String MesReferencia, String SiglaCombustivel) {
    @Override
    public String toString() {
        return MessageFormat.format("""
                Tipo: {0}
                Valor: {1}
                Marca: {2}
                Modelo: {3}
                Ano: {4}
                Combustível: {5}
                Codigo Fipe: {6}
                Mês de referência: {7}
                """, TipoVeiculo, Valor, Marca, Modelo, AnoModelo, Combustivel, CodigoFipe, MesReferencia, SiglaCombustivel);
    }
}
