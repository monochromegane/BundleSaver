package dev.kuro.obi.bundlesaver;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dev.kuro.obi.bundlesaver.annotation.SaveToPreference;
import dev.kuro.obi.bundlesaver.exception.NotSupportedPreferenceTypeException;

public class PreferenceSaver implements SaverBehivor{

	SharedPreferences pref;
	SharedPreferences.Editor editor;

	/**
	 * privateコンストラクタ
	 * インスタンス取得はgetPreferenceSaverメソッドから行います。
	 * @param context
	 */
	private PreferenceSaver(Context context){
		this.pref = PreferenceManager.getDefaultSharedPreferences(context);
	}

	/**
	 * インスタンス取得用の静的メソッド
	 * @param context
	 * @return
	 */
	public static PreferenceSaver getPreferenceSaver(Context context){
		return new PreferenceSaver(context);
	}

	/**
	 * 指定されたキーを用いてPreferenceへの保存を行います。
	 * Preferenceへ格納できない値が指定された場合は、
	 * 実行時例外NotSupportedPreferenceTypeExceptionをスローします。
	 * @param key
	 * @param fieldObject
	 */
	public void put(String key, Object fieldObject){

		if(fieldObject == null) return;

		if(fieldObject instanceof Integer){
			getEditor().putInt(key, (Integer) fieldObject);

		}else if(fieldObject instanceof Long){
			getEditor().putLong(key, (Long) fieldObject);

		}else if(fieldObject instanceof Float){
			getEditor().putFloat(key, (Float) fieldObject);

		}else if(fieldObject instanceof Boolean){
			getEditor().putBoolean(key, (Boolean) fieldObject);

		}else if(fieldObject instanceof String){
			getEditor().putString(key, (String) fieldObject);

		}else{
			throw new NotSupportedPreferenceTypeException(fieldObject.getClass());
		}
		getEditor().commit();
	}

	/**
	 * 指定されたキーを用いてPreferenceから値を取得します。
	 * @param key
	 * @param type
	 * @return
	 */
	public Object get(String key, Class<?> type){

		Object object;

		if(type == int.class || type == Integer.class){
			object = pref.getInt(key, Integer.MIN_VALUE);

		}else if(type == long.class || type == Long.class){
			object = pref.getLong(key, Long.MIN_VALUE);

		}else if(type == float.class || type == Float.class){
			object = pref.getFloat(key, Float.MIN_VALUE);

		}else if(type == boolean.class || type == Boolean.class){
			object = pref.getBoolean(key, Boolean.FALSE);

		}else if(type == String.class){
			object = pref.getString(key, "");

		}else{
			object = null;
		}

		return object;

	}


	private SharedPreferences.Editor getEditor(){
		if(editor != null) return editor;
		editor = pref.edit();
		return editor;
	}

	public void clear(){
		getEditor().clear().commit();
	}

	public void commit(){
		getEditor().commit();
	}

	@Override
	public Class<?> getTargetAnnotation() {
		return SaveToPreference.class;
	}

}
