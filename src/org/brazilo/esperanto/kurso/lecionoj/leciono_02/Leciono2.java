package org.brazilo.esperanto.kurso.lecionoj.leciono_02;

import org.brazilo.esperanto.kurso.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Leciono2 extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lecionoj);
		
		TextView titolo = (TextView)findViewById(R.id.nomo_leciono);
		titolo.setText(R.string.leciono_2);

    	CharSequence[] strings = this.getResources().getTextArray(R.array.menu_leciono_2);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, R.layout.linio, android.R.id.text1, strings);
        setListAdapter(adapter);        
	}
	
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	
    	Intent intent = null;
    	switch(position){
		case 3:
			intent = new Intent(this, Muzikvideo.class);
			startActivity(intent);
	    	break;
    	}
    	
    }	
}
