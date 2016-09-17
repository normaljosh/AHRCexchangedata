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
    //stuff from mysql example

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbenter);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gender = extras.getString("genderchosen");
            String race = extras.getString("racechosen");
            String needles_in = extras.getString("inchosen");
            String needles_out = extras.getString("outchosen");
            TextView text = (TextView) findViewById(R.id.textView6);
            String display = "Race: " + race + " Gender:" + gender + "Needles in: " + needles_in + "Needles out:" + needles_out;
            text.setText(display);

        //initialize database
        DBHandler db = new DBHandler(this);

        // Inserting Client/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addClient(new ClientFormat(race, gender,  needles_in, needles_out));
        // Reading all clients
        Log.d("Reading: ", "Reading all clients..");
        List<ClientFormat> clients = db.getAllClients();

        for (ClientFormat client : clients) {
            String log = "Id: " + client.getid() + " ,Race: " + client.getrace() + " ,Gender: "
                    + client.getgender() + ",Needles In: " + client.getneedles_in() + " ,Needles Out: "
                    + client.getneedles_out();
            // Writing clients  to log
            Log.d("Client: : ", log);

        }





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
