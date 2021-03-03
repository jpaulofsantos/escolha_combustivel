package com.example.escolhacombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool;
    private TextInputEditText editGasolina;
    private TextView textResulatdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcoolCampo);
        editGasolina = findViewById(R.id.editGasolinaCampo);
        textResulatdo = findViewById(R.id.textResultado);

    }

    public void calculaResultado(View view) {
        String valorAlcool = editAlcool.getText().toString();
        String valorGasolina = editGasolina.getText().toString();
        Boolean result = verificaCampos(valorAlcool, valorGasolina);

        if (result ) {
            Double calculo = Double.parseDouble(valorAlcool) / Double.parseDouble(valorGasolina);
            if (calculo >= 0.7) {
                textResulatdo.setText("Abasteça com GASOLINA!");
            } else {
                textResulatdo.setText("Abasteça com ÁLCOOL!");
            }
        }else {
            textResulatdo.setText("Preencha todos os campos para realizar o cálculo!");
        }

    }

    public boolean verificaCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;

        } else if ((pGasolina == null || pGasolina.equals(""))) {
            camposValidados = false;
        }

        return camposValidados;
    }
}
