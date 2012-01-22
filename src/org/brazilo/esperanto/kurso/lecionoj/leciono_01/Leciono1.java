package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import org.brazilo.esperanto.kurso.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Leciono1 extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lecionoj);
		
		TextView titolo = (TextView)findViewById(R.id.nomo_leciono);
		titolo.setText(R.string.leciono_1);

    	CharSequence[] strings = this.getResources().getTextArray(R.array.menu_leciono_1);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, R.layout.linio, android.R.id.text1, strings);
        setListAdapter(adapter);        
	}
	
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	
    	Intent intent = null;
    	switch(position){
		case 0:
			intent = new Intent(this, Alfabeto.class);
			startActivity(intent);
	    	break;
		case 2:
			intent = new Intent(this, PersonajPronomoj.class);
			startActivity(intent);
	    	break;
		case 3:
			intent = new Intent(this, Finajxoj.class);
			startActivity(intent);
	    	break;
		case 4:
			intent = new Intent(this, Vortareto.class);
			startActivity(intent);
	    	break;
		case 5:
			intent = new Intent(this, Pluralo.class);
			startActivity(intent);
	    	break;
		case 6:
			intent = new Intent(this, PosedajPronomoj.class);
			startActivity(intent);
	    	break;	
		case 8:
			intent = new Intent(this, Prononco.class);
			startActivity(intent);
	    	break;	
    	}
    	
    }	
}
