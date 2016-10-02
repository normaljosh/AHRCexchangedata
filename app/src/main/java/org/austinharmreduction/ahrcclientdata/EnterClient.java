package org.austinharmreduction.ahrcclientdata;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class EnterClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterclient);
    }
    public static String gender; // store the text corresponding to  the gender radiobutton, can be called as EnterClient.gender
    public static String race; //store the text corresponding to the race radiobutton can be called as EnterClient.race


    public void onGenderButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Male:
                if (checked)
                    gender = "Male";
                break;
            case R.id.Female:
                if (checked)
                    gender = "Female";
                break;
            case R.id.Other:
                RadioButton fish = (RadioButton) findViewById(R.id.Other);
                if (checked)
                    //set this as the radiobutton to be changed by the showinput function
                    buttonstore.getInstance().setbuttonhold(fish);
                    ShowInput();
                gender = "reset"; //this lets us pass the new gender when nextscreen is clicked
                break;

        }


    }

    public void onRaceButtonClicked(View view) {
        // Is the race button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.White:
                if (checked)
                    race = "White";
                break;
            case R.id.Black:
                if (checked)
                    race = "Black";
                break;
            case R.id.Hispanic:
                if (checked)
                    race = "Hispanic";
                break;
            case R.id.OtherRace:
                RadioButton fish = (RadioButton) findViewById(R.id.OtherRace);
                if (checked)
                    buttonstore.getInstance().setbuttonhold(fish);//set this as the radiobutton to be changed by the showinput function
                ShowInput();
                race = "reset";
                break;

        }
}

    /** Called when the user clicks the Send button */
    public void NextScreen(View view) {
        Intent intent = new Intent(this, needles.class);
        RadioButton button = (RadioButton) findViewById(R.id.Other);
        RadioButton RaceButton = (RadioButton) findViewById(R.id.OtherRace);
        if  (gender == "reset")
            gender = button.getText().toString();
        if (race == "reset")
            race = RaceButton.getText().toString();
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        startActivity(intent);
    }
//this function serves to change the input text for an "other" button, and store that as the item
    protected void ShowInput() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(EnterClient.this);
        View promptView = layoutInflater.inflate(R.layout.staffinput, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EnterClient.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    RadioButton button = buttonstore.getInstance().getbuttonhold();
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