package com.example.disasterprepfrontend;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Integer> geologicalImages = new ArrayList<>();
        geologicalImages.add(R.drawable.landslide);
        geologicalImages.add(R.drawable.avalanches);
        geologicalImages.add(R.drawable.earthquake);
        geologicalImages.add(R.drawable.sinkhole);
        geologicalImages.add(R.drawable.volcanic);

        List<String> geologicalNames = new ArrayList<>();
        geologicalNames.add("Landslide");
        geologicalNames.add("Avalanche");
        geologicalNames.add("Earthquake");
        geologicalNames.add("Sinkhole");
        geologicalNames.add("Volcanic Eruption");

        List<String> geologicalDesc = new ArrayList<>();
        geologicalDesc.add("Geological Hazard - The sudden movement of rock, debris, or earth down a slope, often triggered by heavy rainfall, seismic activity, or human actions.\n");
        geologicalDesc.add("Geological Hazard - Large masses of snow or ice rapidly sliding down a mountainside, often triggered by weather conditions, slope steepness, or human activities like skiing.\n");
        geologicalDesc.add("Geological Hazard - Sudden shaking or trembling of the ground caused by the release of energy in the Earth's crust, usually resulting from tectonic plate movements.\n");
        geologicalDesc.add("Geological Hazard - Depressions or cavities in the ground caused by the collapse of surface materials into underground voids, often resulting from factors such as dissolved rocks, water level changes, or human activities.d");
        geologicalDesc.add("Geological Hazard - Explosive release of molten rock (magma), gases, and other materials from a volcano, often accompanied by ash clouds, lava flows, and volcanic gases.");

        List<ModelGeological> modelList = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            modelList.add(new ModelGeological(geologicalImages.get(i),geologicalNames.get(i),geologicalDesc.get(i)));
        }


        Button geoButton = findViewById(R.id.btn_geo);
        Button waterButton = findViewById(R.id.btn_water);
        Button weatherButton = findViewById(R.id.btn_weather);


        geoButton.setOnClickListener(v -> {
            FragmentGeological geoFrament = new FragmentGeological(modelList);
            FragmentTransaction trans  = getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.framelayout, geoFrament);
            trans.commit();

        });


    }
}