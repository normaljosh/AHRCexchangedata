package org.austinharmreduction.ahrcclientdata;

import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by Josh Leibowitz on 10/2/2016.
 */

// to store which button to edit
public class buttonstore {
    private RadioButton buttonhold;
    public RadioButton getbuttonhold() {return buttonhold;}
    public void setbuttonhold(RadioButton buttonhold) {this.buttonhold = buttonhold;}
    private static final buttonstore ourInstance = new buttonstore();

    public static buttonstore getInstance() {
        return ourInstance;
    }
    private buttonstore() {
        // Exists only to defeat instantiation.
    }

}
