package com.example.dvdloc_verstraete;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String lemail =this.getIntent().getStringExtra("mail");
        TextView textView = (TextView) findViewById(R.id.email_user);
        textView.setText("Bonjour " + lemail);

        //textView.setText();
        //---------------------------------------------------------------------
        // Gestion du bouton BtnRock associé à la ressource btnRock
        //---------------------------------------------------------------------
        final Button btnRock = (Button) findViewById(R.id.btnRock);
        //Utilisation d'un listerner (interface de gestion d'évènement) pour récupérer  l'interaction avec le bouton
        btnRock.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Rock");
                alertDialog.setMessage("Voulez-vous choisir le rock? ");
                //confirmation : oui
                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogueInterface, int i) {
                        Toast toast = Toast.makeText(getApplicationContext(), btnRock.getText(), Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent = new Intent(MainActivity.this, Rock.class);
                        startActivity(intent);
                    }
                });
                //confirmation : non
                alertDialog.setNegativeButton("non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //rien
                    }
                });
                alertDialog.show();
            }
        });
        //---------------------------------------------------------------------
        final Button btnPop = (Button) findViewById(R.id.btnPop);
        btnPop.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Pop");
                alertDialog.setMessage("Voulez-vous choisir la Pop? ");
                //confirmation : oui
                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogueInterface, int i) {
                        Toast toast = Toast.makeText(getApplicationContext(), btnPop.getText(),Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent = new Intent(MainActivity.this, Pop.class);
                        startActivity(intent);
                    }
                 });
                //confirmation : non
                alertDialog.setNegativeButton("non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //rien
                    }
                });
                alertDialog.show();
            }
        });
        //---------------------------------------------------------------------
        final Button btnReggae = (Button) findViewById(R.id.btnReggae);
        btnReggae.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Reggae");
                alertDialog.setMessage("Voulez-vous choisir le Reggae? ");
                //confirmation : oui
                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogueInterface, int i) {
                        Toast toast = Toast.makeText(getApplicationContext(), btnReggae.getText(),Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent = new Intent(MainActivity.this, Reggae.class);
                        startActivity(intent);
                     }
                 });
                //confirmation : non
                alertDialog.setNegativeButton("non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //rien
                    }
                });
                alertDialog.show();
            }
        });
        //---------------------------------------------------------------------
        final Button btnRap = (Button) findViewById(R.id.btnRap);
        btnRap.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Rap");
                alertDialog.setMessage("Voulez-vous choisir le Rap? ");
                //confirmation : oui
                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogueInterface, int i) {
                        Toast toast = Toast.makeText(getApplicationContext(), btnRap.getText(),Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent = new Intent(MainActivity.this, Rap.class);
                        startActivity(intent);
                    }
                });
                //confirmation : non
                alertDialog.setNegativeButton("non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //rien
                    }
                });
                alertDialog.show();
            }
        });
    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu unMenu){
        //Gestion ouverture/fermeture du menugeneral (MenuInflater)
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugeneral, unMenu);
        return true;
    }

    //activation des menus et sous menus
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this, item.getTitle(),Toast.LENGTH_SHORT).show();
        switch (item.getItemId())
        {
            case R.id.menuRechercher:
                //TODO
                Intent intent2 = new Intent(MainActivity.this, Recherche.class);
                startActivityForResult(intent2, 2);
                return true;
            case R.id.menuRéserver:
                //TODO
                Intent intent = new Intent(MainActivity.this, Reservation.class);
                startActivityForResult(intent, 1);
                return true;
            case R.id.menuMagasins:
                //TODO
                return true;
            case R.id.menuPresentation:
                //TODO
                return true;
        }
        return true;
    }
    /**
     * Cette méthode est appelée quand un résultat parvient à l'activité
     * @param requestCode
     * @param resultCode
     * @param data
     */
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                switch (resultCode) {

                    case RESULT_OK:
                        Toast.makeText(MainActivity.this,
                                "Reservation confirmée",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_CANCELED:
                        Toast.makeText(MainActivity.this,
                                "Reservation annulée",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    String titre = data.getStringExtra("titre");
                    Toast.makeText(MainActivity.this,
                            titre,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return;
    }
}



