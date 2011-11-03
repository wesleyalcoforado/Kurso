package org.brazilo.esperanto.kurso.utilaj;

import android.app.TabActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class KursoActivity extends TabActivity {

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
