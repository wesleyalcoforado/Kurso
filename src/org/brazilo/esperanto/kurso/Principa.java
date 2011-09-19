package org.brazilo.esperanto.kurso;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principa extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principa);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu_lecionoj, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	switch(position){
		case 0:
	    	MediaPlayer mp = MediaPlayer.create(this, R.raw.adiau1);
	    	mp.start();
	    	break;
		case 1:
	    	showAlert("Lição 2");
	    	break;
		case 2:
	    	showAlert("Lição 3");
	    	break;
		case 3:
	    	showAlert("Lição 4");
	    	break;
		case 4:
	    	showAlert("Lição 5");
	    	break;
		case 5:
	    	showAlert("Lição 6");
	    	break;
		case 6:
	    	showAlert("Lição 7");
	    	break;
		case 7:
	    	showAlert("Lição 8");
	    	break;
		case 8:
	    	showAlert("Lição 9");
	    	break;
		case 9:
	    	showAlert("Lição 10");
	    	break;	    	
		case 10:
	    	showAlert("Lição 11");
	    	break;
		case 11:
	    	showAlert("Lição 12");
	    	break;
    	}
    	
    }
	
    public void showAlert(String msg){
    	AlertDialog.Builder constructor = new AlertDialog.Builder(this);
    	constructor.setMessage(msg);
    	constructor.setNeutralButton("OK", null);
    	constructor.setTitle("Oi!");
    	
    	AlertDialog alert = constructor.create();
    	alert.show();
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