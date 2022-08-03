package com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alura.aluraviagens.util.DiasUtil;
import com.alura.aluraviagens.util.MoedaUtil;
import com.alura.aluraviagens.R;
import com.alura.aluraviagens.util.ResourcesUtil;
import com.alura.aluraviagens.model.Pacote;

import java.util.List;

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

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.ItemPacote_txtPreco);
        String moedaBrasileiraFormatada = MoedaUtil.formataPara_MoedaReal(pacote.getPreco());
        preco.setText(moedaBrasileiraFormatada);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.ItemPacote_txtDias);
        String labelDias = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(labelDias);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.ItemPacote_img);
        Drawable drawableImagemPacote = ResourcesUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.ItemPacote_txtLocal);
        local.setText(pacote.getLocal());
    }
}
