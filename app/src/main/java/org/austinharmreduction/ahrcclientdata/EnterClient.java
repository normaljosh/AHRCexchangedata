package org.austinharmreduction.ahrcclientdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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