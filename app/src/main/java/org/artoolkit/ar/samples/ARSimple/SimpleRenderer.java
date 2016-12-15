/*
 *  SimpleRenderer.java
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

import android.media.MediaPlayer;
import android.renderscript.Matrix4f;
import android.util.Log;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import org.artoolkit.ar.base.ARToolKit;
import org.artoolkit.ar.base.rendering.ARRenderer;
import org.artoolkit.ar.base.rendering.Cube;
import org.artoolkit.ar.samples.R;

import java.io.Console;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Vector;

/**
 * A very simple Renderer that adds a marker and draws a cube on it.
 */
public class SimpleRenderer extends ARRenderer {
	private ARToolKit arToolKit = ARToolKit.getInstance();

	private int markerID = -1;
	private int markerID2 = -1;
	private int markerID3 = -1;
	private int markerID4 = -1;
	private int markerID5 = -1;

	MediaPlayer m1 = null;
	MediaPlayer m2 = null;
	private Cube cube1 = new Cube(40.0f, 0.0f, 0.0f, 20.0f);
	private Cube cube2 = new Cube(40.0f, 0.0f, 0.0f, 20.0f);
	private Cube cube3 = new Cube(40.0f, 0.0f, 0.0f, 20.0f);
	private Cube cube4 = new Cube(40.0f, 0.0f, 0.0f, 20.0f);
	private Cube cube5 = new Cube(40.0f, 0.0f, 0.0f, 20.0f);

	private float angle = 0.0f;
	private boolean spinning = false;
	private Vector<Integer> markers;

	public void bindPlayers(MediaPlayer m1, MediaPlayer m2) {
		this.m1 = m1;
		this.m2 = m2;
	}
	@Override
	public boolean configureARScene() {

		markerID2 = arToolKit.addMarker("single;Data/sample1.patt;80");
		markerID = arToolKit.addMarker("single;Data/sample2.patt;80");
		markerID3 = arToolKit.addMarker("single;Data/patt.hiro;80");
		markerID4 = arToolKit.addMarker("single;Data/patt.kanji;80");
		//markerID5 = arToolKit.addMarker("single;Data/patt.hiro;40");

		//markers.add(arToolKit.addMarker("single;Data/patt.kanji;80"));
		//markers.add(arToolKit.addMarker("single;Data/patt.hiro;80"));
		//markerID = arToolKit.addMarker("single;Data/patt.hiro;80");
		//if (markerID < 0) return false;

		/*markers.add(ARToolKit.getInstance().addMarker("single;Data/multi/a.patt"));
		markers.add(ARToolKit.getInstance().addMarker("single;Data/multi/patt.b"));
		markers.add(ARToolKit.getInstance().addMarker("single;Data/multi/patt.c"));
		markers.add(ARToolKit.getInstance().addMarker("single;Data/multi/patt.d"));
		markers.add(ARToolKit.getInstance().addMarker("single;Data/multi/patt.g"));
		markers.add(ARToolKit.getInstance().addMarker("single;Data/multi/patt.f"));
		*/

		return true;

	}

	public void click(MediaPlayer m) {
		//m.start();
		Log.i("aa", "click click pouet pouet");
		spinning = !spinning;
	}

	public void draw(GL10 gl) {

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadMatrixf(arToolKit.getProjectionMatrix(), 0);

		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glFrontFace(GL10.GL_CW);

		gl.glMatrixMode(GL10.GL_MODELVIEW);

		if (arToolKit.queryMarkerVisible(markerID)) {
			Log.i("sample1", "sample1");
			gl.glLoadMatrixf(arToolKit.queryMarkerTransformation(markerID), 0);
			float[] transform = arToolKit.queryMarkerTransformation(markerID);


			//for (int i = 0; i < transform.length; ++i) {

			Log.i("x", String.valueOf(transform[3]));
			Log.i("y", String.valueOf(transform[9]));
			Log.i("z", String.valueOf(transform[12]));
			//}

			gl.glPushMatrix();
			gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			cube1.draw(gl);
			gl.glPopMatrix();

			if (spinning) angle += 5.0f;
			ARSimple.pauseM2();
		} else {
			ARSimple.playM2();
		}

		if (arToolKit.queryMarkerVisible(markerID2)) {
			float[] transform2 = arToolKit.queryMarkerTransformation(markerID2);
			Log.i("sample2 ", "sample2");

			//for (int i = 0; i < transform.length; ++i) {

			Log.i("x2", String.valueOf(transform2[3]));
			Log.i("y2", String.valueOf(transform2[9]));
			Log.i("z2", String.valueOf(transform2[12]));
			gl.glLoadMatrixf(arToolKit.queryMarkerTransformation(markerID2), 0);

			gl.glPushMatrix();
			gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			cube2.draw(gl);
			gl.glPopMatrix();

			ARSimple.pauseM1();
			if (spinning) angle += 5.0f;
		} else {
			ARSimple.playM1();
		}

		if (arToolKit.queryMarkerVisible(markerID3)) {
			Log.i("hiro", "hiro");
			gl.glLoadMatrixf(arToolKit.queryMarkerTransformation(markerID3), 0);


			gl.glPushMatrix();
			gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			cube3.draw(gl);
			gl.glPopMatrix();

			if (spinning) angle += 5.0f;
			ARSimple.pauseM0();
		} else {
			ARSimple.playM0();
		}

		if (arToolKit.queryMarkerVisible(markerID4)) {

			gl.glLoadMatrixf(arToolKit.queryMarkerTransformation(markerID4), 0);

			gl.glPushMatrix();
			gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			cube4.draw(gl);
			gl.glPopMatrix();

			if (spinning) angle += 5.0f;
			ARSimple.pauseM3();
		} else {
			ARSimple.playM3();
		}
/*
		if (arToolKit.queryMarkerVisible(markerID5)) {

			gl.glLoadMatrixf(arToolKit.queryMarkerTransformation(markerID4), 0);

			gl.glPushMatrix();
			gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
			cube5.draw(gl);
			gl.glPopMatrix();

			if (spinning) angle += 5.0f;
			ARSimple.pauseM1();
		} else {
			ARSimple.playM1();
		}

		/*
		for (int i = 0; i < markers.size() -1; ++i) {
			if (arToolKit.queryMarkerVisible(markers.get(i).intValue())) {

				gl.glLoadMatrixf(arToolKit.queryMarkerTransformation(markers.get(i).intValue()), 0);

				gl.glPushMatrix();
				gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
				cube.draw(gl);
				gl.glPopMatrix();

				if (spinning) angle += 5.0f;
			}
			/*
			if (arToolKit.queryMarkerVisible(markers.elementAt(i))) {

				gl.glLoadMatrixf(arToolKit.queryMarkerTransformation(markers.elementAt(i)), 0);

				gl.glPushMatrix();
				gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
				cube.draw(gl);
				gl.glPopMatrix();

				if (spinning) angle += 5.0f;
			}*/
		//}


	}
}