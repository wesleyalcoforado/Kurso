package org.brazilo.esperanto.kurso.lecionoj.leciono_02;

import org.brazilo.esperanto.kurso.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Muzikvideo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leciono_2_muzikvideo_teksto);
	}
	
	public void LudiVideon(View v){
		Intent intent = new Intent(this, Ludilo.class);
		startActivity(intent);
	}
}
