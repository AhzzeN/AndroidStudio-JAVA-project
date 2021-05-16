package com.example.dvdloc_verstraete;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import dao.C;

public class register extends AppCompatActivity {
    private EditText edt_Email;
    private EditText edt_pswd;
    private EditText edt_pswd_verif;
    private Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt_Email = (EditText) findViewById(R.id.crea_Email);
        edt_pswd = (EditText) findViewById(R.id.crea_pswd);
        edt_pswd_verif = (EditText) findViewById(R.id.crea_pswd_verif);
        final Button btn_ok = (Button) findViewById(R.id.btn_ok_register);
        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = edt_Email.getText().toString();
                String pswd = edt_pswd.getText().toString();
                String pswd_verif = edt_pswd_verif.getText().toString();
                Log.i("pswd", pswd);
                Log.i("pswd_verif", pswd_verif);
                if ( pswd_verif.equals(pswd)){
                    registerUser();
                }else{
                    Toast.makeText(getApplicationContext(),"Erreur mot de passe",Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView tel = (TextView) findViewById (R.id.txt_redirection_vers_Login);

        // Permet de souligner le texte
        SpannableString content = new SpannableString ("Déjà inscrit ? clique içi !");
        content.setSpan (new UnderlineSpan(), 0, content.length (), 0);
        tel.setText (content);

        // Permet de mettre le texte en bleu 
        tel.setTextColor (Color.BLUE);

        // Permet de mettre le texte en gras
        tel.setTypeface (null, Typeface.BOLD);

        // Definit l'action lors du clic
        tel.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick (View arg0)
            {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(register.this);
                alertDialog.setTitle("Connexion");
                alertDialog.setMessage("Avez vous déjà un compte? ");
                //confirmation : oui
                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogueInterface, int i) {
                        Intent intent = new Intent(register.this, Login.class);
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
    public void registerUser()
    {
        final String email = edt_Email.getText().toString().trim();
        final String pswd = edt_pswd.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                C.Register_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            Log.i("test ajout", response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                parms.put("email", email);
                parms.put("password", pswd);
                return parms;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}