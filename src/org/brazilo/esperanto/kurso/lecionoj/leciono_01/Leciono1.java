package org.brazilo.esperanto.kurso.lecionoj.leciono_01;

import org.brazilo.esperanto.kurso.R;
import org.brazilo.esperanto.kurso.utilaj.Utila;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Leciono1 extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lecionoj);
		
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu_leciono_1, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
		
	}
	
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	
    	switch(position){
		case 0:
			Utila.montriAverton("Lição 1", this);
	    	break;

    	}
    	
    }	
}
