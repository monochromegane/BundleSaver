package dev.kuro.obi.bundlesaver;

public interface SaverBehivor {
	Class<?> getTargetAnnotation();
	void put(String key, Object fieldObject);
	Object get(String key, Class<?> type);
}
