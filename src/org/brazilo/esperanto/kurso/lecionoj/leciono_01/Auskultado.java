package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import java.util.ArrayList;
import java.util.Random;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.utilaj.Utila;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Auskultado extends Activity{

	private ArrayList<String> vortoj;
	private ArrayList<String> korektajVortoj;
	private ArrayList<String> nekorektajVortoj;
	private String nunaVorto;
	private Random hazardilo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.leciono_1_auskultado);
		
		hazardilo = new Random();
		
		IniciatiVortlistojn();
		KalkuliTrafojn();
		
		EditText tekstujo = (EditText)findViewById(R.id.editText1);
		tekstujo.setOnKeyListener(new KeyListener());
		
		((TextView)findViewById(R.id.textView1)).setText(null);
	}
	
	private void IniciatiVortlistojn() {
		vortoj = new ArrayList<String>();
		korektajVortoj = new ArrayList<String>();
		nekorektajVortoj = new ArrayList<String>();
		
		for (CharSequence vorto : this.getResources().getTextArray(R.array.auskultlisto_2)) {
			vortoj.add(vorto.toString());
		}
	}
	
	private void KalkuliTrafojn() {
		TextView kiomDaVortoj = (TextView)findViewById(R.id.kiom_da_vortoj);
		TextView kiomDaEraroj = (TextView)findViewById(R.id.kiom_da_eraroj);
		TextView kiomDaTrafoj = (TextView)findViewById(R.id.kiom_da_trafoj);
		TextView procentoDaTrafoj = (TextView)findViewById(R.id.trafo_procento);
		
		Integer kvantoVortoj = vortoj.size();
		Integer kvantoEraroj = nekorektajVortoj.size();
		Integer kvantoTrafoj = korektajVortoj.size();
		Integer procento = 0;
		if(kvantoEraroj + kvantoTrafoj > 0) {
			procento = Math.round(kvantoTrafoj * 100 / (kvantoEraroj + kvantoTrafoj));
		}
		
		kiomDaVortoj.setText(kvantoVortoj.toString());
		kiomDaEraroj.setText(kvantoEraroj.toString());
		kiomDaTrafoj.setText(kvantoTrafoj.toString());
		procentoDaTrafoj.setText(procento + "%");
	}
	
	public void KomenciTeston(View view) {
		nunaVorto = PreniVorton();
		LudiVorton(null);
	}
	
	private String PreniVorton() {
		int hazarda = hazardilo.nextInt(vortoj.size());
		return vortoj.get(hazarda);
	}
	
	public void LudiVorton(View view) {
		Utila.ludu(nunaVorto, this);
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
