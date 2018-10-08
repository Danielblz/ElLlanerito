package com.example.danielbustamante.elllanerito;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LlaneroAdapter extends RecyclerView.Adapter<LlaneroAdapter.LlaneroViewHolder>
        implements View.OnClickListener {

    private ArrayList<Llanerito> llanero;
    private View.OnClickListener listener;

    public LlaneroAdapter(ArrayList<Llanerito> llanero) {
        this.llanero   = llanero;
    }

    @NonNull
    @Override
    public LlaneroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list, parent,false);
        itemView.setOnClickListener(this);
        return new LlaneroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LlaneroViewHolder holder, int position) {
        Llanerito llanerito = llanero.get(position);
        holder.bindLlanero(llanerito);
    }

    @Override

    public int getItemCount() { return  llanero.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener=listener;

    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);

        }

    }

    public class LlaneroViewHolder extends RecyclerView.ViewHolder{
        private TextView tNombre;
        public LlaneroViewHolder(View itemView) {
            super(itemView);
            tNombre = itemView.findViewById(R.id.tNombre);

        }


        public void bindLlanero(Llanerito llanerito) {

            tNombre.setText("" + llanerito.getNombre());
        }
    }
}
