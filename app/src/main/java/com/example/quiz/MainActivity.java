package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciar, btnSair;
    private EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnSair = findViewById(R.id.btnSair);
        edtNome = findViewById(R.id.edtNome);

        edtNome.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (edtNome.getText().length() > 0) {
                    btnIniciar.setEnabled(true);
                }
                else {
                    btnIniciar.setEnabled(false);
                }
                return false;
            }
        });
    }

    public void iniciar (View view){
        Intent it  = new Intent (this, Quiz1.class);
        it.putExtra("nome", edtNome.getText().toString());
        startActivity(it);
    }

    public void sair (View view){

        finish();
    }
}
