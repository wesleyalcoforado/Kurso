package org.brazilo.esperanto.kurso;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.brazilo.esperanto.kurso.lecionoj.leciono_01.Leciono1;
import org.brazilo.esperanto.kurso.utilaj.Utila;

public class Principa extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principa);
        
        try
        {
        	CharSequence[] strings = this.getResources().getTextArray(R.array.menu_lecionoj);
	        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, R.layout.linio, android.R.id.text1, strings);
	        setListAdapter(adapter);
        }catch(Exception e){
        	Utila.montriAverton(e.getMessage(), this);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	
    	switch(position){
		case 0:
			Intent intent = new Intent(this.getApplicationContext(), Leciono1.class);
			this.startActivity(intent);
	    	break;
		case 1:
			Utila.montriAverton("Lição 2", this);
	    	break;
		case 2:
			Utila.montriAverton("Lição 3", this);
	    	break;
		case 3:
			Utila.montriAverton("Lição 4", this);
	    	break;
		case 4:
			Utila.montriAverton("Lição 5", this);
	    	break;
		case 5:
			Utila.montriAverton("Lição 6", this);
	    	break;
		case 6:
			Utila.montriAverton("Lição 7", this);
	    	break;
		case 7:
			Utila.montriAverton("Lição 8", this);
	    	break;
		case 8:
			Utila.montriAverton("Lição 9", this);
	    	break;
		case 9:
			Utila.montriAverton("Lição 10", this);
	    	break;	    	
		case 10:
			Utila.montriAverton("Lição 11", this);
	    	break;
		case 11:
			Utila.montriAverton("Lição 12", this);
	    	break;
    	}
    	
    }	
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.principa, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.kio_estas_esperanto:
			Intent intent = new Intent(this.getApplicationContext(), KioEstas.class);
			this.startActivity(intent);
			return true;

		case R.id.foriri:
			this.finish();
			return true;
		
		default:
			return super.onOptionsItemSelected(item);
		}
    }    
	
}