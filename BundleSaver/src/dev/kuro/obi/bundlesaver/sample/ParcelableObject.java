package dev.kuro.obi.bundlesaver.sample;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableObject implements Parcelable {

	private int testParcelable;

	public ParcelableObject(int testParcelable){
		setTestParcelable(testParcelable);
	}

	public void setTestParcelable(int testParcelable){
		this.testParcelable = testParcelable;
	}

	public int getTestParcelable(){
		return testParcelable;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(testParcelable);
	}

	public static final Parcelable.Creator<ParcelableObject> CREATOR
		= new Parcelable.Creator<ParcelableObject>() {
		public ParcelableObject createFromParcel(Parcel in) {
			return new ParcelableObject(in.readInt());
		}

		public ParcelableObject[] newArray(int size) {
			return new ParcelableObject[size];
		}
	};

}
