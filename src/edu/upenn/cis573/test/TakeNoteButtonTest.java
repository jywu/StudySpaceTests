package edu.upenn.cis573.test;

import org.junit.Test;

import edu.upenn.cis573.EditNoteActivity;
import edu.upenn.cis573.SearchActivity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.widget.Button;

public class TakeNoteButtonTest extends
		ActivityInstrumentationTestCase2<SearchActivity> {

	SearchActivity searchActivity;
	Button noteButton;
	
	public TakeNoteButtonTest(){
		super("edu.upenn.cis573", SearchActivity.class);
	}
	
	 @Override
	  protected void setUp() throws Exception {
	    super.setUp();

	    setActivityInitialTouchMode(false);

	    searchActivity = getActivity();    
	    noteButton = (Button) searchActivity.findViewById( 
				 edu.upenn.cis573.R.id.notebutton );
	  }
	 
	 @Test
	 public void testNoteButtonExist() throws Exception{
		 ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), noteButton);
	 }
	 
	 @Test
	 public void testStartEditNoteActivity() throws Exception{
		 ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);
		 
		
	     TouchUtils.clickView(this, noteButton);

	        // To click on a click, e.g. in a listview
	        // listView.getChildAt(0);

	        // Wait 2 seconds for the start of the activity
	        
	        EditNoteActivity startedActivity = (EditNoteActivity) monitor
	            .waitForActivityWithTimeout(2000);
	        assertNotNull(startedActivity);
	        
	        // Press back and click again
	        this.sendKeys(KeyEvent.KEYCODE_BACK);
	        TouchUtils.clickView(this, noteButton);
		 
	 }
	
}
