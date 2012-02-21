package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import java.util.ArrayList;
import java.util.Random;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.exceptions.MalplenaVortlistoException;
import org.brazilo.esperanto.kurso.utilaj.Utila;

import android.app.Activity;
import android.os.Bundle;
import android.util.MonthDisplayHelper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


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
		
		iniciatiVortlistojn();
		kalkuliTrafojn();
		
		EditText tekstujo = (EditText)findViewById(R.id.editText1);
		tekstujo.setOnKeyListener(new KeyListener());
		
		((TextView)findViewById(R.id.textView1)).setText(null);
	}
	
	private void iniciatiVortlistojn() {
		vortoj = new ArrayList<String>();
		korektajVortoj = new ArrayList<String>();
		nekorektajVortoj = new ArrayList<String>();
		
		for (CharSequence vorto : this.getResources().getTextArray(R.array.auskultlisto_2)) {
			vortoj.add(vorto.toString());
		}
	}
	
	private void kalkuliTrafojn() {
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
	
	public void komenciTeston(View view) {
		venontaVorto();
	}
	
	private void venontaVorto() {
		try{
			nunaVorto = preniVorton();
			ludiVorton(null);
		}catch (MalplenaVortlistoException e) {
			Integer kvantoEraroj = nekorektajVortoj.size();
			Integer kvantoTrafoj = korektajVortoj.size();
			Integer procento = 0;
			if(kvantoEraroj + kvantoTrafoj > 0) {
				procento = Math.round(kvantoTrafoj * 100 / (kvantoEraroj + kvantoTrafoj));
			}
			
			if(procento >= 70){
				Utila.gratuli(this);
				Utila.montriAverton(R.string.gratulon_via_rezulto_estis_tre_bona, this);
			}else{
				Utila.provuDenove(this);
				Utila.montriAverton(R.string.via_rezulto_ne_estis_tre_bona_provu_denove, this);
			}
		}
	}
	
	private String preniVorton() throws MalplenaVortlistoException {
		if(vortoj.size() == 0){
			throw new MalplenaVortlistoException();
		}
		
		int hazarda = hazardilo.nextInt(vortoj.size());
		return vortoj.get(hazarda);
	}
	
	public void ludiVorton(View view) {
		Utila.ludu(nunaVorto, this);
	}
	
	private boolean testiVorton(String vorto) {
		boolean rezulto = false;
		
		if(nunaVorto.trim().equalsIgnoreCase(vorto.trim())) {
			korektajVortoj.add(nunaVorto);
			vortoj.remove(nunaVorto);
			kalkuliTrafojn();
			venontaVorto();
			rezulto = true;
		} else {
			nekorektajVortoj.add(vorto);
			ripeti();
		}
		
		kalkuliTrafojn();
		
		return rezulto;
	}
	
	private void ripeti() {
		Utila.nei(this);
		Toast.makeText(this, nunaVorto, Toast.LENGTH_LONG).show();
		ludiVorton(null);
	}

	protected class KeyListener implements View.OnKeyListener {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
				EditText tekstujo = (EditText)v;
				String teksto = tekstujo.getText().toString();
				tekstujo.getText().clear();
				
				if(testiVorton(teksto)){
					TextView tekstaro = (TextView)findViewById(R.id.textView1);
					tekstaro.append(teksto + "\n");
					rulumiMalsupren();
				}
				
				return true;
			}
			return false;
		}

		private void rulumiMalsupren() {
			final TextView tekstaro = (TextView)findViewById(R.id.textView1);
			final ScrollView rulumilo = (ScrollView)findViewById(R.id.scrollView1);
			rulumilo.post(new Runnable(){

				@Override
				public void run() {
					rulumilo.smoothScrollTo(0, tekstaro.getBottom());
				}
				
			});
			
		}
		
	}
	


}
