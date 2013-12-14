package edu.upenn.cis573.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.upenn.cis573.HistoryListActivity;
import edu.upenn.cis573.SearchActivity;
import edu.upenn.cis573.database.DBManager;
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

    
    public void testRetrievedHistory() {
        int expectedLength = DBManager.query().size();
        //SearchActivity _listActivity = getActivity();
        //assertEquals("Mismatch between database and retrieved history",expectedLength, _listActivity.getListAdapter().getCount());
    }
    

}



