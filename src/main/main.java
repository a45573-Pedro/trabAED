package main;

import aidoutor.AIDoutor;
import java.util.Scanner;

/**
 * Classe principal para executar o sistema de auxílio ao diagnóstico de doenças.
 * 
 * @author *****
 */
public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AIDoutor aidoutor = new AIDoutor();


        aidoutor.carregarDados();


        aidoutor.mostrarListaSintomas();


        String entrada;
        do {
            System.out.print("Qual o sintoma? ou fim para terminar: ");
            entrada = scanner.nextLine().trim().toLowerCase();
            if (!entrada.equals("fim") && !entrada.isEmpty()) {
                aidoutor.adicionarSintoma(entrada);
            }
        } while (!entrada.equals("fim"));


        System.out.print("Os sintomas do paciente sao: ");
        aidoutor.mostrarSintomasPaciente();


        System.out.println("A(s) possivel doenca(s) que corresponde(m) aos sintomas sao:");
        aidoutor.mostrarDoencas(2);


        System.out.println("Cuide-se!");
        scanner.close();
    }
}
