package br.com.digitalhouse.digitalhousefoodsapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousefoodsapp.R;
import br.com.digitalhouse.digitalhousefoodsapp.interfaces.RestauranteListener;
import br.com.digitalhouse.digitalhousefoodsapp.model.Restaurante;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private List<Restaurante> listaRestaurantes;
    private RestauranteListener restauranteListener;

    public RestauranteAdapter(List<Restaurante> listaRestaurantes, RestauranteListener restauranteListener) {
        this.listaRestaurantes = listaRestaurantes;
        this.restauranteListener = restauranteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurante_celula, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Restaurante restaurante = listaRestaurantes.get(i);
        viewHolder.setupRestaurante(restaurante);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restauranteListener.onRestauranteClicado(listaRestaurantes.get(i));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoImageView;
        private TextView nomeTextView;
        private TextView enderecoTextView;
        private TextView funcionamentoTextView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoImageView = itemView.findViewById(R.id.foto_image_view);
            nomeTextView = itemView.findViewById(R.id.nome_text_view);
            enderecoTextView = itemView.findViewById(R.id.endereco_text_view);
            funcionamentoTextView = itemView.findViewById(R.id.funcionamento_text_view);
        }


        public void setupRestaurante(Restaurante restaurante) {
            fotoImageView.setImageResource(restaurante.getFoto());
            nomeTextView.setText(restaurante.getNomeRestaurante());
            enderecoTextView.setText(restaurante.getEndereco());
            funcionamentoTextView.setText(restaurante.getFuncionamento());
        }
    }


}
