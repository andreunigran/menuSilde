package com.example.menu.bd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.models.Entidade;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterPadrao extends RecyclerView.Adapter<ViewHolderPadrao> {
    List dados;
    int linhasXML;
    public AdapterPadrao(List dados, int linhasXML){
        this.dados=dados;
        this.linhasXML=linhasXML;
    }
    @NonNull
    @Override
    public ViewHolderPadrao onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(linhasXML,parent,false);
        return new ViewHolderPadrao(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPadrao holder, int position) {
        Entidade e= (Entidade) dados.get(position);
        holder.preencheItens(e);
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }


}
