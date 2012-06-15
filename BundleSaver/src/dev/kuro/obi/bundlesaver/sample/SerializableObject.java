package dev.kuro.obi.bundlesaver.sample;

import java.io.Serializable;

public class SerializableObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private int testSerializable;

	public SerializableObject(int testSerializable){
		this.testSerializable = testSerializable;
	}

	public int getTestSerializable(){
		return testSerializable;
	}

}
