package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz1 extends AppCompatActivity {
    private Button btnResponder;
    private RadioGroup rdgQuiz;
    private RadioButton rdbIraque, rdbBrasil, rdbGranada, rdbGuiana;
    private int ponto;
    private Intent it;
    private String nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        btnResponder = findViewById(R.id.btnResponder);
        rdgQuiz = findViewById(R.id.rdgQuiz);
        rdbIraque = findViewById(R.id.rdbIraque);
        rdbBrasil = findViewById(R.id.rdbBrasil);
        rdbGranada = findViewById(R.id.rdbGranada);
        rdbGuiana = findViewById(R.id.rdbGuiana);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rdbBrasil.isChecked() || rdbGranada.isChecked() || rdbGuiana.isChecked() || rdbIraque.isChecked()){
                    btnResponder.setEnabled(true);
                }
                else {
                    btnResponder.setEnabled(false);
                }
            }
        });
    }
    public void responder (View view){
        Intent it = new Intent(this, Quiz2.class);
        it.putExtra("nome", nome);
        if(rdbBrasil.isChecked()){
            ponto++;
            it.putExtra("cont",ponto);
        }
        else{
            it.putExtra("cont",ponto);
        }
        startActivity(it);
        finish();
    }

}