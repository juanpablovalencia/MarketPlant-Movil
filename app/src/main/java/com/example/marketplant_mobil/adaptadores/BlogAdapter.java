package com.example.marketplant_mobil.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marketplant_mobil.BlogActivity;
import com.example.marketplant_mobil.R;
import com.example.marketplant_mobil.modelos.Blog;

import java.util.List;



    public class BlogAdapter extends ArrayAdapter<Blog> {


        private Context context;
        private List<Blog> blogs;

        public BlogAdapter(@NonNull Context context, int resource, @NonNull List<Blog> objects) {
            super(context, resource, objects);

            this.context = context;
            this.blogs = objects;
        }

        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = layoutInflater.inflate(R.layout.content_main2, parent, false);


            TextView txtidBlog = (TextView) rowView.findViewById(R.id.IdBlog);
            TextView txtTitulo = (TextView) rowView.findViewById(R.id.Titulo);
            ;
            TextView txtDescripcion = (TextView) rowView.findViewById(R.id.Descripcion);
            ;

            txtidBlog.setText(String.format("ID:%d", blogs.get(position).getId()));
            txtTitulo.setText(String.format("TITULOS:%s", blogs.get(position).getTitulo()));
            txtDescripcion.setText(String.format("DESCRIPCION: %s", blogs.get(position).getDescripcion()));

            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BlogActivity.class);
                    intent.putExtra("ID", String.valueOf(blogs.get(position).getId()));
                    intent.putExtra("TITULO", blogs.get(position).getTitulo());
                    intent.putExtra("DESCRIPCION", blogs.get(position).getDescripcion());
                    context.startActivity(intent);
                }
            });
            return rowView;


        }
    }


