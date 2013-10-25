package edu.upenn.cis573.test;

import edu.upenn.cis573.HistoryListActivity;
import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistoryButtonsTest extends
    ActivityInstrumentationTestCase2<HistoryListActivity> {

  private static final String NEW_TEXT = "new text";

  public HistoryButtonsTest() {
    super(HistoryListActivity.class);
  }

  public void testSetText() throws Exception {

    HistoryListActivity activity = getActivity();
    /*
    // search for the textView
    final TextView textView = (TextView) activity
        .findViewById(edu.upenn.cis573.R.id.);

    // set text
    getActivity().runOnUiThread(new Runnable() {

      @Override
      public void run() {
        textView.setText(NEW_TEXT);
      }
    });
    
    getInstrumentation().waitForIdleSync();
    assertEquals("Text incorrect", NEW_TEXT, textView.getText().toString());

  }

  @UiThreadTest
  public void testSetTextWithAnnotation() throws Exception {

    SecondActivity activity = getActivity();

    // search for the textView
    final TextView textView = (TextView) activity
        .findViewById(R.id.resultText);

    textView.setText(NEW_TEXT);
    assertEquals("Text incorrect", NEW_TEXT, textView.getText().toString());
*/
  }

} 
