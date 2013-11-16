package edu.upenn.cis573.test;

import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;
import edu.upenn.cis573.EditNoteActivity;
import edu.upenn.cis573.SearchActivity;
import edu.upenn.cis573.database.DBManager;

public class EditNoteActivityTest extends ActivityInstrumentationTestCase2<EditNoteActivity> {

	SearchActivity searchActivity;
	EditNoteActivity editNote;
	
	public EditNoteActivityTest(){
		super("edu.upenn.cis573", EditNoteActivity.class);
	}
	
	 @Override
	  protected void setUp() throws Exception {
	    super.setUp();

	    setActivityInitialTouchMode(false);

	    editNote = getActivity();    
	  }
	 
	 @Test
	 public void testSaveButtonExist() throws Exception{
		 Button saveButton = (Button) editNote.findViewById( 
				 edu.upenn.cis573.R.id.savebutton);

		 ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), saveButton);
	 }
	 
	 @Test
	 public void testNoteTextExist() throws Exception{
		 EditText textField = (EditText)editNote.findViewById(edu.upenn.cis573.R.id.editnote1);
		 ViewAsserts.assertOnScreen(this.getActivity().getWindow().getDecorView(), textField);
		 
		
		
	 }
	 
	 @Test
	 public void testSuccessWritenInDB() throws Exception{
		 EditText textField = (EditText)editNote.findViewById(edu.upenn.cis573.R.id.editnote1);
		// textField.setText("hello there!");
		// DBManager.initDB(searchActivity);
		// assertEquals(1, DBManager.updateDb(textField.toString()));
	 }
	 
}
