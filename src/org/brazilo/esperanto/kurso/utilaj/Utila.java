package org.brazilo.esperanto.kurso.utilaj;

import java.util.HashMap;
import java.util.Random;

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
	private static Random hazardilo;
	private static Random getHazardilo() {
		if(hazardilo == null){
			hazardilo = new Random();
		}
		
		return hazardilo;
	}
	
    public static void montriAverton(int mesagxoId, Context kunteksto){
    	String mesagxo = kunteksto.getResources().getText(mesagxoId).toString();
    	montriAverton(mesagxo, kunteksto);
    }
	
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
		
		ludu(vorto, kunteksto);
	}    
	
	public static void ludu(String vorto, Context kunteksto) {
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
    
    public static String konvertiAlCxapelitaj(String vorto){
    	HashMap<String, String> paroj = new HashMap<String, String>();
    	vorto = vorto.replaceAll("X", "x");
    	
    	paroj.put("cx", "ĉ");
    	paroj.put("jx", "ĵ");
    	paroj.put("sx", "ŝ");
    	paroj.put("gx", "ĝ");
    	paroj.put("hx", "ĥ");
    	paroj.put("ux", "ŭ");
    	paroj.put("Cx", "Ĉ");
    	paroj.put("Jx", "Ĵ");
    	paroj.put("Sx", "Ŝ");
    	paroj.put("Gx", "Ĝ");
    	paroj.put("Hx", "Ĥ");
    	paroj.put("Ux", "Ŭ");
    	
    	for(String sxlosilo: paroj.keySet()){
    		vorto = vorto.replaceAll(sxlosilo, paroj.get(sxlosilo));
    	}
    	
    	return vorto;
    }
    
    public static void gratuli(Context kunteksto) {
    	int indekso = getHazardilo().nextInt(7) + 1;
    	ludu("gratulo"+indekso, kunteksto);
    }
    
    public static void nei(Context kunteksto) {
    	int indekso = getHazardilo().nextInt(4) + 1;
    	ludu("ne"+indekso, kunteksto);
    }
    
    public static void provuDenove(Context kunteksto) {
    	int indekso = getHazardilo().nextInt(6) + 1;
    	ludu("nebona"+indekso, kunteksto);
    }
    
}
