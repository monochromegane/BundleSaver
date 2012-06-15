package dev.kuro.obi.bundlesaver.sample;

import android.app.Activity;
import dev.kuro.obi.bundlesaver.annotation.BundleTarget;

public class SampleParentActivity extends Activity {

	@BundleTarget
	public    int testParentPublic;
	@BundleTarget
	protected int testParentProtected;
	@BundleTarget
			  int testParentDefault;
	@BundleTarget
	private   int testParentPrivate;

}
