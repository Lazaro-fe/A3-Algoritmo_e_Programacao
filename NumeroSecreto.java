/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao04;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class NumeroSecreto {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();

        boolean rodando_jogo = true;

        while (rodando_jogo) {
            System.out.println("\n===== NÚMERO SECRETO =====");
            System.out.println("O número está entre 1 e 100");
            System.out.println("1 - Advinhar Número");
            System.out.println("2 - Sair do Jogo");
            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:

                    String jogar_novamente;

                    do{
                        // Irá armazenar o número sorteado pelo sistema
                        int numero_secreto = randomizer.nextInt(100) + 1;
                        // Irá guardar o número digitado pelo jogador
                        int palpite_de_numero_sorteado = 0;
                        // Armazenará a quantidade de tentativas realizadas pelo jogador
                        int tentativas = 0;

                        while (palpite_de_numero_sorteado != numero_secreto) {
                            System.out.println("Digite um número entre 1 e 100: ");
                            palpite_de_numero_sorteado = sc.nextInt();
                            tentativas++;

                            if (palpite_de_numero_sorteado < numero_secreto){
                                System.out.println("O número secreto é MAIOR QUE: " + palpite_de_numero_sorteado);
                            } else if (palpite_de_numero_sorteado > numero_secreto) {
                                System.out.println("O número secreto é MENOR QUE: " + palpite_de_numero_sorteado);
                            } else {
                                System.out.println("Parabéns!!\n Você conseguiu advinhar o número secreto =");
                                System.out.println("Número sorteado: " + numero_secreto);
                                System.out.println("Quantidade de palpites feitos pelo jogador: " + tentativas);
                            }
                        }

                        // Utilizei o equalIgnoreCase, pois caso o usuário digite "s" ou "S", o laço do-while irá repetir o jogo
                        // Caso o usuário digite "n" ou qualquer outra coisa, irá voltar para o menu inicial
                        System.out.print("Gostaria de jogar novamente? (s/n): ");
                        jogar_novamente = sc.next();

                    } while (jogar_novamente.equalsIgnoreCase("S"));
                    break;
                case 2:
                    System.out.println("\nSaindo do Jogo....");
                    rodando_jogo = false;
                    break;
                default:
                    System.out.println("Opção inválida!!\nTente digitar o número 1 ou 2!");
                    break;
            }
        }
        sc.close();
    }
}
