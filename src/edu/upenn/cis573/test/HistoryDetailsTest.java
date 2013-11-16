package edu.upenn.cis573.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import edu.upenn.cis573.HistoryDetails;
import edu.upenn.cis573.HistoryTabDetails;

public class HistoryDetailsTest extends ActivityInstrumentationTestCase2<HistoryDetails> {

	HistoryTabDetails historyTabDetails;
	HistoryDetails historyDetails;
	EditText field;
	
   

	public HistoryDetailsTest(){
		super("edu.upenn.cis573", HistoryDetails.class);
	}
	
    @Before
    public void setUp() throws Exception {
    	super.setUp();

	    setActivityInitialTouchMode(false);
	    historyDetails  = getActivity(); 
	  //  historyTabDetails = historyDetails.getTabDetails();     
	  //  field = (EditText)historyTabDetails.getView().findViewById(R.id.note);
    }

    @Test
    public void testNotesFieldShown() throws Exception{
    	assertNotNull(historyDetails);
    	//historyTabDetails = historyDetails.getTabDetails();
    	//field = (EditText)historyTabDetails.getView().findViewById(edu.upenn.cis573.R.id.note);
    	//assertNotNull(historyTabDetails);
    }
   
    /*
    @Test
    public void testNotesFieldShown() throws Exception{
    	//ViewAsserts.assertOnScreen(historyTabDetails.getView(), field);
    }
    
    @Test
    public void testCorrectContentNotesField() throws Exception{
    	//assertEquals(1, 1);
    }
    
    @Test
    public void testSuccessUpdateDb() throws Exception{
    	//assertEquals(1, 1);
    }
    */

}
