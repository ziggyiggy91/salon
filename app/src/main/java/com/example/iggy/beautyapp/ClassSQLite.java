package com.example.iggy.beautyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Iggy on 7/16/2018.
 */

public class ClassSQLite extends SQLiteOpenHelper {
    public  static final String DATABASE =  "data.db";

    private static final String query = "select * from tableExample where Name='" + "Ismael" +  "'";
    private String dbPath = " ";
    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";
    SQLiteDatabase db;
    static int counter = 0;
    Toast toaster;

    String [] columnName = {};

    String tableClientsInsert = "";
    Context context;

    private static final String DATABASE_CREATE = "create table newTable ( id varchar(255));";


    public ClassSQLite(Context context){
        super(context,DATABASE,null,1);
        this.context = context;
        Log.d(TAG, "sql constructor ");
        //dbPath = context.getDatabasePath("testing.db").getPath();
        //File file = new File("/data/data/com.example.iggy.atm/databases/newdb.db" );
        //db = SQLiteDatabase.openOrCreateDatabase(file, null);
        //Log.d(TAG, "sql lite path: " + dbPath);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d(TAG, "sql db open? " + db.isOpen());
            Log.d(TAG, "sql create ");
            db.execSQL(DATABASE_CREATE);
        }
        catch(SQLiteException e){
            Log.d(TAG, "Couldn't create a new database.");
        }

        //SQLiteDatabase sql = SQLiteDatabase.openOrCreateDatabase("testing.db",null,null);

        //db.execSQL(query);
        //SQLiteDatabase datab = this.getReadableDatabase();
        //Cursor res =  sql.rawQuery( query, null );

    }

    public void insert(String table,String[] key , String[] data){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues content = new ContentValues();

            Log.d(TAG, "Counter: " + counter);
            counter++;
            Log.d(TAG, "db: " + db);
            for(int i = 0; i < key.length;i++) {
                content.put(key[i], data[i]);
            }
            db.insert(table, null, content);

        }
        catch (SQLiteException e){

        }
    }

    public void retrieve(String table,String[] column,String select){
        int counter = 0;
        //String column[] = {"id"};
        SQLiteDatabase db =  this.getReadableDatabase();
        //ContentValues content = new ContentValues();
        //content.containsKey("id");
        Cursor cursor = db.query(table,column,null,null,null,null,null);
        Log.d(TAG, "db: " + db);

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            columnName = cursor.getColumnNames();
            for(int i = 0; i < columnName.length; i++) {
                Log.d(TAG, "columnName: " + columnName[i]);


                String itemId = cursor.getString(
                        cursor.getColumnIndexOrThrow(""+columnName[i] +""));
                Log.d(TAG, "item: " + itemId);
            }
            Log.d(TAG, "retrieve counter: " + counter);

            counter++;


            //itemIds.add(itemId);
        }

        cursor.close();
    }

    public void drop(String table){

        try{
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("drop table " + table);

        }
        catch(SQLException e){
            toaster = Toast.makeText(context, "Couldn't drop table " + table, Toast.LENGTH_LONG);
            toaster.show();

        }
    }


    public void query(String data){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(data);
        }
        catch(SQLiteException e){
            Log.d(TAG, "Couldn't create table");
        }
    }

    public void delete(String data){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(data);
        }
        catch(SQLiteException e){
            Log.d(TAG, "Couldn't create table");
        }
    }


    public void tableClient(String fName,String lName,String phone,String eMail,String pAddress,String bDay,String photo,String lVisit){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            tableClientsInsert = "insert into tableClients(First_Name,Last_Name,Phone," +
                    "Email,Physical_Address,Birthdate,Photo,Last_Visit) " + "values ('" + fName +
                    "','" + lName + "'," + phone + ",'" + eMail + "','" + pAddress + "','" + bDay +
                    "','" + photo + "','" + lVisit + "');";

            Cursor cursor = db.rawQuery("select First_Name,Last_Name,Birthdate from tableClients where First_Name = '" + fName
                    + "' and Last_Name = '" + lName + "' and Birthdate = '" + bDay + "';", null);
        }
        catch(SQLException e){
            Log.d(TAG, "couldn't find");

        }
        //query(tableClientsInsert);

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
