package org.artoolkit.ar.samples.ARSimple;

import android.util.Log;

import java.util.Vector;

/**
 * Created by Eros on 23/12/2016.
 */

public class SerieNote {
    Vector <Integer> notes; // liste contenant la suite de note que le joueur devra faire
    int niveau; // plus le niveau augmente plus il y aura de note à effectuer;
    int nbMarqueur ; // nombre de marqueur
    int nbNote; // nombre de note au niveau niveau
    public SerieNote(int nbMarqueur){
        this.nbMarqueur = nbMarqueur;
        this.niveau = 0;
        this.nbNote = 4;
        this.notes =  new Vector<Integer>();
        creerSerie();
    }

    public SerieNote(int niveau, int nbMarqueur){
        this.niveau = niveau;
        this.nbMarqueur = nbMarqueur;
        this.nbNote = 4 + niveau;
        this.notes =  new Vector<Integer>();
        creerSerie();
    }

    public void creerSerie(){
        for (int i = 0; i <  nbNote; i++){
            notes.add((int)(Math.random()*nbMarqueur - 1 )+1);
           // Log.i("notes", ""+notes.get(i));
        }
    }

    public Vector<Integer> getNotes(){
        return notes;
    }

    public void setNiveau(int niveau){

        this.niveau = niveau;
        this.nbNote = 4 + niveau;
        notes.clear();
        creerSerie();
    }
    public  int getNiveau(){
        return niveau;
    }


}
