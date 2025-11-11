package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }

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

    // ✅ Método 1: editar diretamente com parâmetros
    public void editarUsuario(String novoNome, String novoTipo) {
        if (novoNome != null && !novoNome.isEmpty()) this.nome = novoNome;
        if (novoTipo != null && !novoTipo.isEmpty()) this.tipo = novoTipo;
        System.out.println("✅ Dados do usuário atualizados com sucesso!");
    }

    // ✅ Método 2: menu interativo para editar no console
    public void menuEditarUsuario() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU DE EDIÇÃO DE USUÁRIO =====");
            System.out.println("1 - Editar nome");
            System.out.println("2 - Editar tipo");
            System.out.println("3 - Exibir dados do usuário");
            System.out.println("0 - Sair da edição");
            System.out.print("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    if (!novoNome.isEmpty()) this.nome = novoNome;
                }
                case 2 -> {
                    System.out.print("Novo tipo (ex: Administrador, Cliente, Funcionário...): ");
                    String novoTipo = sc.nextLine();
                    if (!novoTipo.isEmpty()) this.tipo = novoTipo;
                }
                case 3 -> exibirDados();
                case 0 -> System.out.println("Saindo do menu de edição...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
