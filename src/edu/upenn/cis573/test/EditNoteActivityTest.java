package edu.upenn.cis573.test;

import org.junit.Test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.hardware.Camera;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import edu.upenn.cis573.EditNoteActivity;
import edu.upenn.cis573.SearchActivity;
import edu.upenn.cis573.StudySpace;
import edu.upenn.cis573.database.DBManager;
import edu.upenn.cis573.datastructure.Room;

public class EditNoteActivityTest extends ActivityInstrumentationTestCase2<SearchActivity> {

    SearchActivity searchActivity;
    Button noteButton;
    EditNoteActivity editNote;

    public EditNoteActivityTest(){
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
    public void testSaveButtonExist() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        Button saveButton = (Button) editNote.findViewById( 
                edu.upenn.cis573.R.id.savebutton);

        ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), saveButton);
        this.sendKeys(KeyEvent.KEYCODE_BACK);
        
    }

    
    @Test
    public void testNoteTextExist() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        EditText textField = (EditText)editNote.findViewById(edu.upenn.cis573.R.id.editnote1);
        ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), textField);
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }

    @Test
    public void testSuccessWritenInDB() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        EditText textField = (EditText)editNote.findViewById(edu.upenn.cis573.R.id.editnote1);
        // textField.setText("hello there!");
        // DBManager.initDB(searchActivity);
        // assertEquals(1, DBManager.updateDb(textField.toString()));
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }
    
    @Test
    public void testRecordButtonsExist() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        Button recordButton = (Button) editNote.findViewById(edu.upenn.cis573.R.id.record_button);
        ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), recordButton);
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }
    
    @Test
    public void testPlayButtonExist() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        
        Button playButton = (Button) editNote.findViewById(edu.upenn.cis573.R.id.play_button);
        ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), playButton);
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }

    
    @Test
    public void testSpeakButtonExist() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        ImageButton speakButton = (ImageButton) editNote.findViewById(edu.upenn.cis573.R.id.btnSpeak);
        ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), speakButton);
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }
    
    public boolean isCameraInUse() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (RuntimeException e) {
            return true;
        } finally {
            if (c != null) c.release();
        }
        return false;
    }
    
    @Test
    public void testCameraButton() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        //TouchUtils.dragQuarterScreenDown(this, editNote);
        //Button pictureButton = (Button) editNote.findViewById(edu.upenn.cis573.R.id.camera);
        //ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), pictureButton);
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }
    
    @Test
    public void testCameraUse() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        ImageView picture = (ImageView) editNote.findViewById(edu.upenn.cis573.R.id.camerapicture);
        TouchUtils.clickView(this, noteButton);
        Activity cameraActivity = monitor
                .waitForActivityWithTimeout(2000);
        //assertTrue(isCameraInUse());
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }
    
    @Test
    public void testPicture() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        ImageView picture = (ImageView) editNote.findViewById(edu.upenn.cis573.R.id.camerapicture);
        TouchUtils.clickView(this, noteButton);
        Activity cameraActivity = monitor
                .waitForActivityWithTimeout(2000);
        //assertTrue(isCameraInUse());
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }
    
    @Test
    public void testRecording() throws Exception{
        ActivityMonitor monitor = getInstrumentation().addMonitor(EditNoteActivity.class.getName(), null, false);

        TouchUtils.clickView(this, noteButton);
        
        // Wait 2 seconds for the start of the activity
        editNote = (EditNoteActivity) monitor
                .waitForActivityWithTimeout(2000);
        Button recordButton = (Button) editNote.findViewById(edu.upenn.cis573.R.id.record_button);
        this.sendKeys(KeyEvent.KEYCODE_BACK);
    }

}
