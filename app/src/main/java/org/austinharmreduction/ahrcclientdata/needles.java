package org.austinharmreduction.ahrcclientdata;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class needles extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needles);
    }

        String needles_in; // store the text corresponding to  the needles in
        String needles_out; //store the text corresponding to the needles out
        String type;//store the text corresponding to the type
        String ins;//store the text corresponding to the ins


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

    public void onTypeButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.type1:
                if (checked)
                    type = getResources().getString(R.string.type1);
                break;
            case R.id.type2:
                if (checked)
                    type = getResources().getString(R.string.type2);
                break;
            case R.id.type3:
                if (checked)
                    type = getResources().getString(R.string.type3);
                break;
        }
    }
        //take race and gender from EnterClient, pass to DBEnter
    /** Called when the user clicks the Enter Client button */
    public void DBScreen(View view) {
        RadioGroup needlesingroup = (RadioGroup)findViewById(R.id.InGroup);
        RadioGroup needlesoutgroup = (RadioGroup)findViewById(R.id.OutGroup);
        RadioGroup insgroup = (RadioGroup)findViewById(R.id.insuranceGroup);
        RadioGroup typegroup = (RadioGroup)findViewById(R.id.TypeGroup);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (needlesingroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter needles in", duration);
            toast.show();
            return;
        }
        if (needlesoutgroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter needles out", duration);
            toast.show();
            return;
        }
        if (insgroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter insurance", duration);
            toast.show();
            return;
        }
        if (typegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter type of exchanger", duration);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, DBEnter.class);
        RadioButton button = (RadioButton) findViewById(R.id.otherin);
        RadioButton buttonout = (RadioButton) findViewById(R.id.otherout);
        RadioButton buttonins = (RadioButton) findViewById(R.id.otherins);
        if  (needles_in == getResources().getString(R.string.reset))
            needles_in = button.getText().toString();
        if  (needles_out == getResources().getString(R.string.reset))
            needles_out = buttonout.getText().toString();
        if  (ins == getResources().getString(R.string.reset))
            ins = buttonins.getText().toString();
        Bundle extras = getIntent().getExtras();
        boolean mainmenu = false; // for path in next entry
        String gender= extras.getString("genderchosen");
        String race = extras.getString("racechosen");
        String age = extras.getString("agechosen");
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("agechosen", age); // pass age to the next Activity
        intent.putExtra("inchosen", needles_in);// pass needles in to the next Activity
        intent.putExtra("outchosen", needles_out);// pass needles out to the next Activity
        intent.putExtra("typechosen", type);// pass needles out to the next Activity
        intent.putExtra("inschosen", ins);// pass needles out to the next Activity
        intent.putExtra("mainmenu", mainmenu);
        startActivity(intent); //go to enter client
        finish();
    }

    public void mainmenu(View view) {
        RadioGroup needlesingroup = (RadioGroup)findViewById(R.id.InGroup);
        RadioGroup needlesoutgroup = (RadioGroup)findViewById(R.id.OutGroup);
        RadioGroup insgroup = (RadioGroup)findViewById(R.id.insuranceGroup);
        RadioGroup typegroup = (RadioGroup)findViewById(R.id.TypeGroup);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (needlesingroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter needles in", duration);
            toast.show();
            return;
        }
        if (needlesoutgroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter needles out", duration);
            toast.show();
            return;
        }
        if (insgroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter insurance", duration);
            toast.show();
            return;
        }
        if (typegroup.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(context, "please enter type of exchanger", duration);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, DBEnter.class);
        RadioButton button = (RadioButton) findViewById(R.id.otherin);
        RadioButton buttonout = (RadioButton) findViewById(R.id.otherout);
        RadioButton buttonins = (RadioButton) findViewById(R.id.otherins);
        if  (needles_in == getResources().getString(R.string.reset))
            needles_in = button.getText().toString();
        if  (needles_out == getResources().getString(R.string.reset))
            needles_out = buttonout.getText().toString();
        if  (ins == getResources().getString(R.string.reset))
            ins = buttonins.getText().toString();
        Bundle extras = getIntent().getExtras();
        String gender= extras.getString("genderchosen");
        String race = extras.getString("racechosen");
        String age = extras.getString("agechosen");
        boolean mainmenu = true;
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("agechosen", age); // pass age to the next Activity
        intent.putExtra("inchosen", needles_in);// pass needles in to the next Activity
        intent.putExtra("outchosen", needles_out);// pass needles out to the next Activity
        intent.putExtra("typechosen", type);// pass needles out to the next Activity
        intent.putExtra("inschosen", ins);// pass needles out to the next Activity
        intent.putExtra("mainmenu", mainmenu);
        startActivity(intent); //go to enter client
        finish();
    }

    protected void ShowInputNumber() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(needles.this);
        View promptView = layoutInflater.inflate(R.layout.numberinput, null);
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
    }



