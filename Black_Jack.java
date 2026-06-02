import java.util.Random;
import java.util.Scanner;

public class Black_Jack {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random sortear_cartas = new Random();

        int [][] pilhas_de_cartas_que_serao_distribuidas = new int[52][2];
        int [][] cartas_do_jogador = new int[22][2];
        int [][] cartas_do_adversario = new int[22][2];

        int opcao_desejada = 0;

        while (opcao_desejada != 3) {
            System.out.println("\n===== BLACKJACK =====");
            System.out.println("1 - JOGAR");
            System.out.println("2 - REGRAS DO JOGO");
            System.out.println("3 - SAIR");
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            opcao_desejada = sc.nextInt();

            switch (opcao_desejada) {
                case 1:

                    int vitorias_do_jogador = 0;
                    int vitorias_do_adversario = 0;
                    int rodadas_necessarias_para_vencer_o_jogo;
                    
                    System.out.println("Digite a quantidade de rodadas necessárias para que os jogares vençam a partidad: ");
                    rodadas_necessarias_para_vencer_o_jogo = sc.nextInt();

                    while (vitorias_do_jogador < rodadas_necessarias_para_vencer_o_jogo && vitorias_do_adversario < rodadas_necessarias_para_vencer_o_jogo) {
                        System.out.println("\n==== NOVA RODADA ====");
                        System.out.println("=== PLACAR ATUAL ===");
                        System.out.println("Jogador: " + vitorias_do_jogador + " X Adversário: " + vitorias_do_adversario);

                        int montando_pilha_de_cartas = 0;
                        for (int naipe_de_cartas = 1; naipe_de_cartas <= 4; naipe_de_cartas++){
                            for (int valor_das_cartas = 1; valor_das_cartas <= 13; valor_das_cartas++){
                                pilhas_de_cartas_que_serao_distribuidas[montando_pilha_de_cartas][0] = valor_das_cartas;
                                pilhas_de_cartas_que_serao_distribuidas[montando_pilha_de_cartas][1] = naipe_de_cartas;
                                montando_pilha_de_cartas++;
                            }
                        }

                        for (int emb = 0; emb < 52; emb++){
                            int embaralhando_aleatoriamente = sortear_cartas.nextInt(52);
                            int[] temporario = pilhas_de_cartas_que_serao_distribuidas[emb];
                            pilhas_de_cartas_que_serao_distribuidas[emb] = pilhas_de_cartas_que_serao_distribuidas[embaralhando_aleatoriamente];
                            pilhas_de_cartas_que_serao_distribuidas[embaralhando_aleatoriamente] = temporario;
                        }

                        int soma_das_cartas_do_jogador = 0;
                        int soma_das_cartas_do_adversario = 0;
                        int quantidade_de_cartas_do_jogador = 0;
                        int quantidade_de_cartas_do_adversario = 0;
                        int carta_no_topo_da_pilha = 0;

                        cartas_do_jogador[quantidade_de_cartas_do_jogador][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_jogador[quantidade_de_cartas_do_jogador][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_jogador += calcular_valores_das_cartas(cartas_do_jogador[quantidade_de_cartas_do_jogador][0]);
                        quantidade_de_cartas_do_jogador++;
                        carta_no_topo_da_pilha++;

                        cartas_do_jogador[quantidade_de_cartas_do_jogador][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_jogador[quantidade_de_cartas_do_jogador][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_jogador += calcular_valores_das_cartas(cartas_do_jogador[quantidade_de_cartas_do_jogador][0]);
                        quantidade_de_cartas_do_jogador++;
                        carta_no_topo_da_pilha++;

                        cartas_do_adversario[quantidade_de_cartas_do_adversario][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_adversario[quantidade_de_cartas_do_adversario][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_adversario += calcular_valores_das_cartas(cartas_do_adversario[quantidade_de_cartas_do_adversario][0]);
                        quantidade_de_cartas_do_adversario++;
                        carta_no_topo_da_pilha++;

                        cartas_do_adversario[quantidade_de_cartas_do_adversario][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                        cartas_do_adversario[quantidade_de_cartas_do_adversario][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                        soma_das_cartas_do_adversario += calcular_valores_das_cartas(cartas_do_adversario[quantidade_de_cartas_do_adversario][0]);
                        quantidade_de_cartas_do_adversario++;
                        carta_no_topo_da_pilha++;

                        System.out.println("\n== CARTAS DO JOGADOR ==");
                        exibir_cartas(cartas_do_jogador[0][0], cartas_do_jogador[0][1]);
                        exibir_cartas(cartas_do_jogador[1][0], cartas_do_jogador[1][1]);
                        System.out.println("Soma atual das suas cartas: " + soma_das_cartas_do_jogador);

                        System.out.println("\n== CARTAS DO ADVERSÁRIO ==");
                        exibir_cartas(cartas_do_adversario[0][0], cartas_do_adversario[0][1]);
                        System.out.println();

                        boolean segunda_jogada_do_jogador = true;
                        while (segunda_jogada_do_jogador && soma_das_cartas_do_adversario <= 21) {
                            System.out.println("Deseja pedir mais uma carta ? \n1 - Sim \n2 - Não");
                            int opcao_do_usuario = sc.nextInt();

                            if (opcao_do_usuario == 1) {
                                cartas_do_jogador[quantidade_de_cartas_do_jogador][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                                cartas_do_jogador[quantidade_de_cartas_do_jogador][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];

                                soma_das_cartas_do_jogador += calcular_valores_das_cartas(cartas_do_jogador[quantidade_de_cartas_do_jogador][0]);

                                System.out.println("Você comprou uma carta: ");
                                exibir_cartas(cartas_do_jogador[quantidade_de_cartas_do_jogador][0], cartas_do_jogador[quantidade_de_cartas_do_jogador][1]);

                                quantidade_de_cartas_do_jogador++;
                                carta_no_topo_da_pilha++;

                                System.out.println("Sua soma de cartas atualmente: " + soma_das_cartas_do_jogador);
                            } else {
                                segunda_jogada_do_jogador = false;
                            }
                        }

                        System.out.println("\nMostrando a segunda carta do Adversário: ");
                        exibir_cartas(cartas_do_adversario[1][0], cartas_do_adversario[1][1]);
                        System.out.println("Soma das cartas do Adversário: " + soma_das_cartas_do_adversario);

                        if (soma_das_cartas_do_jogador > 21) {
                            System.out.println("Você estorou 21!\nO adversário venceu a rodada!");
                            vitorias_do_adversario++;
                        } else {
                            while (soma_das_cartas_do_adversario <= 16) {
                                System.out.println("O adversário comprou uma carta: ");
                                cartas_do_adversario[quantidade_de_cartas_do_adversario][0] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][0];
                                cartas_do_adversario[quantidade_de_cartas_do_adversario][1] = pilhas_de_cartas_que_serao_distribuidas[carta_no_topo_da_pilha][1];
                                soma_das_cartas_do_adversario += calcular_valores_das_cartas(cartas_do_adversario[quantidade_de_cartas_do_adversario][0]);

                                exibir_cartas(cartas_do_adversario[quantidade_de_cartas_do_adversario][0], cartas_do_adversario[quantidade_de_cartas_do_adversario][1]);
                                quantidade_de_cartas_do_adversario++;
                                carta_no_topo_da_pilha++;
                                System.out.println("Soma das cartas do Adversário atualmente: " + soma_das_cartas_do_adversario);
                            }

                            System.out.println("\n=== FIM DA RODADA ===");
                            System.out.println("Sua pontuação final: " +soma_das_cartas_do_jogador);
                            System.out.println("Pontuação final do adversário: " +soma_das_cartas_do_adversario);

                            if (soma_das_cartas_do_adversario < 21) {
                                System.out.println("O Adversário estorou 21!\nVocê venceu a rodada!");
                                vitorias_do_jogador++;
                            } else if (soma_das_cartas_do_jogador > soma_das_cartas_do_adversario) {
                                System.out.println("Você venceu a rodada!\nParabéns!!");
                            } else if (soma_das_cartas_do_adversario > soma_das_cartas_do_jogador) {
                                System.out.println("O Adversário venceu a rodada!");
                                vitorias_do_adversario++;
                            } else {
                                System.out.println("Empate!\nNenhum ponto foi atribuído!");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n=== REGRAS DO BLACKJACK ===");
                    System.out.println("1° OBJETIVO: SOMAR PONTOS ATÉ CHEGAR O MAIS PRÓXIMO DE 21. Quem passar de 21 perde a rodada!");
                    System.out.println("============================================================================================");
                    System.out.println("2° VALORES DAS CARTAS:");
                    System.out.println("- As (A) vale 1 ponto.\n- 10, Valete (J), Dama (Q) e Rei (K) valem 10 pontos.\n- Cartas de 2 a 9 valem seu próprio valor nominal.");
                    System.out.println("============================================================================================");
                    System.out.println("3° - Estrutura Geral: ");
                    System.out.println("O jogo termina quando alguém atingir o número de vitórias definido inicialmente.");
                    System.out.println("============================================================================================");
                    System.out.println("4° - Distribuição Inicial: ");
                    System.out.println("- O usuário recebe 2 cartas viradas para cima.\n - O adversário recebe 1 para cima e 1 oculta [X].");
                    System.out.println("============================================================================================");
                    System.out.println("5° - Turno do Usuário: ");
                    System.out.println("- Você pode pedir cartas até decidir parar ou até estourar (Ultrapassar 21 pontos).");
                    System.out.println("============================================================================================");
                    System.out.println("6° - Turno do Adversário: ");
                    System.out.println("- Se o jogador estourar, o adversário vence direto.\n- Se não, a carta oculta dele é revelado.\n- Ele é obrigado a comprar cartas se tiver 16 ou menos.\n - Ele é obrigado a parar se atingir 17 ou mais.");
                    System.out.println("============================================================================================");
                    System.out.println("7° - Pontuação da Rodada: ");
                    System.out.println("- Quem tiver a maior soma em passar de 21 pontua.\n - Em caso de somas iguais, ocorre empate (sem empate para ambas as partes!).");
                    break;
                case 3:
                    System.out.println("Saindo do jogo!!\nObrigado por jogar nosso jogo!!");
                    break;
                default:
                    System.out.println("Opção inválida!!\nTente escolher números entre 1 a 3, para que o sistema funcione!");
                    break;
            }
        }
        sc.close();
    }

    public static int calcular_valores_das_cartas (int valor_bruto) {
        if (valor_bruto == 1) {
            return 1;
        } else if (valor_bruto >= 10) {
            return 10;
        } else {
            return valor_bruto;
        }
    }

    public static void exibir_cartas(int valor_das_cartas, int naipe_de_cartas){
        String nomeacao_da_carta = "";
        String nomeacao_do_naipe = "";

        switch (valor_das_cartas) {
            case 1:
                nomeacao_da_carta = "Ás";
                break;
            case 11:
                nomeacao_da_carta = "Valete";
                break;
            case 12:
                nomeacao_da_carta = "Dama";
                break;
            case 13:
                nomeacao_da_carta = "Rei";
                break;
            default:
                nomeacao_da_carta = String.valueOf(valor_das_cartas);
                break;
        }

        switch (naipe_de_cartas) {
            case 1:
                nomeacao_do_naipe = "Copas";
                break;
            case 2:
                nomeacao_do_naipe = "Espadas";
                break;
            case 3:
                nomeacao_do_naipe = "Ouros";
                break;
            case 4:
                nomeacao_do_naipe = "Paus";
                break;
            default:
                break;
        }

        System.out.println("[" + nomeacao_da_carta + " de " + nomeacao_do_naipe);
    }
}