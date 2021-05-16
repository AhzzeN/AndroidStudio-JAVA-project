package com.example.dvdloc_verstraete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Pop extends AppCompatActivity {

    String url ="http://192.168.0.10/volley_serv/listemusique.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        ListView listeMusiques = (ListView) findViewById(R.id.Pop_listview);
        final MusiqueItemAdapter musiqueItemAdapter = new MusiqueItemAdapter(this, R.layout.adapter_item);

        final RequestQueue requestQueue = Volley.newRequestQueue (getApplicationContext());
        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.POST,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count < response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                MusiqueItem musique = new MusiqueItem();
                                musique.setTitre(jsonObject.getString("Titre"));
                                musique.setAuteur(jsonObject.getString("nom_Auteur"));
                                musique.setAlbum(jsonObject.getString("Album"));
                                musique.setCat(jsonObject.getString("libelle"));
                                String path = getPackageName() + ":drawable/" + jsonObject.getString("Img");
                                int resID = getResources().getIdentifier(path, null, null);
                                musique.setImage(resID);
                                Log.i("genre", musique.getCat());
                                if(musique.getCat().equals("POP")){
                                    musiqueItemAdapter.add(musique);
                                }


                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Une erreur est survenue", Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });
        requestQueue.add(arrayRequest);
        listeMusiques.setAdapter(musiqueItemAdapter);

        final Button btnRetourMenuPop = (Button) findViewById(R.id.btnRetourMenuPop);
        btnRetourMenuPop.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Pop.this);
                alertDialog.setTitle("Retour au menu");
                Intent intent = new Intent(Pop.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}