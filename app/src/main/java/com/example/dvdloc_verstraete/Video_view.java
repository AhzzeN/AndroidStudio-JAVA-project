 package com.example.dvdloc_verstraete;

import androidx.appcompat.app.AppCompatActivity;
import com.example.dvdloc_verstraete.VideoAdapter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.*;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;

import java.util.ArrayList;
import java.util.List;

public class Video_view extends YouTubeBaseActivity{

    static final String TAG = "Video_view";

    Button btnPlay;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String lelien =this.getIntent().getStringExtra("Lien");
        String lauteur =this.getIntent().getStringExtra("Auteur");
        String letitre =this.getIntent().getStringExtra("Titre");



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        TextView Titre = (TextView) findViewById(R.id.Titre_Musique);
        TextView Auteur = (TextView) findViewById(R.id.Auteur_Musique);
        Titre.setText(letitre);
        Auteur.setText(lauteur);
        Log.d(TAG, "onCreate : Starting.");
        btnPlay = (Button) findViewById(R.id.btnPlay);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick : Done.");
                youTubePlayer.loadVideo(lelien);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick : Failed initialising.");
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick : Initialising Youtube Player.");
                youTubePlayerView.initialize(VideoAdapter.getApiKey(), onInitializedListener);
            }
        });
    }
}