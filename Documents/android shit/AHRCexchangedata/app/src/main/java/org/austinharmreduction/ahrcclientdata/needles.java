package org.austinharmreduction.ahrcclientdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class needles extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needles);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gender= extras.getString("genderchosen");
            String race = extras.getString("racechosen");
            TextView text = (TextView) findViewById(R.id.textView5);
            String display = "Race: " + race + " Gender:" + gender;
            text.setText(display);

        }
    }

    public void backbutton(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gender = extras.getString("genderchosen");
            String race = extras.getString("racechosen");

            intent.putExtra("genderchosen", gender); // pass gender to the next Activity
            intent.putExtra("racechosen", race); // pass race to the next Activity

        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
