package service;

import model.Livro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Classe que gerencia uma coleção de livros em memória.
 * Fornece operações básicas: adicionar, listar, buscar e remover livros.
 */
public class Biblioteca {
    // lista de livros cadastrados na biblioteca
    private List<Livro> livros = new ArrayList<>();

    // adiciona um livro à coleção
    public void adicionarLivro(Livro l) {
        try {
            livros.add(l);
            System.out.println("Livro adicionado: " + l.getTitulo());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }

    // lista todas as publicações (chama o método de exibição de cada livro)
    public void listarLivros() {
        try {
            if (livros.isEmpty()) {
                System.out.println("Nenhum livro cadastrado.");
                return;
            }
            livros.forEach(Livro::exibirInformacoes);
        } catch (Exception e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }

    // procura um livro pelo título (insensível a maiúsculas/minúsculas)
    public Livro buscarLivro(String titulo) {
        try {
            for (Livro l : livros) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    return l;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao buscar livro: " + e.getMessage());
            return null;
        }
    }

    // remove o livro com o título informado
    public void removerLivro(String titulo) {
        try {
            Iterator<Livro> it = livros.iterator();
            while (it.hasNext()) {
                Livro l = it.next();
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    it.remove();
                    System.out.println("Livro removido: " + titulo);
                    return;
                }
            }
            System.out.println("Livro não encontrado.");
        } catch (Exception e) {
            System.out.println("Erro ao remover livro: " + e.getMessage());
        }
    }

    // métodos de usuário foram mantidos fora deste trecho caso existam em outra versão
}
