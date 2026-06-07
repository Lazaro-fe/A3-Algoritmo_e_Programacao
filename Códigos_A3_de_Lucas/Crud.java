package Códigos_A3_de_Lucas;
import java.util.Scanner;


public class Crud {
    public static void main(String[] args){ 
        Scanner input = new Scanner ( System.in );
        
        int maxDeJogadores = 4;
        String[] jogadores = new String[maxDeJogadores];//Aqui defini uma array (isso serve para guardar um número definido de dados dentro de um mesmo espaço da memória)
        
        int jogadoresCadastrados = 0;
        int opcao = 0;
        
        while (opcao != 6){ //Laço de repetição para voltar as opções principais do menu sempre que uma ação secundária for finalizada
        
            //Menu de opções do sistema
            System.out.println("\n========= Menu do Game =========");
            System.out.println("1 - Cadastrar um novo jogador");
            System.out.println("2 - Ver um jogador");
            System.out.println("3 - Ver todos os jogadores");
            System.out.println("4 - Alterar nome do jogador");
            System.out.println("5 - Excluir jogador");
            System.out.println("6 - Sair");
            System.out.println("=================================");
            System.out.println("\n Escolha uma opção: ");
            
            opcao = input.nextInt();
            input.nextLine();
            
            switch (opcao){
                    //Primeira opção: Criar novos jogadores
                case 1: 
     
                    if (jogadoresCadastrados < maxDeJogadores){ 
                        
                        System.out.println("Escreva o nome do jogador: " );
                        String nomeJogador = input.nextLine();
                        jogadores[jogadoresCadastrados] = nomeJogador;
                        jogadoresCadastrados++;
                        System.out.println("Jogador cadastrado com sucesso");
                    } 
                    else{   
                        
                        System.out.println("O número máximo de jogadores foi atingido, aguarde a próxima partida!");
                    }
                    
                break;
                
                //Segunda opção: Ver um jogador
                case 2: 
                    if ( jogadoresCadastrados == 0 ){
                    
                        System.out.println("Nenhum jogador foi cadastrado");
                    }
                    else{ 
                        
                        System.out.println("Jogador 1 " + "Jogador 2 " + "Jogador 3 " + "Jogador 4");
                        System.out.println("Escolha o número do jogador que quer ver: ");

                        int opcaoJogador = input.nextInt();
                        int indice = opcaoJogador - 1;

                        if(indice >= 0 && indice < maxDeJogadores){
                            
                            if(jogadores[indice] != null){
                                System.out.println("Nome do jogador: " + jogadores[indice]);
                            }
                            else{
                                System.out.println("Esse jogador ainda não foi cadastrado");
                            }
                        }
                        else{
                            System.out.println("Opcao inválida");
                        }
                    }
                    
                break;

                //Terceira opção: Ver a lista completa de jogadores    
                case 3: 
                    if ( jogadoresCadastrados == 0 ){
                        System.out.println("Nenhum jogador foi cadastrado");
                    }
                    else{ 
                        
                        System.out.println("\n============ Lista de Jogadores ============");

                            for (int i = 0; i < jogadores.length; i++ ){
                                if (jogadores[i] != null){
                                    System.out.println(jogadores[i]);
                                }
                            }
                    }
                    
                break;
             
                //Quarta opçao: Alterar o nome do jogador    
                case 4: 
                    if (jogadoresCadastrados == 0){
                        System.out.println("Nenhum jogador foi cadastrado!");
                    }
            
                    else{
                        System.out.println("Escolha qual jogador deseja alterar: ");

                        for (int i = 0; i <= jogadores.length - 1; i++){
                            if (jogadores[i] != null){       
                                System.out.println(i + 1 + " - " + jogadores[i]);
                            }                                                        
                        }

                    int opcaoAlterar = input.nextInt();
                    int indiceAlterar = opcaoAlterar - 1;


                    /*Verfica se o indice do jogador for maior ou igual a 0
                    e se é menor que o número máximo de jogadores*/
                    if (indiceAlterar >= 0 && indiceAlterar < maxDeJogadores){
                            System.out.println("Digite o novo nome");
                            input.nextLine();
                            String novoNome = input.nextLine();
                            jogadores[indiceAlterar] = novoNome;
                            System.out.println("Jogador atualizado com sucesso");
                    }
                    else{
                        System.out.println("Opção inválida");
                    }
                }
                break;
                
                case 5:
                    if(jogadoresCadastrados == 0){
                        System.out.println("Nenhum jogador foi cadastrado");
                    }
                    else{
                        for(int i = 0; i <= jogadores.length - 1; i++){
                            if(jogadores[i] != null){
                                System.out.println(i + 1 + " - " + jogadores[i]);
                            }
                        }
                        
                        int opcaoExcluir = input.nextInt();
                        int indiceExcluir = opcaoExcluir - 1;
                        
                        if (indiceExcluir >= 0 && indiceExcluir < maxDeJogadores){
                            if (jogadores[indiceExcluir] != null){
                                System.out.println("Jogador " + jogadores[indiceExcluir] + " Excluido com sucesso!");
                                jogadores[indiceExcluir] = null;
                                jogadoresCadastrados--;
                            }
                            else{
                                System.out.println("Esse jogador não existe!");
                            }
                        }
                        else{
                            System.out.println("Opção inválida!");
                        }
                      
                    }
                break;
            }

        }
    }
           
}
    
