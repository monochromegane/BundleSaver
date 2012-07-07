package dev.kuro.obi.bundlesaver;

import java.lang.reflect.Field;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import dev.kuro.obi.bundlesaver.annotation.BundleTarget;
import dev.kuro.obi.bundlesaver.utils.ReflectionUtil;

@Deprecated public class AutoBundleSaver {

	private static final String SEPARATOR = ",";

	/**
	 * privateコンストラクタ
	 * インスタンス取得はgetAutoBundleSaverメソッドから行います。
	 * @param bundle
	 */
	private AutoBundleSaver(){
	}

	/**
	 * @deprecated 非推奨メソッド
	 * {@link AutoStateSaver#getAutoStateSaver()}
	 * インスタンス取得用の静的メソッド
	 * @return
	 */
	@Deprecated public static AutoBundleSaver getAutoBundleSaver(){
		return new AutoBundleSaver();
	}

	/**
	 * @deprecated 非推奨メソッド
	 * {@link AutoStateSaver#saveToBundle(Bundle, Object)}
	 * BundleTargetアノテーションが設定されたインスタンス変数フィールドをBundleへ保存します。
	 * @param bundle
	 * @param rootObject
	 */
	@Deprecated public void save(Bundle bundle, Object rootObject) {

		BundleSaver saver = BundleSaver.getBundleSaver(bundle);
		List<Class<?>> superClasses = ReflectionUtil.getSuperClasses(rootObject, Activity.class);
		for(Class<?> clazz: superClasses){

			String className = clazz.getName();
			List<Field> fields = ReflectionUtil.getDeclaredFields(clazz, BundleTarget.class);
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
	 * @deprecated 非推奨メソッド
	 * {@link AutoStateSaver#restoreFromBundle(Bundle, Object)}
	 * BundleTargetアノテーションが設定されたインスタンス変数フィールドをBundleから復元します。
	 * @param bundle
	 * @param rootObject
	 */
	@Deprecated public void restore(Bundle bundle, Object rootObject){

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
						saver.get(genKey(className, field.getName()), field.getType()));

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
