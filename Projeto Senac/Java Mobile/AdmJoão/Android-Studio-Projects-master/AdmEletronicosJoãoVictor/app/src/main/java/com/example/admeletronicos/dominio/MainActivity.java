package com.example.admeletronicoslucas.dominio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.admeletronicoslucas.R;
import com.example.admeletronicoslucas.db.BancoDados;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BancoDados db = new BancoDados(this);
    }

    // Metodo para chamar a tela que Lista os produtos
    public void irTelaEstoque(View view) {
        Intent intent = new Intent(this, EstoqueActivity.class);
        startActivity(intent);
    }

    // Metodo para chamar a tela de Cadastro dos produtos
    public void irTelaCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}