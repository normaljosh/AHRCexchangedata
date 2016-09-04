package org.austinharmreduction.ahrcclientdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    String gender; // store the text corresponding to  the gender radiobutton
    String race; //store the text corresponding to the race radiobutton


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
                if (checked)
                    gender = "Other";
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

        }
}
    //display gender button
    public void displaygender(View view) {
        //display the gender string when clicked
        TextView text = (TextView) findViewById(R.id.textView);
        String display = "Race: " + race + " Gender:" + gender;
        text.setText(display);
    }

    /** Called when the user clicks the Send button */
    public void NextScreen(View view) {
        Intent intent = new Intent(this, needles.class);
        intent.putExtra("genderchosen", gender); // pass gender to the next Activity
        intent.putExtra("racechosen", race); // pass race to the next Activity
        startActivity(intent);
    }
}