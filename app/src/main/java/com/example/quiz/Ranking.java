package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {
    private TextView txtNome, txtSoma;
    private Intent it;
    private Button btnResponderNovamente, btnTelaPrincipal;
    private int ponto;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        btnResponderNovamente = findViewById(R.id.btnResponderNovamente);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);
        txtNome = findViewById(R.id.txtNome);
        txtSoma = findViewById(R.id.txtSoma);



        it = getIntent();
        nome = it.getStringExtra("nome");
        txtNome.setText(nome);

        ponto = getIntent().getIntExtra("cont", 0);
        txtSoma.setText(String.valueOf(ponto));

    }
    public void reponderNovamente (View view){

        Intent it = new Intent (this, Quiz1.class);
        startActivity(it);
        finish();
    }

    public void telaPrincipal (View view){

        Intent it = new Intent (this, MainActivity.class);
        startActivity(it);
        finish();
    }
}