import java.util.Random;
import java.util.Scanner;

public class Black_Jack {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random sortear_cartas = new Random();

        int [][] pilhas_de_cartas_que_serao_distribuidas = new int[52][2];
        int [][] cartas_do_jogador = new int[22][2];
        int [][] cartas_do_adversario = new int[22][2];

        int vitorias_do_jogador = 0;
        int vitorias_do_adversario = 0;
        int rodadas_necessarias_para_vencer_o_jogo;

        int opcao_desejada = 0;
        

        while (opcao_desejada != 3) {
            System.out.println("\n===== BLACKJACK =====");
            System.out.println("1 - JOGAR");
            System.out.println("2 - REGRAS DO JOGO");
            System.out.println("3 - SAIR");
            System.out.println();
            System.out.print("Digite a opção desejada");
            opcao_desejada = sc.nextInt();

            switch (opcao_desejada) {
                case 1:
                    
                    System.out.println("Digite a quantidade de rodadas necessárias para que os jogares vençam a partidad: ");
                    rodadas_necessarias_para_vencer_o_jogo = sc.nextInt();

                    while (vitorias_do_jogador < rodadas_necessarias_para_vencer_o_jogo && vitorias_do_adversario < rodadas_necessarias_para_vencer_o_jogo) {
                        System.out.println("\n==== NOVA RODADA ====");
                        System.out.println("=== PLACAR ATUAL ===");
                        System.out.println("Jogador: " + vitorias_do_jogador + "X Adversário: " + vitorias_do_adversario);

                        int montando_pilha_de_cartas = 0;
                        for (int naipe_de_cartas = 1; naipe_de_cartas <= 4; naipe_de_cartas++){
                            for (int valor_das_cartas = 1; valor_das_cartas <= 13; valor_das_cartas++){
                                pilhas_de_cartas_que_serao_distribuidas[montando_pilha_de_cartas][0] = valor_das_cartas;
                                pilhas_de_cartas_que_serao_distribuidas[montando_pilha_de_cartas][1] = naipe_de_cartas;
                            }
                        }

                        int soma_das_cartas_do_jogador = 0;
                        int soma_das_cartas_do_adversario = 0;
                        int quantidade_de_cartas_do_jogador = 0;
                        int quantidade_de_cartas_do_adversario = 0;
                        int carta_no_topo_da_pilha = 0;

                        cartas_do_jogador[quantidade_de_cartas_do_jogador][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_jogador[quantidade_de_cartas_do_jogador][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_jogador += calcular_valores_das_cartas_do_jogador(cartas_do_jogador[quantidade_de_cartas_do_jogador][0]);
                        quantidade_de_cartas_do_jogador++;
                        carta_no_topo_da_pilha++;

                        cartas_do_jogador[quantidade_de_cartas_do_jogador][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_jogador[quantidade_de_cartas_do_jogador][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_jogador += calcular_valores_das_cartas_do_jogador(cartas_do_jogador[quantidade_de_cartas_do_jogador][0]);
                        quantidade_de_cartas_do_jogador++;
                        carta_no_topo_da_pilha++;

                        cartas_do_adversario[quantidade_de_cartas_do_adversario][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_adversario[quantidade_de_cartas_do_adversario][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_adversario += calcular_valores_das_cartas_do_adversario(cartas_do_adversario[quantidade_de_cartas_do_adversario][0]);
                        quantidade_de_cartas_do_adversario++;
                        carta_no_topo_da_pilha++;

                        cartas_do_adversario[quantidade_de_cartas_do_adversario][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_adversario[quantidade_de_cartas_do_adversario][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_adversario += calcular_valores_das_cartas_do_adversario(cartas_do_adversario[quantidade_de_cartas_do_adversario][0]);
                        quantidade_de_cartas_do_adversario++;
                        carta_no_topo_da_pilha++;

                        System.out.println("\n== CARTAS DO JOGADOR ==");
                        exibir_carta_do_jogador(cartas_do_jogador[0][0], cartas_do_jogador[0][1]);
                        exibir_carta_do_jogador(cartas_do_jogador[1][0], cartas_do_jogador[1][1]);
                        System.out.println("Soma atual das suas cartas: " +soma_das_cartas_do_jogador);

                        System.out.println("\n== CARTAS DO ADVERSÁRIO ==");
                        exibir_cartas_do_adversario(cartas_do_adversario[0][0], cartas_do_adversario[0][1]);
                        System.out.println();
                    }
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Saindo do jogo!!\nObrigado por jogar nosso jogo!!");
                    break;
                default:
                    System.out.println("Opção inválida!!\nTente escolher números entre 1 a 3, para que o sistema funcione!");
                    break;
            }
        }
    }
}