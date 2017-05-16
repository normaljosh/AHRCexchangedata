package org.austinharmreduction.ahrcclientdata;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Context;
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
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.austinharmreduction.ahrcclientdata.ClientFormat;
import org.austinharmreduction.ahrcclientdata.DBHandler;
import org.austinharmreduction.ahrcclientdata.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;



/**
 * Created by Josh Leibowitz on 5/7/2017.
 */



public class debugdata extends AppCompatActivity {
    public Integer offset;
    public Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugdata);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(0);
        offset = 0;
        Button Displaybutton = (Button) findViewById(R.id.showrowbutton);
        Displaybutton.setText(stringfromclient(clients.get(0)));

        Button Displaybutton2 = (Button) findViewById(R.id.showrowbutton2);
        Displaybutton2.setText(stringfromclient(clients.get(1)));

        Button Displaybutton3 = (Button) findViewById(R.id.showrowbutton3);
        Displaybutton3.setText(stringfromclient(clients.get(2)));

        Button Displaybutton4 = (Button) findViewById(R.id.showrowbutton4);
        Displaybutton4.setText(stringfromclient(clients.get(3)));

        Button Displaybutton5 = (Button) findViewById(R.id.showrowbutton5);
        Displaybutton5.setText(stringfromclient(clients.get(4)));

    }
    public void nextbutton( View view) {
        offset = offset + 5;
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(offset);
        Button Displaybutton = (Button) findViewById(R.id.showrowbutton);
        Displaybutton.setText(stringfromclient(clients.get(0)));

        Button Displaybutton2 = (Button) findViewById(R.id.showrowbutton2);
        Displaybutton2.setText(stringfromclient(clients.get(1)));

        Button Displaybutton3 = (Button) findViewById(R.id.showrowbutton3);
        Displaybutton3.setText(stringfromclient(clients.get(2)));

        Button Displaybutton4 = (Button) findViewById(R.id.showrowbutton4);
        Displaybutton4.setText(stringfromclient(clients.get(3)));

        Button Displaybutton5 = (Button) findViewById(R.id.showrowbutton5);
        Displaybutton5.setText(stringfromclient(clients.get(4)));
    }
    public void prevbutton( View view) {
        if(offset > 4) {
            offset = offset - 5;
        }
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(offset);
        Button Displaybutton = (Button) findViewById(R.id.showrowbutton);
        Displaybutton.setText(stringfromclient(clients.get(0)));

        Button Displaybutton2 = (Button) findViewById(R.id.showrowbutton2);
        Displaybutton2.setText(stringfromclient(clients.get(1)));

        Button Displaybutton3 = (Button) findViewById(R.id.showrowbutton3);
        Displaybutton3.setText(stringfromclient(clients.get(2)));

        Button Displaybutton4 = (Button) findViewById(R.id.showrowbutton4);
        Displaybutton4.setText(stringfromclient(clients.get(3)));

        Button Displaybutton5 = (Button) findViewById(R.id.showrowbutton5);
        Displaybutton5.setText(stringfromclient(clients.get(4)));
    }






//gets string to display from a client object
public static String stringfromclient( ClientFormat grabclient){
    String babystring = "Site: "
            + grabclient.getsite() + "   Sex:"
            + grabclient.getgender() + "  Race: "
            + grabclient.getrace() + "  Age: "
            + grabclient.getage() + "\n" + "  Needles In: "
            + grabclient.getneedles_in() + "  Needles Out: "
            + grabclient.getneedles_out() + "  Type: "
            + grabclient.gettype() + "  Ins: "
            + grabclient.getins();
    return babystring;
};







    //this function serves to change the input text for an "other" button, and store that as the item
    protected void changeclient1(View view) {
        Intent intent = new Intent(this, clientedit.class);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(offset);
        id = clients.get(0).getid();
        intent.putExtra("idchosen", id);
        startActivity(intent); //go to enter client
    }

    //this function serves to change the input text for an "other" button, and store that as the item
    protected void changeclient2(View view) {
        Intent intent = new Intent(this, clientedit.class);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(offset);
        id = clients.get(1).getid();
        intent.putExtra("idchosen", id);
        startActivity(intent); //go to enter client
    }

    //this function serves to change the input text for an "other" button, and store that as the item
    protected void changeclient3(View view) {
        Intent intent = new Intent(this, clientedit.class);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(offset);
        id = clients.get(2).getid();
        intent.putExtra("idchosen", id);
        startActivity(intent); //go to enter client
    }

    //this function serves to change the input text for an "other" button, and store that as the item
    protected void changeclient4(View view) {
        Intent intent = new Intent(this, clientedit.class);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(offset);
        id = clients.get(3).getid();
        intent.putExtra("idchosen", id);
        startActivity(intent); //go to enter client
    }

    //this function serves to change the input text for an "other" button, and store that as the item
    protected void changeclient5(View view) {
        Intent intent = new Intent(this, clientedit.class);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getLastClients(offset);
        id = clients.get(4).getid();
        intent.putExtra("idchosen", id);
        startActivity(intent); //go to enter client
    }

    public void gotomain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

























}