package edu.upenn.cis573.test;

import org.junit.Test;

import edu.upenn.cis573.EditNoteActivity;
import edu.upenn.cis573.HistoryListActivity;
import edu.upenn.cis573.SearchActivity;
import edu.upenn.cis573.StudySpace;
import edu.upenn.cis573.StudySpaceListActivity;
import edu.upenn.cis573.database.DBManager;
import edu.upenn.cis573.datastructure.Room;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TakeNotesTest extends
ActivityInstrumentationTestCase2<SearchActivity> {

    SearchActivity searchActivity;
    Button noteButton;

    public TakeNotesTest(){
        super("edu.upenn.cis573", SearchActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);

        searchActivity = getActivity();
        
        StudySpace mockHistory = new StudySpace(){
            public Room[] getRooms(){
                Room[] rooms = new Room[1];
                rooms[0] =new Room("A");
                return rooms; 
            }
        };
        DBManager.add(mockHistory);
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
        
        // Wait 2 seconds for the start of the activity
        EditNoteActivity startedEditNoteActivity = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        assertNotNull(startedEditNoteActivity);

        // Press back and click again
        this.sendKeys(KeyEvent.KEYCODE_BACK);

    }



}
