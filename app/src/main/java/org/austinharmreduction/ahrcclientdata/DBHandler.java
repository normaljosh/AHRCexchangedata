package org.austinharmreduction.ahrcclientdata;

/**
 * Created by Josh Leibowitz on 9/5/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
//This was pretty much all directly lifted from an online example, but it establishes the framework
//for the database that the info is stored in.
public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "clientInfo";
    //Table name
    private static final String TABLE_CLIENTS = "participants";
    // Column names
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "DateTime";
    private static final String KEY_STAFF = "Staff";
    private static final String KEY_SITE = "Site";
    private static final String KEY_RACE = "Race";
    private static final String KEY_GENDER = "Sex";
    private static final String KEY_AGE = "Age";
    private static final String KEY_NEEDLES_IN = "Units_In";
    private static final String KEY_NEEDLES_OUT = "Units_Out";
    private static final String KEY_TYPE = "Type";
    private static final String KEY_INS = "Insurance";
    private static final String KEY_COMMENT = "Comment";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CLIENTS
                + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_DATE + " DATETIME DEFAULT (DATETIME(CURRENT_TIMESTAMP, 'LOCALTIME')),"
                + KEY_STAFF + " TEXT,"
                + KEY_SITE + " TEXT,"
                + KEY_GENDER + " TEXT,"
                + KEY_RACE + " TEXT,"
                + KEY_AGE + " TEXT,"
                + KEY_NEEDLES_IN + " INTEGER,"
                + KEY_NEEDLES_OUT + " INTEGER,"
                + KEY_TYPE + " TEXT,"
                + KEY_INS + " TEXT,"
                + KEY_COMMENT + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);
    // Creating tables again
        onCreate(db);
    }
    // Adding new client
    public void addClient(ClientFormat client) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STAFF, client.getstaff()); // client Race
        values.put(KEY_SITE, client.getsite()); // client Race
        values.put(KEY_GENDER, client.getgender()); // client Gender
        values.put(KEY_RACE, client.getrace()); // client Race
        values.put(KEY_AGE, client.getage()); // client Race
        values.put(KEY_NEEDLES_IN, client.getneedles_in()); // client Needles_in
        values.put(KEY_NEEDLES_OUT, client.getneedles_out()); // client Needles_out
        values.put(KEY_TYPE, client.gettype()); // client Race
        values.put(KEY_INS, client.getins()); // client Race
        values.put(KEY_COMMENT, client.getcomment()); // client Race
    // Inserting Row
        db.insert(TABLE_CLIENTS, null, values);
        db.close(); // Closing database connection
        SiteHolder.getInstance().setdatehold(Calendar.getInstance());
    }

 /*   // Getting one client... doesn't work right now and will need to be edited
    public ClientFormat getclient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CLIENTS, new String[] { KEY_ID, KEY_DATE, KEY_STAFF, KEY_SITE,
                KEY_GENDER, KEY_RACE, KEY_AGE, KEY_NEEDLES_IN, KEY_NEEDLES_OUT, KEY_TYPE, KEY_INS }, KEY_RACE+ "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        ClientFormat oneclient = new ClientFormat(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), (cursor.getString(3)), (cursor.getString(4)),
                (cursor.getString(5)));
// return client
        return oneclient;
    }*/

 // Getting last 10 clients
 public List<ClientFormat> getLastClients(Integer offsetnum) {
     List<ClientFormat> ClientList = new ArrayList<ClientFormat>();
     // Select All Query
     String selectQuery = "SELECT * FROM " + TABLE_CLIENTS + " ORDER BY ID DESC LIMIT 10 OFFSET " + Integer.toString(offsetnum) ;
     SQLiteDatabase db = this.getWritableDatabase();
     Cursor cursor = db.rawQuery(selectQuery, null);
     // looping through all rows and adding to list
     if (cursor.moveToFirst()) {
         do {
             ClientFormat client = new ClientFormat();
             client.setid(Integer.parseInt(cursor.getString(0)));
             client.setdate(cursor.getString(1));
             client.setstaff(cursor.getString(2));
             client.setsite(cursor.getString(3));
             client.setgender(cursor.getString(4));
             client.setrace(cursor.getString(5));
             client.setage(cursor.getString(6));
             client.setneedles_in(cursor.getString(7));
             client.setneedles_out(cursor.getString(8));
             client.settype(cursor.getString(9));
             client.setins(cursor.getString(10));
             client.setcomment(cursor.getString(11));
             // Adding contact to list
             ClientList.add(client);
         } while (cursor.moveToNext());
     }
     // return contact list
     return ClientList;
 }


    // Getting specific client by id
    public List<ClientFormat> getClientfromId(Integer id) {
        List<ClientFormat> ClientList = new ArrayList<ClientFormat>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CLIENTS + " WHERE ID LIKE " + Integer.toString(id) ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ClientFormat client = new ClientFormat();
                client.setid(Integer.parseInt(cursor.getString(0)));
                client.setdate(cursor.getString(1));
                client.setstaff(cursor.getString(2));
                client.setsite(cursor.getString(3));
                client.setgender(cursor.getString(4));
                client.setrace(cursor.getString(5));
                client.setage(cursor.getString(6));
                client.setneedles_in(cursor.getString(7));
                client.setneedles_out(cursor.getString(8));
                client.settype(cursor.getString(9));
                client.setins(cursor.getString(10));
                client.setcomment(cursor.getString(11));
                // Adding contact to list
                ClientList.add(client);
            } while (cursor.moveToNext());
        }
        // return contact list
        return ClientList;
    }




    // Getting All Clients
    public List<ClientFormat> getAllClients() {
        List<ClientFormat> ClientList = new ArrayList<ClientFormat>();
    // Select All Query
            String selectQuery = "SELECT * FROM " + TABLE_CLIENTS;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
    // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    ClientFormat client = new ClientFormat();
                    client.setid(Integer.parseInt(cursor.getString(0)));
                    client.setdate(cursor.getString(1));
                    client.setstaff(cursor.getString(2));
                    client.setsite(cursor.getString(3));
                    client.setgender(cursor.getString(4));
                    client.setrace(cursor.getString(5));
                    client.setage(cursor.getString(6));
                    client.setneedles_in(cursor.getString(7));
                    client.setneedles_out(cursor.getString(8));
                    client.settype(cursor.getString(9));
                    client.setins(cursor.getString(10));
                    client.setcomment(cursor.getString(11));
    // Adding contact to list
                    ClientList.add(client);
                } while (cursor.moveToNext());
            }
    // return contact list
            return ClientList;
    }


    // Getting number of clients in database
    public int getClientCount() {
        String countQuery = "SELECT * FROM " + TABLE_CLIENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
// return count
        return cursor.getCount();
    }/*

    // Updating a Client -- not used and will need to add other terms
    public int updateClient(ClientFormat client) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_RACE, client.getrace());
        values.put(KEY_GENDER, client.getgender());
        values.put(KEY_NEEDLES_IN, client.getneedles_in());
        values.put(KEY_NEEDLES_OUT, client.getneedles_out());
// updating row
        return db.update(TABLE_CLIENTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(client.getid())});
    }

    // Deleting a client
    public void deleteClient(ClientFormat client) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CLIENTS, KEY_ID + " = ?",
                new String[] { String.valueOf(client.getid()) });
        db.close();
    }*/

    //taken from databasemanager
    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }
}