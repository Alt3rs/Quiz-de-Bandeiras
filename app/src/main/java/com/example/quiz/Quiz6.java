package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz6 extends AppCompatActivity {
    private Button btnResponder6;
    private RadioGroup rdgQuiz6;
    private RadioButton rdbCoreia, rdbAfrica, rdbCambodja, rdbPortugal;
    private int ponto;
    private Intent it;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);

        btnResponder6 = findViewById(R.id.btnResponder6);
        rdgQuiz6 = findViewById(R.id.rdgQuiz6);
        rdbAfrica = findViewById(R.id.rdbAfrica);
        rdbCambodja = findViewById(R.id.rdbCambodja);
        rdbCoreia = findViewById(R.id.rdbCoreia);
        rdbPortugal = findViewById(R.id.rdbPortugal);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbAfrica.isChecked() || rdbCambodja.isChecked() || rdbCoreia.isChecked() || rdbPortugal.isChecked()){
                    btnResponder6.setEnabled(true);
                }
                else{
                    btnResponder6.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder6(View view){
        Intent it = new Intent(this, Quiz7.class);
        it.putExtra("nome", nome);
        if(rdbCoreia.isChecked()){
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