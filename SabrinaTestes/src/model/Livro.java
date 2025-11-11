package model;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Livro extends Publicacao {
    private String autor;

    public Livro(String titulo, String autor, double preco, int estoque, int ano, String editora) {
        super(titulo, preco, estoque, ano, editora);
        this.autor = autor;
    }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    // ✅ Menu interativo de edição
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
    public void exibirInformacoes() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("\n------ INFORMAÇÕES DO LIVRO ------");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Preço: " + nf.format(preco));
        System.out.println("Estoque: " + estoque);
        System.out.println("Ano: " + ano);
        System.out.println("Editora: " + editora);
        System.out.println("----------------------------------");
    }
}
