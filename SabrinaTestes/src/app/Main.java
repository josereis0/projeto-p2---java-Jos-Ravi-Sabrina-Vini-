package app;

import model.*;
import service.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Classe principal que inicializa o sistema de livraria e exibe
 * um menu interativo no console para o usuário interagir.
 * Contém o método `main` que controla o fluxo da aplicação.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Biblioteca biblioteca = new Biblioteca();
            ArrayList<Usuario> usuarios = new ArrayList<>();

            // variável que armazena a opção escolhida pelo usuário no menu
            int opcao;
            do {
            System.out.println("\n SISTEMA DE LIVRARIA ");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro");
            System.out.println("4 - Remover livro");
            System.out.println("5 - Cadastrar usuário");
            System.out.println("6 - Listar usuários");
            System.out.println("7 - Adicionar livro ao carrinho");
            System.out.println("8 - Ver carrinho");
            System.out.println("9 - Finalizar compra");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            // trata cada opção do menu através de um switch
            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    // cria e adiciona um novo livro à biblioteca
                    biblioteca.adicionarLivro(new Livro(titulo, autor, preco, estoque, ano));
                    break;

                case 2:
                    // lista todos os livros cadastrados na biblioteca
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o título: ");
                    String buscar = sc.nextLine();
                    Livro l = biblioteca.buscarLivro(buscar);
                    if (l != null) l.exibirInformacoes();
                    else System.out.println("Livro não encontrado.");
                    break;

                case 4:
                    System.out.print("Digite o título: ");
                    String remover = sc.nextLine();
                    biblioteca.removerLivro(remover);
                    break;

                case 5:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Tipo (Cliente/Admin): ");
                    String tipo = sc.nextLine();

                    // cria um usuário do tipo escolhido e adiciona à lista local
                    if (tipo.equalsIgnoreCase("Admin")) {
                        usuarios.add(new Admin(nome));
                    } else {
                        usuarios.add(new Cliente(nome));
                    }
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 6:
                    // exibe os usuários cadastrados no sistema (lista local `usuarios`)
                    if (usuarios.isEmpty()) System.out.println("Nenhum usuário cadastrado.");
                    else usuarios.forEach(Usuario::exibirDados);
                    break;

                case 7:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    Usuario usuarioCarrinho = usuarios.stream()
                            .filter(u -> u instanceof Cliente && u.getNome().equalsIgnoreCase(nomeCliente))
                            .findFirst().orElse(null);
                    // verifica se o cliente existe e permite adicionar livro ao carrinho
                    if (usuarioCarrinho == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Título do livro: ");
                    String tituloCarrinho = sc.nextLine();
                    Livro livroCarrinho = biblioteca.buscarLivro(tituloCarrinho);
                    // adiciona o livro ao carrinho se estiver disponível
                    if (livroCarrinho != null && livroCarrinho.isDisponivel()) {
                        ((Cliente) usuarioCarrinho).getCarrinho().adicionarLivro(livroCarrinho);
                        System.out.println("Livro adicionado ao carrinho!");
                    } else {
                        System.out.println("Livro não encontrado ou indisponível.");
                    }
                    break;

                case 8:
                    System.out.print("Nome do cliente: ");
                    String nomeC = sc.nextLine();
                    Usuario uC = usuarios.stream()
                            .filter(u -> u instanceof Cliente && u.getNome().equalsIgnoreCase(nomeC))
                            .findFirst().orElse(null);
                    // exibe o conteúdo do carrinho do cliente encontrado
                    if (uC != null) ((Cliente) uC).getCarrinho().exibirCarrinho();
                    else System.out.println("Cliente não encontrado.");
                    break;

                case 9:
                    System.out.print("Nome do cliente: ");
                    String nomeF = sc.nextLine();
                    Usuario uF = usuarios.stream()
                            .filter(u -> u instanceof Cliente && u.getNome().equalsIgnoreCase(nomeF))
                            .findFirst().orElse(null);
                    // finaliza a compra (desconta estoque e limpa o carrinho)
                    if (uF != null) ((Cliente) uF).getCarrinho().finalizarCompra();
                    else System.out.println("Cliente não encontrado.");
                    break;

               

                case 0:
                    // opção para encerrar o programa
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

            sc.close();
        } catch (Exception e) {
            System.out.println("Erro no sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
