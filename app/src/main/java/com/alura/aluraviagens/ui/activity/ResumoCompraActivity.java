package com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.util.DataUtil;
import com.alura.aluraviagens.util.MoedaUtil;
import com.alura.aluraviagens.util.ResourcesUtil;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraData(pacote);
            mostraPreco(pacote);
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumoCompra_PrecoPacote);
        String moedaBrasileira = MoedaUtil.formataPara_MoedaReal(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumoCompra_DataViagem);
        String periodoEmTexto = DataUtil.formataPeriodoExibido(pacote.getDias());
        data.setText((periodoEmTexto));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumoCompra_imgPacote);
        Drawable drawableImagem = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableImagem);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumoCompra_LocalPacote);
        local.setText(pacote.getLocal());
    }
}