package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Collections;
import java.util.List;

public class Cars extends AppCompatActivity
{
    RecyclerView recyclerViewVoiture;
    VoitureAdapter  VoitureAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        recyclerViewVoiture = findViewById(R.id.voitures);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewVoiture.setLayoutManager(layoutManager);


        List<Voiture> listeVoiture = VoitureContent.getVoitures();
        Collections.sort(listeVoiture);
        VoitureAdapter = new VoitureAdapter(this ,listeVoiture);
        recyclerViewVoiture.setAdapter(VoitureAdapter);


    }
}