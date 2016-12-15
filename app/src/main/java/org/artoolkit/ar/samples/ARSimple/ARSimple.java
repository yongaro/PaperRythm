/*
 *  ARSimple.java
 *  ARToolKit5
 *
 *  Disclaimer: IMPORTANT:  This Daqri software is supplied to you by Daqri
 *  LLC ("Daqri") in consideration of your agreement to the following
 *  terms, and your use, installation, modification or redistribution of
 *  this Daqri software constitutes acceptance of these terms.  If you do
 *  not agree with these terms, please do not use, install, modify or
 *  redistribute this Daqri software.
 *
 *  In consideration of your agreement to abide by the following terms, and
 *  subject to these terms, Daqri grants you a personal, non-exclusive
 *  license, under Daqri's copyrights in this original Daqri software (the
 *  "Daqri Software"), to use, reproduce, modify and redistribute the Daqri
 *  Software, with or without modifications, in source and/or binary forms;
 *  provided that if you redistribute the Daqri Software in its entirety and
 *  without modifications, you must retain this notice and the following
 *  text and disclaimers in all such redistributions of the Daqri Software.
 *  Neither the name, trademarks, service marks or logos of Daqri LLC may
 *  be used to endorse or promote products derived from the Daqri Software
 *  without specific prior written permission from Daqri.  Except as
 *  expressly stated in this notice, no other rights or licenses, express or
 *  implied, are granted by Daqri herein, including but not limited to any
 *  patent rights that may be infringed by your derivative works or by other
 *  works in which the Daqri Software may be incorporated.
 *
 *  The Daqri Software is provided by Daqri on an "AS IS" basis.  DAQRI
 *  MAKES NO WARRANTIES, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION
 *  THE IMPLIED WARRANTIES OF NON-INFRINGEMENT, MERCHANTABILITY AND FITNESS
 *  FOR A PARTICULAR PURPOSE, REGARDING THE DAQRI SOFTWARE OR ITS USE AND
 *  OPERATION ALONE OR IN COMBINATION WITH YOUR PRODUCTS.
 *
 *  IN NO EVENT SHALL DAQRI BE LIABLE FOR ANY SPECIAL, INDIRECT, INCIDENTAL
 *  OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 *  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 *  INTERRUPTION) ARISING IN ANY WAY OUT OF THE USE, REPRODUCTION,
 *  MODIFICATION AND/OR DISTRIBUTION OF THE DAQRI SOFTWARE, HOWEVER CAUSED
 *  AND WHETHER UNDER THEORY OF CONTRACT, TORT (INCLUDING NEGLIGENCE),
 *  STRICT LIABILITY OR OTHERWISE, EVEN IF DAQRI HAS BEEN ADVISED OF THE
 *  POSSIBILITY OF SUCH DAMAGE.
 *
 *  Copyright 2015 Daqri, LLC.
 *  Copyright 2011-2015 ARToolworks, Inc.
 *
 *  Author(s): Julian Looser, Philip Lamb
 *
 */

package org.artoolkit.ar.samples.ARSimple;

import org.artoolkit.ar.base.ARActivity;
import org.artoolkit.ar.base.rendering.ARRenderer;
import org.artoolkit.ar.samples.R;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;


/**
 * A very simple example of extending ARActivity to create a new AR application.
 */
public class ARSimple extends ARActivity {


	private static final int MY_PERMISSIONS_REQUEST_CAMERA = 133;
	/**
     * A custom renderer is used to produce a new visual experience.
     */
    private SimpleRenderer simpleRenderer = new SimpleRenderer();

    /**
     * The FrameLayout where the AR view is displayed.
     */
    private FrameLayout mainLayout;
	boolean loaded = false;
	int explosionId;

	// Obligé de les jouer depuis une Activity
	static MediaPlayer m1, m2, m3, m4, m5, m6, m7, m8, m9, m0;
	static CountDownTimer t1, t2, t3, t4, t5, t6, t7, t8, t9, t0;

	private static void pause(MediaPlayer media, CountDownTimer timer) {
		if (media != null) {
			if (media.isPlaying()) {
				/*
				if (timer != null) {
					timer.cancel();
					timer = null;
				}
				*/
				media.pause();
			} else {
				Log.w("MediaPlayer : ", " l'instance n'est pas en mode lecture");
			}
		} else {
			Log.w("MediaPlayer : ", " l'instance n'a pas été initialisée");
		}
	}

	public static void pauseM0() {
		pause(m0, t0);
	}

	public static void pauseM1() {
		pause(m1, t1);
	}

	public static void pauseM2() {
		pause(m2, t2);
	}

	public static void pauseM3() {
		pause(m3, t3);
	}

