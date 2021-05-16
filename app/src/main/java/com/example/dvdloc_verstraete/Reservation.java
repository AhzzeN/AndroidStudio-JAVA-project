package com.example.dvdloc_verstraete;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {
    private Button btnOK;
    private Button btnAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        btnOK = findViewById(R.id.btnConfirmer);
        btnOK.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view)
            {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        btnAnnuler = findViewById(R.id.btnAnnuler);
        btnAnnuler.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view)
            {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });


        final Button btnRetour = (Button) findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Reservation.this);
                alertDialog.setTitle("Retour au menu");
                Intent intent = new Intent(Reservation.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}