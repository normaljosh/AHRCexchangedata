package org.austinharmreduction.ahrcclientdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class SiteChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_change);
    }
    public void onSiteButtonClicked(View view) {
        // Is the gender button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Comal:
                if (checked)
                    SiteHolder.getInstance().setsitehold("3rd & Comal");
                break;
            case R.id.Mars:
                if (checked)
                    SiteHolder.getInstance().setsitehold("Mars North");
                break;
            case R.id.Montopolis:
                if (checked)
                    SiteHolder.getInstance().setsitehold("Montopolis");
                break;
            case R.id.Peer:
                if (checked)
                    SiteHolder.getInstance().setsitehold("Peer Exchange");
                break;
            case R.id.Phases:
                if (checked)
                    SiteHolder.getInstance().setsitehold("Phases");
                break;
            case R.id.Pickle:
                if (checked)
                    SiteHolder.getInstance().setsitehold("Pickle");
                break;
            case R.id.Planet:
                if (checked)
                    SiteHolder.getInstance().setsitehold("Planet K");
                break;
            case R.id.Waller:
                if (checked)
                    SiteHolder.getInstance().setsitehold("Waller");
                break;



        }
        TextView text = (TextView) findViewById(R.id.textView7);
        String site = SiteHolder.getInstance().getsitehold();
        text.setText(site);

    }
}
