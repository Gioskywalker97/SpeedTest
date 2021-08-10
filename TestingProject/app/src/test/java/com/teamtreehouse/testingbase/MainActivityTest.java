package com.teamtreehouse.testingbase;

import static org.junit.Assert.assertEquals;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.apache.tools.ant.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
//@Config( = BuildConfig.class, sdk = Build.VERSION_CODES.M)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);

    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
        //Arrange
        String givenString = "test123";
        activity.editText.setText(givenString);

        //Act
        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        //Assert
        String actualString = activity.textView.getText().toString();
        assertEquals(givenString, actualString);

    }

    @Test
    public void spinnerUpdateBackgroundColor() throws Exception {
        // Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // Act
        activity.colorSpinner.setSelection(index);

        // Assert
        int expectedColor = ((ColorDrawable)activity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, expectedColor);
    }
}
