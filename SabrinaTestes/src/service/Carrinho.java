package service;

import model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class Carrinho {
    private List<Livro> itens = new ArrayList<>();

    public void adicionarLivro(Livro l) {
        try {
            itens.add(l);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar livro ao carrinho: " + e.getMessage());
        }
    }

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
