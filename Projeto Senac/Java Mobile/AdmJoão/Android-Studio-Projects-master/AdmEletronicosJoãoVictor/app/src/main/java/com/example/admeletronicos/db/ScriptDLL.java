package com.example.admeletronicoslucas.db;

public class ScriptDLL {
    //Método estático que contém uma string com uma query para a criação da tabela.
    public static String criarTabela(){
        String QUERY_CRIACAO_TABELA =
                "CREATE TABLE " + "produto" + "( " +
                        "codigo" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nome" +" VARCHAR(250) NOT NULL, " +
                        "fabricante" + " VARCHAR(250) NOT NULL)";
        return QUERY_CRIACAO_TABELA;
    }
}