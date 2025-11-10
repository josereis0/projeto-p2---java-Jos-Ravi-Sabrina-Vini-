package service;

import model.Livro;
import model.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro l) {
        livros.add(l);
        System.out.println("Livro adicionado: " + l.getTitulo());
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        livros.forEach(Livro::exibirInformacoes);
    }

    public Livro buscarLivro(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }

    public void removerLivro(String titulo) {
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
    }

    public void adicionarUsuario(Usuario usuario) {
        Usuario.adicionarUsuario(usuario);
    }

    public void removerUsuario(String nome) {
        Usuario.removerUsuario(nome);
    }

    public Usuario buscarUsuario(String nome) {
        return Usuario.buscarUsuario(nome);
    }

    public void listarUsuarios() {
        List<Usuario> usuarios = Usuario.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        usuarios.forEach(Usuario::exibirDados);
    }
}
