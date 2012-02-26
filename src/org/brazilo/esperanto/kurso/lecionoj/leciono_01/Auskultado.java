package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import java.util.ArrayList;
import java.util.Random;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.exceptions.MalplenaVortlistoException;
import org.brazilo.esperanto.kurso.utilaj.Utila;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Auskultado extends Activity{

	private ArrayList<String> vortoj;
	private ArrayList<String> korektajVortoj;
	private ArrayList<String> nekorektajVortoj;
	private String nunaVorto;
	private Random hazardilo;
	private boolean testoAktiva;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.leciono_1_auskultado);
		
		hazardilo = new Random();
		
		EditText tekstujo = (EditText)findViewById(R.id.editText1);
		tekstujo.setOnKeyListener(new KeyListener());
	}
	
	private void iniciatiVortlistojn() {
		vortoj = new ArrayList<String>();
		korektajVortoj = new ArrayList<String>();
		nekorektajVortoj = new ArrayList<String>();
		
		for (CharSequence vorto : getVortListo()) {
			vortoj.add(vorto.toString());
		}
	}
	
	protected CharSequence[] getVortListo(){
		return this.getResources().getTextArray(R.array.auskultlisto);
	}
	
	private void kalkuliTrafojn() {
		TextView kiomDaVortoj = (TextView)findViewById(R.id.kiom_da_vortoj);
		TextView kiomDaEraroj = (TextView)findViewById(R.id.kiom_da_eraroj);
		TextView kiomDaTrafoj = (TextView)findViewById(R.id.kiom_da_trafoj);
		TextView procentoDaTrafoj = (TextView)findViewById(R.id.trafo_procento);
		
		kiomDaVortoj.setText(getKvantoDaVortoj().toString());
		kiomDaEraroj.setText(getKvantoDaEraroj().toString());
		kiomDaTrafoj.setText(getKvantoDaTrafoj().toString());
		procentoDaTrafoj.setText(getProcento() + "%");
	}
	
	public void komenciTeston(View view) {
		testoAktiva = true;
		arangxiButonojn();
		
		iniciatiVortlistojn();
		kalkuliTrafojn();
		
		venontaVorto();
		ludiVorton(null);
	}
	
	private void venontaVorto() {
		try{
			nunaVorto = null;
			nunaVorto = preniVorton();
		}catch (MalplenaVortlistoException e) {
			finiTeston(null);
		}
	}
	
	public void finiTeston(View view){
		if(getProcento() >= 70){
			Utila.gratuli(this);
			Utila.montriAverton(R.string.gratulon_via_rezulto_estis_tre_bona, this);
		}else{
			Utila.provuDenove(this);
			Utila.montriAverton(R.string.via_rezulto_ne_estis_tre_bona_provu_denove, this);
		}
		
		testoAktiva = false;
		arangxiButonojn();
	}
	
	private void arangxiButonojn(){
		Button ludi = (Button)findViewById(R.id.button3);
		Button halti = (Button)findViewById(R.id.button2);
		Button ripeti = (Button)findViewById(R.id.button1);
		
		EditText tekstujo = (EditText)findViewById(R.id.editText1);
		
		if(testoAktiva){
			ludi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_but_ludi_unselected);
			halti.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_but_halti_selected);
			ripeti.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_but_ripeti_selected);
			
			ludi.setEnabled(false);
			halti.setEnabled(true);
			ripeti.setEnabled(true);
			
			TextView tekstaro = (TextView)findViewById(R.id.textView1);
			tekstaro.setText(null);
			
			tekstujo.setEnabled(true);
			tekstujo.setText(null);
		}else{
			ludi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_but_ludi_selected);
			halti.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_but_halti_unselected);
			ripeti.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_but_ripeti_unselected);

			ludi.setEnabled(true);
			halti.setEnabled(false);
			ripeti.setEnabled(false);
			
			tekstujo.setEnabled(false);
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
		if(nunaVorto != null){
			Utila.ludu(nunaVorto, this);
		}
	}
	
	private void ludiVortonPostTempo(final long tempoEnMilisekundoj){
		Thread t = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(tempoEnMilisekundoj);
					Utila.ludu(nunaVorto, getApplicationContext());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t.start();
	}
	
	private boolean testiVorton(String vorto) {
		boolean rezulto = false;
		
		String traktitaVorto = Utila.konvertiAlCxapelitaj(vorto.trim());
		
		if(nunaVorto.trim().equalsIgnoreCase(traktitaVorto)) {
			korektajVortoj.add(nunaVorto);
			vortoj.remove(nunaVorto);
			kalkuliTrafojn();
			venontaVorto();
			ludiVorton(null);
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
		
		Toast mesagxo = Toast.makeText(this, nunaVorto, Toast.LENGTH_LONG);
		mesagxo.setGravity(Gravity.TOP, 0, 50);
		mesagxo.show();
		
		venontaVorto();
		ludiVortonPostTempo(3500);
	}
	
	private Integer getKvantoDaVortoj(){
		return vortoj.size();
	}
	
	private Integer getKvantoDaTrafoj(){
		return korektajVortoj.size();
	}
	
	private Integer getKvantoDaEraroj(){
		return nekorektajVortoj.size();
	}
	
	private Integer getProcento(){
		Integer procento = 0;
		if((getKvantoDaEraroj() + getKvantoDaTrafoj()) > 0) {
			procento = Math.round(getKvantoDaTrafoj() * 100 / (getKvantoDaTrafoj() + getKvantoDaEraroj()));
		}
		
		return procento;
	}

	protected class KeyListener implements View.OnKeyListener {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {	
			if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
				EditText tekstujo = (EditText)v;
				String teksto = tekstujo.getText().toString();
				tekstujo.getText().clear();
				
				String vorto = nunaVorto;
				if(testiVorton(teksto)){
					TextView tekstaro = (TextView)findViewById(R.id.textView1);
					tekstaro.setText(vorto + "\n" + tekstaro.getText());
				}
				
				return true;
			}
			return false;
		}
		
	}
	


}
