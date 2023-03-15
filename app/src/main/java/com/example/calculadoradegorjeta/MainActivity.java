package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textViewPorcentagem;
    private TextView textViewGorjeta;
    private TextView textViewTotalGorjeta;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editTextValor);
        textViewPorcentagem = findViewById(R.id.textViewGorjeta);
        textViewGorjeta = findViewById(R.id.textViewPorcentagem);
        textViewTotalGorjeta = findViewById(R.id.textViewTotalGorjeta);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textViewPorcentagem.setText(Math.round(porcentagem) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calcular() {
        String valorRecuperado = editTextValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG).show();

        } else {
            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            textViewGorjeta.setText("R$ " + Math.round(gorjeta));
            textViewTotalGorjeta.setText("R$ " + total);


        }
    }
}