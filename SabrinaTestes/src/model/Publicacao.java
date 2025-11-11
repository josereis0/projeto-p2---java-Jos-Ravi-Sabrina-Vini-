package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Publicacao {
    protected String titulo;
    protected double preco;
    protected int estoque;
    protected int ano;

    public Publicacao(String titulo, double preco, int estoque, int ano) {
        this.titulo = titulo;
        this.preco = preco;
        this.estoque = estoque;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
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

    // Método que será sobrescrito pelas subclasses
    public void exibirInformacoes() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Título: " + titulo);
        System.out.println("Preço: " + nf.format(preco));
        System.out.println("Estoque: " + estoque);
        System.out.println("Ano: " + ano);
        System.out.println("-------------------------");
    }
}
