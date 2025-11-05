package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private int estoque;
    private int ano;

    public Livro(String titulo, String autor, double preco, int estoque, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.estoque = estoque;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public int getAno() { return ano; }

    public boolean isDisponivel() {
        return estoque > 0;
    }

    public void decrementarEstoque() {
        if (estoque > 0) estoque--;
    }

    public void incrementarEstoque() {
        estoque++;
    }

    public void exibirInformacoes() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Preço: " + nf.format(preco));
        System.out.println("Estoque: " + estoque);
        System.out.println("Ano: " + ano);
        System.out.println("-------------------------");
    }
}
