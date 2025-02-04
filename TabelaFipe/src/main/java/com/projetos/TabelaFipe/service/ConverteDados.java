package com.projetos.TabelaFipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.Collection;
import java.util.List;

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper= new ObjectMapper();

    @Override
    public <T> T ConverteDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public <T> List<T> ConverteDadosLista(String json, Class<T> classe) {
        CollectionType colecao = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        try {
            return mapper.readValue(json, colecao);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
