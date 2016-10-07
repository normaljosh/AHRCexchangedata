package org.austinharmreduction.ahrcclientdata;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.austinharmreduction.ahrcclientdata.ClientFormat;
import org.austinharmreduction.ahrcclientdata.DBHandler;
import org.austinharmreduction.ahrcclientdata.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class EmailCSV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailcsv);
        //initialize database
        DBHandler db = new DBHandler(this);
        //write all database to list called "clients"
        List<ClientFormat> clients = db.getAllClients();

        //set up csv file
        File file   = null;
        File root   = Environment.getExternalStorageDirectory();
        if (root.canWrite()){
            File dir    =   new File (root.getAbsolutePath() + "/PersonData");
            dir.mkdirs();
            file   =   new File(dir, "Data.csv");
            FileOutputStream out   =   null;
            try {
                out = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                //for loop to write row by row to the file. Slashes are escaping character
                String header = "\"ID\",\"Datetime\",\"Staff\",\"Site\",\"Gender\",\"Race\",\"Age\",\"Units In\",\"Units Out\",\"Type\",\"Insurance\",\"Comment\"";
                        out.write(header.getBytes());
                for (ClientFormat client : clients) {
                    String line = "\n" + "\"" + client.getid() + "\",\""
                            + client.getdate() + "\",\""
                            + client.getstaff() + "\",\""
                            + client.getsite() + "\",\""
                            + client.getgender() + "\",\""
                            + client.getrace() + "\",\""
                            + client.getage() + "\",\""
                            + client.getneedles_in() + "\",\""
                            + client.getneedles_out() + "\",\""
                            + client.gettype() + "\",\""
                            + client.getins() + "\",\""
                            + client.getcomment() + "\"";
                    // Writing clients  to log

                    out.write(line.getBytes());

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Uri u1  =   null;
        u1  =   Uri.fromFile( file);

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Participant List");
        sendIntent.putExtra(Intent.EXTRA_STREAM, u1);
        sendIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"normaljosh@gmail.com"});
        sendIntent.setType("text/html");
        startActivity(sendIntent);
    }

}
