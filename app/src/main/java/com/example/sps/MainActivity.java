package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView CreerAc;
    EditText LoginUser, PassUser;
    Button SeConnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreerAc = findViewById(R.id.CreerCompte);
        LoginUser = findViewById(R.id.userlogin);
        PassUser = findViewById(R.id.userpass);
        SeConnecter = findViewById(R.id.Loginbtn);

        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);

        String UserSp = pref.getString("User", "");
        String Passwordsp = pref.getString("Password", "");

        SeConnecter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if ((LoginUser.getText().toString().equals("SPS")) && (PassUser.getText().toString().equals("123")))
                {
                    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();

                    editor.putString("User", LoginUser.getText().toString());
                    editor.putString("Password", PassUser.getText().toString());

                    editor.commit();

                    Intent toHomeAct = new Intent(MainActivity.this, Home.class);
                    startActivity(toHomeAct);
                    finish();

                    Toast.makeText(MainActivity.this, "Bienvenue " + LoginUser.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Merci de vérifier vos données  . . .", Toast.LENGTH_SHORT).show();
                }

                if ((LoginUser.getText().toString().isEmpty()) && (PassUser.getText().toString().isEmpty()))
                {
                    Toast.makeText(MainActivity.this, "Merci de Remplir toutes les Champs . . . ", Toast.LENGTH_SHORT).show();
                    LoginUser.setError("Champ Vide");
                    PassUser.setError("Champ Vide");
                }

            }
        });


        CreerAc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toCreateAct = new Intent(MainActivity.this, CreerCompte.class);
                startActivityIfNeeded(toCreateAct,10);
            }
        });
    }

        protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 10) 
            {
                if (resultCode == RESULT_OK) 
                {
                    String Login_data = data.getStringExtra("Login_user");
                    String Password_data = data.getStringExtra("Pass_user");

                    LoginUser.setText(Login_data);
                    PassUser.setText(Password_data);
                }
            }
        }
    }