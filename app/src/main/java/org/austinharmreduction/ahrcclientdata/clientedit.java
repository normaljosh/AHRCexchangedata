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
        Button sexbutton = (Button) findViewById(R.id.sexbutton);
        Button racebutton = (Button) findViewById(R.id.racebutton);
        Button agebutton = (Button) findViewById(R.id.agebutton);
        Button inbutton = (Button) findViewById(R.id.inbutton);
        Button outbutton = (Button) findViewById(R.id.outbutton);
        Button typebutton = (Button) findViewById(R.id.typebutton);
        Button insbutton = (Button) findViewById(R.id.insbutton);
        sitebutton.setText(clients.get(0).getsite());
        sexbutton.setText(clients.get(0).getgender());
        racebutton.setText(clients.get(0).getrace());
        agebutton.setText(clients.get(0).getage());
        inbutton.setText(clients.get(0).getneedles_in());
        outbutton.setText(clients.get(0).getneedles_out());
        typebutton.setText(clients.get(0).gettype());
        insbutton.setText(clients.get(0).getins());
    }

    public void changebutton(View v) {
        Button sitebutton = (Button) findViewById(v.getId());
        pushbuttonstore.getInstance().setpushbuttonhold(sitebutton);
        ShowInput();
        SiteHolder.getInstance().setChangedhold(true);

    }

    public void changenumber(View v) {
        Button sitebutton = (Button) findViewById(v.getId());
        pushbuttonstore.getInstance().setpushbuttonhold(sitebutton);
        ShowNumber();
        SiteHolder.getInstance().setChangedhold(true);
    }


    public void cancelchanges(View v){
        Intent intent = new Intent(this, debugdata.class);
        startActivity(intent);
    }

    public void savechanges(View v){
        Bundle extras = getIntent().getExtras();
        Integer id = extras.getInt("idchosen");
        DBHandler db = new DBHandler(this);

        Button sitebutton = (Button) findViewById(R.id.sitebutton);
        db.updateclient(id, "Site", sitebutton.getText().toString());

        Button sexbutton = (Button) findViewById(R.id.sexbutton);
        db.updateclient(id, "Sex", sexbutton.getText().toString());

        Button racebutton = (Button) findViewById(R.id.racebutton);
        db.updateclient(id, "Race", racebutton.getText().toString());

        Button agebutton = (Button) findViewById(R.id.agebutton);
        db.updateclient(id, "Age", agebutton.getText().toString());

        Button inbutton = (Button) findViewById(R.id.inbutton);
        db.updateclient(id, "Units_In", inbutton.getText().toString());

        Button outbutton = (Button) findViewById(R.id.outbutton);
        db.updateclient(id, "Units_Out", outbutton.getText().toString());

        Button typebutton = (Button) findViewById(R.id.typebutton);
        db.updateclient(id, "Type", typebutton.getText().toString());

        Button insbutton = (Button) findViewById(R.id.insbutton);
        db.updateclient(id, "Insurance", insbutton.getText().toString());

        Intent intent = new Intent(this, debugdata.class);
        startActivity(intent);
    }




    protected void ShowInput() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(clientedit.this);
        View promptView = layoutInflater.inflate(R.layout.nameinput, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(clientedit.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    Button button = pushbuttonstore.getInstance().getpushbuttonhold();
                    public void onClick(DialogInterface dialog, int id) {
                        button.setText(editText.getText());
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
    protected void ShowNumber() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(clientedit.this);
        View promptView = layoutInflater.inflate(R.layout.numberinput, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(clientedit.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    Button button = pushbuttonstore.getInstance().getpushbuttonhold();
                    public void onClick(DialogInterface dialog, int id) {
                        button.setText(editText.getText());
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}