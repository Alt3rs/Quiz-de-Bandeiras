package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz7 extends AppCompatActivity {
    private Button btnResponder7;
    private RadioGroup rdgQuiz7;
    private RadioButton rdbChile, rdbCuba, rdbBrunei, rdbHonduras;
    private int ponto;
    private Intent it;
    private String nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz7);
        btnResponder7 = findViewById(R.id.btnResponder7);
        rdgQuiz7 = findViewById(R.id.rdgQuiz7);
        rdbBrunei = findViewById(R.id.rdbBrunei);
        rdbChile = findViewById(R.id.rdbChile);
        rdbCuba = findViewById(R.id.rdbCuba);
        rdbHonduras = findViewById(R.id.rdbHonduras);

        it = getIntent();
        nome = it.getStringExtra("nome");


        rdgQuiz7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbBrunei.isChecked() || rdbChile.isChecked() || rdbCuba.isChecked() || rdbHonduras.isChecked()){
                    btnResponder7.setEnabled(true);
                }
                else{
                    btnResponder7.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder7 (View view){
        Intent it = new Intent(this, Quiz8.class);
        it.putExtra("nome", nome);
        if(rdbCuba.isChecked()){
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