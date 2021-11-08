package com.example.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.bd.AdapterPadrao;
import com.example.menu.bd.Dao;
import com.example.menu.models.Posto;
import com.example.menu.models.Veiculo;

import java.util.List;

public class CadastroVeiculo extends Fragment {

    private EditText descricao;
    private EditText placa;
    private EditText cor;
    private EditText km;
    private Button btnSalvar;
    private RecyclerView recyclerView;
    private List dados;
    private AdapterPadrao adapterPadrao;
    private Dao dao;
    private LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_veiculo, container, false);

        descricao = view.findViewById(R.id.id_nome_veiculo);
        placa = view.findViewById(R.id.id_placa_veiculo);
        cor = view.findViewById(R.id.id_cor_veiculo);
        km = view.findViewById(R.id.id_km_veiculo);
        btnSalvar=view.findViewById(R.id.btn_salvar_veiculo);
        recyclerView=view.findViewById(R.id.id_recycle);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        dao= new Dao(getContext());
        atualiza();
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        return view ;
    }

    private void atualiza(){
        try {
            dados =dao.getDados(Veiculo.class,null,null);
            if(adapterPadrao==null) {
                adapterPadrao= new AdapterPadrao(dados,R.layout.linha_veiculo);
                recyclerView.setAdapter(adapterPadrao);
            }else
                adapterPadrao.notifyDataSetChanged();

        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    private void salvar(){
        Veiculo v = new Veiculo();
        v.setCor(cor.getText().toString());
        v.setDescricao(descricao.getText().toString());
        v.setPlaca(placa.getText().toString());
        v.setKmAtual(km.getText().toString());
        dao.insere(v);
    }
}
