package com.example.sps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity
{
    ImageView I1, I2;
    TextView sp1, sp2;
    Button bp1, bp2, btnList, btnDisconnect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseApp.initializeApp(Home.this);
        DatabaseReference database;

        database = FirebaseDatabase.getInstance("https://mini-projet-2023-ce50a-default-rtdb.firebaseio.com").getReference("Spots");

        I1 = findViewById(R.id.p1);
        I2 = findViewById(R.id.p2);

        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);

        bp1 = findViewById(R.id.btnp1);
        bp2 = findViewById(R.id.btnp2);

        btnList = findViewById(R.id.buttonAll);
        btnDisconnect = findViewById(R.id.disconnect);

        btnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toCarsActivity = new Intent(Home.this, Cars.class);
                startActivity(toCarsActivity);
            }
        });

        sp1.setText("Data 1 ");
        database.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    sp1.setText("Data 2 ");

                    String place1 = snapshot.child("Spot1").getValue(String.class);
                    sp1.setText("Data 3 ");

                    if (place1 != null)
                    {
                        sp2.setText("Data 4 ");
                        bp1.setText(place1);

                        if (place1.equals("Vide"))
                        {
                            bp1.setText(place1);
                            I1.setVisibility(View.INVISIBLE);
                            sp1.setText("Data 5");
                        }

                        if (place1.equals("Réservé"))
                        {
                            bp1.setText(place1);
                            I1.setVisibility(View.VISIBLE);
                            sp1.setText("Data 6 ");

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                sp1.setText("Data 7 ");

                Toast.makeText(Home.this, "No Data", Toast.LENGTH_LONG).show();
            }
        });

        sp1.setText("Data 8 ");

        database.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    {
                    String place2 = snapshot.child("Spot2").getValue(String.class);
                        if (place2 != null)
                        {
                            bp2.setText(place2);

                        if (place2.equals("Vide"))
                        {
                            bp2.setText(place2);
                            I2.setVisibility(View.INVISIBLE);
                        }

                        if (place2.equals("Réservé"))
                        {
                            bp2.setText(place2);
                            I2.setVisibility(View.VISIBLE);
                        }
                    }}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                //Toast.makeText(Home.this, "No Data", Toast.LENGTH_LONG).show();
            }
        });

        btnDisconnect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences settings = getSharedPreferences("sharedPref", MainActivity.MODE_PRIVATE);
                settings.edit().clear().apply();

                Intent toLoginActivity = new Intent(Home.this, MainActivity.class);
                startActivity(toLoginActivity);
                finish();
            }
        });
    }
}
