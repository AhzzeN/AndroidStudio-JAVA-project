package com.example.dvdloc_verstraete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Recherche extends AppCompatActivity {
    private Button btnCherche;
    private EditText edtCherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher);
        edtCherche = findViewById(R.id.edtRecherche);
        btnCherche = findViewById(R.id.btnRecherche);

        btnCherche.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast toast = Toast.makeText(getApplicationContext(), edtCherche.getText(), Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent (Recherche.this, Rock.class);
                intent.putExtra("titre", edtCherche.getText().toString());
                startActivity(intent);
            }
        });

        final Button btnRetour = (Button) findViewById(R.id.btnRetourRecherche);
        btnRetour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Recherche.this);
                alertDialog.setTitle("Retour au menu");
                Intent intent = new Intent(Recherche.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
