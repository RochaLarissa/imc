package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularImc(View view) {

        ImageView img;
        EditText edtPeso, edtAltura;
        TextView txtResultado, txtLabel;

        img = findViewById(R.id.edtImage);
        edtPeso = findViewById(R.id.editPeso);
        edtAltura = findViewById(R.id.editAltura);
        txtResultado = findViewById(R.id.txtResult);
        txtLabel = findViewById(R.id.txtLabelIMC);

        double peso = 0;
        double altura = 0;
        try {
            peso = Double.parseDouble(edtPeso.getText().toString());
        } catch (Exception e) {
            edtPeso.setError("Inválido");
        }

        try {
            altura = Double.parseDouble(edtAltura.getText().toString());
        } catch (Exception e) {
            edtAltura.setError("Inválido");
        }

        if (peso != 0 && altura != 0) {
            double imc = peso / (altura * altura);
            if (imc < 18.5) {
                txtLabel.setText("Seu índice de massa corporal é:");
                txtResultado.setText("Baixo Peso");
                img.setImageResource(R.drawable.baixo_peso);
            } else if (imc < 25) {
                txtLabel.setText("Seu índice de massa corporal é:");
                txtResultado.setText("Peso Normal");
                img.setImageResource(R.drawable.normal);
            } else if (imc < 30) {
                txtLabel.setText("Seu índice de massa corporal é:");
                txtResultado.setText("Sobrepeso");
                img.setImageResource(R.drawable.sobrepeso);
            } else if (imc < 35) {
                txtLabel.setText("Seu índice de massa corporal é:");
                txtResultado.setText("Obesidade Grau I");
                img.setImageResource(R.drawable.obesidade_1);
            } else if (imc < 40) {
                txtLabel.setText("Seu índice de massa corporal é:");
                txtResultado.setText("Obesidade Grau II");
                img.setImageResource(R.drawable.obesidade_2);
            } else {
                txtLabel.setText("Seu índice de massa corporal é:");
                txtResultado.setText("Obesidade Grau III");
                img.setImageResource(R.drawable.obesidade_2);
            }
        }


    }
}