package dev.kuro.obi.bundlesaver;

import java.io.Serializable;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import dev.kuro.obi.bundlesaver.annotation.SaveToBundle;
import dev.kuro.obi.bundlesaver.exception.NotSupportedBundleTypeException;
import dev.kuro.obi.bundlesaver.utils.ArrayUtil;

public class BundleSaver implements SaverBehivor{

	Bundle bundle;

	/**
	 * privateコンストラクタ
	 * インスタンス取得はgetBundleSaverメソッドから行います。
	 * @param bundle
	 */
	private BundleSaver(Bundle bundle){
		this.bundle = bundle;
	}

	/**
	 * インスタンス取得用の静的メソッド
	 * @param bundle
	 * @return
	 */
	public static BundleSaver getBundleSaver(Bundle bundle){
		return new BundleSaver(bundle);
	}

	/**
	 * 指定されたキーを用いてBundleへの保存を行います。
	 * Bundleへ格納できない値が指定された場合は、Bundleのクリアを行い、
	 * 実行時例外NotSupportedBundleTypeExceptionをスローします。
	 * @param key
	 * @param fieldObject
	 */
	public void put(String key, Object fieldObject){

		if(fieldObject == null) return;

		if(fieldObject instanceof Short){
			bundle.putShort(key, (Short) fieldObject);

		}else if(fieldObject instanceof short[]){
			bundle.putShortArray(key, (short[]) fieldObject);

		}else if(fieldObject instanceof Short[]){
			bundle.putShortArray(key, ArrayUtil.convertShortArrayObjectToPrimitive((Short[])fieldObject));

		}else if(fieldObject instanceof Integer){
			bundle.putInt(key, (Integer) fieldObject);

		}else if(fieldObject instanceof int[]){
			bundle.putIntArray(key, (int[]) fieldObject);

		}else if(fieldObject instanceof Integer[]){
			bundle.putIntArray(key, ArrayUtil.convertIntArrayObjectToPrimitive((Integer[])fieldObject));

		}else if(fieldObject instanceof Long){
			bundle.putLong(key, (Long) fieldObject);

		}else if(fieldObject instanceof long[]){
			bundle.putLongArray(key, (long[]) fieldObject);

		}else if(fieldObject instanceof Long[]){
			bundle.putLongArray(key, ArrayUtil.convertLongArrayObjectToPrimitive((Long[])fieldObject));

		}else if(fieldObject instanceof Float){
			bundle.putFloat(key, (Float) fieldObject);

		}else if(fieldObject instanceof float[]){
			bundle.putFloatArray(key, (float[]) fieldObject);

		}else if(fieldObject instanceof Float[]){
			bundle.putFloatArray(key, ArrayUtil.convertFloatArrayObjectToPrimitive((Float[])fieldObject));

		}else if(fieldObject instanceof Double){
			bundle.putDouble(key, (Double) fieldObject);

		}else if(fieldObject instanceof double[]){
			bundle.putDoubleArray(key, (double[]) fieldObject);

		}else if(fieldObject instanceof Double[]){
			bundle.putDoubleArray(key, ArrayUtil.convertDoubleArrayObjectToPrimitive((Double[])fieldObject));

		}else if(fieldObject instanceof Byte){
			bundle.putByte(key, (Byte) fieldObject);

		}else if(fieldObject instanceof byte[]){
			bundle.putByteArray(key, (byte[]) fieldObject);

		}else if(fieldObject instanceof Byte[]){
			bundle.putByteArray(key, ArrayUtil.convertByteArrayObjectToPrimitive((Byte[])fieldObject));

		}else if(fieldObject instanceof Boolean){
			bundle.putBoolean(key, (Boolean) fieldObject);

		}else if(fieldObject instanceof boolean[]){
			bundle.putBooleanArray(key, (boolean[]) fieldObject);

		}else if(fieldObject instanceof Boolean[]){
			bundle.putBooleanArray(key, ArrayUtil.convertBooleanArrayObjectToPrimitive((Boolean[])fieldObject));

		}else if(fieldObject instanceof Character){
			bundle.putChar(key, (Character) fieldObject);

		}else if(fieldObject instanceof char[]){
			bundle.putCharArray(key, (char[]) fieldObject);

		}else if(fieldObject instanceof Character[]){
			bundle.putCharArray(key, ArrayUtil.convertCharArrayObjectToPrimitive((Character[])fieldObject));

		}else if(fieldObject instanceof String){
			bundle.putString(key, (String) fieldObject);

		}else if(fieldObject instanceof String[]){
			bundle.putStringArray(key, (String[]) fieldObject);

		}else if(fieldObject instanceof CharSequence){
			bundle.putCharSequence(key, (CharSequence) fieldObject);

		}else if(fieldObject instanceof CharSequence[]){
			bundle.putCharSequenceArray(key, (CharSequence[]) fieldObject);

		}else if(fieldObject instanceof Bundle){
			bundle.putBundle(key, (Bundle) fieldObject);

		}else if(fieldObject instanceof Parcelable){
			bundle.putParcelable(key, (Parcelable) fieldObject);

		}else if(fieldObject instanceof Parcelable[]){
			bundle.putParcelableArray(key, (Parcelable[]) fieldObject);

		}else if(isParcelableSparseArray(fieldObject)){
			bundle.putSparseParcelableArray(key, (SparseArray) fieldObject);

		}else if(isStringArrayList(fieldObject)){
			bundle.putStringArrayList(key, (ArrayList<String>)fieldObject);

		}else if(isIntegerArrayList(fieldObject)){
			bundle.putIntegerArrayList(key, (ArrayList<Integer>)fieldObject);

		}else if(isCharSequenceArrayList(fieldObject)){
			bundle.putCharSequenceArrayList(key, (ArrayList<CharSequence>)fieldObject);

		}else if(isParcelableArrayList(fieldObject)){
			bundle.putParcelableArrayList(key, (ArrayList<Parcelable>)fieldObject);

		}else if(fieldObject instanceof Serializable){
			bundle.putSerializable(key, (Serializable) fieldObject);

		}else{
			bundle.clear();
			throw new NotSupportedBundleTypeException(fieldObject.getClass());
		}
	}

