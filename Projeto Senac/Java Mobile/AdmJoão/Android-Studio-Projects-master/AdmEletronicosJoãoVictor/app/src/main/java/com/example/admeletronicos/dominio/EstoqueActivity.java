package com.example.admeletronicoslucas.dominio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.admeletronicoslucas.R;

public class EstoqueActivity extends AppCompatActivity {

    private ListView listViewProdutos;
    private ProdutoAdapter produtoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);
        listViewProdutos = (ListView)findViewById(R.id.listViewProdutos);
        produtoAdapter = new ProdutoAdapter();

        listViewProdutos.setAdapter(produtoAdapter.listarProdutos(this));
    }

    //Cria o menu_produtos na tela, que possui apenas uma seta para voltar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_produtos, menu);
        return true;
    }

    //Método para verificar item selecionado no menu, que nesse caso é apenas o botão de retorno
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.itemVoltar){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
