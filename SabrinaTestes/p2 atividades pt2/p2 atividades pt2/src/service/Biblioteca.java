package service;

import model.Livro;
import model.Usuario;
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

    public void adicionarUsuario(Usuario usuario) {
        try {
            Usuario.adicionarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    public void removerUsuario(String nome) {
        try {
            Usuario.removerUsuario(nome);
        } catch (Exception e) {
            System.out.println("Erro ao remover usuário: " + e.getMessage());
        }
    }

    public Usuario buscarUsuario(String nome) {
        try {
            return Usuario.buscarUsuario(nome);
        } catch (Exception e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
            return null;
        }
    }

    public void listarUsuarios() {
        try {
            List<Usuario> usuarios = Usuario.listarUsuarios();
            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuário cadastrado.");
                return;
            }
            usuarios.forEach(Usuario::exibirDados);
        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }
}
