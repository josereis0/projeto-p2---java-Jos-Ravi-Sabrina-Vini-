package model;

import service.Carrinho;

/*
 * Representa um cliente do sistema, que é um tipo de `Usuario`.
 * Cada cliente possui um `Carrinho` para adicionar livros e finalizar compras.
 */
public class Cliente extends Usuario {
    // carrinho associado ao cliente para compras
    private Carrinho carrinho;

    public Cliente(String nome) {
        super(nome, "Cliente");
        // inicializa um carrinho novo ao criar o cliente
        this.carrinho = new Carrinho();
    }

    // retorna o carrinho do cliente (com tratamento de exceção)
    public Carrinho getCarrinho() {
        try {
            return carrinho;
        } catch (Exception e) {
            System.out.println("Erro ao obter carrinho: " + e.getMessage());
            return null;
        }
    }
}
