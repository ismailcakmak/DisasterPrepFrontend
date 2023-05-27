package com.example.disasterprepfrontend;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterGeological extends RecyclerView.Adapter<AdapterGeological.MyViewHolder> {

    List<ModelGeological> modelList;
    AdapterGeologicalListener listener;
    Context context;



    interface AdapterGeologicalListener{
        public void clicked(ModelGeological model);
    }

    public AdapterGeological(Context context, List<ModelGeological> modelList) {
        this.modelList = modelList;
        this.context = context;

        listener = new AdapterGeologicalListener() {
            @Override
            public void clicked(ModelGeological model) {

                Intent i = new Intent(context, ActivityGeoView.class);
                i.putExtra("model", model);
                context.startActivity(i);

            }
        };
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.geological_row, parent, false);
        MyViewHolder holder = new MyViewHolder(root);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.description.setText(modelList.get(position).getDesc());
        holder.imgview.setImageResource(modelList.get(position).getImage());
        holder.name.setText(modelList.get(position).getName());

        holder.root.setOnClickListener(v->{
            listener.clicked(modelList.get(position));
        });
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout root;
        ImageView imgview;
        TextView name;
        TextView description;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            root = itemView.findViewById(R.id.geo_row_lyt);
            imgview = itemView.findViewById(R.id.geo_row_img);
            name = itemView.findViewById(R.id.geo_row_name);
            description = itemView.findViewById(R.id.geo_row_desc);
        }
    }



}
