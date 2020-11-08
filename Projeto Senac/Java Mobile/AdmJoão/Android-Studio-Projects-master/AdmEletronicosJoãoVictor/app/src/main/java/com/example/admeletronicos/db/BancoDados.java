package com.example.admeletronicoslucas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.admeletronicoslucas.dominio.Produto;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {
    private static final int VERSAO_BANCO = 1;

    //Nome do Banco de Dados
    private static final String NOME_BANCO = "dbAdmEletronicos";

    //Nome da tabela
    private static final String TABELA = "produto";

    //Nome das colunas
    private static final String COLUNA_CODIGO = "codigo";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_FABRICANTE = "fabricante";

    //Variável para manipular o banco de dados
    SQLiteDatabase db;

    public BancoDados(Context context) {
        //Construtor para criação do banco de dados de uma determinada versão
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    /*Esse método é chamado apenas uma vez para a criação do banco de dados
      Uma vez que o banco é criado, esse método não é mais chamado, mesmo
      após o programa ter sido fechado e aberto novamente.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Comando para criar a tabela
        db.execSQL(ScriptDLL.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Método para realizar a conexão ao banco de dados.
    public void conectardb(Context context){
        try{
            db = this.getWritableDatabase();
        } catch (SQLException ex){
            //Avisa o erro caso haja erro ao tentar conectar ao banco de dados.
            AlertDialog.Builder aviso = new AlertDialog.Builder(context);
            aviso.setTitle("Erro na conexão!")
                    .setMessage("Erro ao conectar ao banco de dados: " + ex.getMessage())
                    .setNeutralButton("Ok", null)
                    .show();
        }
    }

    //Método para fechar a conexão com o banco de dados.
    public void fechardb(Context context){
        try{
            db = this.getWritableDatabase();
        } catch (SQLException ex){
            //Avisa o erro caso haja erro ao desconectar.
            AlertDialog.Builder aviso = new AlertDialog.Builder(context);
            aviso.setTitle("Erro ao fechar a conexão!")
                    .setMessage("Erro desconectar do banco de dados: " + ex.getMessage())
                    .setNeutralButton("Ok", null)
                    .show();
        }
    }

    //Método para adicionar um produto ao banco de dados.
    public void adicionarProduto(Produto produto, Context context){

        conectardb(context);

        try{
            //Variável ContentValues que recebe os valores das colunas.
            ContentValues valores = new ContentValues();
            valores.put(COLUNA_NOME, produto.getNome());
            valores.put(COLUNA_FABRICANTE, produto.getFabricante());

            //Comando para inserir um produto no banco de dados.
            db.insert(TABELA, null, valores);

            //Mostra na tela o produto inserido no banco de dados
            Toast.makeText(context, "Produto " + produto.getNome() +
                    " adicionado com sucesso!", Toast.LENGTH_LONG).show();

        } catch (SQLException ex){
            //Avisa caso haja erro ao tentar insirir um produto no banco de dados.
            AlertDialog.Builder aviso = new AlertDialog.Builder(context);
            aviso.setTitle("Erro!")
                    .setMessage("Não foi possível inserir o produto no banco: " + ex.getMessage())
                    .setNeutralButton("Ok", null)
                    .show();
        }

        //Fechar conexão com o banco de dados após o uso
        fechardb(context);
    }

    //Função para remover um produto do banco de dados
    public void removerProduto(Produto produto, Context context){

        conectardb(context);

        try {
            //Comando para deletar um produto no banco de dados através do código
            db.delete(TABELA, COLUNA_CODIGO + " = ?",
                    new String[]{String.valueOf(produto.getCodigo())});

            //Mostra na tela o produto removido do banco de dados.
            Toast.makeText(context, "Produto " + produto.getNome() +
                    " removido com sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException ex){
            //Avisa caso haja erro ao tentar remover um produto no banco de dados.
            AlertDialog.Builder aviso = new AlertDialog.Builder(context);
            aviso.setTitle("Erro!")
                    .setMessage("Erro ao deletar o produto no banco: " + ex.getMessage())
                    .setNeutralButton("Ok", null)
                    .show();
        }

        //Fechar conexão com o banco de dados após o uso
        fechardb(context);
    }

    //Atualiza um produto no banco de dados.
    public void atualizarProduto(Produto produto, Context context){

        conectardb(context);

        //Variável ContentValues que recebe os valores das colunas
        ContentValues valores = new ContentValues();
        valores.put(COLUNA_NOME, produto.getNome());
        valores.put(COLUNA_FABRICANTE, produto.getFabricante());

        //Comando para atualizar um produto no banco de dados através do código
        db.update(TABELA, valores, COLUNA_CODIGO + " = ?",
                new String[]{String.valueOf(produto.getCodigo())});

        //Fechar conexão com o banco de dados após o uso
        fechardb(context);
    }

    /*Método para selecionar produtos através da busca pelo nome do produto.
      Ele retorna uma lista de produtos e caso seja passado uma string vazia,
      o método retorna todos os produtos do banco de dados.
     */
    public List<Produto> selecionarProdutos(String buscaNome, Context context){

        conectardb(context);

        List<Produto> listaProdutos = new ArrayList<Produto>();

        //Cursor para ler a consulta feita ao banco de dados.
        Cursor cursor;
        cursor = db.query(TABELA, new String[]{COLUNA_CODIGO, COLUNA_NOME, COLUNA_FABRICANTE},
                COLUNA_NOME + " LIKE ?", new String[]{"%"+buscaNome+"%"},
                null, null,null );

        //Verifica se há dados no cursor e caso haja, adiciona cada dado à lista de produtos.
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Produto produtoSelecionado = new Produto();
                produtoSelecionado.setCodigo(cursor.getInt(0));
                produtoSelecionado.setNome(cursor.getString(1));
                produtoSelecionado.setFabricante(cursor.getString(2));

                listaProdutos.add(produtoSelecionado);
            }while(cursor.moveToNext());
        }

        //Fechar conexão com o banco de dados após o uso
        fechardb(context);

        return listaProdutos;
    }
}
