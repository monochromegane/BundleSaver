package dev.kuro.obi.bundlesaver;

import java.lang.reflect.Field;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import dev.kuro.obi.bundlesaver.utils.ReflectionUtil;

public class AutoStateSaver {

	private static final String SEPARATOR = ",";

	/**
	 * privateコンストラクタ
	 * インスタンス取得はgetAutoBundleSaverメソッドから行います。
	 * @param bundle
	 */
	private AutoStateSaver(){
	}

	/**
	 * インスタンス取得用の静的メソッド
	 * @return
	 */
	public static AutoStateSaver getAutoStateSaver(){
		return new AutoStateSaver();
	}

	/**
	 * SaveToBundleアノテーションが設定されたインスタンス変数フィールドをBundleへ保存します。
	 * @param bundle
	 * @param rootObject
	 */
	public void saveToBundle(Bundle bundle, Object rootObject) {
		BundleSaver saver = BundleSaver.getBundleSaver(bundle);
		save(saver, rootObject);
	}

	/**
	 * SaveToPreferenceアノテーションが設定されたインスタンス変数フィールドをPreferenceへ保存します。
	 * @param context
	 * @param rootObject
	 */
	public void saveToPreference(Context context, Object rootObject) {
		PreferenceSaver saver = PreferenceSaver.getPreferenceSaver(context);
		save(saver, rootObject);
		saver.commit();
	}


	private void save(SaverBehivor saver, Object rootObject) {

		List<Class<?>> superClasses = ReflectionUtil.getSuperClasses(rootObject, Activity.class);
		for(Class<?> clazz: superClasses){

			String className = clazz.getName();
			List<Field> fields = ReflectionUtil.getDeclaredFields(clazz, saver.getTargetAnnotation());
			for(Field field: fields){

				// Bundleへ保存
				saver.put(
						genKey(className, field.getName()),
						ReflectionUtil.getFieldObject(rootObject, field)
						);
			}
		}
	}

	/**
	 * SaveToBundleアノテーションが設定されたインスタンス変数フィールドをBundleから復元します。
	 * @param bundle
	 * @param rootObject
	 */
	public void restoreFromBundle(Bundle bundle, Object rootObject){
		BundleSaver saver = BundleSaver.getBundleSaver(bundle);
		restore(saver, rootObject);
	}

	/**
	 * SaveToPreferenceアノテーションが設定されたインスタンス変数フィールドをPreferenceから復元します。
	 * @param context
	 * @param rootObject
	 */
	public void restoreFromPreference(Context context, Object rootObject){
		PreferenceSaver saver = PreferenceSaver.getPreferenceSaver(context);
		restore(saver, rootObject);
	}

	private void restore(SaverBehivor saver, Object rootObject) {

		List<Class<?>> superClasses = ReflectionUtil.getSuperClasses(rootObject, Activity.class);
		for(Class<?> clazz: superClasses){

			String className = clazz.getName();
			List<Field> fields = ReflectionUtil.getDeclaredFields(clazz, saver.getTargetAnnotation());
			for(Field field: fields){

				// Bundleから復元
				ReflectionUtil.setFieldValue(
						rootObject,
						field,
						saver.get(genKey(className, field.getName()), field.getType()));

			}
		}
	}

	public void clearFromPreference(Context context) {
		PreferenceSaver saver = PreferenceSaver.getPreferenceSaver(context);
		saver.clear();
	}

	/**
	 * Bundle/Preferenceへ格納する際のキーを生成します。
	 * @param className
	 * @param fieldName
	 * @return
	 */
	private static String genKey(String className, String fieldName){
		return className + SEPARATOR + fieldName;
	}

}
