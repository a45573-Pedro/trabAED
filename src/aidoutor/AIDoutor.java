/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aidoutor;

import colecoes.LinkedMap;
import colecoes.Map;
import colecoes.SinglyLinkedList;
import resources.DataProvider;

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
     * Carrega os dados de doenças e sintomas a partir da classe DataProvider.
     */
    public void carregarDados() {
        this.doencasAssociadas = DataProvider.carregarDados();
        System.out.println("Dados carregados diretamente da classe DataProvider.");
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
     * Adiciona um sintoma à lista do paciente, se for válido.
     * 
     * @param sintoma Sintoma a ser adicionado.
     */
    public void adicionarSintoma(String sintoma) {
        boolean valido = false;
        for (String doenca : doencasAssociadas.keySet()) {
            if (verificaSintomaNaLista(doencasAssociadas.get(doenca), sintoma)) {
                valido = true;
                break;
            }
        }

        if (valido) {
            sintomasPaciente.addLast(sintoma);
        } else {
            System.out.println("Sintoma invalido: " + sintoma);
        }
    }

    /**
     * Limpa todos os sintomas do paciente.
     */
    public void limparSintomas() {
        sintomasPaciente = new SinglyLinkedList<>();
        System.out.println("A lista de sintomas foi limpa.");
    }

    /**
     * Mostra as doenças associadas aos sintomas do paciente.
     * Destaca doenças com pelo menos o número especificado de sintomas.
     * 
     * @param numeroSintomas Número mínimo de sintomas para destacar uma doença.
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
            int contador = contarSintomasNaLista(doencasAssociadas.get(doenca));
            if (contador > 0) {
                System.out.println("Doenca: " + doenca + " corresponde(m) " + contador + " sintoma(s).");
                encontrouDoenca = true;
            }
        }

        System.out.println("Possivel doenca que corresponde a pelo menos " + numeroSintomas + " sintoma(s) sao:");
        for (String doenca : doencasAssociadas.keySet()) {
            int contador = contarSintomasNaLista(doencasAssociadas.get(doenca));
            if (contador >= numeroSintomas) {
                System.out.println("Doenca: " + doenca + " corresponde(m) " + contador + " sintoma(s).");
            }
        }

        if (!encontrouDoenca) {
            System.out.println("Nenhuma!");
        }
    }

    /**
     * Conta quantos sintomas da doença estão na lista de sintomas do paciente.
     * 
     * @param sintomas Lista de sintomas da doença.
     * @return Número de sintomas presentes na lista do paciente.
     */
    private int contarSintomasNaLista(SinglyLinkedList<String> sintomas) {
        int contador = 0;
        for (String sintoma : sintomas) {
            if (verificaSintomaNaLista(sintomasPaciente, sintoma)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Verifica se um sintoma está em uma lista de sintomas.
     * 
     * @param lista Lista de sintomas a ser verificada.
     * @param sintoma Sintoma a ser procurado.
     * @return true se o sintoma estiver na lista, false caso contrário.
     */
    private boolean verificaSintomaNaLista(SinglyLinkedList<String> lista, String sintoma) {
        for (String s : lista) {
            if (s.equals(sintoma)) {
                return true; 
            }
        }
        return false; 
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
     * Retorna uma representação em string do estado atual da classe.
     * 
     * @return String representando os sintomas do paciente e doenças associadas.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sintomas do paciente: ");
        for (String sintoma : sintomasPaciente) {
            sb.append(sintoma).append(", ");
        }
        sb.append("\nDoenças associadas: ");
        for (String doenca : doencasAssociadas.keySet()) {
            sb.append(doenca).append(", ");
        }
        return sb.toString();
    }
}