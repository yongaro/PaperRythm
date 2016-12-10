package org.artoolkit.ar.samples.ARSimple;

import android.media.MediaPlayer;

import org.artoolkit.ar.samples.R;

import java.net.URI;
import java.util.Vector;

/**
 * Created by quentin on 02/12/16.
 */

public class DicoSon {
    static int samplesByProfil = 2;
    static int nbProfile = 2;
    static boolean isInitialized = false;

    static Vector<Integer> soundBank;

    public static void initialize () {
        soundBank = new Vector<Integer>();
        soundBank.add(R.raw.marker1);
        soundBank.add(R.raw.marker2);
        soundBank.add(R.raw.monson);
        soundBank.add(R.raw.monson);
        isInitialized = true;
    }

    public static Vector<Integer> getProfile(int profileId) {
        if (!isInitialized) {
            initialize();
        }
        Vector<Integer> soundSample = new Vector<Integer>();
        for (int i = 0; i < samplesByProfil; ++i) {
            soundSample.add(soundBank.get((profileId % nbProfile) + i));
        }
        return soundSample;
    }


}
