package dev.kuro.obi.bundlesaver.sample;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import dev.kuro.obi.bundlesaver.AutoBundleSaver;
import dev.kuro.obi.bundlesaver.NotSupportedBundleTypeException;
import dev.kuro.obi.bundlesaver.R;
import dev.kuro.obi.bundlesaver.annotation.BundleTarget;

public class SampleActivity extends SampleParentActivity {

	@BundleTarget
	public    int testAccessModiferPublic;
	@BundleTarget
	protected int testAccessModiferProtected;
	@BundleTarget
	          int testAccessModiferDefault;
	@BundleTarget
	private   int testAccessModiferPrivate;

	@BundleTarget
	int testAnnotationPresence;
	int testAnnotationAbsence;

	@BundleTarget
	short testPrimitiveShort;
	@BundleTarget
	short[] testPrimitiveShortArray;

	@BundleTarget
	Short testObjectShort;
	@BundleTarget
	Short[] testObjectShortArray;

	@BundleTarget
	int testPrimitiveInt;
	@BundleTarget
	int[] testPrimitiveIntArray;

	@BundleTarget
	Integer testObjectInt;
	@BundleTarget
	Integer[] testObjectIntArray;

	@BundleTarget
	long testPrimitiveLong;
	@BundleTarget
	long[] testPrimitiveLongArray;

	@BundleTarget
	Long testObjectLong;
	@BundleTarget
	Long[] testObjectLongArray;

	@BundleTarget
	float testPrimitiveFloat;
	@BundleTarget
	float[] testPrimitiveFloatArray;

	@BundleTarget
	Float testObjectFloat;
	@BundleTarget
	Float[] testObjectFloatArray;

	@BundleTarget
	double testPrimitiveDouble;
	@BundleTarget
	double[] testPrimitiveDoubleArray;

	@BundleTarget
	Double testObjectDouble;
	@BundleTarget
	Double[] testObjectDoubleArray;

	@BundleTarget
	byte testPrimitiveByte;
	@BundleTarget
	byte[] testPrimitiveByteArray;

	@BundleTarget
	Byte testObjectByte;
	@BundleTarget
	Byte[] testObjectByteArray;

	@BundleTarget
	boolean testPrimitiveBoolean;
	@BundleTarget
	boolean[] testPrimitiveBooleanArray;

	@BundleTarget
	Boolean testObjectBoolean;
	@BundleTarget
	Boolean[] testObjectBooleanArray;

	@BundleTarget
	char testPrimitiveChar;
	@BundleTarget
	char[] testPrimitiveCharArray;

	@BundleTarget
	Character testObjectChar;
	@BundleTarget
	Character[] testObjectCharArray;

	@BundleTarget
	String testString;
	@BundleTarget
	String[] testStringArray;

	@BundleTarget
	CharSequence testCharSequence;
	@BundleTarget
	CharSequence[] testCharSequenceArray;

	@BundleTarget
	Bundle testBundle;

	@BundleTarget
	ParcelableObject testParcelable;
	@BundleTarget
	ParcelableObjects testParcelables;
	@BundleTarget
	ParcelableObject[] testParcelableArray;

	@BundleTarget
	SerializableObject testSerializable;

	@BundleTarget
	SparseArray<ParcelableObject> testSparseArray;

	@BundleTarget
	ArrayList<String> testStringArrayList;
	@BundleTarget
	ArrayList<Integer> testIntegerArrayList;
	@BundleTarget
	ArrayList<CharSequence> testCharSequenceArrayList;
	@BundleTarget
	ArrayList<Parcelable> testParcelableArrayList;

	public enum TESTENUM {
		TESTENUM1,
		TESTENUM2
	}

	@BundleTarget
	TESTENUM testEnum;

