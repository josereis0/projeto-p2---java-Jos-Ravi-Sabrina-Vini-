package model;

import java.text.NumberFormat;
import java.util.Locale;

/*
 * Classe base para publicações (ex: livros, revistas).
 * Define atributos comuns como título, preço, estoque, ano e editora
 * e fornece métodos utilitários relacionados ao estoque e exibição.
 */
public class Publicacao {
    // campos protegidos para acesso por subclasses
    protected String titulo;
    protected double preco;
    protected int estoque;
    protected int ano;
    protected String editora;

    public Publicacao(String titulo, double preco, int estoque, int ano , String editora) {
        this.titulo = titulo;
        this.preco = preco;
        this.estoque = estoque;
        this.ano = ano;
        this.editora = editora;
    }

    // getters básicos
    public String getTitulo() { return titulo; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public int getAno() { return ano; }
    public String getEditora (){return editora;}

    // indica se há unidades em estoque
    public boolean isDisponivel() {
        return estoque > 0;
    }

    // decrementa o estoque quando uma unidade é vendida/emprestada
    public void decrementarEstoque() {
        if (estoque > 0) estoque--;
    }

    // incrementa o estoque (ex: ao devolver um exemplar)
    public void incrementarEstoque() {
        estoque++;
    }

    // Método que pode ser sobrescrito pelas subclasses para exibir detalhes
    public void exibirInformacoes() {
        try {
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
            System.out.println("Título: " + titulo);
            System.out.println("Preço: " + nf.format(preco));
            System.out.println("Estoque: " + estoque);
            System.out.println("Ano: " + ano);
            System.out.println("Editora : " + editora);
            System.out.println("-------------------------");
        } catch (Exception e) {
            System.out.println("Erro ao exibir publicação: " + e.getMessage());
        }
    }
}
