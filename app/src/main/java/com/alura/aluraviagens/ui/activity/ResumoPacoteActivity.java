package com.alura.aluraviagens.ui.activity;

import static com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;
import static com.alura.aluraviagens.util.DataUtil.formataPeriodoExibido;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.util.DiasUtil;
import com.alura.aluraviagens.util.MoedaUtil;
import com.alura.aluraviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_PACOTE = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_PACOTE);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button btnRealizaPagamento = findViewById(R.id.resumoPacote_btnPagar);
        btnRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviaParaPagamento(pacote);
            }
        });
    }

    private void enviaParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
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