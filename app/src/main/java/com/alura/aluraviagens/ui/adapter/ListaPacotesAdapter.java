package com.alura.aluraviagens.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {
    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);
        TextView local = viewCriada.findViewById(R.id.txtLocal);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.imgItemPacote);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem()
                , "drawable", context.getPackageName());
        Drawable drawableImagemPacote = ResourcesCompat.getDrawable(resources, idDoDrawable, null);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.txtDias);
        String labelDias = "";
        int qtnDias = pacote.getDias();
        if (qtnDias >1){
            labelDias = qtnDias + " dias";
        }else {
            labelDias = qtnDias + " dia";
        }
        dias.setText(labelDias);

        BigDecimal precoDoPacote = pacote.getPreco();

        TextView preco = viewCriada.findViewById(R.id.txtPreco);
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));

        String moedaBrasileiraFormatada =
                formatoBrasileiro.format(precoDoPacote).replace("R$", "R$ ");
        preco.setText(moedaBrasileiraFormatada);

        return viewCriada;
    }
}
