package com.example.admeletronicoslucas.dominio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.admeletronicoslucas.R;
import com.example.admeletronicoslucas.db.BancoDados;

public class CadastroActivity extends AppCompatActivity {

    private BancoDados db;

    EditText editNome, editFabricante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        editNome = (EditText)findViewById(R.id.editTextNome);
        editFabricante = (EditText)findViewById(R.id.editTextFabricante);
        db = new BancoDados(this);
    }

    /*Cria o menu_produtos na tela, que possui uma seta para voltar, um ícone para salvar produto e
      um ícone para remover produto.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cad_produtos, menu);
        return true;
    }

    //Método para verificar item selecionado no menu e ativar a ação a ser tomada.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemVoltar:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.itemSalvar:
                if(validarCampos(editNome.getText().toString()) != true ||
                        validarCampos(editFabricante.getText().toString()) != true){
                    AlertDialog.Builder avisoDiag = new AlertDialog.Builder(this);
                    avisoDiag.setTitle("Erro!")
                            .setMessage("Não pode haver campos vazios!")
                            .setNeutralButton("Ok", null)
                            .show();
                } else {
                    //Salva o produto no banco de dados inserindo os valores de entrada.
                    db.adicionarProduto(new Produto(editNome.getText().toString(),
                            editFabricante.getText().toString()), this);
                }
                break;
            case R.id.itemRemover:
                ListView viewProdutos = new ListView(this);
                ProdutoAdapter produtoAdapter = new ProdutoAdapter();
                viewProdutos.setAdapter(produtoAdapter.listarProdutos(this));
                AlertDialog.Builder builderDiag = new AlertDialog.Builder(this);
                builderDiag.setTitle("Escolha o item a ser removido!")
                        .setCancelable(true)
                        .setView(viewProdutos);
                final AlertDialog dialog = builderDiag.create();
                dialog.show();
                //Listener para poder identificar e excluir o item selecionado.
                viewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //Remover o produto selecionado.
                        db.removerProduto(db.selecionarProdutos("", CadastroActivity.this)
                                .get(i), CadastroActivity.this);
                        dialog.dismiss();
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Método para verificar se há campos vazios.
    public boolean validarCampos(String campo){
        if(campo.compareTo("") == 0){
            return false;
        } else {
            return true;
        }
    }
}
