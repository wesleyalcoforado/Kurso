package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.utilaj.KursoTabActivity;

import android.os.Bundle;
import android.widget.TabHost;


public class Alfabeto extends KursoTabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leciono_1_alfabeto);
		
		TabHost mTabHost = getTabHost();
		
		mTabHost.addTab(mTabHost.newTabSpec("tabKlarigo").setIndicator("Explicação").setContent(R.id.tabKlarigo));
		mTabHost.addTab(mTabHost.newTabSpec("tabEkzerco").setIndicator("Exercícios").setContent(R.id.tabEkzerco));
		
		mTabHost.setCurrentTab(0);
	}
}
