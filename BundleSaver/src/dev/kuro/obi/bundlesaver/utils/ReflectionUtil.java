package dev.kuro.obi.bundlesaver.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtil {

	/**
	 * 指定されたオブジェクトのスーパークラス一覧を取得します。
	 * 遡るスーパークラスは、引数goBackTargetClassで指定します。
	 * また、引数goBackTargetClassで指定したクラスは一覧に含まれません。
	 * @param object
	 * @param goBackTargetClass
	 * @return
	 */
	public static List<Class<?>> getSuperClasses(Object object, Class<?> goBackTargetClass) {

		List<Class<?>> classes = new ArrayList<Class<?>>();

		Class<?> nowClass = object.getClass();
		while(nowClass != null
				&& !nowClass.equals(goBackTargetClass)){
			classes.add(nowClass);
			nowClass = nowClass.getSuperclass();
		}

		return classes;
	}

	/**
	 * 指定したクラスから、BundleTargetアノテーションが設定されているインスタンス変数の
	 * 一覧を取得します。
	 * static, final属性の変数は一覧に含まれません。
	 * @param clazz
	 * @param targetAnnotation
	 * @return
	 */
	public static List<Field> getDeclaredFields(Class<?> clazz, Class targetAnnotation){

		List<Field> returnFields = new ArrayList<Field>();
		Field[] fields = clazz.getDeclaredFields();

		for(Field field: fields){
			// 対象アノテーション判定
			if(field.getAnnotation(targetAnnotation) == null) continue;
			int modifier = field.getModifiers();
			// static属性判定
			if(Modifier.isStatic(modifier))    continue;
			// final属性判定
			if(Modifier.isFinal(modifier))     continue;

			field.setAccessible(true);
			returnFields.add(field);
		}

		return returnFields;
	}


	/**
	 * 指定したフィールドのオブジェクトを取得します。
	 * @param object
	 * @param field
	 * @return
	 */
	public static Object getFieldObject(Object object, Field field){
		Object returnObject = null;
		try {
			field.setAccessible(true);
			return field.get(object);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return returnObject;
	}


	/**
	 * 指定したフィールドに値を設定します。
	 * @param object
	 * @param field
	 * @param value
	 */
	public static void setFieldValue(Object object, Field field, Object value){
		try {
			field.set(object, value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
