package edu.upenn.cis573.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.upenn.cis573.HistoryListActivity;
import edu.upenn.cis573.SearchActivity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class HistoryListActivityTest extends
ActivityInstrumentationTestCase2<SearchActivity>{
    
    public HistoryListActivityTest() {
        super(SearchActivity.class);
    }
    
    public HistoryListActivityTest(Class<SearchActivity> activityClass) {
        super(activityClass);
        // TODO Auto-generated constructor stub
    }

    private SearchActivity mActivity;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        super.setUp(); 
        mActivity = getActivity();
    }

    /*
    public void testRetrievedHistory() {
        int expectedLength = DBManager.query().size();
        SearchActivity _listActivity = getActivity();
        assertEquals("Mismatch between database and retrieved history",expectedLength, _listActivity.getListAdapter().getCount());
    }*/
    
    @Test
    public void testStartSecondActivity() throws Exception {
        
        // add monitor to check for the second activity
        ActivityMonitor monitor = getInstrumentation().addMonitor(HistoryListActivity.class.getName(), null, false);

        // find button and click it
        Button history = (Button) mActivity.findViewById(edu.upenn.cis573.R.id.historyButton);
        TouchUtils.clickView(this, history);

        // To click on a click, e.g. in a listview
        // listView.getChildAt(0);

        // Wait 2 seconds for the start of the activity
        
        HistoryListActivity startedActivity = (HistoryListActivity) monitor
            .waitForActivityWithTimeout(2000);
        assertNotNull(startedActivity);
        

        // Search for the textView 
        TextView textView = (TextView) mActivity.findViewById(edu.upenn.cis573.R.id.clearHistoryButton);
        
        // check that the TextView is on the screen
        ViewAsserts.assertOnScreen(startedActivity.getWindow().getDecorView(),
            textView);
        
        // Validate the text on the TextView
        assertEquals("Text incorrect", "Clear History", textView.getText().toString());
        
        // Press back and click again
        this.sendKeys(KeyEvent.KEYCODE_BACK);
        TouchUtils.clickView(this, history);

      }

}



