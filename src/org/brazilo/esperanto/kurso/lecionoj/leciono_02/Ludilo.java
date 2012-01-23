package org.brazilo.esperanto.kurso.lecionoj.leciono_02;

import org.brazilo.esperanto.kurso.R;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Ludilo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leciono_2_muzikvideo);
		
		VideoView v = (VideoView)findViewById(R.id.video);
		v.setMediaController(new MediaController(this));
		v.setVideoURI(Uri.parse("android.resource://"+ getPackageName() +"/" + R.raw.jen));
		v.requestFocus();
		v.start();
	}
}
