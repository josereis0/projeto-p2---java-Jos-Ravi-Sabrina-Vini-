package service;

import model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

/*
 * Representa um carrinho de compras simples que guarda uma lista de `Livro`.
 * Permite adicionar itens, exibir o conteúdo e finalizar a compra (descontando estoque).
 */
public class Carrinho {
    // itens armazenados no carrinho
    private List<Livro> itens = new ArrayList<>();

    // adiciona um livro ao carrinho
    public void adicionarLivro(Livro l) {
        try {
            itens.add(l);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar livro ao carrinho: " + e.getMessage());
        }
    }

    // exibe os itens do carrinho com preços e calcula o total
    public void exibirCarrinho() {
        try {
            if (itens.isEmpty()) {
                System.out.println("Carrinho vazio.");
                return;
            }

            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
            double total = 0;
            System.out.println("Itens no carrinho:");
            for (Livro l : itens) {
                System.out.println("- " + l.getTitulo() + " | " + nf.format(l.getPreco()));
                total += l.getPreco();
            }
            System.out.println("Total: " + nf.format(total));
        } catch (Exception e) {
            System.out.println("Erro ao exibir carrinho: " + e.getMessage());
        }
    }

    // finaliza a compra: decrementa o estoque dos livros disponíveis e limpa o carrinho
    public void finalizarCompra() {
        try {
            if (itens.isEmpty()) {
                System.out.println("Carrinho vazio.");
                return;
            }

            for (Livro l : new ArrayList<>(itens)) {
                if (l.isDisponivel()) {
                    l.decrementarEstoque();
                }
            }

            System.out.println("Compra finalizada com sucesso!");
            itens.clear();
        } catch (Exception e) {
            System.out.println("Erro ao finalizar compra: " + e.getMessage());
        }
    }
}
