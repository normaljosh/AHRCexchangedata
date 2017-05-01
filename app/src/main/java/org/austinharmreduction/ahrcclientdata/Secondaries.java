package org.austinharmreduction.ahrcclientdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/* So this functionality was built in to allow secondaries to be entered... it's too clumsy to go through
the two screens every time when 1 person is exchanging for many others, so this compresses the data onto
one screen.
 */

public class Secondaries extends AppCompatActivity {
Spinner gendersp1;
Spinner racesp1;
    Spinner agesp1;
    Spinner numsp1;
    Spinner inssp1;

    Spinner gendersp2;
    Spinner racesp2;
    Spinner agesp2;
    Spinner numsp2;
    Spinner inssp2;

    Spinner gendersp3;
    Spinner racesp3;
    Spinner agesp3;
    Spinner numsp3;
    Spinner inssp3;

    Spinner gendersp4;
    Spinner racesp4;
    Spinner agesp4;
    Spinner numsp4;
    Spinner inssp4;

    Spinner gendersp5;
    Spinner racesp5;
    Spinner agesp5;
    Spinner numsp5;
    Spinner inssp5;

    Spinner gendersp6;
    Spinner racesp6;
    Spinner agesp6;
    Spinner numsp6;
    Spinner inssp6;
    
    int needlesin = 100;
    int needlesout = 100;
    String race = "black";
    String gender = "female";
    String age = "20";
    String ins = "Map";
    String comment = "testcomment";
    String staff = SiteHolder.getInstance().getstaffhold();
    String site = SiteHolder.getInstance().getsitehold();



    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondaries);
        gendersp1 = (Spinner) findViewById(R.id.gendersp1);
        agesp1 = (Spinner) findViewById(R.id.agesp1);
        racesp1 = (Spinner) findViewById(R.id.racesp1);
        inssp1 = (Spinner) findViewById(R.id.inssp1);
        numsp1 = (Spinner) findViewById(R.id.numsp1);

        gendersp2 = (Spinner) findViewById(R.id.gendersp2);
        agesp2 = (Spinner) findViewById(R.id.agesp2);
        racesp2 = (Spinner) findViewById(R.id.racesp2);
        inssp2 = (Spinner) findViewById(R.id.inssp2);
        numsp2 = (Spinner) findViewById(R.id.numsp2);

        gendersp3 = (Spinner) findViewById(R.id.gendersp3);
        agesp3 = (Spinner) findViewById(R.id.agesp3);
        racesp3 = (Spinner) findViewById(R.id.racesp3);
        inssp3 = (Spinner) findViewById(R.id.inssp3);
        numsp3 = (Spinner) findViewById(R.id.numsp3);

        gendersp4 = (Spinner) findViewById(R.id.gendersp4);
        agesp4 = (Spinner) findViewById(R.id.agesp4);
        racesp4 = (Spinner) findViewById(R.id.racesp4);
        inssp4 = (Spinner) findViewById(R.id.inssp4);
        numsp4 = (Spinner) findViewById(R.id.numsp4);

        gendersp5 = (Spinner) findViewById(R.id.gendersp5);
        agesp5 = (Spinner) findViewById(R.id.agesp5);
        racesp5 = (Spinner) findViewById(R.id.racesp5);
        inssp5 = (Spinner) findViewById(R.id.inssp5);
        numsp5 = (Spinner) findViewById(R.id.numsp5);

        gendersp6 = (Spinner) findViewById(R.id.gendersp6);
        agesp6 = (Spinner) findViewById(R.id.agesp6);
        racesp6 = (Spinner) findViewById(R.id.racesp6);
        inssp6 = (Spinner) findViewById(R.id.inssp6);
        numsp6 = (Spinner) findViewById(R.id.numsp6);
        
        //create array adapters
        ArrayAdapter<CharSequence> genderadapter = ArrayAdapter.createFromResource(this,
                R.array.genderarray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> raceadapter = ArrayAdapter.createFromResource(this,
                R.array.racearray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> ageadapter = ArrayAdapter.createFromResource(this,
                R.array.agearray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> insadapter = ArrayAdapter.createFromResource(this,
                R.array.insarray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> numadapter = ArrayAdapter.createFromResource(this,
                R.array.numarray, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        insadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
// Apply the adapter to the spinner
        gendersp1.setAdapter(genderadapter);
        numsp1.setAdapter(numadapter);
        racesp1.setAdapter(raceadapter);
        agesp1.setAdapter(ageadapter);
        inssp1.setAdapter(insadapter);

        gendersp2.setAdapter(genderadapter);
        numsp2.setAdapter(numadapter);
        racesp2.setAdapter(raceadapter);
        agesp2.setAdapter(ageadapter);
        inssp2.setAdapter(insadapter);

        gendersp3.setAdapter(genderadapter);
        numsp3.setAdapter(numadapter);
        racesp3.setAdapter(raceadapter);
        agesp3.setAdapter(ageadapter);
        inssp3.setAdapter(insadapter);

        gendersp4.setAdapter(genderadapter);
        numsp4.setAdapter(numadapter);
        racesp4.setAdapter(raceadapter);
        agesp4.setAdapter(ageadapter);
        inssp4.setAdapter(insadapter);

        gendersp5.setAdapter(genderadapter);
        numsp5.setAdapter(numadapter);
        racesp5.setAdapter(raceadapter);
        agesp5.setAdapter(ageadapter);
        inssp5.setAdapter(insadapter);

        gendersp6.setAdapter(genderadapter);
        numsp6.setAdapter(numadapter);
        racesp6.setAdapter(raceadapter);
        agesp6.setAdapter(ageadapter);
        inssp6.setAdapter(insadapter);
    }
    public void newclient(View view) {
        Bundle extras = getIntent().getExtras();
        String staff = SiteHolder.getInstance().getstaffhold();
        String site = SiteHolder.getInstance().getsitehold();
        String gender = extras.getString("genderchosen");
        String race = extras.getString("racechosen");
        String age = extras.getString("agechosen");
        int needlesin = Integer.parseInt(extras.getString("inchosen"));
        int needlesout = Integer.parseInt(extras.getString("outchosen"));
        String ins = extras.getString("inschosen");
        String comment = extras.getString("commentchosen");


        // divide # needles in and out by # of secondaries
        int second1=Integer.parseInt(numsp1.getSelectedItem().toString());
        int second2=Integer.parseInt(numsp2.getSelectedItem().toString());
        int second3=Integer.parseInt(numsp3.getSelectedItem().toString());
        int second4=Integer.parseInt(numsp4.getSelectedItem().toString());
        int second5=Integer.parseInt(numsp5.getSelectedItem().toString());
        int second6=Integer.parseInt(numsp6.getSelectedItem().toString());
        int needlesinavg = needlesin / (second1 + second2 + second3 + second4 + second5 + second6);
        int needlesoutavg = needlesout / (second1 + second2 + second3 + second4 + second5 + second6);
        //initialize db for entry
        DBHandler db = new DBHandler(this);

        //for debug, will be removed
        TextView bees = (TextView)findViewById(R.id.displayspinner);
        bees.setText(Integer.toString(needlesinavg));

        //add primary client
        db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                Integer.toString(needlesoutavg), getResources().getString(R.string.type2) , ins, comment));
        //add secondary client in first line
        if(second1 != 0) {
            gender = gendersp1.getSelectedItem().toString();
            race = racesp1.getSelectedItem().toString();
            age = agesp1.getSelectedItem().toString();
            ins = inssp1.getSelectedItem().toString();
            for (int x = 0; x < second1; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
            if(second2 != 0) {
                gender = gendersp2.getSelectedItem().toString();
                race = racesp2.getSelectedItem().toString();
                age = agesp2.getSelectedItem().toString();
                ins = inssp2.getSelectedItem().toString();
                for (int x = 0; x < second2; x = x + 1) {
                    db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                            Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
                }
            }
        if(second3 != 0) {
            gender = gendersp3.getSelectedItem().toString();
            race = racesp3.getSelectedItem().toString();
            age = agesp3.getSelectedItem().toString();
            ins = inssp3.getSelectedItem().toString();
            for (int x = 0; x < second3; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second4 != 0) {
            gender = gendersp4.getSelectedItem().toString();
            race = racesp4.getSelectedItem().toString();
            age = agesp4.getSelectedItem().toString();
            ins = inssp4.getSelectedItem().toString();
            for (int x = 0; x < second4; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second5 != 0) {
            gender = gendersp5.getSelectedItem().toString();
            race = racesp5.getSelectedItem().toString();
            age = agesp5.getSelectedItem().toString();
            ins = inssp5.getSelectedItem().toString();
            for (int x = 0; x < second5; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second6 != 0) {
            gender = gendersp6.getSelectedItem().toString();
            race = racesp6.getSelectedItem().toString();
            age = agesp6.getSelectedItem().toString();
            ins = inssp6.getSelectedItem().toString();
            for (int x = 0; x < second6; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        Intent path = new Intent(this, EnterClient.class);
        startActivity(path);
    }

    public void backtomain(View view) {
        Bundle extras = getIntent().getExtras();
        String staff = SiteHolder.getInstance().getstaffhold();
        String site = SiteHolder.getInstance().getsitehold();
        String gender = extras.getString("genderchosen");
        String race = extras.getString("racechosen");
        String age = extras.getString("agechosen");
        int needlesin = Integer.parseInt(extras.getString("inchosen"));
        int needlesout = Integer.parseInt(extras.getString("outchosen"));
        String ins = extras.getString("inschosen");
        String comment = extras.getString("commentchosen");

        // divide # needles in and out by # of secondaries
        int second1=Integer.parseInt(numsp1.getSelectedItem().toString());
        int second2=Integer.parseInt(numsp2.getSelectedItem().toString());
        int second3=Integer.parseInt(numsp3.getSelectedItem().toString());
        int second4=Integer.parseInt(numsp4.getSelectedItem().toString());
        int second5=Integer.parseInt(numsp5.getSelectedItem().toString());
        int second6=Integer.parseInt(numsp6.getSelectedItem().toString());
        int needlesinavg = needlesin / (second1 + second2 + second3 + second4 + second5 + second6 + 1);
        int needlesoutavg = needlesout / (second1 + second2 + second3 + second4 + second5 + second6 + 1);
        //initialize db for entry
        DBHandler db = new DBHandler(this);

        //for debug, will be removed
        TextView bees = (TextView)findViewById(R.id.displayspinner);
        bees.setText(Integer.toString(needlesinavg));

        //add primary client
        db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                Integer.toString(needlesoutavg), getResources().getString(R.string.type2) , ins, comment));
        //add secondary client in first line
        if(second1 != 0) {
            gender = gendersp1.getSelectedItem().toString();
            race = racesp1.getSelectedItem().toString();
            age = agesp1.getSelectedItem().toString();
            ins = inssp1.getSelectedItem().toString();
            for (int x = 0; x < second1; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second2 != 0) {
            gender = gendersp2.getSelectedItem().toString();
            race = racesp2.getSelectedItem().toString();
            age = agesp2.getSelectedItem().toString();
            ins = inssp2.getSelectedItem().toString();
            for (int x = 0; x < second2; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second3 != 0) {
            gender = gendersp3.getSelectedItem().toString();
            race = racesp3.getSelectedItem().toString();
            age = agesp3.getSelectedItem().toString();
            ins = inssp3.getSelectedItem().toString();
            for (int x = 0; x < second3; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second4 != 0) {
            gender = gendersp4.getSelectedItem().toString();
            race = racesp4.getSelectedItem().toString();
            age = agesp4.getSelectedItem().toString();
            ins = inssp4.getSelectedItem().toString();
            for (int x = 0; x < second4; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second5 != 0) {
            gender = gendersp5.getSelectedItem().toString();
            race = racesp5.getSelectedItem().toString();
            age = agesp5.getSelectedItem().toString();
            ins = inssp5.getSelectedItem().toString();
            for (int x = 0; x < second5; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        if(second6 != 0) {
            gender = gendersp6.getSelectedItem().toString();
            race = racesp6.getSelectedItem().toString();
            age = agesp6.getSelectedItem().toString();
            ins = inssp6.getSelectedItem().toString();
            for (int x = 0; x < second6; x = x + 1) {
                db.addClient(new ClientFormat(staff, site, gender, race, age, Integer.toString(needlesinavg),
                        Integer.toString(needlesoutavg), getResources().getString(R.string.type3), ins, comment));
            }
        }
        Intent path = new Intent(this, MainActivity.class);
        startActivity(path);
    }
}
