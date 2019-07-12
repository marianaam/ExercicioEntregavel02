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
import br.com.digitalhouse.digitalhousefoodsapp.interfaces.CardapioListener;
import br.com.digitalhouse.digitalhousefoodsapp.model.Cardapio;

public class DetalheAdapter extends RecyclerView.Adapter<DetalheAdapter.ViewHolder> {


    private TextView nome;
    private List<Cardapio> cardapioList;
    private CardapioListener cardapioListener;



    public DetalheAdapter(List<Cardapio> cardapioList, CardapioListener cardapioListener) {
        this.cardapioList = cardapioList;
        this.cardapioListener = cardapioListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detalhe_restaurante_celula, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Cardapio cardapio = cardapioList.get(i);

        viewHolder.setupCardapio(cardapio);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardapioListener.onPratoClicado(cardapio);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardapioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoPratoImageView;
        private TextView nomePratoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoPratoImageView = itemView.findViewById(R.id.foto_prato_image_view);
            nomePratoTextView = itemView.findViewById(R.id.nome_prato_text_view);
        }

        public void setupCardapio(Cardapio cardapio) {
            nomePratoTextView.setText(cardapio.getNomePrato());
        }
    }
}
