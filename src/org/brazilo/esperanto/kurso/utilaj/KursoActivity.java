package org.brazilo.esperanto.kurso.utilaj;

import android.app.Activity;
import android.view.View;

public class KursoActivity extends Activity implements Ludebla {

	public void ludu(View v){
		Utila.ludu(v, this);
	}
	
}
