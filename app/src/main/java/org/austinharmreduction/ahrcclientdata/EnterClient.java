package org.austinharmreduction.ahrcclientdata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EnterClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterclient);
    }
    public static String gender; // store the text corresponding to  the gender radiobutton, can be called as EnterClient.gender
    public static String race; //store the text corresponding to the race radiobutton can be called as EnterClient.race
    public static String age; //store the text corresponding to the age radiobutton can be called as EnterClient.race

    public void OnGenderButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.gen1:
                if (checked)
                    gender = getResources().getString(R.string.gen1);
                break;
            case R.id.gen2:
                if (checked)
                    gender = getResources().getString(R.string.gen2);
                break;
            case R.id.gen3:
                if (checked)
                    gender = getResources().getString(R.string.gen3);
                break;
            case R.id.gen4:
                if (checked)
                    gender = getResources().getString(R.string.gen4);
                break;
            case R.id.OtherGender:
                RadioButton fish = (RadioButton) findViewById(R.id.OtherGender);
                if (checked)
                    buttonstore.getInstance().setbuttonhold(fish);//set this as the radiobutton to be changed by the showinput function
                ShowInput();//see below function, this lets us rename the text of the button
                gender = getResources().getString(R.string.reset);//setting the value to "reset" lets us change the value to the text  of the button
                break;
        }


    }

    public void onRaceButtonClicked(View view) {
        // Is the race button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.race1:
                if (checked)
                    race = getResources().getString(R.string.race1);
                break;
            case R.id.race2:
                if (checked)
                    race = getResources().getString(R.string.race2);
                break;
            case R.id.race3:
                if (checked)
                    race = getResources().getString(R.string.race3);
                break;
            case R.id.race4:
                if (checked)
                    race = getResources().getString(R.string.race4);
                break;
            case R.id.race5:
                if (checked)
                    race = getResources().getString(R.string.race5);
                break;
            case R.id.race6:
                if (checked)
                    race = getResources().getString(R.string.race6);
                break;
            case R.id.OtherRace:
                RadioButton fish = (RadioButton) findViewById(R.id.OtherRace);
                if (checked)
                    buttonstore.getInstance().setbuttonhold(fish);//set this as the radiobutton to be changed by the showinput function
                ShowInput();//see below function, this lets us rename the text of the button
                //setting the value to "reset" lets us change the value to the text  of the button
                race = getResources().getString(R.string.reset);
                break;

        }
        
}
    public void onAgeButtonClicked(View view) {
        // Is the race button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.age1:
                if (checked)
                    age = getResources().getString(R.string.age1);
                break;
            case R.id.age2:
                if (checked)
                    age = getResources().getString(R.string.age2);
                break;
            case R.id.age3:
                if (checked)
                    age = getResources().getString(R.string.age3);
                break;
            case R.id.age4:
                if (checked)
                    age = getResources().getString(R.string.age4);
                break;
            case R.id.age5:
                if (checked)
                    age = getResources().getString(R.string.age5);
                break;
            case R.id.age6:
                if (checked)
                    age = getResources().getString(R.string.age6);
                break;
            case R.id.age7:
                if (checked)
                    age = getResources().getString(R.string.age7);
                break;
            case R.id.age8:
                if (checked)
                    age = getResources().getString(R.string.age8);
                break;
            case R.id.age9:
                if (checked)
                    age = getResources().getString(R.string.age9);
                break;
            case R.id.age10:
                if (checked)
                    age = getResources().getString(R.string.age10);
                break;
            case R.id.age11:
                if (checked)
                    age = getResources().getString(R.string.age11);
                break;
            case R.id.age12:
                if (checked)
                    age = getResources().getString(R.string.age11);
                break;

        }
    }
    /** Called when the user clicks the Send button */
    public void NextScreen(View view) {
        //validate that gender, race, age have all been checked
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        RadioGroup gendergroup = (RadioGroup)findViewById(R.id.genderGroup);
        RadioGroup agegroup = (RadioGroup)findViewById(R.id.AgeGroup);
        RadioGroup racegroup = (RadioGroup)findViewById(R.id.RaceGroup);
    //make warning pop up if gender, age, or race aren't checked, and prevent going to next screen
        if (gendergroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter gender", duration);
            toast.show();
            return;
        }
        if (racegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter race", duration);
            toast.show();
            return;
        }
        if (agegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter age", duration);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, needles.class);
        RadioButton button = (RadioButton) findViewById(R.id.OtherGender);
        RadioButton RaceButton = (RadioButton) findViewById(R.id.OtherRace);
        //setting the gender and race fields to what you changed them to earlier
        if  (gender == getResources().getString(R.string.reset))
            gender = button.getText().toString();
        if (race == getResources().getString(R.string.reset))
            race = RaceButton.getText().toString();
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("agechosen", age); // pass race to the next Activity
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