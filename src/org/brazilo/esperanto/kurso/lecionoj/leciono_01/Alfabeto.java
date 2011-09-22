package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.utilaj.Utila;

public class Alfabeto extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.leciono_1_alfabeto);
	}
	
	public void ludu(View v){
		Button butono = (Button)v;
		String vorto = butono.getText().toString();
		
		try{
			int sono_identigilo = Utila.akiriSonoIdentigilon(vorto.toLowerCase(), this);
			Utila.luduGxisLaFino(sono_identigilo, this);
		}catch(Exception e){
			Toast.makeText(this, "Arquivo de som não encontrado!", Toast.LENGTH_SHORT).show();
		}
	}
	
	
}
