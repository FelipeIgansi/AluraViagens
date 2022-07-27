package com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alura.aluraviagens.R;
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
        TextView local = viewCriada.findViewById(R.id.txtLocal);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.imgItemPacote);
        // Para poder usar a imagem primeiro precisa do resources
        Resources resources = context.getResources();
        // A partir do resources terá acesso a imagem passando como parametro: nome,
        // local onde elá está localizada e o package onde está armazenado
        int idDrawable = resources.getIdentifier(pacote.getImagem(),
                "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.txtDias);
        dias.setText(pacote.getDias()+" dias");

        TextView preco = viewCriada.findViewById(R.id.txtPreco);
        preco.setText(pacote.getPreco().toString());

        return viewCriada;
    }
}
