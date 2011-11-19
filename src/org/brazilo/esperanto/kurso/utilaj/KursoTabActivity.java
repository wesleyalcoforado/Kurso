package org.brazilo.esperanto.kurso.utilaj;

import android.app.TabActivity;
import android.view.View;

public class KursoTabActivity extends TabActivity implements Ludebla {

	public void ludu(View v){
		Utila.ludu(v, this);
	}
	
}
