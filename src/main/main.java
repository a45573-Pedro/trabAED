package main;

import aidoutor.AIDoutor;
import java.util.Scanner;

/**
 * Classe principal para executar o sistema de auxílio ao diagnóstico de doenças.
 * 
 * @author Pedro
 */
public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AIDoutor aidoutor = new AIDoutor();

        // Carregar os dados do arquivo Data.txt
        aidoutor.carregarDados();

        // Mostrar sintomas disponíveis
        aidoutor.mostrarListaSintomas();

        // Captura de sintomas
        String entrada;
        do {
            System.out.print("Qual o sintoma? ou fim para terminar: ");
            entrada = scanner.nextLine().trim().toLowerCase();
            if (!entrada.equals("fim") && !entrada.isEmpty()) {
                aidoutor.adicionarSintoma(entrada);
            }
        } while (!entrada.equals("fim"));

        // Mostrar sintomas do paciente
        System.out.print("Os sintomas do paciente sao: ");
        aidoutor.mostrarSintomasPaciente();

        // Mostrar doenças associadas
        System.out.println("A(s) possivel doenca(s) que corresponde(m) aos sintomas sao:");
        aidoutor.mostrarDoencas(2);

        // Finalizar
        System.out.println("Cuide-se!");
        scanner.close();
    }
}
