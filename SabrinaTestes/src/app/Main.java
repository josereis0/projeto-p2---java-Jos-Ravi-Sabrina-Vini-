package app;

import model.*;
import service.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        ArrayList<Usuario> usuarios = new ArrayList<>();
       

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

            
            System.out.println("10 - Registrar devolução");
            System.out.println("11 - Listar empréstimos");
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
                        usuarios.add(new Admin(nome));
                    } else {
                        usuarios.add(new Cliente(nome));
                    }
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 6:
                    if (usuarios.isEmpty()) System.out.println("Nenhum usuário cadastrado.");
                    else usuarios.forEach(Usuario::exibirDados);
                    break;

                case 7:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    Usuario usuarioCarrinho = usuarios.stream()
                            .filter(u -> u instanceof Cliente && u.getNome().equalsIgnoreCase(nomeCliente))
                            .findFirst().orElse(null);
                    if (usuarioCarrinho == null) {
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

                case 8:
                    System.out.print("Nome do cliente: ");
                    String nomeC = sc.nextLine();
                    Usuario uC = usuarios.stream()
                            .filter(u -> u instanceof Cliente && u.getNome().equalsIgnoreCase(nomeC))
                            .findFirst().orElse(null);
                    if (uC != null) ((Cliente) uC).getCarrinho().exibirCarrinho();
                    else System.out.println("Cliente não encontrado.");
                    break;

                case 9:
                    System.out.print("Nome do cliente: ");
                    String nomeF = sc.nextLine();
                    Usuario uF = usuarios.stream()
                            .filter(u -> u instanceof Cliente && u.getNome().equalsIgnoreCase(nomeF))
                            .findFirst().orElse(null);
                    if (uF != null) ((Cliente) uF).getCarrinho().finalizarCompra();
                    else System.out.println("Cliente não encontrado.");
                    break;

               

                case 10:
                    System.out.print("Título do livro: ");
                    String tituloDev = sc.nextLine();
                    Emprestimo emprestimoDev = emprestimos.stream()
                            .filter(e -> e.getLivro().getTitulo().equalsIgnoreCase(tituloDev) && !e.isDevolvido())
                            .findFirst().orElse(null);
                    if (emprestimoDev != null) {
                        emprestimoDev.registrarDevolucao();
                    } else {
                        System.out.println("Empréstimo não encontrado ou já devolvido.");
                    }
                    break;

                case 11:
                    if (emprestimos.isEmpty()) System.out.println("Nenhum empréstimo registrado.");
                    else emprestimos.forEach(Emprestimo::exibirDadosEmprestimo);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }



    package model;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Publicacao p1 = new Livro("Dom Casmurro", "Machado de Assis", 49.90, 5, 1899);
        Publicacao p2 = new Revista("Superinteressante", 19.90, 10, 2025, "Ciência");

        ArrayList<Publicacao> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);

        for (Publicacao p : lista) {
            // polimorfismo: mesmo método, comportamentos diferentes
            p.exibirInformacoes();
        }
    }
}

}
