package com.example.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.menu.bd.Dao;
import com.example.menu.models.Entidade;
import com.example.menu.models.Posto;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroPosto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroPosto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnSalvar;
    private EditText nome;
    private EditText endereco;
    private ListView lista;
    private List<Entidade> dados;
    private ArrayAdapter<String>  adapter;
    Dao dao;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroPosto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroPosto.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroPosto newInstance(String param1, String param2) {
        CadastroPosto fragment = new CadastroPosto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro_posto, container, false);
        btnSalvar=view.findViewById(R.id.bt_salvar);
         nome =(EditText) view.findViewById(R.id.id_nome_posto);
         endereco =(EditText) view.findViewById(R.id.id_endereco_posto);
        lista = view.findViewById(R.id.id_list_posto);
        dao = new Dao(view.getContext());

        atualizar();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPosto(v);
            }
        });

        return view;
    }
    private void atualizar() {
        try {
            dados =dao.getDados(Posto.class,null,null);
            if(adapter==null) {
                adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, dados);
                lista.setAdapter(adapter);
            }else
             adapter.notifyDataSetChanged();


        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public void salvarPosto(View view){
        Posto posto = new Posto();
        posto.setNome(nome.getText().toString());
        posto.setEndereco(endereco.getText().toString());
        dao.insere(posto);
        atualizar();
    }
}