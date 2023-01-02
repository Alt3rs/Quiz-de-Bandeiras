package com.example.quiz;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz2 extends AppCompatActivity {
    private Button btnResponder2;
    private RadioGroup rdgQuiz2;
    private RadioButton rdbUSA, rdbAustralia, rdbDinamarca, rdbJapao;
    private int ponto;
    private String nome;
    private Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        btnResponder2 = findViewById(R.id.btnResponder2);
        rdgQuiz2 = findViewById(R.id.rdgQuiz2);
        rdbAustralia = findViewById(R.id.rdbAutralia);
        rdbDinamarca = findViewById(R.id.rdbDinamarca);
        rdbJapao = findViewById(R.id.rdbJapao);
        rdbUSA = findViewById(R.id.rdbUSA);

        it = getIntent();
        nome = it.getStringExtra("nome");

        rdgQuiz2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbAustralia.isChecked() || rdbDinamarca.isChecked() || rdbJapao.isChecked() || rdbUSA.isChecked()){
                    btnResponder2.setEnabled(true);
                }
                else{
                    btnResponder2.setEnabled(false);
                }
            }
        });

        ponto = getIntent().getIntExtra("cont",0);


    }

    public void responder2 (View view){
        Intent it = new Intent(this, Quiz3.class);
        it.putExtra("nome", nome);
        if(rdbUSA.isChecked()){
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