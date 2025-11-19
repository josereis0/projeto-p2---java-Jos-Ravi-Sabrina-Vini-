package model;

public class Admin extends Usuario {

    public Admin(String nome) {
        super(nome, "Admin");
    }

    public void aprovarEmprestimo() {
        try {
            System.out.println("Admin " + getNome() + " aprovou um empréstimo.");
        } catch (Exception e) {
            System.out.println("Erro ao aprovar empréstimo: " + e.getMessage());
        }
    }
}
