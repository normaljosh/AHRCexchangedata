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

public class DBEnter extends AppCompatActivity {
    //This class creates the database if it doesn't exist, and writes all the data we've collected to a database.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbenter);
        Bundle extras = getIntent().getExtras();
        //getting all the values entered previously
        if (extras != null) {
            String staff = SiteHolder.getInstance().getstaffhold();
            String site = SiteHolder.getInstance().getsitehold();
            String gender = extras.getString("genderchosen");
            String race = extras.getString("racechosen");
            String age = extras.getString("agechosen");
            String needles_in = extras.getString("inchosen");
            String needles_out = extras.getString("outchosen");
            String type = extras.getString("typechosen");
            String ins = extras.getString("inschosen");
            String comment = extras.getString("commentchosen");
            //this bool chooses whether we go to the main menu, or back to the "enter client screen"
            boolean mainmenu = extras.getBoolean("mainmenu");
            TextView text = (TextView) findViewById(R.id.textView6);
            String display = "Race: " + race + " Gender:" + gender + "Staff:" + staff + "Site:" + site
                    + "Needles in: " + needles_in + "Needles out:" + needles_out + "Age:" + age
                    + "Type:" + type + "insurance:" + ins + "mainmenu " + mainmenu;
            text.setText(display);

        //initialize database
        DBHandler db = new DBHandler(this);

        // Inserting Client/Rows
        db.addClient(new ClientFormat(staff, site, gender, race, age, needles_in, needles_out, type, ins, comment));


            Intent path1 = new Intent(this, EnterClient.class);
            Intent path2 = new Intent(this, MainActivity.class);
            if (mainmenu)
            startActivity(path2);
            else startActivity(path1);
    }
    }


        /** Called when the user clicks the See Database button */

    public void seedatabase(View view) {
        Intent intent = new Intent(this, AndroidDatabaseManager.class);
        startActivity(intent); //go to enter client
    }

    /**
     * Called when the user clicks the Enter Client button
     */
    public void Enter(View view) {
        Intent intent = new Intent(this, EnterClient.class);
        startActivity(intent); //go to enter client
    }
}
