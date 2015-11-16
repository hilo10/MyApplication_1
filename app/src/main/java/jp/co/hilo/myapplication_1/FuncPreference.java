package jp.co.hilo.myapplication_1;

import android.content.Context;
import android.content.SharedPreferences;

public class FuncPreference {

	private static final String CNT_ITEMS 	= "CNT_ITEMS";
	private static final String REG_TITLE	= "REG_TITLE";
	private static final String REG_ID 		= "REG_ID";
	private static final String REG_PASS 	= "REG_PASS";

	//===============================================================================================
	// ShareMethod
	//===============================================================================================
	public static SharedPreferences getPreferences( Context context ){
		SharedPreferences pref = context.getSharedPreferences( "PassMngPref" , Context.MODE_PRIVATE );
		return pref;
	}

	//===============================================================================================
	// CNT_ITEMS
	//===============================================================================================
	public static int loadCntItems( Context context ){
		// 取得失敗した場合は return"0"
		return getPreferences( context ).getInt( CNT_ITEMS, 0 );
	}
	public static void saveCntItems( Context context, int items ){
		SharedPreferences.Editor editor = getPreferences( context ).edit();
		editor.putInt( CNT_ITEMS, items );
		editor.commit();
	}

	//===============================================================================================
	// Title
	//===============================================================================================
	public static String loadTitle( Context context, int number ){
		// 取得失敗した場合は return"0"
		String num = String.format("%03d", number );;
		return getPreferences( context ).getString( REG_TITLE + "_" + num, "0" );
	}
	public static void saveTitle( Context context, int number, String title ){
		String num = String.format("%03d", number );
		SharedPreferences.Editor editor = getPreferences( context ).edit();
		editor.putString( REG_TITLE + "_" + num, title );
		editor.commit();
	}

	//===============================================================================================
	// ID
	//===============================================================================================
	public static String loadId( Context context, int number ){
		// 取得失敗した場合は return"0"
		String num = String.format("%03d", number );
		return getPreferences( context ).getString( REG_ID + "_" + num, "0" );
	}
	public static void saveId( Context context, int number, String id ){
		String num = String.format("%03d", number );
		SharedPreferences.Editor editor = getPreferences( context ).edit();
		editor.putString( REG_ID + "_" + num, id );
		editor.commit();
	}

	//===============================================================================================
	// Password
	//===============================================================================================
	public static String loadPassword( Context context, int number ){
		// 取得失敗した場合は return"0"
		String num = String.format("%03d", number );
		return getPreferences( context ).getString( REG_PASS + "_" + num, "0" );
	}
	public static void savePassword( Context context, int number, String pass ){
		String num = String.format("%03d", number );
		SharedPreferences.Editor editor = getPreferences( context ).edit();
		editor.putString( REG_PASS + "_" + num, pass );
		editor.commit();
	}
}
