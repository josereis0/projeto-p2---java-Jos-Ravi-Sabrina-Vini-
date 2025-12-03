package model;

import java.util.Scanner;

/*
 * Representa um livro, que é um tipo de `Publicacao`.
 * Contém informações como autor, preço, estoque e utilitários
 * para edição e exibição de seus dados.
 */
public class Livro extends Publicacao {
    // autor do livro
    private String autor;

    // construtor completo com editora
    public Livro(String titulo, String autor, double preco, int estoque, int ano, String editora) {
        super(titulo, preco, estoque, ano, editora);
        this.autor = autor;
    }

    // Construtor de conveniência sem editora (mantém compatibilidade com chamadas antigas)
    public Livro(String titulo, String autor, double preco, int estoque, int ano) {
        super(titulo, preco, estoque, ano, "");
        this.autor = autor;
    }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    // menu interativo que permite editar os campos do livro pelo console
    public void menuEditarLivro() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU DE EDIÇÃO DE LIVRO =====");
            System.out.println("1 - Editar Título");
            System.out.println("2 - Editar Autor");
            System.out.println("3 - Editar Preço");
            System.out.println("4 - Editar Estoque");
            System.out.println("5 - Editar Ano");
            System.out.println("6 - Editar Editora");
            System.out.println("7 - Exibir Informações");
            System.out.println("0 - Sair da Edição");
            System.out.print("Escolha uma opção: ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Novo título: ");
                    String novoTitulo = sc.nextLine();
                    if (!novoTitulo.isEmpty()) this.titulo = novoTitulo;
                }
                case 2 -> {
                    System.out.print("Novo autor: ");
                    String novoAutor = sc.nextLine();
                    if (!novoAutor.isEmpty()) this.autor = novoAutor;
                }
                case 3 -> {
                    System.out.print("Novo preço: ");
                    try {
                        this.preco = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Preço inválido. Valor não alterado.");
                    }
                }
                case 4 -> {
                    System.out.print("Novo estoque: ");
                    try {
                        this.estoque = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Estoque inválido. Valor não alterado.");
                    }
                }
                case 5 -> {
                    System.out.print("Novo ano: ");
                    try {
                        this.ano = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido. Valor não alterado.");
                    }
                }
                case 6 -> {
                    System.out.print("Nova editora: ");
                    String novaEditora = sc.nextLine();
                    if (!novaEditora.isEmpty()) this.editora = novaEditora;
                }
                case 7 -> exibirInformacoes();
                case 0 -> System.out.println("Saindo do menu de edição...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    @Override
    // imprime informações formatadas do livro reutilizando superclasse
    public void exibirInformacoes() {
        try {
            System.out.println("\n------ INFORMAÇÕES DO LIVRO ------");
            // exibe informações da superclasse
            super.exibirInformacoes();
            System.out.println("Autor: " + autor);
        } catch (Exception e) {
            System.out.println("Erro ao exibir informações do livro: " + e.getMessage());
        }
    }
}
