package dev.kuro.obi.bundlesaver.sample;

import android.app.Activity;
import dev.kuro.obi.bundlesaver.annotation.SaveToBundle;

public class SampleParentActivity extends Activity {

	@SaveToBundle
	public    int testParentPublic;
	@SaveToBundle
	protected int testParentProtected;
	@SaveToBundle
			  int testParentDefault;
	@SaveToBundle
	private   int testParentPrivate;

}