	public static void pauseM4() {
		pause(m4, t4);
	}

	public static void pauseM5() {
		pause(m5, t5);
	}

	public static void pauseM6() {
		pause(m6, t6);
	}

	public static void pauseM7() {
		pause(m7, t7);
	}

	public static void pauseM8() {
		pause(m8, t8);
	}

	public static void pauseM9() {
		pause(m9, t9);
	}


	private static void play(final MediaPlayer media, CountDownTimer timer) {

		if (media != null) {
			media.start();

			/*t1 = new CountDownTimer(30000, 1000) {
				@Override
				public void onTick(long l) {
					//Toast.makeText(app, "seconds remaining: " + l / 1000, Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onFinish() {
					//media.start();
				}
			}.start();
*/
			//timer = app.new MyTimer(30000, 1000);
		} else {
			Log.w("MediaPlayer : ", " l'instance n'a pas été initialisée");
		}
	}

	public static void playM0() {
		play(m0, t0);
	}

	public static void playM1() {
		play(m1, t1);
	}

	public static void playM2() {
		play(m2, t2);
	}

	public static void playM3() {
		play(m3, t3);
	}

	public static void playM4() {
		play(m4, t4);
	}

	public static void playM5() {
		play(m5, t5);
	}

	public static void playM6() {
		play(m6, t6);
	}

	public static void playM7() {
		play(m7, t7);
	}

	public static void playM8() {
		play(m8, t8);
	}

	public static void playM9() {
		play(m9, t9);
	}

	static ARSimple app;
	int profile = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);      
		setContentView(R.layout.main);
		m0 = MediaPlayer.create(this, R.raw.monson);
		m1 = MediaPlayer.create(this, R.raw.marker1);
		m2 = MediaPlayer.create(this, R.raw.marker2);
		m3 = MediaPlayer.create(this, R.raw.grelot);

		simpleRenderer.bindPlayers(m1, m2);
		mainLayout = (FrameLayout)this.findViewById(R.id.mainLayout);

		if (!checkCameraPermission()) {
			//if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) { //ASK EVERY TIME - it's essential!
			ActivityCompat.requestPermissions(this,
					new String[]{Manifest.permission.CAMERA},
					MY_PERMISSIONS_REQUEST_CAMERA);
		}

		 app = this;

		// When the screen is tapped, inform the renderer and vibrate the phone
		mainLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                simpleRenderer.click(m1);
				Vector<Integer> newSound = DicoSon.getProfile(++profile);
				for (int i = 0; i < newSound.size(); ++i) {

					m0.stop();
					m1.stop();
					m2.stop();
					m3.stop();

					m0.reset();
					m1.reset();
					m2.reset();
					m3.reset();

					m1 = MediaPlayer.create(app, newSound.get(0));
					m2 = MediaPlayer.create(app, newSound.get(1));
					m0 = MediaPlayer.create(app, newSound.get(2));
					m3 = MediaPlayer.create(app, newSound.get(3));
				}

				Toast.makeText(app, "Profil :" + Integer.toString((profile % 4) + 1), Toast.LENGTH_SHORT).show();
				Log.i("Profil :", Integer.toString((profile % 4) + 1));

				/*

				setVolumeControlStream(AudioManager.STREAM_MUSIC);
				SoundPool soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);

				AssetManager assetManager = getAssets();

				AssetFileDescriptor descriptor=null;
				try {
					descriptor = assetManager.openFd("raw/monson.ogg");

					explosionId = soundPool.load(descriptor, 1);

					soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
						public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
							loaded = true;
							soundPool.play(explosionId, 1, 1, 0, 0, 1);
						}
					});

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/




				Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(40);
            }

        });
	}

	/**
	 * Provide our own SimpleRenderer.
	 */
	@Override
	protected ARRenderer supplyRenderer() {
		if (!checkCameraPermission()) {
			Toast.makeText(this, "No camera permission - restart the app", Toast.LENGTH_LONG).show();
			return null;
		}

		return new SimpleRenderer();
	}
	
	/**
	 * Use the FrameLayout in this Activity's UI.
	 */
	@Override
	protected FrameLayout supplyFrameLayout() {
		return (FrameLayout)this.findViewById(R.id.mainLayout);    	
	}

	private boolean checkCameraPermission() {
		return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
		switch (requestCode) {
			case MY_PERMISSIONS_REQUEST_CAMERA: {
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
					Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
				return;
			}
		}
	}

	public class MyTimer extends CountDownTimer {
		public MyTimer(long millisInFuture, long countDownInterval) {

			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
			Looper.prepare();
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
		}

		@Override
		public void onTick(long millisUntilFinished) {
			// TODO Auto-generated method stub
		}

	}
}