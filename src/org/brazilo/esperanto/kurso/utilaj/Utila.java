package org.brazilo.esperanto.kurso.utilaj;

import java.util.HashMap;

import org.brazilo.esperanto.kurso.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class Utila {
    public static void montriAverton(String mesagxo, Context kunteksto){
    	AlertDialog.Builder constructor = new AlertDialog.Builder(kunteksto);
    	constructor.setMessage(mesagxo);
    	constructor.setNeutralButton(R.string.butono_ok, null);
    	constructor.setTitle(R.string.fenestro_averto);
    	
    	AlertDialog alert = constructor.create();
    	alert.show();
    }
    
    public static void luduGxisLaFino(int sonoId, Context kunteksto){
    	MediaPlayer mp = MediaPlayer.create(kunteksto, sonoId);
    	mp.start();
    	mp.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
			}
		});
    }
    
    public static int akiriSonoIdentigilon(String sondosiero, Context kunteksto){
    	int id = kunteksto.getResources().getIdentifier(konvertiAlXSistemo(sondosiero), "raw", kunteksto.getPackageName());
    	if(id == 0){
    		throw new Resources.NotFoundException();
    	}
    	return id;
    }
    
    private static String konvertiAlXSistemo(String vorto){
    	HashMap<String, String> paroj = new HashMap<String, String>();
    	paroj.put("ĉ", "cx");
    	paroj.put("ĵ", "jx");
    	paroj.put("ŝ", "sx");
    	paroj.put("ĝ", "gx");
    	paroj.put("ĥ", "hx");
    	paroj.put("ŭ", "ux");
    	
    	for(String sxlosilo: paroj.keySet()){
    		vorto = vorto.replaceAll(sxlosilo, paroj.get(sxlosilo));
    	}
    	
    	return vorto;
    }
    
}
