package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.utilaj.KursoActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Finajxoj extends KursoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.leciono_1_finajxoj);
	}
	
	public void kuntiri(View view){
		TextView butono = (TextView)view;
		LinearLayout paneloVerboj = (LinearLayout)findViewById(R.id.leciono_1_finajxoj_verboj);
		LinearLayout paneloSubstantivoj = (LinearLayout)findViewById(R.id.leciono_1_finajxoj_substantivoj);
		LinearLayout paneloAdjektivoj = (LinearLayout)findViewById(R.id.leciono_1_finajxoj_adjektivoj);
		
		if(butono.getId() == R.id.leciono_1_finajxoj_butono_verboj){
			if(paneloVerboj.getVisibility() == View.GONE){
				paneloVerboj.setVisibility(View.VISIBLE);
			}else{
				paneloVerboj.setVisibility(View.GONE);
			}
			paneloSubstantivoj.setVisibility(View.GONE);
			paneloAdjektivoj.setVisibility(View.GONE);
		}else if(butono.getId() == R.id.leciono_1_finajxoj_butono_substantivoj){
			if(paneloSubstantivoj.getVisibility() == View.GONE){
				paneloSubstantivoj.setVisibility(View.VISIBLE);
			}else{
				paneloSubstantivoj.setVisibility(View.GONE);
			}
			paneloVerboj.setVisibility(View.GONE);
			paneloAdjektivoj.setVisibility(View.GONE);
		}else{
			if(paneloAdjektivoj.getVisibility() == View.GONE){
				paneloAdjektivoj.setVisibility(View.VISIBLE);
			}else{
				paneloAdjektivoj.setVisibility(View.GONE);
			}
			paneloVerboj.setVisibility(View.GONE);
			paneloSubstantivoj.setVisibility(View.GONE);
		}
	}	
}
