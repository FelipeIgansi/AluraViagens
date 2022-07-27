package com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.dao.PacoteDAO;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle("Lista Pacotes");
        ListView listaPacotes = findViewById(R.id.listaPacotes_listView);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}