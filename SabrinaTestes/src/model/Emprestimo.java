package model;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.devolvido = false;

        if (livro.isDisponivel()) {
            livro.decrementarEstoque();
        } else {
            System.out.println("Aviso: o livro não está disponível.");
        }
    }

    public Livro getLivro() { return livro; }
    public boolean isDevolvido() { return devolvido; }

    public void registrarDevolucao() {
        if (!devolvido) {
            devolvido = true;
            dataDevolucao = LocalDate.now();
            livro.incrementarEstoque();
            System.out.println("Devolução registrada: " + livro.getTitulo());
        } else {
            System.out.println("Esse empréstimo já foi devolvido.");
        }
    }

    public void exibirDadosEmprestimo() {
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Data do empréstimo: " + dataEmprestimo);
        System.out.println("Devolvido: " + (devolvido ? "Sim (" + dataDevolucao + ")" : "Não"));
        System.out.println("-------------------------");
    }
}
