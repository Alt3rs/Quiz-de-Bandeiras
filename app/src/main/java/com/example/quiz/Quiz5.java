package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz5 extends AppCompatActivity {
    private Button btnResponder5;
    private RadioGroup rdgQuiz5;
    private RadioButton rdbNoruega, rdbVietna, rdbBulgaria, rdbEspanha;
    private int ponto;
    private Intent it;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        btnResponder5 = findViewById(R.id.btnResponder5);
        rdgQuiz5 = findViewById(R.id.rdgQuiz5);
        rdbBulgaria = findViewById(R.id.rdbBulgaria);
        rdbNoruega = findViewById(R.id.rdbNoruega);
        rdbEspanha = findViewById(R.id.rdbEspanha);
        rdbVietna = findViewById(R.id.rdbVietna);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbBulgaria.isChecked() || rdbNoruega.isChecked() || rdbEspanha.isChecked() || rdbVietna.isChecked()){
                    btnResponder5.setEnabled(true);
                }
                else{
                    btnResponder5.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder5 (View view) {
        Intent it = new Intent(this, Quiz6.class);
        it.putExtra("nome", nome);
        if(rdbBulgaria.isChecked()){
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