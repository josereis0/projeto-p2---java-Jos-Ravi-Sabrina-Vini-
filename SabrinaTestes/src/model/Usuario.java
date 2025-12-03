package model;

import java.util.ArrayList;
import java.util.List;

/*
 * Classe que representa um usuário genérico do sistema.
 * Mantém nome e tipo, além de uma lista estática de usuários cadastrados
 * e métodos utilitários para CRUD simples em memória.
 *
 * Observação: A possibilidade de auto-edição foi removida para evitar que
 * usuários comuns alterem seu tipo (ex: tornar-se Admin).
 */
public class Usuario {
    private String nome;
    private String tipo;
    // lista estática compartilhada entre todas as instâncias
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();

    public Usuario(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }

    public void setNome(String nome) { this.nome = nome; }

    // adiciona um usuário à lista global (se ainda não existir)
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

    // remove usuário pelo nome (insensível a maiúsculas/minúsculas)
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

    // busca usuário por nome e retorna a instância ou null
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

    // retorna uma cópia da lista de usuários cadastrados
    public static List<Usuario> listarUsuarios() {
        try {
            return new ArrayList<>(usuariosCadastrados);
        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // exibe informações básicas do usuário
    public void exibirDados() {
        try {
            System.out.println("Nome: " + nome + " | Tipo: " + tipo);
        } catch (Exception e) {
            System.out.println("Erro ao exibir dados de usuário: " + e.getMessage());
        }
    }
}
