package com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.util.DiasUtil;
import com.alura.aluraviagens.util.MoedaUtil;
import com.alura.aluraviagens.util.ResourcesUtil;

import java.math.BigDecimal;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        TextView local = findViewById(R.id.resumoPacote_btnPagar);
        local.setText(pacoteSP.getLocal());

        ImageView imagem = findViewById(R.id.resumoPacote_imgLocalPacote);
        Drawable drawable = ResourcesUtil.devolveDrawable(this, pacoteSP.getImagem());
        imagem.setImageDrawable(drawable);

        TextView dias = findViewById(R.id.resumoPacote_txtDiasPacote);
        String diasEmTexto = DiasUtil.formataEmTexto(pacoteSP.getDias());
        dias.setText(diasEmTexto);

        TextView preco = findViewById(R.id.resumoPacote_txtPreco);
        String moedaBrasileira = MoedaUtil.formataPara_MoedaReal(pacoteSP.getPreco());
        preco.setText(moedaBrasileira);


    }
}