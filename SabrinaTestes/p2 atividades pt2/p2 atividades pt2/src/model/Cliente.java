package model;

import service.Carrinho;

public class Cliente extends Usuario {
    private Carrinho carrinho;

    public Cliente(String nome) {
        super(nome, "Cliente");
        this.carrinho = new Carrinho();
    }

    public Carrinho getCarrinho() {
        try {
            return carrinho;
        } catch (Exception e) {
            System.out.println("Erro ao obter carrinho: " + e.getMessage());
            return null;
        }
    }
}
