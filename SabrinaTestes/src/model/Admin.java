package model;

/*
 * Representa um usuário administrador do sistema.
 * Herdando de `Usuario`, pode conter ações administrativas.
 */
public class Admin extends Usuario {

    // construtor que define o tipo como "Admin"
    public Admin(String nome) {
        super(nome, "Admin");
    }

    // exemplo de método administrativo simples (apenas demonstração)
    public void aprovarEmprestimo() {
        try {
            System.out.println("Admin " + getNome() + " aprovou um empréstimo.");
        } catch (Exception e) {
            System.out.println("Erro ao aprovar empréstimo: " + e.getMessage());
        }
    }
}
