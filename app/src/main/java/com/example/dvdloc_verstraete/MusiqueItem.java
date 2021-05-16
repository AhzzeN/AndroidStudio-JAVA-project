package com.example.dvdloc_verstraete;

import android.media.Image;

public class MusiqueItem {

    private String Cat;
    private String Titre;
    private String Auteur;
    private String Album;
    private String Lien;
    private int Image = 0;

    // Constructeur
    public MusiqueItem(){}

    //mutateur
    public void setCat(String Cat){this.Cat = Cat;}
    public void setTitre(String Titre){this.Titre = Titre;}
    public void setAuteur(String Auteur){this.Auteur = Auteur;}
    public void setImage(int Image){this.Image = Image;}
    public void setLien(String Lien){this.Lien = Lien;}
    public void setAlbum(String Album){this.Album = Album;}

    //méthode
    public String getCat(){ return this.Cat;}
    public String getTitre(){ return this.Titre;}
    public String getAuteur(){ return this.Auteur;}
    public String getAlbum(){ return this.Album;}
    public String getLien(){ return this.Lien;}
    public int getImage(){return this.Image;}
}
