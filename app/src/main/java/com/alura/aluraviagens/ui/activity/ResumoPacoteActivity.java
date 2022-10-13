package com.alura.aluraviagens.ui.activity;

import static com.alura.aluraviagens.util.DataUtil.formataPeriodoExibido;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.util.DiasUtil;
import com.alura.aluraviagens.util.MoedaUtil;
import com.alura.aluraviagens.util.ResourcesUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_PACOTE = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_PACOTE);

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraDias(pacote);
            mostraPreco(pacote);
            mostraData(pacote);

            Button btnRealizaPagamento = findViewById(R.id.resumoPacote_btnPagar);
            btnRealizaPagamento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }




    }

    private void mostraData(@NonNull Pacote pacote) {
        TextView data = findViewById(R.id.resumoPacote_txtDataPacote);
        String dataFormatadaViagem = formataPeriodoExibido(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void mostraPreco(@NonNull Pacote pacote) {
        TextView preco = findViewById(R.id.resumoPacote_txtPreco);
        String moedaBrasileira = MoedaUtil.formataPara_MoedaReal(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(@NonNull Pacote pacote) {
        TextView dias = findViewById(R.id.resumoPacote_txtDiasPacote);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(@NonNull Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumoPacote_imgLocalPacote);
        Drawable drawable = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(@NonNull Pacote pacote) {
        TextView local = findViewById(R.id.resumoPacote_txtLocalPacote);
        local.setText(pacote.getLocal());
    }
}