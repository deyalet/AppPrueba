package com.example.appprueba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Revistas> revistas;

    public Adapter(Context ctx, List<Revistas> revistas){
        this.inflater = LayoutInflater.from(ctx);
        this.revistas = revistas;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.publicaciones_list_layout,parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.revistaAnio.setText(revistas.get(position).getAnio());
        holder.revistaTitulo.setText(revistas.get(position).getTitulo());
        holder.revistaDoi.setText(revistas.get(position).getDoi());
        Picasso.get().load(revistas.get(position).getCover()).into(holder.revistaCover);

    }

    @Override
    public int getItemCount() {
        return revistas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView revistaIsseu, revistaVolumen, revistaNumero, revistaAnio, revistaFecha, revistaTitulo, revistaDoi;
        ImageView revistaCover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            revistaAnio = itemView.findViewById(R.id.txtAnio);
            revistaTitulo = itemView.findViewById(R.id.txtTitulo);
            revistaDoi = itemView.findViewById(R.id.txtDoi);
            revistaCover = itemView.findViewById(R.id.imagen);
        }
    }
}
