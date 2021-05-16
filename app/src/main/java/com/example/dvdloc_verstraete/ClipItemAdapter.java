package com.example.dvdloc_verstraete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ClipItemAdapter extends ArrayAdapter<MusiqueItem> {

    public ClipItemAdapter(Context context, int textViewRessourceId)
    {
        super(context, textViewRessourceId);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View result = view;
        if(view == null){
            result = LayoutInflater.from(getContext()).inflate(R.layout.activity_video_view, parent, false);
        }
        MusiqueItem uneMusique = getItem(position);

        TextView titre = result.findViewById(R.id.Titre_Musique);
        titre.setText(uneMusique.getTitre());

        TextView auteur = result.findViewById(R.id.Auteur_Musique);
        auteur.setText(uneMusique.getAuteur());

        return result;
    }
    public void updateData(){this.notifyDataSetChanged();}

}
