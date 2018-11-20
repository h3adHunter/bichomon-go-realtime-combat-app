package com.unq.epers.bichomon_go_realtime_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.unq.epers.bichomon_go_realtime_app.R;
import com.unq.epers.bichomon_go_realtime_app.model.Combate;

import java.util.List;

public class CombatesAdapter extends RecyclerView.Adapter<CombatesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Combate> listaCombates;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView retador, oponente;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            retador = (TextView) view.findViewById(R.id.lb_retador);
            oponente = (TextView) view.findViewById(R.id.lb_oponente);
        }
    }


    public CombatesAdapter(Context mContext, List<Combate> listaCombates) {
        this.mContext = mContext;
        this.listaCombates = listaCombates;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.combate_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Combate combate = listaCombates.get(position);
        holder.retador.setText(combate.getRetador());
        holder.oponente.setText(combate.getOponente());
    }

    @Override
    public int getItemCount() {
        return listaCombates.size();
    }
}
