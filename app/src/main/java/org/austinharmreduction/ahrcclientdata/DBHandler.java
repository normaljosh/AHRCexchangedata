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

import java.util.ArrayList;
import java.util.List;
public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "clientInfo";
    //Table name
    private static final String TABLE_CLIENTS = "clients";
    // Column names
    private static final String KEY_ID = "id";
    private static final String KEY_RACE = "race";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_NEEDLES_IN = "needles_in";
    private static final String KEY_NEEDLES_OUT = "needles_out";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CLIENTS + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_RACE + " TEXT," + KEY_GENDER + " TEXT," +
         KEY_NEEDLES_IN + " INTEGER," + KEY_NEEDLES_OUT + " INTEGER" +
        ")";
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
        values.put(KEY_RACE, client.getrace()); // client Race
        values.put(KEY_GENDER, client.getgender()); // client Gender
        values.put(KEY_NEEDLES_IN, client.getneedles_in()); // client Needles_in
        values.put(KEY_NEEDLES_OUT, client.getneedles_out()); // client Needles_out
    // Inserting Row
        db.insert(TABLE_CLIENTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting one client
    public ClientFormat getclient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CLIENTS, new String[] { KEY_ID, KEY_RACE,
                        KEY_GENDER, KEY_NEEDLES_IN, KEY_NEEDLES_OUT }, KEY_RACE + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        ClientFormat oneclient = new ClientFormat(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), (cursor.getString(3)),
                (cursor.getString(4)));
// return client
        return oneclient;
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
                    client.setrace(cursor.getString(1));
                    client.setgender(cursor.getString(2));
                    client.setneedles_in(cursor.getString(3));
                    client.setneedles_out(cursor.getString(4));
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
    }
    // Updating a Client
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
    }

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