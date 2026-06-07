import java.util.Random;
import java.util.Scanner;

public class Numero_secreto {
    
    public static void main(String[] args) {

        //* Cria uma instância para ler o que o usuário digitar */
        Scanner sc = new Scanner(System.in);

        //* Cria uma instância para o gerador de números */
        Random randomizer = new Random();

        //* Utilizo uma variável de controle para manter o menu principal ativa*/
        boolean rodando_jogo = true;

        //* Loop principal do Menu: enquanto a condição true, o código irá rodar */
        while (rodando_jogo) {
            System.out.println("\n===== NÚMERO SECRETO =====");
            System.out.println("O número está entre 1 e 100");
            System.out.println("1 - Advinhar Número");
            System.out.println("2 - Sair do Jogo");
            System.out.print("Digite a opção desejada: ");
            int opcao = sc.nextInt();

            //* Faz uma analise da escolha */
            switch (opcao) {
                case 1: //* Opção 1° - Advinhar o número */

                    String jogar_novamente;

                    //* O laço de repetição do-while: Faz com que o jogo rode pelo menor uma vez */
                    do{
                        //* A maquina faz o sorteio do número de forma aleatória de 0 a 99 */
                        //* O uso do número ocorre, devido a ordem numerica começar pelo 0 e ir até 99, dessa forma o número 1 soma mais
                        // mais um número nessa contagem */
                        int numero_secreto = randomizer.nextInt(100) + 1;
                        //* Inicia o número de palpites pelo 0, até o 100 */
                        int palpite_de_numero_sorteado = 0;
                        //* O número de tentativas inicia como 0 */
                        int tentativas = 0;

                        //* Laço de repetição para roda enquanto valor do palpite for difetente do número sorteado */
                        while (palpite_de_numero_sorteado != numero_secreto) {
                            System.out.print("Digite um número entre 1 e 100: ");
                            palpite_de_numero_sorteado = sc.nextInt(); //* Lê o palpite do jogador */
                            tentativas++; //* Incrementa o +1 no número de tentativas */

                            //* Condicional para verifcar em qual opção o palpite é encaixado */
                            if (palpite_de_numero_sorteado < numero_secreto){
                                System.out.println("O número secreto é MAIOR QUE: " + palpite_de_numero_sorteado);
                            } else if (palpite_de_numero_sorteado > numero_secreto) {
                                System.out.println("O número secreto é MENOR QUE: " + palpite_de_numero_sorteado);
                            } else {
                                System.out.println("Parabéns!!\n Você conseguiu advinhar o número secreto =" +numero_secreto);
                                System.out.println("Número sorteado: " + numero_secreto);
                                System.out.println("Quantidade de palpites feitos pelo jogador: " + tentativas);
                            }
                        }

                        //* Pergunta ao jogador se ele deseja continuar jogando, sem retornar ao menu */
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