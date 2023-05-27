package com.example.disasterprepfrontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityGeoView extends AppCompatActivity {

    public ActivityGeoView() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_view);

        ModelGeological receivedModel = (ModelGeological) getIntent().getSerializableExtra("model");

        ImageView imgview = findViewById(R.id.imgview_act2);
        TextView name = findViewById(R.id.name_act2);
        TextView desc = findViewById(R.id.desc_act2);

        imgview.setImageResource(receivedModel.getImage());
        name.setText(receivedModel.getName());
        desc.setText(receivedModel.getDesc());

    }
}