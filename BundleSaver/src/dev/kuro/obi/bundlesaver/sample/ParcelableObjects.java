package dev.kuro.obi.bundlesaver.sample;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableObjects implements Parcelable {

	private ArrayList<ParcelableObject> parcelableObjects;

	public ParcelableObjects(ArrayList<ParcelableObject> parcelableObjects){
		this.parcelableObjects = parcelableObjects;
	}

	public int getParcelableObjectsSize(){
		return parcelableObjects.size();
	}

	public ParcelableObject getParcelableObject(int index){
		return parcelableObjects.get(index);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(parcelableObjects);
	}

	public static final Parcelable.Creator<ParcelableObjects> CREATOR
    	= new Parcelable.Creator<ParcelableObjects>() {
		public ParcelableObjects createFromParcel(Parcel in) {
			return new ParcelableObjects(in.createTypedArrayList(ParcelableObject.CREATOR));
		}

		public ParcelableObjects[] newArray(int size) {
		    return new ParcelableObjects[size];
		}
	};

}
