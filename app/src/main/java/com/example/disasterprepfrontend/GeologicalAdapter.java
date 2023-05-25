package com.example.disasterprepfrontend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GeologicalAdapter extends RecyclerView.Adapter {

    List<Integer> images;
    List<String> nameList;
    List<String> descList;

    public GeologicalAdapter(List<Integer> list, List<String> nameList, List<String> descList){
        images = list;
        this.nameList = nameList;
        this.descList = descList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.geological_row, parent, false);
        MyViewHolder holder = new MyViewHolder(root);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgview;
        TextView name;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgview = itemView.findViewById(R.id.geo_row_img);
            name = itemView.findViewById(R.id.geo_row_name);
            description = itemView.findViewById(R.id.geo_row_desc);
        }

        public void bindData(int image, String myname, String desc) {
            imgview.setImageResource(image);
            name.setText(myname);
            description.setText(desc);
        }
    }



}
