package dev.kuro.obi.bundlesaver.exception;

public class NotSupportedPreferenceTypeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Preferenceへ格納できない型を指定した場合にスローされる実行時例外です。
	 * @param type
	 */
	public NotSupportedPreferenceTypeException(Class<?> type){
		super("NotSupportedPreferenceType: " + type.getName());
	}

}
