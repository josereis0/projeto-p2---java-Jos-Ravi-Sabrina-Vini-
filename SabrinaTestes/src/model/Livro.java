package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Livro extends Publicacao {
    private String autor;

    public Livro(String titulo, String autor, double preco, int estoque, int ano , String editora) {
        super(titulo, preco, estoque, ano , editora); // chama o construtor da superclasse
        this.autor = autor;
    }

    public String getAutor() { return autor; }

    @Override
    public void exibirInformacoes() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Preço: " + nf.format(preco));
        System.out.println("Estoque: " + estoque);
        System.out.println("Ano: " + ano);
        System.out.println("Editora: " + editora);
        System.out.println("-------------------------");
    }
}
