package dev.kuro.obi.bundlesaver;

import java.lang.reflect.Field;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import dev.kuro.obi.bundlesaver.annotation.BundleTarget;
import dev.kuro.obi.bundlesaver.utils.ReflectionUtil;

public class AutoBundleSaver {

	private static final String SEPARATOR = ",";

	/**
	 * privateコンストラクタ
	 * インスタンス取得はgetAutoBundleSaverメソッドから行います。
	 * @param bundle
	 */
	private AutoBundleSaver(){
	}

	/**
	 * インスタンス取得用の静的メソッド
	 * @return
	 */
	public static AutoBundleSaver getAutoBundleSaver(){
		return new AutoBundleSaver();
	}

	/**
	 * BundleTargetアノテーションが設定されたインスタンス変数フィールドをBundleへ保存します。
	 * @param bundle
	 * @param rootObject
	 */
	public void save(Bundle bundle, Object rootObject) {

		BundleSaver saver = BundleSaver.getBundleSaver(bundle);
		List<Class<?>> superClasses = ReflectionUtil.getSuperClasses(rootObject, Activity.class);
		for(Class<?> clazz: superClasses){

			String className = clazz.getName();
			List<Field> fields = ReflectionUtil.getDeclaredFields(clazz, BundleTarget.class);
			for(Field field: fields){

				// Bundleへ保存
				saver.putToBundle(
						genKey(className, field.getName()),
						ReflectionUtil.getFieldObject(rootObject, field)
						);
			}
		}
	}

	/**
	 * BundleTargetアノテーションが設定されたインスタンス変数フィールドをBundleから復元します。
	 * @param bundle
	 * @param rootObject
	 */
	public void restore(Bundle bundle, Object rootObject){

		BundleSaver saver = BundleSaver.getBundleSaver(bundle);
		List<Class<?>> superClasses = ReflectionUtil.getSuperClasses(rootObject, Activity.class);
		for(Class<?> clazz: superClasses){

			String className = clazz.getName();
			List<Field> fields = ReflectionUtil.getDeclaredFields(clazz, BundleTarget.class);
			for(Field field: fields){

				// Bundleから復元
				ReflectionUtil.setFieldValue(
						rootObject,
						field,
						saver.getFromBundle(genKey(className, field.getName()), field.getType()));

			}
		}
	}

	/**
	 * Bundleへ格納する際のキーを生成します。
	 * @param className
	 * @param fieldName
	 * @return
	 */
	private static String genKey(String className, String fieldName){
		return className + SEPARATOR + fieldName;
	}

}
