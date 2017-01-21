package org.austinharmreduction.ahrcclientdata;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
//This functions pretty similarly to the "EnterClient" screen, it's just the second screen of data.
public class needles extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needles);
    }

        String gender; //store the text corresponding to the needles out
        String type;
    String ins;//store the text corresponding to the ins
    String age;//store the text corresponding to the ins
        String comment;//store the comment text


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

    public void onInsButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.ins1:
                if (checked)
                    ins = getResources().getString(R.string.ins1);
                break;
            case R.id.ins2:
                if (checked)
                    ins = getResources().getString(R.string.ins2);
                break;
            case R.id.ins3:
                if (checked)
                    ins = getResources().getString(R.string.ins3);
                break;
            case R.id.ins4:
                if (checked)
                    ins = getResources().getString(R.string.ins4);
                break;
            case R.id.ins5:
                if (checked)
                    ins = getResources().getString(R.string.ins5);
                break;
            case R.id.ins6:
                if (checked)
                    ins = getResources().getString(R.string.ins6);
                break;
            case R.id.otherins:
                RadioButton fish = (RadioButton) findViewById(R.id.otherins);
                if (checked)
                    //set this as the radiobutton to be changed by the showinput function
                    buttonstore.getInstance().setbuttonhold(fish);
                ShowInput();
                ins = getResources().getString(R.string.reset);; //this lets us pass the new gender when nextscreen is clicked
                break;
        }
    }

    public void entersecondaries(View view) {
        RadioGroup gendergroup = (RadioGroup)findViewById(R.id.genderGroup);
        RadioGroup insgroup = (RadioGroup)findViewById(R.id.insuranceGroup);
        RadioGroup agegroup = (RadioGroup)findViewById(R.id.AgeGroup);
        TextView commentview = (TextView) findViewById(R.id.commenttext);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (gendergroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter gender", duration);
            toast.show();
            return;
        }
        if (insgroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter insurance", duration);
            toast.show();
            return;
        }
        if (agegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter age of exchanger", duration);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, Secondaries.class);
        RadioButton button = (RadioButton) findViewById(R.id.OtherGender);
        RadioButton buttonins = (RadioButton) findViewById(R.id.otherins);
        if  (gender == getResources().getString(R.string.reset))
            gender = button.getText().toString();
        if  (ins == getResources().getString(R.string.reset))
            ins = buttonins.getText().toString();
        Bundle extras = getIntent().getExtras();
        String needles_in= extras.getString("inchosen");
        String race = extras.getString("racechosen");
        String needles_out = extras.getString("outchosen");
        String comment = commentview.getText().toString();
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("agechosen", age); // pass age to the next Activity
        intent.putExtra("inchosen", needles_in);// pass needles in to the next Activity
        intent.putExtra("outchosen", needles_out);// pass needles out to the next Activity
        intent.putExtra("inschosen", ins);// pass needles out to the next Activity
        intent.putExtra("commentchosen", comment);
        startActivity(intent); //go to enter client
        finish();
    }

        //take race and gender from EnterClient, pass to DBEnter
    /** Called when the user clicks the Enter Client button */
    public void DBScreen(View view) {
        type = getResources().getString(R.string.type1);
        RadioGroup gendergroup = (RadioGroup)findViewById(R.id.genderGroup);
        RadioGroup insgroup = (RadioGroup)findViewById(R.id.insuranceGroup);
        RadioGroup agegroup = (RadioGroup)findViewById(R.id.AgeGroup);
        TextView commentview = (TextView) findViewById(R.id.commenttext);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (gendergroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter gender", duration);
            toast.show();
            return;
        }
        if (insgroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter insurance", duration);
            toast.show();
            return;
        }
        if (agegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter age of exchanger", duration);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, DBEnter.class);
        RadioButton button = (RadioButton) findViewById(R.id.OtherGender);
        RadioButton buttonins = (RadioButton) findViewById(R.id.otherins);

        if  (gender == getResources().getString(R.string.reset))
            gender = button.getText().toString();
        if  (ins == getResources().getString(R.string.reset))
            ins = buttonins.getText().toString();
        Bundle extras = getIntent().getExtras();
        boolean mainmenu = false; // for path in next entry
        String needles_in= extras.getString("inchosen");
        String race = extras.getString("racechosen");
        String needles_out = extras.getString("outchosen");
        String comment = commentview.getText().toString();
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("agechosen", age); // pass age to the next Activity
        intent.putExtra("inchosen", needles_in);// pass needles in to the next Activity
        intent.putExtra("outchosen", needles_out);// pass needles out to the next Activity
        intent.putExtra("typechosen", type);// pass needles out to the next Activity
        intent.putExtra("inschosen", ins);// pass needles out to the next Activity
        intent.putExtra("commentchosen", comment);
        intent.putExtra("mainmenu", mainmenu);
        startActivity(intent); //go to enter client
        finish();
    }
    //this is identical to the last one, but the mainmenu bool is set to True, which will make us
    //go to the main menu after the DBEnter class.
    public void mainmenu(View view) {
        type = getResources().getString(R.string.type1);
        RadioGroup gendergroup = (RadioGroup)findViewById(R.id.genderGroup);
        RadioGroup insgroup = (RadioGroup)findViewById(R.id.insuranceGroup);
        RadioGroup agegroup = (RadioGroup)findViewById(R.id.AgeGroup);
        TextView commentview = (TextView) findViewById(R.id.commenttext);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (gendergroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter gender", duration);
            toast.show();
            return;
        }
        if (insgroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter insurance", duration);
            toast.show();
            return;
        }
        if (agegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter age of exchanger", duration);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, DBEnter.class);
        RadioButton button = (RadioButton) findViewById(R.id.OtherGender);
        RadioButton buttonins = (RadioButton) findViewById(R.id.otherins);

        if  (gender == getResources().getString(R.string.reset))
            gender = button.getText().toString();
        if  (ins == getResources().getString(R.string.reset))
            ins = buttonins.getText().toString();
        Bundle extras = getIntent().getExtras();
        boolean mainmenu = true; // for path in next entry
        String needles_in= extras.getString("inchosen");
        String race = extras.getString("racechosen");
        String needles_out = extras.getString("outchosen");
        String comment = commentview.getText().toString();
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("agechosen", age); // pass age to the next Activity
        intent.putExtra("inchosen", needles_in);// pass needles in to the next Activity
        intent.putExtra("outchosen", needles_out);// pass needles out to the next Activity
        intent.putExtra("typechosen", type);// pass needles out to the next Activity
        intent.putExtra("inschosen", ins);// pass needles out to the next Activity
        intent.putExtra("commentchosen", comment);
        intent.putExtra("mainmenu", mainmenu);
        startActivity(intent); //go to enter client
        finish();
    }

    public void commententer(View view){
// get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(needles.this);
        View promptView = layoutInflater.inflate(R.layout.commentinput, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(needles.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView commentview = (TextView) findViewById(R.id.commenttext);
                        commentview.setText(editText.getText());//display comment as text, will store when data sent
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
        LayoutInflater layoutInflater = LayoutInflater.from(needles.this);
        View promptView = layoutInflater.inflate(R.layout.staffinput, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(needles.this);
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
    public void clearbuttons(View view){
        RadioGroup gendergroup = (RadioGroup)findViewById(R.id.genderGroup);
        RadioGroup agegroup = (RadioGroup)findViewById(R.id.AgeGroup);
        RadioGroup insgroup = (RadioGroup)findViewById(R.id.insuranceGroup);
        gendergroup.clearCheck();
        agegroup.clearCheck();
        insgroup.clearCheck();
        gender = null;
        age = null;
        ins = null;
    }

    }




