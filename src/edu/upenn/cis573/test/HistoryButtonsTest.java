package edu.upenn.cis573.test;

import edu.upenn.cis573.EditNoteActivity;
import edu.upenn.cis573.HistoryListActivity;
import edu.upenn.cis573.SearchActivity;
import edu.upenn.cis573.StudySpace;
import edu.upenn.cis573.database.DBManager;
import edu.upenn.cis573.datastructure.Room;
import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistoryButtonsTest extends
    ActivityInstrumentationTestCase2<SearchActivity> {
    SearchActivity searchActivity;
    View history;
    HistoryListActivity historyList;

    public HistoryButtonsTest(){
        super("edu.upenn.cis573", SearchActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);

        searchActivity = getActivity();
        
        history = (View) searchActivity.findViewById( 
                edu.upenn.cis573.R.id.historyButton );
        
        DBManager.initDB(getActivity());
        StudySpace mockHistory = new StudySpace(){
            public Room[] getRooms(){
                Room[] rooms = new Room[1];
                rooms[0] =new Room("A");
                return rooms; 
            }
            public String getBuildingName() {
                return "BuildingName";
            }
            public String getSpaceName() {
                return "SpaceName";
            }
            public String getPrivacy() {
                return "S";
            }
            public int getMaximumOccupancy() {
                return 100;
            }
            public boolean hasComputer() {
                return false;
            }
            public boolean has_big_screen() {
                return false;
            }
            
            public int getMonth() {
                return 10;
            }

            public int getYear() {
                return 1990;
            }
            
            public int getGroupSize() {
                return 2;
            }
            
            public int getStartHour() {
                return 10;
            }

            public int getEndHour() {
                return 11;
            }
            
            public int getStartMin() {
                return 10;
            }

            public int getEndMin() {
                return 20;
            }
            
            public int getStartDate() {
                return 10;
            }
            
            public int getEndDate() {
                return 10;
            }
            public double getDistance(){
                return 1.0;
            }

            public double getSpaceLatitude() {
                return 1.0;
            }

            public double getSpaceLongitude() {
                return 1.0;
            }

            public int getNumberOfRooms() {
                return 1;
            }

            public String getReserveType() {
                return "N";
            }

            public String getComments() {
                return "";
            }
            
            public String getRoomNames() {
                return "roomname";
            }
        };

        DBManager.add(mockHistory);
        
    }

  public void testHistoryEntry() throws Exception {
      ActivityMonitor monitor = getInstrumentation().addMonitor(HistoryListActivity.class.getName(), null, false);


  }

} 
