package br.com.digitalhouse.digitalhousefoodsapp.model;

import java.io.Serializable;
import java.util.List;

public class Cardapio implements Serializable {

    private int fotoPrato;
    private String nomePrato;
    private String descricaoPrato;

    public int getFotoPrato() {
        return fotoPrato;
    }

    public void setFotoPrato(int fotoPrato) {
        this.fotoPrato = fotoPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }
}
