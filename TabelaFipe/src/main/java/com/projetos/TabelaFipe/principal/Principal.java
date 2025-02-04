package com.projetos.TabelaFipe.principal;

import com.projetos.TabelaFipe.models.Dados;
import com.projetos.TabelaFipe.models.Modelos;
import com.projetos.TabelaFipe.models.Veiculo;
import com.projetos.TabelaFipe.service.ConsumoDados;
import com.projetos.TabelaFipe.service.ConverteDados;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner ler = new Scanner(System.in);
    private ConsumoDados consumo = new ConsumoDados();
    private ConverteDados conversor = new ConverteDados();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibirMenu(){
        System.out.println("""
                *** OPÇÕES ***
                Carros
                Motos
                Caminhao
                
                Digite uma opção: 
                """);

        String opcao = ler.nextLine();
        String endereco = "";
        if(opcao.toLowerCase().contains("car")){
            endereco += URL_BASE + "carros/marcas/";
        }
        else if(opcao.toLowerCase().contains("mot")){
            endereco += URL_BASE + "motos/marcas/";
        }
        else if(opcao.toLowerCase().contains("cam")){
            endereco += URL_BASE + "caminhoes/marcas/";
        }
        String json = consumo.obterDados(endereco);

        var lista = conversor.ConverteDadosLista(json, Dados.class);
        lista.stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(dados -> System.out.println(dados.toString()));

        System.out.println("\nDigite uma opção de marca: ");
        opcao = ler.nextLine();

        endereco += opcao + "/modelos/";
        json = consumo.obterDados(endereco);

        var modelos = conversor.ConverteDados(json, Modelos.class);
        modelos.modelos().stream()
                        .sorted(Comparator.comparing(Dados::nome))
                                .forEach(System.out::println);

        System.out.println("\nDigite uma opção de modelo: ");
        opcao = ler.nextLine();

        endereco += opcao + "/anos/";
        json = consumo.obterDados(endereco);

        var anos = conversor.ConverteDadosLista(json, Dados.class);
        anos.stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(System.out::println);

        System.out.println("\nDigite o código: ");
        opcao = ler.nextLine();

        endereco += opcao;
        json = consumo.obterDados(endereco);

        System.out.println("\nCarro selecionado: \n\n");
        var veiculo = conversor.ConverteDados(json, Veiculo.class);
        System.out.println(veiculo.toString());
    }

}