	@BundleTarget
	ParcelableObject testNull;

//	@BundleTarget
//	NotSupportedBundleTypeObject testNotSupportedBundleType;
	@BundleTarget
	ArrayList<NotSupportedBundleTypeObject> testNotSupportedBundleTypeArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button)findViewById(R.id.change_value);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				changeValue();
			}
		});
        setInitValue();
    }

    private void setInitValue(){
    	testAccessModiferPublic = 1;
    	testAccessModiferProtected = 1;
    	testAccessModiferDefault = 1;
    	testAccessModiferPrivate = 1;
    	testAnnotationPresence = 1;
    	testAnnotationAbsence = 1;
    	testPrimitiveShort = 1;
    	testPrimitiveShortArray = new short[]{1, 1};
    	testObjectShort = 1;
    	testObjectShortArray = new Short[]{1, 1};
    	testPrimitiveInt = 1;
    	testPrimitiveIntArray = new int[]{1, 1};
    	testObjectInt = 1;
    	testObjectIntArray = new Integer[]{1, 1};
    	testPrimitiveLong = 1L;
    	testPrimitiveLongArray = new long[]{1L, 1L};
    	testObjectLong = 1L;
    	testObjectLongArray = new Long[]{1L, 1L};
    	testPrimitiveFloat = 1F;
    	testPrimitiveFloatArray = new float[]{1F, 1F};
    	testObjectFloat = 1F;
    	testObjectFloatArray = new Float[]{1F, 1F};
    	testPrimitiveDouble = 1.0;
    	testPrimitiveDoubleArray = new double[]{1.0, 1.0};
    	testObjectDouble = 1.0;
    	testObjectDoubleArray = new Double[]{1.0, 1.0};
    	testPrimitiveByte = 1;
    	testPrimitiveByteArray = new byte[]{1, 1};
    	testObjectByte = 1;
    	testObjectByteArray = new Byte[]{1, 1};
    	testPrimitiveBoolean = false;
    	testPrimitiveBooleanArray = new boolean[]{false, false};
    	testObjectBoolean = false;
    	testObjectBooleanArray = new Boolean[]{false, false};
    	testPrimitiveChar = 'A';
    	testPrimitiveCharArray = new char[]{'A', 'A'};
    	testObjectChar = 'A';
    	testObjectCharArray = new Character[]{'A', 'A'};
    	testString = "A";
    	testStringArray = new String[]{"A", "A"};
    	testCharSequence = "A";
    	testCharSequenceArray = new CharSequence[]{"A", "A"};
    	testBundle = new Bundle();
    	testBundle.putInt("testBundle", 1);
    	testParcelable = new ParcelableObject(1);
    	ArrayList<ParcelableObject> tmpParcelableObjects = new ArrayList<ParcelableObject>();
    	tmpParcelableObjects.add(new ParcelableObject(1));
    	tmpParcelableObjects.add(new ParcelableObject(1));
    	testParcelables = new ParcelableObjects(tmpParcelableObjects);
    	testParcelableArray = new ParcelableObject[]{
    			new ParcelableObject(1), new ParcelableObject(1)
    	};
    	testSerializable = new SerializableObject(1);
    	testSparseArray = new SparseArray<ParcelableObject>();
    	testSparseArray.put(10, new ParcelableObject(1));
    	testSparseArray.put(20, new ParcelableObject(1));
    	testStringArrayList = new ArrayList<String>();
    	testStringArrayList.add("A");
    	testStringArrayList.add("A");
    	testIntegerArrayList = new ArrayList<Integer>();
    	testIntegerArrayList.add(new Integer(1));
    	testIntegerArrayList.add(new Integer(1));
    	testCharSequenceArrayList = new ArrayList<CharSequence>();
    	testCharSequenceArrayList.add("A");
    	testCharSequenceArrayList.add("A");
    	testParcelableArrayList = new ArrayList<Parcelable>();
    	testParcelableArrayList.add(new ParcelableObject(1));
    	testParcelableArrayList.add(new ParcelableObject(1));
    	testParentPublic = 1;
    	testParentProtected = 1;
    	testParentDefault = 1;
    	testNull = new ParcelableObject(1);
    	testEnum = TESTENUM.TESTENUM1;
//    	testNotSupportedBundleType = new NotSupportedBundleTypeObject(1);
    	testNotSupportedBundleTypeArrayList = new ArrayList<NotSupportedBundleTypeObject>();
    	testNotSupportedBundleTypeArrayList.add(new NotSupportedBundleTypeObject(1));
    }

    private void changeValue(){
    	testAccessModiferPublic = 2;
    	testAccessModiferProtected = 2;
    	testAccessModiferDefault = 2;
    	testAccessModiferPrivate = 2;
    	testAnnotationPresence = 2;
    	testAnnotationAbsence = 2;
    	testPrimitiveShort = 2;
    	testPrimitiveShortArray = new short[]{2, 2};
    	testObjectShort = 2;
    	testObjectShortArray = new Short[]{2, 2};
    	testPrimitiveInt = 2;
    	testPrimitiveIntArray = new int[]{2, 2};
    	testObjectInt = 2;
    	testObjectIntArray = new Integer[]{2, 2};
    	testPrimitiveLong = 2L;
    	testPrimitiveLongArray = new long[]{2L, 2L};
    	testObjectLong = 2L;
    	testObjectLongArray = new Long[]{2L, 2L};
    	testPrimitiveFloat = 2F;
    	testPrimitiveFloatArray = new float[]{2F, 2F};
    	testObjectFloat = 2F;
    	testObjectFloatArray = new Float[]{2F, 2F};
    	testPrimitiveDouble = 2.0;
    	testPrimitiveDoubleArray = new double[]{2.0, 2.0};
    	testObjectDouble = 2.0;
    	testObjectDoubleArray = new Double[]{2.0, 2.0};
    	testPrimitiveByte = 2;
    	testPrimitiveByteArray = new byte[]{2, 2};
    	testObjectByte = 2;
    	testObjectByteArray = new Byte[]{2, 2};
    	testPrimitiveBoolean = true;
    	testPrimitiveBooleanArray = new boolean[]{true, true};
    	testObjectBoolean = true;
    	testObjectBooleanArray = new Boolean[]{true, true};
    	testPrimitiveChar = 'B';
    	testPrimitiveCharArray = new char[]{'B', 'B'};
    	testObjectChar = 'B';
    	testObjectCharArray = new Character[]{'B', 'B'};
    	testString = "B";
    	testStringArray = new String[]{"B", "B"};
    	testCharSequence = "B";
    	testCharSequenceArray = new CharSequence[]{"B", "B"};
    	testBundle = new Bundle();
    	testBundle.putInt("testBundle", 2);
    	testParcelable = new ParcelableObject(2);
    	ArrayList<ParcelableObject> tmpParcelableObjects = new ArrayList<ParcelableObject>();
    	tmpParcelableObjects.add(new ParcelableObject(2));
    	tmpParcelableObjects.add(new ParcelableObject(2));
    	testParcelables = new ParcelableObjects(tmpParcelableObjects);
    	testParcelableArray = new ParcelableObject[]{
    			new ParcelableObject(2), new ParcelableObject(2)
    	};
    	testSerializable = new SerializableObject(2);
    	testSparseArray = new SparseArray<ParcelableObject>();
    	testSparseArray.put(10, new ParcelableObject(2));
    	testSparseArray.put(20, new ParcelableObject(2));
    	testStringArrayList = new ArrayList<String>();
    	testStringArrayList.add("B");
    	testStringArrayList.add("B");
    	testIntegerArrayList = new ArrayList<Integer>();
    	testIntegerArrayList.add(new Integer(2));
    	testIntegerArrayList.add(new Integer(2));
    	testCharSequenceArrayList = new ArrayList<CharSequence>();
    	testCharSequenceArrayList.add("B");
    	testCharSequenceArrayList.add("B");
    	testParcelableArrayList = new ArrayList<Parcelable>();
    	testParcelableArrayList.add(new ParcelableObject(2));
    	testParcelableArrayList.add(new ParcelableObject(2));
    	testParentPublic = 2;
    	testParentProtected = 2;
    	testParentDefault = 2;
    	testNull = null;
    	testEnum = TESTENUM.TESTENUM2;
//    	testNotSupportedBundleType = new NotSupportedBundleTypeObject(2);
    	testNotSupportedBundleTypeArrayList = new ArrayList<NotSupportedBundleTypeObject>();
    	testNotSupportedBundleTypeArrayList.add(new NotSupportedBundleTypeObject(1));
   }

    public short getTestPrimitiveShort(){
    	return testPrimitiveShort;
    }

    public short[] getTestPrimitiveShortArray(){
    	return testPrimitiveShortArray;
    }

    public Short getTestObjectShort(){
    	return testObjectShort;
    }

    public Short[] getTestObjectShortArray(){
    	return testObjectShortArray;
    }

    public int getTestPrimitiveInt(){
    	return testPrimitiveInt;
    }

    public int[] getTestPrimitiveIntArray(){
    	return testPrimitiveIntArray;
    }

    public Integer getTestObjectInt(){
    	return testObjectInt;
    }

    public Integer[] getTestObjectIntArray(){
    	return testObjectIntArray;
    }

    public long getTestPrimitiveLong(){
    	return testPrimitiveLong;
    }

    public long[] getTestPrimitiveLongArray(){
    	return testPrimitiveLongArray;
    }

    public Long getTestObjectLong(){
    	return testObjectLong;
    }

    public Long[] getTestObjectLongArray(){
    	return testObjectLongArray;
    }

    public float getTestPrimitiveFloat(){
    	return testPrimitiveFloat;
    }

    public float[] getTestPrimitiveFloatArray(){
    	return testPrimitiveFloatArray;
    }

    public Float getTestObjectFloat(){
    	return testObjectFloat;
    }

    public Float[] getTestObjectFloatArray(){
    	return testObjectFloatArray;
    }

    public double getTestPrimitiveDouble(){
    	return testPrimitiveDouble;
    }

    public double[] getTestPrimitiveDoubleArray(){
    	return testPrimitiveDoubleArray;
    }

    public Double getTestObjectDouble(){
    	return testObjectDouble;
    }

    public Double[] getTestObjectDoubleArray(){
    	return testObjectDoubleArray;
    }

    public byte getTestPrimitiveByte(){
    	return testPrimitiveByte;
    }

    public byte[] getTestPrimitiveByteArray(){
    	return testPrimitiveByteArray;
    }

    public Byte getTestObjectByte(){
    	return testObjectByte;
    }

    public Byte[] getTestObjectByteArray(){
    	return testObjectByteArray;
    }

    public boolean getTestPrimitiveBoolean(){
    	return testPrimitiveBoolean;
    }

    public boolean[] getTestPrimitiveBooleanArray(){
    	return testPrimitiveBooleanArray;
    }

    public Boolean getTestObjectBoolean(){
    	return testObjectBoolean;
    }

    public Boolean[] getTestObjectBooleanArray(){
    	return testObjectBooleanArray;
    }

    public char getTestPrimitiveChar(){
    	return testPrimitiveChar;
    }

    public char[] getTestPrimitiveCharArray(){
    	return testPrimitiveCharArray;
    }

    public Character getTestObjectChar(){
    	return testObjectChar;
    }

    public Character[] getTestObjectCharArray(){
    	return testObjectCharArray;
    }

    public String getTestString(){
    	return testString;
    }

    public String[] getTestStringArray(){
    	return testStringArray;
    }

    public CharSequence getTestCharSequence(){
    	return testCharSequence;
    }

    public CharSequence[] getTestCharSequenceArray(){
    	return testCharSequenceArray;
    }

    public Bundle getTestBundle(){
    	return testBundle;
    }

    public ParcelableObject getTestParcelable(){
    	return testParcelable;
    }

    public ParcelableObjects getTestParcelables(){
    	return testParcelables;
    }

    public ParcelableObject[] getTestParcelableArray(){
    	return testParcelableArray;
    }

    public SerializableObject getTestSerializable(){
    	return testSerializable;
    }

    public SparseArray<ParcelableObject> getTestSparceArray(){
    	return testSparseArray;
    }

    public ArrayList<String> getTestStringArrayList(){
    	return testStringArrayList;
    }

    public ArrayList<Integer> getTestIntegerArrayList(){
    	return testIntegerArrayList;
    }

    public ArrayList<CharSequence> getTestCharSequenceArrayList(){
    	return testCharSequenceArrayList;
    }

    public ArrayList<Parcelable> getTestParcelableArrayList(){
    	return testParcelableArrayList;
    }

    public TESTENUM getTestEnum() {
    	return testEnum;
    }

//    public NotSupportedBundleTypeObject getNotSupportedBundleType(){
//    	return testNotSupportedBundleType;
//    }

    public int[] getTestParents(){
    	return new int[]{
    			testParentPublic,
    			testParentProtected,
    			testParentDefault
    	};
    }

    public ParcelableObject getTestNull(){
    	return testNull;
    }

    public int[] getTestAccessModifers(){
    	return new int[]{
    			testAccessModiferPublic,
    			testAccessModiferProtected,
    			testAccessModiferDefault,
    			testAccessModiferPrivate
    	};
    }

    public int[] getTestAnnotations(){
    	return new int[]{
    			testAnnotationPresence,
    			testAnnotationAbsence
    	};
    }

    @Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		try{
			AutoBundleSaver.getAutoBundleSaver().save(outState, this);
		}catch(NotSupportedBundleTypeException e){
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		AutoBundleSaver.getAutoBundleSaver().restore(savedInstanceState, this);
	}


}