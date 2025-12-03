package model;

/*
 * Representa um usuário administrador do sistema.
 * Herdando de `Usuario`, herda suas funcionalidades básicas.
 */
public class Admin extends Usuario {

    // construtor que define o tipo como "Admin"
    public Admin(String nome) {
        super(nome, "Admin");
    }
}
