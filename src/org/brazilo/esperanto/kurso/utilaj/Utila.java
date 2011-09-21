package org.brazilo.esperanto.kurso.utilaj;

import org.brazilo.esperanto.kurso.R;
import android.app.AlertDialog;
import android.content.Context;

public class Utila {
    public static void montriAverton(String mesagxo, Context kunteksto){
    	AlertDialog.Builder constructor = new AlertDialog.Builder(kunteksto);
    	constructor.setMessage(mesagxo);
    	constructor.setNeutralButton(R.string.butono_ok, null);
    	constructor.setTitle(R.string.fenestro_averto);
    	
    	AlertDialog alert = constructor.create();
    	alert.show();
    }
    
}
