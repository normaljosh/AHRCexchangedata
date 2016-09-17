package org.austinharmreduction.ahrcclientdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
        //stuff from mysql example
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    /** Called when the user clicks the See Database button */
    public void seedatabase(View view) {
        Intent intent = new Intent(this, AndroidDatabaseManager.class);
        startActivity(intent); //go to enter client
    }

    /** Called when the user clicks the Enter Client button */
    public void Enter(View view) {
        Intent intent = new Intent(this, EnterClient.class);
        startActivity(intent); //go to enter client
    }
}