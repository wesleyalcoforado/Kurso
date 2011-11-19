package org.brazilo.esperanto.kurso.utilaj;

import java.util.HashMap;

import org.brazilo.esperanto.kurso.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Utila {
    public static void montriAverton(String mesagxo, Context kunteksto){
    	AlertDialog.Builder constructor = new AlertDialog.Builder(kunteksto);
    	constructor.setMessage(mesagxo);
    	constructor.setNeutralButton(R.string.butono_ok, null);
    	constructor.setTitle(R.string.fenestro_averto);
    	
    	AlertDialog alert = constructor.create();
    	alert.show();
    }
    
	public static void ludu(View v, Context kunteksto){
		String vorto = "";
		if(v instanceof ImageButton){
			ImageButton image = (ImageButton)v;
			vorto = image.getTag().toString();
		}else{
			Button butono = (Button)v;
			vorto = butono.getText().toString();
		}
		
		try{
			int sono_identigilo = akiriSonoIdentigilon(vorto.toLowerCase(), kunteksto);
			luduGxisLaFino(sono_identigilo, kunteksto);
		}catch(Exception e){
			Toast.makeText(kunteksto, "Arquivo de som não encontrado!", Toast.LENGTH_SHORT).show();
		}
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
    	paroj.put(" ", "_");
    	
    	for(String sxlosilo: paroj.keySet()){
    		vorto = vorto.replaceAll(sxlosilo, paroj.get(sxlosilo));
    	}
    	
    	return vorto;
    }
    
}
