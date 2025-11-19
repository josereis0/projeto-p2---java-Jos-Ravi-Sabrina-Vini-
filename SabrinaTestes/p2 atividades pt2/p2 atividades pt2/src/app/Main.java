package app;

import model.*;
import service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Biblioteca biblioteca = new Biblioteca();

            int opcao;
            do {
            System.out.println("\n SISTEMA DE LIVRARIA ");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro");
            System.out.println("4 - Remover livro");
            System.out.println("5 - Cadastrar usuário");
            System.out.println("6 - Listar usuários");
            System.out.println("7 - Remover usuário");
            System.out.println("8 - Adicionar livro ao carrinho");
            System.out.println("9 - Ver carrinho");
            System.out.println("10 - Finalizar compra");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

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
                    biblioteca.adicionarLivro(new Livro(titulo, autor, preco, estoque, ano));
                    break;

                case 2:
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

                    if (tipo.equalsIgnoreCase("Admin")) {
                        biblioteca.adicionarUsuario(new Admin(nome));
                    } else {
                        biblioteca.adicionarUsuario(new Cliente(nome));
                    }
                    break;

                case 6:
                    biblioteca.listarUsuarios();
                    break;

                case 7:
                    System.out.print("Nome do usuário a remover: ");
                    String nomeRemover = sc.nextLine();
                    biblioteca.removerUsuario(nomeRemover);
                    break;

                case 8:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    Usuario usuarioCarrinho = biblioteca.buscarUsuario(nomeCliente);
                    if (usuarioCarrinho == null || !(usuarioCarrinho instanceof Cliente)) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Título do livro: ");
                    String tituloCarrinho = sc.nextLine();
                    Livro livroCarrinho = biblioteca.buscarLivro(tituloCarrinho);
                    if (livroCarrinho != null && livroCarrinho.isDisponivel()) {
                        ((Cliente) usuarioCarrinho).getCarrinho().adicionarLivro(livroCarrinho);
                        System.out.println("Livro adicionado ao carrinho!");
                    } else {
                        System.out.println("Livro não encontrado ou indisponível.");
                    }
                    break;

                case 9:
                    System.out.print("Nome do cliente: ");
                    String nomeC = sc.nextLine();
                    Usuario uC = biblioteca.buscarUsuario(nomeC);
                    if (uC != null && uC instanceof Cliente) ((Cliente) uC).getCarrinho().exibirCarrinho();
                    else System.out.println("Cliente não encontrado.");
                    break;

                case 10:
                    System.out.print("Nome do cliente: ");
                    String nomeF = sc.nextLine();
                    Usuario uF = biblioteca.buscarUsuario(nomeF);
                    if (uF != null && uF instanceof Cliente) ((Cliente) uF).getCarrinho().finalizarCompra();
                    else System.out.println("Cliente não encontrado.");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

            sc.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
