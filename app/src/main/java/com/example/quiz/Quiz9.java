package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz9 extends AppCompatActivity {
    private Button btnResponder9;
    private RadioGroup rdgQuiz9;
    private RadioButton rdbTurquia, rdbAlemanha, rdbGales, rdbHungria;
    private int ponto;
    private String nome;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz9);
        btnResponder9 = findViewById(R.id.btnResponder9);
        rdgQuiz9 = findViewById(R.id.rdgQuiz9);
        rdbAlemanha = findViewById(R.id.rdbAlemanha);
        rdbGales = findViewById(R.id.rdbGales);
        rdbTurquia = findViewById(R.id.rdbTurquia);
        rdbHungria = findViewById(R.id.rdbHungria);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbAlemanha.isChecked() || rdbGales.isChecked() || rdbTurquia.isChecked() || rdbHungria.isChecked()){
                    btnResponder9.setEnabled(true);
                }
                else{
                    btnResponder9.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder9(View view){
        Intent it = new Intent(this, Quiz10.class);
        it.putExtra("nome", nome);
        if(rdbHungria.isChecked()){
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