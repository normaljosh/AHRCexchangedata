package org.austinharmreduction.ahrcclientdata;

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
import android.widget.TextView;

import java.util.Calendar;

public class SiteChange extends AppCompatActivity {
//This screen lets us set or change the site and staff member
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_change);
        TextView staffview = (TextView) findViewById(R.id.textView8);
        staffview.setText(SiteHolder.getInstance().getstaffhold());
    }
    String siteclick;
    public void onSiteButtonClicked(View view) {
        // Is the site button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.site1:
                if (checked)
                  siteclick = getString(R.string.site1);
                break;
            case R.id.site2:
                if (checked)
                    siteclick = getString(R.string.site2);
                break;
            case R.id.site3:
                if (checked)
                    siteclick = getString(R.string.site3);
                break;
            case R.id.site4:
                if (checked)
                    siteclick = getString(R.string.site4);
                break;
            case R.id.site5:
                if (checked)
                    siteclick = getString(R.string.site5);
                break;
            case R.id.site6:
                if (checked)
                    siteclick = getString(R.string.site6);
                break;
            case R.id.site7:
                if (checked)
                    siteclick = getString(R.string.site7);
                break;
            case R.id.site8:
                if (checked)
                    siteclick = getString(R.string.site8);
                break;
            case R.id.site9:
                if (checked)
                    siteclick = getString(R.string.site9);
                break;
            case R.id.site10:
                if (checked)
                    siteclick = getString(R.string.site10);
                break;
            case R.id.othersite:
                RadioButton sitebutton = (RadioButton) findViewById(R.id.othersite);
                if (checked)
                    //set this as the radiobutton to be changed by the showinput function
                    buttonstore.getInstance().setbuttonhold(sitebutton);
                EnterCustomSite();
                siteclick = getResources().getString(R.string.reset);; //this lets us pass the new gender when nextscreen is clicked
                break;



        }
    }
    public void EnterSite(View view) {
        TextView staffview = (TextView) findViewById(R.id.textView8);


        RadioButton button = (RadioButton) findViewById(R.id.othersite);
        //setting the gender and race fields to what you changed them to earlier
        if  (siteclick == getResources().getString(R.string.reset))
            siteclick = button.getText().toString();
        SiteHolder.getInstance().setstaffhold(staffview.getText().toString());
        SiteHolder.getInstance().setsitehold(siteclick);
        SiteHolder.getInstance().setdatehold(Calendar.getInstance());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent); //go to enter client
    }

    //enter staff
    protected void EnterStaff( View view) {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(SiteChange.this);
        View promptView = layoutInflater.inflate(R.layout.nameinput, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SiteChange.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView staffview = (TextView) findViewById(R.id.textView8);
                        staffview.setText(editText.getText());
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
    protected void EnterCustomSite() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(SiteChange.this);
        View promptView = layoutInflater.inflate(R.layout.siteinput, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SiteChange.this);
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
