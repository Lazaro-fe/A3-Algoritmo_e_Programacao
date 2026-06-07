package Códigos_A3_de_Lucas;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        
        String[] valoresCartas = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] pontosCartas     = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        String[] valoresNaipes = {"Copas", "Espadas", "Ouros", "Paus"};
        
        // Matriz de cartas: coluna 0 = valor, coluna 1 = naipe
        String[][] pilhaCompra = new String[52][2];
        // Matriz que guardarará as cartas que o usuário e o cpu irão comprar durante o jogo 
        String[][] usuario     = new String[13][2];
        String[][] cpu  = new String[13][2];

        //Variaveis para guardar os placares e quantidade de rodadas
        int placarUsuario = 0;    
        int placarCpu = 0;
        int rodadaAtual = 1;
        
        System.out.println("===== Bem Vindo ao BlackJack =====");
        System.out.print("Informe quantas rodadas serao necessarias para declarar um vencedor: ");
        int maximo = input.nextInt();

        // LOOP PRINCIPAL: So para quando um dos jogadores atingir o maximo de vitórias
        while (placarUsuario < maximo && placarCpu < maximo) {
            System.out.println("\n//--------------------//");
            System.out.println(" Rodada  " + rodadaAtual);
            
            //Mostra a pontuação dos jogadores e a quantidade de cartas em mãos
            int somaUsuario = 0;    
            int somaCpu = 0;  
            int qtdUsuario = 0;      
            int qtdCpu = 0;   
            int topo = 0;            

            //Montagem da pilha do baralho com as 52 cartas
            int posicaoPilha = 0;
            for (int c = 0; c < 13; c++) {
                // Para cada face, combina com os 4 naipes
                for (int n = 0; n < 4; n++) {
                    pilhaCompra[posicaoPilha][0] = valoresCartas[c]; 
                    pilhaCompra[posicaoPilha][1] = valoresNaipes[n]; 
                    posicaoPilha++; 
                }
            }
            //Embaralhar as cartas usando:(ALGORITMO FISHER-YATES)
            for (int k = 51; k > 0; k--) {
                // Sorteia um número aleatório
                int j = random.nextInt(k + 1);
                // Realiza a troca das linhas da matriz usando uma variável 
                String[] temp = pilhaCompra[k];
                pilhaCompra[k] = pilhaCompra[j];
                pilhaCompra[j] = temp;
            }
            System.out.println("Pilha de Compra: ");
            for(int x = 0; x < 52; x++){
                System.out.println(" " + (x+1) + " " + pilhaCompra[x][0] + " de " + pilhaCompra[x][1]);
            }
            //Distribui as cartas para o usuario
            for (int j = 0; j < 2; j++) {
                usuario[qtdUsuario][0] = pilhaCompra[topo][0];
                usuario[qtdUsuario][1] = pilhaCompra[topo][1];
                topo++;        
                qtdUsuario++;  
            }
            //Distribui as cartas para o cpu (sendo uma visivel e uma oculta)
            for (int j = 0; j < 2; j++) {
                cpu[qtdCpu][0] = pilhaCompra[topo][0];
                cpu[qtdCpu][1] = pilhaCompra[topo][1];
                topo++;        
                qtdCpu++; 
            }
            //Exibir as cartas 
            System.out.println("\nCartas do Usuario:");
            // Passa por todas as cartas que o usuário tem na mão 
            for (int j = 0; j < qtdUsuario; j++) {
                String carta = usuario[j][0];
                String naipe = usuario[j][1];
                //Usa a função de buscarPontos para descobrir quanto vale o texto da carta em questão
                int pontos = buscarPontos(carta, valoresCartas, pontosCartas);
                somaUsuario += pontos; // Soma os pontos do jogador
                System.out.println("  " + carta + " de " + naipe + " (vale " + pontos + ")");
            }
            System.out.println("  Total: " + somaUsuario);

            System.out.println("\nCartas do Cpu:");
            // Pega apenas os dados da primeira carta do computador 
            String cartaVis = cpu[0][0];
            String naipeVis = cpu[0][1];
            int pontosVis = buscarPontos(cartaVis, valoresCartas, pontosCartas);
            somaCpu += pontosVis; // Guarda o ponto da primeira carta
            System.out.println("  " + cartaVis + " de " + naipeVis + " (vale " + pontosVis + ")");
            System.out.println("  X  (carta oculta)"); // Oculta a segunda carta 

            //Vez do usuario(COMPRAR OU PARAR)
            System.out.println("========================================="); 
            System.out.println("    TURNO DO USUARIO — Pedir ou Parar    ");    
            System.out.println("=========================================");
            //Verificar se ultrapassa o valor estipulado
            while (somaUsuario < 21) {
                System.out.print("\nDeseja comprar uma carta? (s/n): ");
                String escolha = input.next();

                // Se digitar 'n' interrompe o laço de repetição (usuário decide parar)
                if (escolha.equals("n")) {
                    break;
                }
                // Momento de comprar a carta no topo da pilha
                usuario[qtdUsuario][0] = pilhaCompra[topo][0];
                usuario[qtdUsuario][1] = pilhaCompra[topo][1];
                topo++; 

                // Guarda a carta comprada
                String novaCarta = usuario[qtdUsuario][0];
                String novoNaipe = usuario[qtdUsuario][1];
                int novosPontos = buscarPontos(novaCarta, valoresCartas, pontosCartas);

                qtdUsuario++; //Atualiza quantas cartas tem na mão do usuario
                somaUsuario += novosPontos; //Soma os novos pontos na mão dele

                System.out.println("  Carta comprada: " + novaCarta + " de " + novoNaipe + " (vale " + novosPontos + ")");
                System.out.println("  Total: " + somaUsuario);

                // Se estourar 21 pontos, avisa o jogador e sai do loop imediatamente
                if (somaUsuario > 21) {
                    System.out.println("  Passou de 21! Voce perdeu a rodada.");
                    break;
                }
            }
            //Verificação dos resultados 
            if (somaUsuario > 21) {
                // Caso o usuário estourou, a máquina ganha o ponto da rodada 
                System.out.println("\nCpu venceu a rodada!");
                placarCpu++;
            } else {
                // Se o usuário parou seguro (<= 21), a máquina revela sua segunda carta oculta 
                String cartaOculta = cpu[1][0];
                String naipeOculto = cpu[1][1];
                int pontosOcultos = buscarPontos(cartaOculta, valoresCartas, pontosCartas);
                somaCpu += pontosOcultos; // Atualiza a pontuação real da máquina adicionando a oculta

                System.out.println("\nCarta oculta do Cpu revelada:");
                System.out.println("  " + cartaOculta + " de " + naipeOculto + " (vale " + pontosOcultos + ")");
                System.out.println("  Total Cpu: " + somaCpu);

                System.out.println("\nTurno do Cpu:");
                while (somaCpu <= 16) {
                    cpu[qtdCpu][0] = pilhaCompra[topo][0];
                    cpu[qtdCpu][1] = pilhaCompra[topo][1];
                    topo++; 

                    String novaCarta = cpu[qtdCpu][0];
                    String novoNaipe = cpu[qtdCpu][1];
                    int novosPontos = buscarPontos(novaCarta, valoresCartas, pontosCartas);

                    qtdCpu++; 
                    somaCpu += novosPontos; 

                    System.out.println("  Maquina comprou: " + novaCarta + " de " + novoNaipe + " (vale " + novosPontos + ")");
                    System.out.println("  Total Cpu: " + somaCpu);
                }
                //Apuração dos pontos na partida
                System.out.println("\nResultado da rodada:");
                System.out.println("  Usuario: " + somaUsuario + " | Cpu: " + somaCpu);

                //Se a máquina passou de 21, o usuário ganha o ponto
                if (somaCpu > 21) {
                    System.out.println("  Cpu estourou! Usuario venceu!");
                    placarUsuario++;
                //Se ninguém estourou e a pontuação do usuário é maior que a da máquina, o usuario vence
                } else if (somaUsuario > somaCpu) {
                    System.out.println("  Usuario venceu!");
                    placarUsuario++;
                //Se ninguém estourou e o cpu somou mais pontos que o usuário, o cpu vence
                } else if (somaCpu > somaUsuario) {
                    System.out.println("  Cpu venceu!");
                    placarCpu++;
                //As duas pontuações finais resultarem em empate
                } else {
                    System.out.println("  Empate! Nenhum ponto assinalado.");
                }
            }
            rodadaAtual++;
        }
        System.out.println("\n========== FIM DA PARTIDA ==========");
        System.out.println("  Usuario:  " + placarUsuario + " vitoria(s)");
        System.out.println("  Cpu:  " + placarCpu + " vitoria(s)");

        // Faz o balanço geral de vitórias para declarar um vencedor
        if (placarUsuario > placarCpu) {
            System.out.println("VENCEDOR GERAL: Usuario!");
        } else {
            System.out.println("VENCEDOR GERAL: Cpu!");
        }
    }
    static int buscarPontos(String carta, String[] valoresCartas, int[] pontosCartas) {
        for (int i = 0; i < valoresCartas.length; i++) {
            if (valoresCartas[i].equals(carta)) {
                return pontosCartas[i]; // Retorna a pontuação correspondente encontrada 
            }
        }
        return 0; 
    }
}
