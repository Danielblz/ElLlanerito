package com.example.danielbustamante.elllanerito;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private LlaneroAdapter  llaneroAdapter;

    ArrayList<Llanerito> listaLlanero;



    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        listaLlanero=new ArrayList<>();
        recyclerView= view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        LlenarLista();

        llaneroAdapter = new LlaneroAdapter(listaLlanero);
        recyclerView.setAdapter(llaneroAdapter);
        llaneroAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /*Toast.makeText(getContext(), "Seleccionò: "+ listaLlanero.get(recyclerView.getChildAdapterPosition(view)).getNombre(),
                        Toast.LENGTH_SHORT).show();
                        */
                String nombre= listaLlanero.get(recyclerView.getChildAdapterPosition(view)).getNombre().toString();
                Intent intent =new Intent(getContext().getApplicationContext(), DetalleActivity.class);
                intent.putExtra("Nombre", nombre);
            startActivity(intent);


            }
        });
        return  view;
    }

    private void LlenarLista() {
        listaLlanero.add(new Llanerito("Llanerito Copacabana"));
        listaLlanero.add(new Llanerito("Llanerito Pilarica"));
        listaLlanero.add(new Llanerito("Llanerito Centro"));
        listaLlanero.add(new Llanerito("Llanerito los Colores"));
        listaLlanero.add(new Llanerito("Llanerito Sabaneta"));

    }


}
