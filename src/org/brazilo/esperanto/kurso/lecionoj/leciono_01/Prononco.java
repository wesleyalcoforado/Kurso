package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import java.io.IOException;

import org.brazilo.esperanto.kurso.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class Prononco extends Activity {
	private boolean rikordante = false; 
	private MediaRecorder recorder;
	private String vojnomo;
	
	public Prononco(){
		vojnomo = Environment.getExternalStorageDirectory().getAbsolutePath();
		vojnomo += "/sono.3gp";
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.leciono_1_prononco);
	}
	
	public void Rikordi(View v){
		if(!rikordante){
			KomenciRikordi();
		}else{
			HaltiRikordi();
			LudiSonon();
		}
	}

	private void KomenciRikordi(){
		rikordante = true;
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setOutputFile(vojnomo);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		
		try {
			recorder.prepare();
			recorder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void HaltiRikordi(){
		rikordante = false;
		
		recorder.stop();
		recorder.release();
		recorder = null;
	}
	
	private void LudiSonon() {
		MediaPlayer player = new MediaPlayer();
		try {
			player.setDataSource(vojnomo);
			player.prepare();
			player.start();
			player.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.release();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
