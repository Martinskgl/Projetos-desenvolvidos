package com.example.admeletronicoslucas.dominio;

public class Produto {
    private int codigo; //Código do produto
    private String nome; //Nome do Produto
    private String fabricante; //Fabricante do Produto

    /*Construtor do produto com entrada do nome e do fabricante.
      O código é gerado automaticamente com o AUTOINCREMENT no banco de dados.
     */
    public Produto(String nome, String fabricante){
        this.nome = nome;
        this.fabricante = fabricante;
    }

    //Construtor vazio do produto.
    public Produto(){

    }

    /*
       Seção com "getters" e "setters" para manipular externamente as variáveis do produto.
     */

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
