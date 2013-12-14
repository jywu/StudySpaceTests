package edu.upenn.cis573.test;

import java.util.ArrayList;

import org.junit.Before;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.IntentFilter;
import android.test.ActivityInstrumentationTestCase2;
import edu.upenn.cis573.StudySpace;
import edu.upenn.cis573.StudySpaceListActivity;

public class StudySpaceListActivityTest extends
		ActivityInstrumentationTestCase2<StudySpaceListActivity> {

	public StudySpaceListActivityTest() {
		super("edu.upenn.cis573", StudySpaceListActivity.class);
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
	}

	public void testListSize() {
	    final Instrumentation inst = getInstrumentation();
	    final IntentFilter intentFilter = new IntentFilter();
	    ActivityMonitor monitor = inst.addMonitor(intentFilter, null, false);
	    assertEquals(0, monitor.getHits());

	    inst.removeMonitor(monitor);
	}

}
