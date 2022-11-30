package com.example.marketplant_mobil.adaptadores;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marketplant_mobil.R;
import com.example.marketplant_mobil.modelos.Blog;

import java.util.List;

public class Adapter_Blog extends RecyclerView.Adapter<Adapter_Blog.ViewHolder> {

    private List<Blog> blogs;
    private Context context;
//https://paisajismodigital.com/blog/wp-content/uploads/2018/10/dahlia-1024x576.jpg

    private String url_blog="https://paisajismodigital.com/blog/wp-content/uploads/2018/10/dahlia-1024x576.jpg";
    public Adapter_Blog(List<Blog> blogs, Context context) {
        this.blogs = blogs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo_blog.setText(blogs.get(position).getTitulo());
        holder.des_Blog.setText(blogs.get(position).getDescripcion());
        Glide.with(context).load(url_blog).into(holder.img_blog);

    }

    @Override
    public int getItemCount() {
        return blogs.size()  ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_blog;
        private TextView des_Blog;
        private TextView titulo_blog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_blog=itemView.findViewById(R.id.imagen_blog);
            titulo_blog=itemView.findViewById(R.id.titulo_blog);
            des_Blog=itemView.findViewById(R.id.blog_descripcion);

        }
    }
}
