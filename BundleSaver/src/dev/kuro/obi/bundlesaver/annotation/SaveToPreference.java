package dev.kuro.obi.bundlesaver.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SaveToPreference {

	public enum To {
		Bundle,
		Preference
	}

	To[] save() default To.Bundle;

}
