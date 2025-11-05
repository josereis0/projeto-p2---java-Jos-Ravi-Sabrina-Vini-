package model;

public abstract class Usuario {
    private String nome;
    private String tipo;

    public Usuario(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }

    public void exibirDados() {
        System.out.println("Nome: " + nome + " | Tipo: " + tipo);
    }
}
