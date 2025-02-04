package com.projetos.TabelaFipe.service;

public interface IConverteDados {
    <T> T ConverteDados(String json, Class <T> classe);
}
