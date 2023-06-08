package com.example.disasterprepfrontend;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityWaterView extends AppCompatActivity {

    public ActivityWaterView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_view);

        ModelDisaster receivedModel = (ModelDisaster) getIntent().getSerializableExtra("model");

        ImageView imgview = findViewById(R.id.imgview_act3);
        TextView name = findViewById(R.id.name_act3);
        TextView desc = findViewById(R.id.desc_act3);

        imgview.setImageResource(receivedModel.getImage());
        name.setText(receivedModel.getName());
        desc.setText(receivedModel.getPlan());
    }

}
