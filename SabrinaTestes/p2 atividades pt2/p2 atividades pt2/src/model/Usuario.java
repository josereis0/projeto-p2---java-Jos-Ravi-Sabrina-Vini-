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
        try {
            if (!usuariosCadastrados.contains(usuario)) {
                usuariosCadastrados.add(usuario);
                System.out.println("Usuário " + usuario.getNome() + " adicionado com sucesso!");
            } else {
                System.out.println("Usuário já cadastrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    public static void removerUsuario(String nome) {
        try {
            boolean removido = usuariosCadastrados.removeIf(u -> u.getNome().equalsIgnoreCase(nome));
            if (removido) {
                System.out.println("Usuário " + nome + " removido com sucesso!");
            } else {
                System.out.println("Usuário não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover usuário: " + e.getMessage());
        }
    }

    public static Usuario buscarUsuario(String nome) {
        try {
            return usuariosCadastrados.stream()
                    .filter(u -> u.getNome().equalsIgnoreCase(nome))
                    .findFirst().orElse(null);
        } catch (Exception e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
            return null;
        }
    }

    public static List<Usuario> listarUsuarios() {
        try {
            return new ArrayList<>(usuariosCadastrados);
        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void exibirDados() {
        try {
            System.out.println("Nome: " + nome + " | Tipo: " + tipo);
        } catch (Exception e) {
            System.out.println("Erro ao exibir dados de usuário: " + e.getMessage());
        }
    }
}
