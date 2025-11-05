package model;

public class Admin extends Usuario {

    public Admin(String nome) {
        super(nome, "Admin");
    }

    public void aprovarEmprestimo() {
        System.out.println("Admin " + getNome() + " aprovou um empréstimo.");
    }
}
