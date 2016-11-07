package br.usjt.arqdsis.clientep2.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.usjt.arqdsis.clientep2.R;
import br.usjt.arqdsis.clientep2.model.Cliente;
import br.usjt.arqdsis.clientep2.model.ClienteAdapter;
import br.usjt.arqdsis.clientep2.model.Data;

public class ListaClientesActivity extends AppCompatActivity {

    public static final String NOME = "br.usjt.arqdesis.clientep2.nome";
    public static final String EMAIL = "br.usjt.arqdesis.clientep2.email";
    public static final String FONE = "br.usjt.arqdesis.clientep2.fone";
    Activity atividade;
    Cliente[] lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        atividade = this;
        setContentView(R.layout.activity_lista_clientes);
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = Data.buscaClientes(chave);

        BaseAdapter adapter = new ClienteAdapter(this, lista);
        ListView listView = (ListView)findViewById(R.id.Lista_clientes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheClienteActivity.class);
                intent.putExtra(NOME, lista[position].getNome());
                intent.putExtra(FONE, lista[position].getFone());
                intent.putExtra(EMAIL, lista[position].getEmail());

                startActivity(intent);

            }

        });
    }
}
