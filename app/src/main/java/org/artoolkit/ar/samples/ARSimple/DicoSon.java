package org.artoolkit.ar.samples.ARSimple;

import android.media.MediaPlayer;

import org.artoolkit.ar.samples.R;

import java.net.URI;
import java.util.Vector;

/**
 * Created by quentin on 02/12/16.
 */

public class DicoSon {
    static int samplesByProfil = 4;
    static int nbProfile = 4;
    static boolean isInitialized = false;

    static Vector<Vector<Integer>> soundBank;

    public static void initialize () {
        soundBank = new Vector<Vector<Integer>>();

        // Paramètrage du Profil 0 :
        Vector<Integer> profil0 = new Vector<Integer>();
        profil0.add(R.raw.marker1);
        profil0.add(R.raw.rire);
        profil0.add(R.raw.bass1);
        profil0.add(R.raw.cythare);
        soundBank.add(profil0);


        // Paramètrage du Profil 1 :
        Vector<Integer> profil1 = new Vector<Integer>();
        profil1.add(R.raw.zic2);
        profil1.add(R.raw.triangle);
        profil1.add(R.raw.caisseclaire);
        profil1.add(R.raw.bass1);
        soundBank.add(profil1);

        // Paramètrage du Profil 2 :
        Vector<Integer> profil2 = new Vector<Integer>();
        profil2.add(R.raw.zic1);
        profil2.add(R.raw.clap);
        profil2.add(R.raw.triangle);
        profil2.add(R.raw.grelot);
        soundBank.add(profil2);

        // Paramètrage du Profil 3 :
        Vector<Integer> profil3 = new Vector<Integer>();
        profil3.add(R.raw.melody);
        profil3.add(R.raw.bass1);
        profil3.add(R.raw.triangle);
        profil3.add(R.raw.grossecaisse);
        soundBank.add(profil3);


        isInitialized = true;
    }

    public static Vector<Integer> getProfile(int profileId) {
        if (!isInitialized) {
            initialize();
        }
        Vector<Integer> soundSample = new Vector<Integer>();
        for (int i = 0; i < samplesByProfil; ++i) {
            soundSample.add((soundBank.get((profileId % nbProfile)).get(i)));
        }
        return soundSample;
    }


}
