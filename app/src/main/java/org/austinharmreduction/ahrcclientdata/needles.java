package org.austinharmreduction.ahrcclientdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class needles extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needles);
        Bundle extras = getIntent().getExtras();
        String gender= extras.getString("genderchosen");
        String race = extras.getString("racechosen");
    }

        String needles_in; // store the text corresponding to  the needles in
        String needles_out; //store the text corresponding to the needles out


    public void onInButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Ten_in:
                if (checked)
                    needles_in = "10";
                break;
            case R.id.Twenty_in:
                if (checked)
                    needles_in = "20";
                break;
            case R.id.Thirty_in:
                if (checked)
                    needles_in = "30";
                break;

        }


    }

    public void onOutButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Ten_out:
                if (checked)
                    needles_out = "10";
                break;
            case R.id.Twenty_out:
                if (checked)
                    needles_out = "20";
                break;
            case R.id.Thirty_out:
                if (checked)
                    needles_out = "30";
                break;

        }
    }
        //take race and gender from EnterClient, pass to DBEnter
    /** Called when the user clicks the Enter Client button */
    public void DBScreen(View view) {
        Intent intent = new Intent(this, DBEnter.class);
        Bundle extras = getIntent().getExtras();
        String gender= extras.getString("genderchosen");
        String race = extras.getString("racechosen");
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        intent.putExtra("inchosen", needles_in);// pass needles in to the next Activity
        intent.putExtra("outchosen", needles_out);// pass needles out to the next Activity
        startActivity(intent); //go to enter client
    }
    }



