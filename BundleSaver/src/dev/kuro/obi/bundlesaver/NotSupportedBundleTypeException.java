package dev.kuro.obi.bundlesaver;

public class NotSupportedBundleTypeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Bundleへ格納できない型を指定した場合にスローされる実行時例外です。
	 * @param type
	 */
	public NotSupportedBundleTypeException(Class<?> type){
		super("NotSupportedBundleType: " + type.getName());
	}

}
