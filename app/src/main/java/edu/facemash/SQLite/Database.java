package edu.facemash.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.R.id.list;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "wmapMobileLocal.db";
    private Table[] tables = new Table[3];
    private SQLiteDatabase db = null;


    // prepare data string arrays for database scheme injection
    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.tables[0] = new WorkerTable();
        this.tables[1] = new RatingTable();
        this.tables[2] = new WorkerRatingTable();
        this.db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.tables[0].getStructure());
        db.execSQL(this.tables[1].getStructure());
        db.execSQL(this.tables[2].getStructure());

        db.execSQL(
            "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('someGirl', 'someFamily', 'somePlace', 'someNumber');"
        );
        db.execSQL(
                "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('someGirl', 'someFamily', 'somePlace', 'someNumber');"
        );
        db.execSQL(
                "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('someGirl', 'someFamily', 'somePlace', 'someNumber');"
        );
        db.execSQL(
                "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('someGirl', 'someFamily', 'somePlace', 'someNumber');"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(this.tables[0].getDrop());
        db.execSQL(this.tables[1].getDrop());
        db.execSQL(this.tables[2].getDrop());
    }

    public String getWorkers () {

        String workers = "";
//        public Cursor query(boolean distinct, String table, String[] columns,
//                String selection, String[] selectionArgs, String groupBy,
//                String having, String orderBy, String limit)

        Cursor cursor = this.db.rawQuery("SELECT * FROM worker", null);

        if (cursor .moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(0);

                ArrayList<String> list = new ArrayList<>();
                list.add(name);
                cursor.moveToNext();
            }
        }

//        Cursor cursor = this.db.query("worker", workerColumns, "*", null, null, null, null, null);
        cursor.moveToFirst();
        System.out.println(cursor.getCount());
        System.out.println(list);
//        workers = cursor.getString(1);
        cursor.close();


//        String currentTitle="";
//        String currentAuthor="";
//
//        int rows = cursor.getCount();
//        cursor.moveToFirst();
//
//        for(int i=0;i<rows;i++){
//
//            int bookId = cursor.getInt(i);
//
//            if(bookId==id){
//                //now You got the entry and can get all informations You want
//                currentTitle = cursor.getString(1);
//                currentAuthor = cursor.getString(2);
//                cursor.moveToNext();
//            }
//        }
//
//        String mStringArray[] = { "String1", "String2" };
//
//        JSONArray mJSONArray = new JSONArray(Arrays.asList(mStringArray));

        return workers;
    }
}
