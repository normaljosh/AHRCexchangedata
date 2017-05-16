package org.austinharmreduction.ahrcclientdata;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
//This is the main page, code here mostly controls buttons to go to different apps

public class MainActivity extends AppCompatActivity {
        //On Create statement, making a standard instance
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

    //gsgfd
    /** Called when the user clicks the See Database button, starts the AndroidDatabaseManager*/
    public void seedatabase(View view) {
        Intent intent = new Intent(this, debugdata.class);
        startActivity(intent); //go to enter client
    }
    public void debugdata(View view) {
        Intent intent = new Intent(this, AndroidDatabaseManager.class);
        startActivity(intent); //go to enter client
    }

    /** Called when the user clicks the Enter Client button */
    public void Enter(View view) {
        /**Here it's checking to see if we've already entered the staff and site that the data's
         * being entered in. If we haven't yet, it will prompt before we can enter client data*/
        String staff = SiteHolder.getInstance().getstaffhold();
        String site = SiteHolder.getInstance().getsitehold();
        Calendar date = SiteHolder.getInstance().getdatehold();
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        //If no site, goes to "site change" screen
        if (site == null){
            Toast toast = Toast.makeText(context, "please enter site", duration);
            toast.show();
            Intent intent = new Intent(this, SiteChange.class);
            startActivity(intent); //go to enter client
            finish();
        }
        //If no staff, goes to "site change" screen
        if (staff == null){
            Toast toast = Toast.makeText(context, "please enter data inputer", duration);
            toast.show();
            Intent intent = new Intent(this, SiteChange.class);
            startActivity(intent); //go to enter client
            finish();
        }
        //if everything's full, ok to enter the client
        if (date != null){
            Intent intent = new Intent(this, EnterClient.class);
            startActivity(intent); //go to enter client
        }
    }

    /** Called when the user clicks the write to csv button, this is the screen to email the data */
    public void csvwrite(View view) {
        Intent intent = new Intent(this, EmailCSV.class);
        startActivity(intent); //go to enter client
    }

    /** debug, no button currently exists for this*/
    public void debugsecondaries(View view) {
        Intent intent = new Intent(this, Secondaries.class);
        startActivity(intent); //go to site change
    }
    /** Called when the user clicks the site change button */
    public void SiteChange(View view) {
        Intent intent = new Intent(this, SiteChange.class);
        startActivity(intent); //go to site change
    }
}