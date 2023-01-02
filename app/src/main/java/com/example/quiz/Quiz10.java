package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz10 extends AppCompatActivity {
    private Button btnResponder10;
    private RadioGroup rdgQuiz10;
    private RadioButton rdbIrlanda, rdbEscocia, rdbFinlandia, rdbItalia;
    private int ponto;
    private String nome;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz10);
        btnResponder10 = findViewById(R.id.btnResponder10);
        rdgQuiz10 = findViewById(R.id.rdgQuiz10);
        rdbEscocia = findViewById(R.id.rdbEscocia);
        rdbFinlandia = findViewById(R.id.rdbFinlandia);
        rdbIrlanda = findViewById(R.id.rdbIrlanda);
        rdbItalia = findViewById(R.id.rdbItalia);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbEscocia.isChecked() || rdbFinlandia.isChecked() || rdbIrlanda.isChecked() || rdbItalia.isChecked()){
                    btnResponder10.setEnabled(true);
                }
                else{
                    btnResponder10.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder10(View view) {
        Intent it = new Intent(this, Ranking.class);
        it.putExtra("nome", nome);
        if(rdbItalia.isChecked()){
            ponto++;
            it.putExtra("cont",ponto);
        }
        else{
            it.putExtra("cont", ponto);
        }
        startActivity(it);
        finish();
    }
}