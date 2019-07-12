package br.com.digitalhouse.digitalhousefoodsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoodsapp.adapter.RestauranteAdapter;
import br.com.digitalhouse.digitalhousefoodsapp.interfaces.RestauranteListener;
import br.com.digitalhouse.digitalhousefoodsapp.model.Restaurante;

public class MainActivity extends AppCompatActivity implements RestauranteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Restaurante> listaRestaurantes = new ArrayList<>();

        Restaurante restaurante = new Restaurante();
        restaurante.setFoto(R.drawable.foto_restaurante);
        restaurante.setNomeRestaurante("Tony Roma's");
        restaurante.setEndereco("Avenida Lavandisca, 171 - Indianapólis, São Paulo");
        restaurante.setFuncionamento("Fecha às 22:00");
        listaRestaurantes.add(restaurante);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setFoto(R.drawable.foto_cardapio);
        restaurante1.setNomeRestaurante("Aoyama - Moema");
        restaurante1.setEndereco("Alameda dos Arapanés, 532 - Moema, São Paulo");
        restaurante1.setFuncionamento("Fecha às 00:00");
        listaRestaurantes.add(restaurante1);

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setFoto(R.drawable.foto_outback);
        restaurante2.setNomeRestaurante("Outback Moema");
        restaurante2.setEndereco("Avenida Moaci, 187 - Moema, São Paulo");
        restaurante2.setFuncionamento("Fecha às 00:00");
        listaRestaurantes.add(restaurante2);

        Restaurante restaurante3 = new Restaurante();
        restaurante3.setFoto(R.drawable.foto_si_senor);
        restaurante3.setNomeRestaurante("Sí Señor!");
        restaurante3.setEndereco("Alameda Jauaperi, 626 - Moema, São Paulo");
        restaurante3.setFuncionamento("Fecha às 01:00");
        listaRestaurantes.add(restaurante3);

        RestauranteAdapter restauranteAdapter = new RestauranteAdapter(listaRestaurantes, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.restaurante_recycler_view);
        recyclerView.setAdapter(restauranteAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onRestauranteClicado(Restaurante restaurante) {

        Intent intent = new Intent(this, RestauranteDetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESTAURANTE", restaurante);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem menuItem = menu.add(0, 0, 0, "Profile");
        menuItem.setShowAsAction(menuItem.SHOW_AS_ACTION_NEVER);

        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
        }
        return true;


    }
}

