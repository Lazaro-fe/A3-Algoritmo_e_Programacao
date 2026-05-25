import java.util.Scanner;

public class Cadastro_de_Produtos {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Está definindo a quantidade de produtos que devem ser armazenados no mercado do seu Zé
        int armazenamento_do_mercado_do_seu_ze = 10;
        // Será armazenado nessa variável a quantidade de produtos cadastrados
        int quantidade_de_produtos_do_mercadinho = 0;

        // Utlizando vetores para armazenar o nome de produtos cadastrados
        String[] nome_dos_produtos = new String[armazenamento_do_mercado_do_seu_ze];
        // Utilizando vetores para armazenar a quantidade de produtos em estoque no vetor
        int[] quantidade_em_estoque = new int[armazenamento_do_mercado_do_seu_ze];
        // Utilizando vetores para armazenar os precos dos produtos digitados
        double[] preco_dos_produtos = new double[armazenamento_do_mercado_do_seu_ze];

        // 
        int opcao_menu_mercadinho;

        while (true) {
            System.out.println("\n===== CADASTRO DE PRODUTOS DO MERCADINHO DO SEU ZÉ =====");
            System.out.println("1 - INCLUIR NOVO PRODUTO");
            System.out.println("2 - CONSULTAR UM PRODUTO");
            System.out.println("3 - ALTERAR DADOS DE UM PROUTO");
            System.out.println("4 - EXCLUIR DADOS DE UM PRODUTO");
            System.out.println("5 - IMPRIMIR LISTA DE PRODUTOS");
            System.out.println("6 - SAIR DO SISTEMA");
            System.out.println();
            System.out.print("Digite a opção desejada : ");
            opcao_menu_mercadinho = sc.nextInt();

            sc.nextLine(); // Limpando Buffer

            switch (opcao_menu_mercadinho) {
                case 1: // INCLUIR NOVO PRODUTO

                    // VERIFICARÁ SE O ESPAÇO DO VETOR FOI PREENCHIDO
                    if (quantidade_de_produtos_do_mercadinho >= armazenamento_do_mercado_do_seu_ze) {
                        System.out.println("Quantida de Produtos em estoque está cheio!!");
                        continue;
                    }
                    
                    System.out.print("Digite um nome do produto: ");
                    nome_dos_produtos[quantidade_de_produtos_do_mercadinho] = sc.nextLine();

                    System.out.print("Digite a quantidade de produtos presentes no estoque: ");
                    quantidade_em_estoque[quantidade_de_produtos_do_mercadinho] = sc.nextInt();

                    System.out.print("Quanto custa o produto no mercadinho: " );
                    preco_dos_produtos[quantidade_de_produtos_do_mercadinho] = sc.nextDouble();

                    quantidade_de_produtos_do_mercadinho++;
                    System.out.println("Produto Cadastrado com Sucesso!!");
                    break;
                case 2: // CONSULTADO PRODUTO

                    if (quantidade_de_produtos_do_mercadinho == 0) {
                        System.out.println("Nenhum produto foi Cadastrado no Mercadinho!");
                    }

                    System.out.print("Digite o nome do produto que deseja consultar: ");
                    String busca_de_produtos = sc.nextLine();

                    int pos_busca_de_produtos = -1;
                    for(int i = 0; i < quantidade_de_produtos_do_mercadinho; i++){
                        if (nome_dos_produtos[i].equalsIgnoreCase(busca_de_produtos)) {
                            pos_busca_de_produtos = i;
                            break;
                        }
                    }

                    if (pos_busca_de_produtos == -1) {
                        System.out.println("Produto não encontrado no Sistema!");
                    } else {
                        System.out.println("Nome do Produto: " + nome_dos_produtos[pos_busca_de_produtos] + "// Quantidade de Produtos em estoque: " + quantidade_em_estoque[pos_busca_de_produtos] + "// Valor do Produto: R$ " + preco_dos_produtos[pos_busca_de_produtos]);
                    }
                    break;

                case 3: // ALTERANDO DADOS DE PRODUTO
                    
                    if (quantidade_de_produtos_do_mercadinho == 0) {
                        System.out.println("Nenhum produto foi cadastrado!");
                    }

                    System.out.print("Digite o nome do produto que deseja alterar: ");
                    String alterar_produto = sc.nextLine();

                    int pos_altera = -1;
                    for(int d = 0; d < quantidade_de_produtos_do_mercadinho; d++){
                        if (nome_dos_produtos[d].equalsIgnoreCase(alterar_produto)) {
                            pos_altera = d;
                            break;
                        }
                    }

                    if (pos_altera == -1) {
                        System.out.println("Produto não encontrado!");
                    } else {
                        System.out.println("Novo produto: ");
                        String novo_produto_nome = sc.nextLine();

                        System.out.println("Quantidade de estoque do produto: ");
                        int quantidade_de_estoque_do_novo_produto = sc.nextInt();

                        System.out.println("Preço do Produto: ");
                        double preco_de_produto_novo = sc.nextDouble();

                        nome_dos_produtos[pos_altera] = novo_produto_nome;
                        quantidade_em_estoque[pos_altera] = quantidade_de_estoque_do_novo_produto;
                        preco_dos_produtos[pos_altera] = preco_de_produto_novo;

                        System.out.println("Alterado com Sucesso!");
                    }

                    break;
                case 4: // EXCLUINDO PRODUTO DO SISTEMA

                    if (quantidade_de_produtos_do_mercadinho == 0) {
                        System.out.println("Nenhum produto foi cadastrado no mercadinho!");
                    }

                    System.out.println("Digite o nome do produto que deseja remover");
                    String nome_remove = sc.nextLine();

                    int pos_remove = -1;
                    for(int r = 0; r < quantidade_de_produtos_do_mercadinho; r++){
                        if (nome_dos_produtos[r].equalsIgnoreCase(nome_remove)) {
                            pos_remove = r;
                            break;
                        }
                    }

                    if (pos_remove == -1) {
                        System.out.println("Produto não encontrado!");
                    } else {
                        for(int i = pos_remove; i < quantidade_de_produtos_do_mercadinho - 1; i++){
                            nome_dos_produtos[i] = nome_dos_produtos[i + 1];
                            quantidade_em_estoque[i] = quantidade_em_estoque[i + 1];
                            preco_dos_produtos[i] = preco_dos_produtos[i +1];
                        }

                        nome_dos_produtos[quantidade_de_produtos_do_mercadinho - 1] = null;
                        quantidade_em_estoque[quantidade_de_produtos_do_mercadinho - 1] = 0;
                        preco_dos_produtos[quantidade_de_produtos_do_mercadinho - 1] = 0;

                        quantidade_de_produtos_do_mercadinho--;

                        System.out.println("Produto removido com sucesso!");
                    }
                    break;
                case 5: // IMPRIMINDO LISTA DE PRODUTOS

                    if (quantidade_de_produtos_do_mercadinho == 0) {
                        System.out.println("Nenhum Produto cadastrado!");
                        break;
                    }

                    System.out.println("\n===== DADOS DOS PRODUTOS CADASTRADOS =====");
                    for(int yu = 0; yu < quantidade_de_produtos_do_mercadinho; yu++){
                        System.out.println("Nome do Produto: " + nome_dos_produtos[yu] + "// Quantidade do produto em estoque: " + quantidade_em_estoque[yu] + "// Preço do Produto: " +preco_dos_produtos[yu]);
                    }

                    break;
                case 6: // SAINDO DO SISTEMA
                    System.out.println("Saindo do Sistema do Mercadinho do Seu Zé!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção Inválida!!\nTente escolher um número entre 1 e 6");
                    break;
            }
        }
    }
}