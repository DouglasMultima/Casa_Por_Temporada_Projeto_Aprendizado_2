package com.example.casaportemporada.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.casaportemporada.R;
import com.example.casaportemporada.model.Anuncio;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAnuncios extends RecyclerView.Adapter<AdapterAnuncios.MyViewHolder> {

    private List<Anuncio> anuncioList;
    private onClick onClick;

    public AdapterAnuncios(List<Anuncio> anuncioList, AdapterAnuncios.onClick onClick) {
        this.anuncioList = anuncioList;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anuncio,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Anuncio anuncio = anuncioList.get(position);


        Picasso.get().load(anuncio.getUrlImagem()).into(holder.img_anuncio);
        holder.text_titulo.setText(anuncio.getTitulo());
        holder.text_descricao.setText(anuncio.getDescricao());
        holder.text_data.setText("");


        holder.itemView.setOnClickListener(view -> onClick.onClickListener(anuncio));



    }

    @Override
    public int getItemCount() {
        return anuncioList.size();
    }


    public interface onClick {

        public void onClickListener(Anuncio anuncio);

    }

    static class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView img_anuncio;
        TextView text_titulo, text_descricao, text_data;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_anuncio = itemView.findViewById(R.id.img_anuncio);
            text_titulo = itemView.findViewById(R.id.text_titulo_anuncio);
            text_descricao = itemView.findViewById(R.id.text_descricao);
            text_data = itemView.findViewById(R.id.text_data);

        }
    }

}
