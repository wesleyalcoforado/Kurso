package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.utilaj.KursoActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonajPronomoj extends KursoActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.leciono_1_personaj_pronomoj);
	}
	
	public void kuntiri(View view){
		TextView butono = (TextView)view;
		LinearLayout paneloSingularo = (LinearLayout)findViewById(R.id.leciono_1_pp_singularo);
		LinearLayout paneloPluralo = (LinearLayout)findViewById(R.id.leciono_1_pp_pluralo);
		LinearLayout paneloSpecialaj = (LinearLayout)findViewById(R.id.leciono_1_pp_specialaj);
		
		if(butono.getId() == R.id.leciono_1_pp_butono_singularo){
			if(paneloSingularo.getVisibility() == View.GONE){
				paneloSingularo.setVisibility(View.VISIBLE);
			}else{
				paneloSingularo.setVisibility(View.GONE);
			}
			paneloPluralo.setVisibility(View.GONE);
			paneloSpecialaj.setVisibility(View.GONE);
		}else if(butono.getId() == R.id.leciono_1_pp_butono_pluralo){
			if(paneloPluralo.getVisibility() == View.GONE){
				paneloPluralo.setVisibility(View.VISIBLE);
			}else{
				paneloPluralo.setVisibility(View.GONE);
			}
			paneloSingularo.setVisibility(View.GONE);
			paneloSpecialaj.setVisibility(View.GONE);
		}else{
			if(paneloSpecialaj.getVisibility() == View.GONE){
				paneloSpecialaj.setVisibility(View.VISIBLE);
			}else{
				paneloSpecialaj.setVisibility(View.GONE);
			}
			paneloSingularo.setVisibility(View.GONE);
			paneloPluralo.setVisibility(View.GONE);
		}
	}
}
