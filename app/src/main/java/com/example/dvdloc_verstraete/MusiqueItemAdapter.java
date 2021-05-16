package com.example.dvdloc_verstraete;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MusiqueItemAdapter extends ArrayAdapter<MusiqueItem> {

    public MusiqueItemAdapter(Context context, int textViewRessourceId)
    {
        super(context, textViewRessourceId);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View result = view;
        if(view == null){
            result = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);
        }
        MusiqueItem uneMusique = getItem(position);

        TextView titre = result.findViewById(R.id.item_titre);
        titre.setText(uneMusique.getTitre());

        TextView auteur = result.findViewById(R.id.item_auteur);
        auteur.setText(uneMusique.getAuteur());

        TextView album = result.findViewById(R.id.item_Album);
        album.setText(uneMusique.getAlbum());

        ImageView itemImageView = result.findViewById(R.id.item_icon);
        itemImageView.setImageResource(uneMusique.getImage());

        return result;
    }
    public void updateData(){this.notifyDataSetChanged();}

}
