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
import java.util.Calendar;

/*this is the first screen where we enter client data ("needles" is the second screen... I need to
retitle that at some point...
 */
public class EnterClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterclient);
        Calendar date = SiteHolder.getInstance().getdatehold();
        //warning message if more than 7 minutes since last entered in client (In case the site has changed)
        if(Calendar.getInstance().getTimeInMillis() - date.getTimeInMillis()> 300000){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Confirm Site");
            builder.setMessage("Is the current site still " + SiteHolder.getInstance().getsitehold() +"?");

            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    //reset 7 minute timer
                    SiteHolder.getInstance().setdatehold(Calendar.getInstance());
                    dialog.dismiss();
                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // Do nothing
                    Intent intent = new Intent(EnterClient.this, SiteChange.class);
                    startActivity(intent); //go to enter client
                    dialog.dismiss();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
        }

    }
    public static String needles_in; // store the text corresponding to  the gender radiobutton, can be called as EnterClient.gender
    public static String race; //store the text corresponding to the race radiobutton can be called as EnterClient.race
    public static String needles_out; //store the text corresponding to the age radiobutton can be called as EnterClient.race

    public void onInButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.in1:
                if (checked)
                    needles_in = getResources().getString(R.string.in1);
                break;
            case R.id.in2:
                if (checked)
                    needles_in = getResources().getString(R.string.in2);
                break;
            case R.id.in3:
                if (checked)
                    needles_in = getResources().getString(R.string.in3);
                break;
            case R.id.in4:
                if (checked)
                    needles_in = getResources().getString(R.string.in4);
                break;
            case R.id.in5:
                if (checked)
                    needles_in = getResources().getString(R.string.in5);
                break;
            case R.id.in6:
                if (checked)
                    needles_in = getResources().getString(R.string.in6);
                break;
            case R.id.in7:
                if (checked)
                    needles_in = getResources().getString(R.string.in7);
                break;
            case R.id.in8:
                if (checked)
                    needles_in = getResources().getString(R.string.in8);
                break;
            case R.id.in9:
                if (checked)
                    needles_in = getResources().getString(R.string.in9);
                break;
            case R.id.in10:
                if (checked)
                    needles_in = getResources().getString(R.string.in10);
                break;
            case R.id.in11:
                if (checked)
                    needles_in = getResources().getString(R.string.in11);
                break;
            case R.id.otherin:
                RadioButton fish = (RadioButton) findViewById(R.id.otherin);
                if (checked)
                    //set this as the radiobutton to be changed by the showinput function
                    buttonstore.getInstance().setbuttonhold(fish);
                ShowInputNumber();
                needles_in = getResources().getString(R.string.reset);; //this lets us pass the new gender when nextscreen is clicked
                break;


        }


    }

    public void onOutButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.out1:
                if (checked)
                    needles_out = getResources().getString(R.string.out1);
                break;
            case R.id.out2:
                if (checked)
                    needles_out = getResources().getString(R.string.out2);
                break;
            case R.id.out3:
                if (checked)
                    needles_out = getResources().getString(R.string.out3);
                break;
            case R.id.out4:
                if (checked)
                    needles_out = getResources().getString(R.string.out4);
                break;
            case R.id.out5:
                if (checked)
                    needles_out = getResources().getString(R.string.out5);
                break;
            case R.id.out6:
                if (checked)
                    needles_out = getResources().getString(R.string.out6);
                break;
            case R.id.out7:
                if (checked)
                    needles_out = getResources().getString(R.string.out7);
                break;
            case R.id.out8:
                if (checked)
                    needles_out = getResources().getString(R.string.out8);
                break;
            case R.id.out9:
                if (checked)
                    needles_out = getResources().getString(R.string.out9);
                break;
            case R.id.out10:
                if (checked)
                    needles_out = getResources().getString(R.string.out10);
                break;
            case R.id.out11:
                if (checked)
                    needles_out = getResources().getString(R.string.out11);
                break;
            case R.id.otherout:
                RadioButton fish = (RadioButton) findViewById(R.id.otherout);
                if (checked)
                    //set this as the radiobutton to be changed by the showinput function
                    buttonstore.getInstance().setbuttonhold(fish);
                ShowInputNumber();
                needles_out = getResources().getString(R.string.reset);; //this lets us pass the new gender when nextscreen is clicked
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

    /** Called when the user clicks the Send button */
    public void NextScreen(View view) {
        //validate that gender, race, age have all been checked
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        RadioGroup Ingroup = (RadioGroup)findViewById(R.id.InGroup);
        RadioGroup OutGroup = (RadioGroup)findViewById(R.id.OutGroup);
        RadioGroup racegroup = (RadioGroup)findViewById(R.id.RaceGroup);
    //make warning pop up if gender, age, or race aren't checked, and prevent going to next screen
        if (Ingroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter needles in", duration);
            toast.show();
            return;
        }
        if (racegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter race", duration);
            toast.show();
            return;
        }
        if (OutGroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter needles out", duration);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, needles.class);
        RadioButton button = (RadioButton) findViewById(R.id.otherin);
        RadioButton outbutton = (RadioButton) findViewById(R.id.otherout);
        RadioButton RaceButton = (RadioButton) findViewById(R.id.OtherRace);
        //setting the gender and race fields to what you changed them to earlier
        if  (needles_in == getResources().getString(R.string.reset))
            needles_in = button.getText().toString();
        if (race == getResources().getString(R.string.reset))
            race = RaceButton.getText().toString();
        if (needles_out == getResources().getString(R.string.reset))
            needles_out = outbutton.getText().toString();
        intent.putExtra("inchosen", needles_in); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("outchosen", needles_out); // pass race to the next Activity
        startActivity(intent);
    }

    protected void ShowInputNumber() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(EnterClient.this);
        View promptView = layoutInflater.inflate(R.layout.numberinput, null);
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
    /** Called when the user clicks the main menu button */
    public void mainmenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent); //go to site change
    }
    public void clearbuttons(View view){
        RadioGroup Ingroup = (RadioGroup)findViewById(R.id.InGroup);
        RadioGroup OutGroup = (RadioGroup)findViewById(R.id.OutGroup);
        RadioGroup racegroup = (RadioGroup)findViewById(R.id.RaceGroup);
        Ingroup.clearCheck();
        OutGroup.clearCheck();
        racegroup.clearCheck();
        needles_out = null;
        needles_in = null;
        race = null;
    }
}