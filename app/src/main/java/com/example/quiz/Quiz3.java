package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz3 extends AppCompatActivity {
    private RadioGroup rdgQuiz3;
    private Button btnResponder3;
    private RadioButton rdbChina, rdbMadagascar, rdbLaos, rdbIslandia;
    private int ponto;
    private Intent it;
    private String nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        rdgQuiz3 = findViewById(R.id.rdgQuiz3);
        rdbChina = findViewById(R.id.rdbChina);
        rdbIslandia = findViewById(R.id.rdbIslandia);
        rdbLaos = findViewById(R.id.rdbLaos);
        rdbMadagascar = findViewById(R.id.rdbMadagascar);
        btnResponder3 = findViewById(R.id.btnResponder3);

        it = getIntent();
        nome = it.getStringExtra("nome");


        rdgQuiz3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbIslandia.isChecked() || rdbChina.isChecked() || rdbLaos.isChecked() || rdbMadagascar.isChecked()){
                    btnResponder3.setEnabled(true);
                }
                else{
                    btnResponder3.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);
    }
    public void responder3(View view){
        Intent it = new Intent(this, Quiz4.class);
        it.putExtra("nome", nome);
        if(rdbChina.isChecked()){
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