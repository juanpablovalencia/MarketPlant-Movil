package com.example.marketplant_mobil.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marketplant_mobil.R;
import com.example.marketplant_mobil.modelos.Producto;

import java.util.List;

public class Adapter_Producto extends RecyclerView.Adapter<Adapter_Producto.ViewHolder> {

private List<Producto> productos;
private Context context;
    private String URL_imagensemilla = "https://www.elmueble.com/medio/2020/09/09/menta-poleo-plantas-medicinales_0b8847ef_563x375.jpg";

    public Adapter_Producto(List<Producto> productos, Context context) {
        this.productos = productos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txt_nombre.setText(productos.get(position).getNombre());
        holder.txt_descripcion.setText(productos.get(position).getDescripcion());
        holder.txt_precio.setText(productos.get(position).getPrecio());

        Glide.with(context).load(URL_imagensemilla).into(holder.imgP);



    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgP;
        private TextView txt_descripcion;
        private TextView txt_nombre;
        private TextView txt_precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgP=itemView.findViewById(R.id.imagen_persona);
            txt_nombre=itemView.findViewById(R.id.titulo_persona);
            txt_descripcion=itemView.findViewById(R.id.descripcion);
            txt_precio=itemView.findViewById(R.id.precio);
        }
    }
}
