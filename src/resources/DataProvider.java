/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import colecoes.LinkedMap;
import colecoes.Map;
import colecoes.SinglyLinkedList;

/**
 * Classe responsável por fornecer os dados de doenças e sintomas.
 * 
 * @author Pedro
 */
public class DataProvider {

    /**
     * Método estático que retorna o dicionário de doenças e sintomas.
     * 
     * @return Um Map contendo doenças como chave e listas de sintomas como valor.
     */
    public static Map<String, SinglyLinkedList<String>> carregarDados() {
        try {
            Map<String, SinglyLinkedList<String>> doencasAssociadas = new LinkedMap<>();

            SinglyLinkedList<String> sintomasFebre = new SinglyLinkedList<>();
            sintomasFebre.addLast("suor");
            sintomasFebre.addLast("dor");
            sintomasFebre.addLast("febre alta");
            doencasAssociadas.put("Febre", sintomasFebre);

            SinglyLinkedList<String> sintomasAtaquePanico = new SinglyLinkedList<>();
            sintomasAtaquePanico.addLast("nervosismo");
            sintomasAtaquePanico.addLast("suor");
            doencasAssociadas.put("Ataque de Panico", sintomasAtaquePanico);

            SinglyLinkedList<String> sintomasConstipacao = new SinglyLinkedList<>();
            sintomasConstipacao.addLast("nariz pingado");
            sintomasConstipacao.addLast("tosse");
            sintomasConstipacao.addLast("febre baixa");
            doencasAssociadas.put("Constipacao", sintomasConstipacao);

            SinglyLinkedList<String> sintomasInfeccaoViral = new SinglyLinkedList<>();
            sintomasInfeccaoViral.addLast("febre alta");
            sintomasInfeccaoViral.addLast("erupcao cutanea");
            sintomasInfeccaoViral.addLast("inchaco");
            doencasAssociadas.put("Infecao Viral", sintomasInfeccaoViral);

            SinglyLinkedList<String> sintomasRefluxoAcido = new SinglyLinkedList<>();
            sintomasRefluxoAcido.addLast("dor no peito");
            sintomasRefluxoAcido.addLast("arrotos");
            doencasAssociadas.put("Refluxo Acido", sintomasRefluxoAcido);

            return doencasAssociadas;
        } catch (Exception e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
            return new LinkedMap<>(); 
        }
    }
}