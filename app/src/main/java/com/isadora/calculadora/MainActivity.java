package com.isadora.calculadora;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText notaB1;
    private EditText notaB2;
    private TextView mediaNota;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notaB1 = findViewById(R.id.edtNota1);
        notaB2 = findViewById(R.id.edtNota2);
        mediaNota = findViewById(R.id.txtMedia);
        status = findViewById(R.id.txtStatus);

    }

    private float getMedia() {

        float nota1 = Float.parseFloat(notaB1.getText().toString());
        float nota2 = Float.parseFloat(notaB2.getText().toString());
        float media = ((nota1 + nota2) / 2);

        return media;
    }

    private boolean validacao() {
        if (notaB1.getText().toString().trim().equals("") || notaB2.getText().toString().trim().equals("")) {

            Toast.makeText(getApplicationContext(), "Não pode conter campo vazio", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public void media(View view) {
        if (validacao()) {
            return;
        }
        float media = getMedia();

        String sMedia = "Media: " + media;
        mediaNota.setText(sMedia);

        if (media >= 6) {
            status.setTextColor(getColor(R.color.blue));
            status.setText("Aprovado");
        } else {
            status.setTextColor(getColor(R.color.red));
            status.setText("Reprovado");
        }
    }

    public void sair(View view) {
        finish();
    }
}