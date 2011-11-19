package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.utilaj.KursoTabActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;


public class Alfabeto extends KursoTabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leciono_1_alfabeto);
		
		TabHost mTabHost = getTabHost();
		
		Resources res = getResources();
		
		mTabHost.addTab(mTabHost.newTabSpec("tabKlarigo")
								.setIndicator("Explicação", res.getDrawable(R.drawable.ic_tab_praktiko))
								.setContent(R.id.tabKlarigo));

		mTabHost.addTab(mTabHost.newTabSpec("tabEkzerco")
								.setIndicator("Exercícios", res.getDrawable(R.drawable.ic_tab_klarigo))
								.setContent(R.id.tabEkzerco));
		
		mTabHost.setCurrentTab(0);
	}
}
