package service;

import model.Livro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro l) {
        try {
            livros.add(l);
            System.out.println("Livro adicionado: " + l.getTitulo());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }

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
