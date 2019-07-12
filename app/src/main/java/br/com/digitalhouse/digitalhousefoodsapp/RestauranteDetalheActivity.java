package br.com.digitalhouse.digitalhousefoodsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoodsapp.adapter.DetalheAdapter;
import br.com.digitalhouse.digitalhousefoodsapp.interfaces.CardapioListener;
import br.com.digitalhouse.digitalhousefoodsapp.model.Cardapio;
import br.com.digitalhouse.digitalhousefoodsapp.model.Restaurante;

public class RestauranteDetalheActivity extends AppCompatActivity implements CardapioListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_detalhe);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Restaurante restaurante = (Restaurante) bundle.getSerializable("RESTAURANTE");

        ImageView fotoRestaurante = findViewById(R.id.foto_restaurante_image_view);
        fotoRestaurante.setImageResource(restaurante.getFoto());

        TextView nomeRestaurante = findViewById(R.id.nome_restaurante_text_view);
        nomeRestaurante.setText(restaurante.getNomeRestaurante());




        List<Cardapio> cardapiolist = new ArrayList<>();

        Cardapio cardapio = new Cardapio();
        cardapio.setNomePrato("Salada com molho de gengibre");
        cardapiolist.add(cardapio);

        Cardapio cardapio1 = new Cardapio();
        cardapio1.setNomePrato("Salada com molho de gengibre");
        cardapiolist.add(cardapio1);

        Cardapio cardapio2 = new Cardapio();
        cardapio2.setNomePrato("Salada com molho de gengibre");
        cardapiolist.add(cardapio2);

        Cardapio cardapio3 = new Cardapio();
        cardapio3.setNomePrato("Salada com molho de gengibre");
        cardapiolist.add(cardapio3);


        DetalheAdapter detalheAdapter = new DetalheAdapter(cardapiolist, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        RecyclerView recyclerView = findViewById(R.id.detalhe_restaurante_recyclerview);
        recyclerView.setAdapter(detalheAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onPratoClicado(Cardapio cardapio) {
        Intent intent = new Intent(this, ReceitaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("CARDAPIO", cardapio);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
