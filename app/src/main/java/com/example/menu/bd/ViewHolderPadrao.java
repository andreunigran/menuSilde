package com.example.menu.bd;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.models.Entidade;

public class ViewHolderPadrao extends RecyclerView.ViewHolder {
    private TextView nome;
    public ViewHolderPadrao(@NonNull View itemView) {
        super(itemView);
        nome=itemView.findViewById(R.id.id_linhha_nome);
    }
    public void preencheItens(Entidade e){
        nome.setText(e.getId().toString()+"1");
    }
}