package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import org.brazilo.esperanto.kurso.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Auskultado extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.leciono_1_auskultado);
		
		EditText tekstujo = (EditText)findViewById(R.id.editText1);
		tekstujo.setOnKeyListener(new KeyListener());
	}
	
	protected class KeyListener implements View.OnKeyListener {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
				EditText tekstujo = (EditText)v;
				String teksto = tekstujo.getText().toString();
				tekstujo.getText().clear();
				
				
				TextView tekstaro = (TextView)findViewById(R.id.textView1);
				tekstaro.append(teksto + "\n");
				return true;
			}
			return false;
		}
		
	}
	


}
