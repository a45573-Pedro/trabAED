/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aidoutor;

import colecoes.LinkedMap;
import colecoes.Map;
import colecoes.SinglyLinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe principal para auxílio no diagnóstico de doenças.
 * 
 * @author Pedro
 */
public class AIDoutor {

    private Map<String, SinglyLinkedList<String>> doencasAssociadas;
    private SinglyLinkedList<String> sintomasPaciente;

    /**
     * Construtor da classe AIDoutor.
     */
    public AIDoutor() {
        this.doencasAssociadas = new LinkedMap<>();
        this.sintomasPaciente = new SinglyLinkedList<>();
    }

    /**
     * Carrega os dados de doenças e sintomas a partir de um arquivo .txt.
     */
    public void carregarDados() {
        String caminho = "resources/Data.txt"; // Caminho relativo
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String doenca = partes[0].trim();
                    String[] sintomas = partes[1].split(",");

                    SinglyLinkedList<String> listaSintomas = new SinglyLinkedList<>();
                    for (String sintoma : sintomas) {
                        listaSintomas.addLast(sintoma.trim());
                    }
                    doencasAssociadas.put(doenca, listaSintomas);
                }
            }
            System.out.println("Dados carregados a partir do arquivo Data.txt.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }

    /**
     * Mostra todos os sintomas possíveis disponíveis no sistema.
     */
    public void mostrarListaSintomas() {
        System.out.println("Os sintomas possiveis sao:");
        for (String doenca : doencasAssociadas.keySet()) {
            for (String sintoma : doencasAssociadas.get(doenca)) {
                System.out.print("{" + sintoma + "} ");
            }
        }
        System.out.println();
    }

    /**
     * Adiciona um sintoma à lista do paciente.
     * 
     * @param sintoma Sintoma a ser adicionado.
     */
    public void adicionarSintoma(String sintoma) {
        sintomasPaciente.addLast(sintoma);
    }

    /**
     * Mostra os sintomas atuais do paciente.
     */
    public void mostrarSintomasPaciente() {
        if (sintomasPaciente.isEmpty()) {
            System.out.println("Nenhum!");
        } else {
            for (String sintoma : sintomasPaciente) {
                System.out.print(sintoma + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Mostra as doenças associadas aos sintomas do paciente.
     * 
     * @param numeroSintomas Número mínimo de sintomas para destaque.
     */
    public void mostrarDoencas(int numeroSintomas) {
        if (sintomasPaciente.isEmpty()) {
            System.out.println("Nenhuma!");
            System.out.println("Possivel doenca que corresponde a pelo menos " + numeroSintomas + " sintoma(s) sao:");
            System.out.println("Nenhuma!");
            return;
        }

        boolean encontrouDoenca = false;

        for (String doenca : doencasAssociadas.keySet()) {
            int contador = 0;
            for (String sintoma : doencasAssociadas.get(doenca)) {
                if (verificaSintomaNaLista(sintoma)) {
                    contador++;
                }
            }

            if (contador > 0) {
                System.out.println("Doenca: " + doenca + " corresponde(m) " + contador + " sintoma(s).");
                encontrouDoenca = true;
            }
        }

        System.out.println("Possivel doenca que corresponde a pelo menos " + numeroSintomas + " sintoma(s) sao:");
        if (!encontrouDoenca) {
            System.out.println("Nenhuma!");
        }
    }

    private boolean verificaSintomaNaLista(String sintoma) {
        for (String s : sintomasPaciente) {
            if (s.equals(sintoma)) {
                return true;
            }
        }
        return false;
    }
}
