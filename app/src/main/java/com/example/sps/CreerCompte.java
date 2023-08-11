package com.example.sps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreerCompte extends AppCompatActivity
{
    EditText User,Pass;
    TextView log;
    Button create;

    public final String usr_login = "Login_user";
    public final String pass_login = "Pass_user";

    final static String TAG = "AccountCreationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);

        create = findViewById(R.id.creerac);
        create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToMainActivity();
            }
        });

        log = findViewById(R.id.connect);
        log.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                 Intent toLoginAct = new Intent(CreerCompte.this,MainActivity.class);
                 startActivity(toLoginAct);
            }
        });

    }

    private void goToMainActivity()
    {
        User = findViewById(R.id.creerlogin);
        Pass = findViewById(R.id.creerpass);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("usr_login", User.getText().toString());
        resultIntent.putExtra("pass_login", Pass.getText().toString());

        setResult(RESULT_OK,resultIntent);
        finish();
    }
}
