package com.example.ac1lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextQuantidadeSimples, textQuantidadeCalabresa, textQuantidadeEspecial, editQuantidadeBatata,
            textQuantidadeChips, editQuantidadeOnion, textQuantidadeRefrigerante, textQuantidadeSuco, textQuantidadeAgua;
    TextView textTotal;
    Button buttonTotal, buttonLimparPedido;

    float precoSimples = 10.00f, precoCalabresa = 15.00f, precoEspecial = 20.00f, precoBatata = 10.00f,
            precoOnion = 15.00f, precoChips = 6.00f, precoRefrigerante = 5.00f, precoSuco = 10.00f, precoAgua = 4.00f;

    @Override
    protected void onCreate(Bundle savedImstanceState) {
        super.onCreate(savedImstanceState);
        setContentView(R.layout.activity_main);

        editTextTextQuantidadeSimples = findViewById(R.id.editTextTextQuantidadeSimples);
        textQuantidadeCalabresa = findViewById(R.id.textQuantidadeCalabresa);
        textQuantidadeEspecial = findViewById(R.id.textQuantidadeEspecial);
        editQuantidadeBatata = findViewById(R.id.editQuantidadeBatata);
        textQuantidadeChips = findViewById(R.id.textQuantidadeChips);
        editQuantidadeOnion = findViewById(R.id.editQuantidadeOnion);
        textQuantidadeRefrigerante = findViewById(R.id.textQuantidadeRefrigerante);
        textQuantidadeSuco = findViewById(R.id.textQuantidadeSuco);
        textQuantidadeAgua = findViewById(R.id.textQuantidadeAgua);

        buttonTotal = findViewById(R.id.buttonTotal);
        buttonLimparPedido = findViewById(R.id.buttonLimparPedido);
        textTotal = findViewById(R.id.textTotal);

        buttonTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculoTotal();
            }
        });

        buttonLimparPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparPedido();
            }
        });
    }

    private void calculoTotal() {
        try {
            int simples = parseInputValue(editTextTextQuantidadeSimples.getText().toString());
            int calabresa = parseInputValue(textQuantidadeCalabresa.getText().toString());
            int especialLanche = parseInputValue(textQuantidadeEspecial.getText().toString());
            int batata = parseInputValue(editQuantidadeBatata.getText().toString());
            int chips = parseInputValue(textQuantidadeChips.getText().toString());
            int onion = parseInputValue(editQuantidadeOnion.getText().toString());
            int refrigerante = parseInputValue(textQuantidadeRefrigerante.getText().toString());
            int suco = parseInputValue(textQuantidadeSuco.getText().toString());
            int agua = parseInputValue(textQuantidadeAgua.getText().toString());

            double total = simples * precoSimples + calabresa * precoCalabresa + especialLanche * precoEspecial
                    + batata * precoBatata + chips * precoChips + onion * precoOnion + refrigerante * precoRefrigerante
                    + suco * precoSuco + agua * precoAgua;

            textTotal.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void limparPedido() {
        editTextTextQuantidadeSimples.setText("");
        textQuantidadeCalabresa.setText("");
        textQuantidadeEspecial.setText("");
        editQuantidadeBatata.setText("");
        textQuantidadeChips.setText("");
        editQuantidadeOnion.setText("");
        textQuantidadeRefrigerante.setText("");
        textQuantidadeSuco.setText("");
        textQuantidadeAgua.setText("");
        textTotal.setText(String.valueOf("Total: "));
    }

    private int parseInputValue(String string) {
        if (string.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(string);
        }
    }

}