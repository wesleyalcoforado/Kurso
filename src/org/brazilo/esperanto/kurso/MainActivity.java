package org.brazilo.esperanto.kurso;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupControls();
    }

	private void setupControls() {
        Spinner menu = (Spinner) findViewById(R.id.spMenu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu_lecionoj, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		menu.setAdapter(adapter);
		
		menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
		        showAlert("oi");
		    } 

		    public void onNothingSelected(AdapterView<?> adapterView) {
		        return;
		    }
		});
	}
	
    public void showAlert(String msg){
    	AlertDialog.Builder constructor = new AlertDialog.Builder(this);
    	constructor.setMessage(msg);
    	constructor.setNeutralButton("OK", null);
    	
    	AlertDialog alert = constructor.create();
    	alert.show();
    }	
	
	public void kioEstas(View view)
	{
		Intent intent = new Intent(this.getApplicationContext(), KioEstasActivity.class);
		this.startActivity(intent);
	}
}