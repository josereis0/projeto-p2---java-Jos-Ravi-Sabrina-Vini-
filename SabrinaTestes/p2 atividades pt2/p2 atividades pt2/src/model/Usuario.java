package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String tipo;
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();

    public Usuario(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }

    public static void adicionarUsuario(Usuario usuario) {
        if (!usuariosCadastrados.contains(usuario)) {
            usuariosCadastrados.add(usuario);
            System.out.println("Usuário " + usuario.getNome() + " adicionado com sucesso!");
        } else {
            System.out.println("Usuário já cadastrado!");
        }
    }

    public static void removerUsuario(String nome) {
        boolean removido = usuariosCadastrados.removeIf(u -> u.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Usuário " + nome + " removido com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    public static Usuario buscarUsuario(String nome) {
        return usuariosCadastrados.stream()
                .filter(u -> u.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
    }

    public static List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuariosCadastrados);
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome + " | Tipo: " + tipo);
    }
}
