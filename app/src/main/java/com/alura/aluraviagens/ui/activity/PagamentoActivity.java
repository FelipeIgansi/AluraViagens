package com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        mostraPreco(pacoteSP);


        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_TxtPreco);
        String moedaReal = MoedaUtil.formataPara_MoedaReal(pacote.getPreco());
        preco.setText(moedaReal);
    }
}