	/**
	 * 指定されたキーを用いてBundleから値を取得します。
	 * @param key
	 * @param type
	 * @return
	 */
	public Object get(String key, Class<?> type){

		Object object;

		// プリミティブラッパの配列はプリミティブへ変換されているため、再度変換
		if(type == Short[].class){
			object = ArrayUtil.convertShortArrayPrimitiveToArray(bundle.getShortArray(key));

		}else if(type == Integer[].class){
			object = ArrayUtil.convertIntArrayPrimitiveToArray(bundle.getIntArray(key));

		}else if(type == Long[].class){
			object = ArrayUtil.convertLongArrayPrimitiveToArray(bundle.getLongArray(key));

		}else if(type == Float[].class){
			object = ArrayUtil.convertFloatArrayPrimitiveToArray(bundle.getFloatArray(key));

		}else if(type == Double[].class){
			object = ArrayUtil.convertDoubleArrayPrimitiveToArray(bundle.getDoubleArray(key));

		}else if(type == Byte[].class){
			object = ArrayUtil.convertByteArrayPrimitiveToArray(bundle.getByteArray(key));

		}else if(type == Boolean[].class){
			object = ArrayUtil.convertBooleanArrayPrimitiveToArray(bundle.getBooleanArray(key));

		}else if(type == Character[].class){
			object = ArrayUtil.convertCharArrayPrimitiveToArray(bundle.getCharArray(key));

		}else{
			object = bundle.get(key);
		}

		return object;

	}

	/**
	 * オブジェクトがArrayList<String>を満たしていることを判定します。
	 * @param fieldObject
	 * @return
	 */
	private boolean isStringArrayList(Object fieldObject){
		if(!(fieldObject instanceof ArrayList<?>)) return false;
		for(Object object: (ArrayList<?>)fieldObject){
			if(!(object instanceof String)) return false;
		}
		return true;
	}

	/**
	 * オブジェクトがArrayList<Integer>を満たしていることを判定します。
	 * @param fieldObject
	 * @return
	 */
	private boolean isIntegerArrayList(Object fieldObject){
		if(!(fieldObject instanceof ArrayList<?>)) return false;
		for(Object object: (ArrayList<?>)fieldObject){
			if(!(object instanceof Integer)) return false;
		}
		return true;
	}

	/**
	 * オブジェクトがArrayList<CharSequence>を満たしていることを判定します。
	 * @param fieldObject
	 * @return
	 */
	private boolean isCharSequenceArrayList(Object fieldObject){
		if(!(fieldObject instanceof ArrayList<?>)) return false;
		for(Object object: (ArrayList<?>)fieldObject){
			if(!(object instanceof CharSequence)) return false;
		}
		return true;
	}

	/**
	 * オブジェクトがArrayList<Parcelable>を満たしていることを判定します。
	 * @param fieldObject
	 * @return
	 */
	private boolean isParcelableArrayList(Object fieldObject){
		if(!(fieldObject instanceof ArrayList<?>)) return false;
		for(Object object: (ArrayList<?>)fieldObject){
			if(!(object instanceof Parcelable)) return false;
		}
		return true;
	}

	/**
	 * オブジェクトがSparseArray<? extends Parcelable>を満たしていることを判定します。
	 * @param fieldObject
	 * @return
	 */
	private boolean isParcelableSparseArray(Object fieldObject){
		if(!(fieldObject instanceof SparseArray<?>)) return false;
		SparseArray<?> sparseArray = (SparseArray<?>)fieldObject;
		for(int i=0; i<sparseArray.size(); i++){
			if(!(sparseArray.valueAt(i) instanceof Parcelable)){
				return false;
			}
		}
		return true;
	}

	@Override
	public Class<?> getTargetAnnotation() {
		return SaveToBundle.class;
	}

}
