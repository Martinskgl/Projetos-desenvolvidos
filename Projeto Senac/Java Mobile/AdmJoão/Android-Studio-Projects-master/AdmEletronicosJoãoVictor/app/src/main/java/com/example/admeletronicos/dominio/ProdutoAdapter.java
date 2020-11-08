package com.example.admeletronicoslucas.dominio;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.admeletronicoslucas.db.BancoDados;
import com.example.admeletronicoslucas.dominio.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoAdapter {
    private BancoDados db; //Banco de dados

    private ArrayAdapter<String> adapter; //Gerencia e adapta os dados que irão para a listView posteriormente.
    private ArrayList<String> lista; //Lista que contém os dados que serão exibidos.
    private List<Produto> listaprodutos; //Lista de produtos.

    //Esta função retorna o ArrayAdapter com os dados que será utilizados pela listView
    public ArrayAdapter<String> listarProdutos(Context context){

        db = new BancoDados(context);

        //Faz a busca de todos os produtos no banco de dados e armazena numa lista de produtos.
        listaprodutos = db.selecionarProdutos("", context);

        //Lista de String que será utilizada para formatar o texto do dado que será exibido.
        lista = new ArrayList<String>();

        //Pega os dados da lista e atribui um layout padrão do android chamado simple_list_item_1.
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, lista);

        /*Varre a lista de produtos e adiciona cada item que será exibido na "lista" de forma
         formatada e depois atualiza o Adapter a cada item adicionado.
         */
        for (Produto produto : listaprodutos) {
            lista.add("Nome: " + produto.getNome() + "\nFabricante: " + produto.getFabricante());
            adapter.notifyDataSetChanged();
        }

        return adapter;
    }
}
