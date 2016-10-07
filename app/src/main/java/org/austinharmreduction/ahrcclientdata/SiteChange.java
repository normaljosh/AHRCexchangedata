package org.austinharmreduction.ahrcclientdata;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class SiteChange extends AppCompatActivity {

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
            case R.id.Comal:
                if (checked)
                  siteclick = "3rd & Comal";
                break;
            case R.id.Mars:
                if (checked)
                    siteclick = "Mars North";
                break;
            case R.id.Montopolis:
                if (checked)
                    siteclick = "Montopolis";;
                break;
            case R.id.Peer:
                if (checked)
                    siteclick = "Peer Exchange";
                break;
            case R.id.Phases:
                if (checked)
                    siteclick = "Phases";
                break;
            case R.id.Pickle:
                if (checked)
                    siteclick = "Pickle";
                break;
            case R.id.Planet:
                if (checked)
                    siteclick = "Planet K";
                break;
            case R.id.Waller:
                if (checked)
                    siteclick = "Waller";
                break;



        }
    }
    public void EnterSite(View view) {
        TextView staffview = (TextView) findViewById(R.id.textView8);
        SiteHolder.getInstance().setstaffhold(staffview.getText().toString());
       SiteHolder.getInstance().setsitehold(siteclick);

    finish();
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

}
