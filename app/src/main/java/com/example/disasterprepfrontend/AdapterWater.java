package com.example.disasterprepfrontend;

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

public class AdapterWater extends RecyclerView.Adapter<AdapterWater.MyViewHolder> {

    List<ModelDisaster> modelList;
    AdapterWater.AdapteWaterListener listener;
    Context context;


    interface AdapteWaterListener{
        public void clicked(ModelDisaster model);
    }


    AdapterWater(Context context, List<ModelDisaster> modelList) {
        this.modelList = modelList;
        this.context = context;

        listener = new AdapteWaterListener() {
            @Override
            public void clicked(ModelDisaster model) {
                Intent i = new Intent(context, ActivityWaterView.class);
                i.putExtra("model", model);
                context.startActivity(i);
            }
        };

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.water_row, parent, false);
        MyViewHolder holder = new MyViewHolder(root);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.description.setText(modelList.get(position).getName());
        holder.imgview.setImageResource(modelList.get(position).getImage());
        holder.name.setText(modelList.get(position).getDesc());

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

            root = itemView.findViewById(R.id.water_row_lyt);
            imgview = itemView.findViewById(R.id.water_row_img);
            name = itemView.findViewById(R.id.water_row_name);
            description = itemView.findViewById(R.id.water_row_desc);
        }
    }

}
