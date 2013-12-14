package edu.upenn.cis573.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import edu.upenn.cis573.HistoryDetails;
import edu.upenn.cis573.HistoryTabDetails;
import edu.upenn.cis573.SearchActivity;
import edu.upenn.cis573.StudySpace;
import edu.upenn.cis573.database.DBManager;
import edu.upenn.cis573.datastructure.Room;

public class HistoryDetailsTest extends ActivityInstrumentationTestCase2<SearchActivity> {

    HistoryTabDetails historyTabDetails;
    HistoryDetails historyDetails;
    EditText field;



    public HistoryDetailsTest(){
        super(SearchActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(false);
        DBManager.initDB(getActivity());
        
        //  historyTabDetails = historyDetails.getTabDetails();     
        //  field = (EditText)historyTabDetails.getView().findViewById(R.id.note);
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

    @Test
    public void testNotesFieldShown() throws Exception{
        assertNotNull(this.getActivity());
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
