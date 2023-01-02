package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz8 extends AppCompatActivity {
    private Button btnResponder8;
    private RadioGroup rdgQuiz8;
    private RadioButton rdbGuatemala, rdbArgentina, rdbMalasia, rdbUruguai;
    private int  ponto;
    private String nome;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz8);
        btnResponder8 = findViewById(R.id.btnResponder8);
        rdgQuiz8 = findViewById(R.id.rdgQuiz8);
        rdbArgentina = findViewById(R.id.rdbArgentina);
        rdbGuatemala = findViewById(R.id.rdbGuatemala);
        rdbMalasia = findViewById(R.id.rdbMalasia);
        rdbUruguai = findViewById(R.id.rdbUruguai);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbArgentina.isChecked() || rdbGuatemala.isChecked() || rdbMalasia.isChecked() || rdbUruguai.isChecked()){
                    btnResponder8.setEnabled(true);
                }
                else{
                    btnResponder8.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder8 (View view){
        Intent it = new Intent(this, Quiz9.class);
        it.putExtra("nome", nome);
        if(rdbGuatemala.isChecked()){
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