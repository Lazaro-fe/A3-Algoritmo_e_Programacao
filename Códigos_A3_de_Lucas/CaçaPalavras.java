package Códigos_A3_de_Lucas;
import java.util.Random;
import java.util.Scanner;

public class CaçaPalavras {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String matriz[][] = new String[10][10];

        int opcaoMatriz;

        System.out.println("1- Prencher o Caca Palavra manualmente");
        System.out.println("\n2- Preencher de forma automatica");
        System.out.println("Digite a opcao desejada: ");
        opcaoMatriz = input.nextInt();
        input.nextLine();

        switch (opcaoMatriz) {
            case 1:
                System.out.println("Digite as Letras do Caca Palavra");
                String letraMatriz;
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz.length; j++) {
                        letraMatriz = input.nextLine();
                        while (!letraMatriz.matches("[a-zA-z]")) {
                            System.out.println("Entrada invalida! Digite apenas UMA letra.");
                            System.out.printf("Posicao [%d][%d]: ", i, j);
                            letraMatriz = input.nextLine().toUpperCase();
                        }
                        matriz[i][j] = letraMatriz;
                    }
                }
                break;

            case 2:
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz.length; j++) {
                        int nAleatorio = random.nextInt(26) + 65;

                        String letraAleatoria = String.valueOf((char) nAleatorio);

                        matriz[i][j] = letraAleatoria;
                    }
                }
                break;

        }
        System.out.println("\n======== CACA PALAVRA ========");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        int[][] direcoes = {
            {0, 1}, // horizontal direita
            {0, -1}, // horizontal esquerda
            {1, 0}, // vertical baixo
            {-1, 0}, // vertical cima
            {1, 1}, // diagonal baixo-direita
            {1, -1}, // diagonal baixo-esquerda
            {-1, 1}, // diagonal cima-direita
            {-1, -1} // diagonal cima-esquerda
        };

        String[] nomes = {
            "Horizontal para direita",
            "Horizontal para esquerda",
            "Vertical para baixo",
            "Vertical para cima",
            "Diagonal baixo-direita",
            "Diagonal baixo-esquerda",
            "Diagonal cima-direita",
            "Diagonal cima-esquerda"
        };

        String palavra = "";
        while (!palavra.equals("999")) {
            System.out.print("Digite uma palavra: ");
            palavra = input.nextLine().toUpperCase();

            if (palavra.equals("999")) {
                System.out.println("Encerrando o jogo. Ate mais!");
                break;
            }

            if (palavra.length() > 10) {
                System.out.println("Palavra muito longa! Maximo de 10 caracteres.\n");
                continue;
            }

            boolean encontrou = false;

            // percorre cada posição da matriz
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    // testa cada um dos 8 sentidos
                    for (int d = 0; d < 8; d++) {
                        boolean bateu = true;

                        // verifica letra por letra no sentido d
                        for (int k = 0; k < palavra.length(); k++) {
                            int novaLinha = i + k * direcoes[d][0];
                            int novaColuna = j + k * direcoes[d][1];

                            // saiu da matriz ou letra errada
                            if (novaLinha < 0 || novaLinha >= 10
                                    || novaColuna < 0 || novaColuna >= 10
                                    || !matriz[novaLinha][novaColuna].equals(String.valueOf(palavra.charAt(k)))) {
                                bateu = false;
                                break;
                            }
                        }

                        if (bateu) {
                            System.out.println("Palavra \"" + palavra + "\" ENCONTRADA!");
                            System.out.println("  Posicao inicial: linha " + i + ", coluna " + j);
                            System.out.println("  Sentido: " + nomes[d] + "\n");
                            encontrou = true;
                        }
                    }
                }
            }

            if (!encontrou) {
                System.out.println("Palavra \"" + palavra + "\" NAO encontrada.\n");
            }
        }
    }
}
