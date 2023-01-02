package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz4 extends AppCompatActivity {
    private Button btnResponder4;
    private RadioGroup rdgQuiz4;
    private RadioButton rdbJamaica, rdbFilipinas, rdbCanada, rdbMexico;
    private int ponto;
    private String nome;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        btnResponder4 = findViewById(R.id.btnResponder4);
        rdgQuiz4 = findViewById(R.id.rdgQuiz4);
        rdbCanada = findViewById(R.id.rdbCanada);
        rdbFilipinas = findViewById(R.id.rdbFilipinas);
        rdbJamaica = findViewById(R.id.rdbJamaica);
        rdbMexico = findViewById(R.id.rdbMexico);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbCanada.isChecked() || rdbFilipinas.isChecked() || rdbJamaica.isChecked() || rdbMexico.isChecked()){
                    btnResponder4.setEnabled(true);
                }
                else{
                    btnResponder4.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder4 (View view){
        Intent it = new Intent(this, Quiz5.class);
        it.putExtra("nome", nome);
        if(rdbCanada.isChecked()){
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