package org.austinharmreduction.ahrcclientdata;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

public class clientedit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        Integer id = extras.getInt("idchosen");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientedit);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getClientfromId(id);
        Button sitebutton = (Button) findViewById(R.id.sitebutton);
        sitebutton.setText(clients.get(0).getsite());

        Button sexbutton = (Button) findViewById(R.id.sexbutton);
        sexbutton.setText(clients.get(0).getgender());

        Button racebutton = (Button) findViewById(R.id.racebutton);
        racebutton.setText(clients.get(0).getrace());

        Button agebutton = (Button) findViewById(R.id.agebutton);
        agebutton.setText(clients.get(0).getage());

        Button inbutton = (Button) findViewById(R.id.inbutton);
        inbutton.setText(clients.get(0).getneedles_in());

        Button outbutton = (Button) findViewById(R.id.outbutton);
        outbutton.setText(clients.get(0).getneedles_out());

        Button typebutton = (Button) findViewById(R.id.typebutton);
        typebutton.setText(clients.get(0).gettype());

        Button insbutton = (Button) findViewById(R.id.insbutton);
        insbutton.setText(clients.get(0).getins());
    }
}