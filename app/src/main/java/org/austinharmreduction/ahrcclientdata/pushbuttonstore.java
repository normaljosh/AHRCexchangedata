package org.austinharmreduction.ahrcclientdata;

import android.widget.Button;

/**
 * Created by Josh Leibowitz on 10/2/2016.
 */

// to store which button to edit
public class pushbuttonstore {
    private Button pushbuttonhold;
    public Button getpushbuttonhold() {return pushbuttonhold;}
    public void setpushbuttonhold(Button pushbuttonhold) {this.pushbuttonhold = pushbuttonhold;}
    private static final pushbuttonstore ourInstance = new pushbuttonstore();

    public static pushbuttonstore getInstance() {
        return ourInstance;
    }
    private pushbuttonstore() {
        // Exists only to defeat instantiation.
    }

}
