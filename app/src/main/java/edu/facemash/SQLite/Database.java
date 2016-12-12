package edu.facemash.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.gson.Gson;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "wmapMobileLocal.db";
    private Table[] tables = new Table[3];
    private SQLiteDatabase db = null;

    // prepare data string arrays for database scheme injection
    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
//        db.execSQL("DROP DATABASE " + DATABASE_NAME);
        tables[0] = new WorkerTable();
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tables[0].getStructure());

        db.delete("worker", "1 = ?", new String[] {"1"});

        db.delete("worker", "NAME = 'Bruce'", null);
        db.delete("worker", "NAME = 'Peter'", null);
        db.delete("worker", "NAME = 'Tony'", null);

        db.execSQL(
                "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('Peter', 'Parker', 'NY', '111');"
        );
        db.execSQL(
                "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('Bruce', 'Wayne', 'Gotham', '222');"
        );
        db.execSQL(
                "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('Bruce', 'Bennet', 'Desert', '333');"
        );
        db.execSQL(
                "INSERT INTO worker (NAME, SURNAME, DEPARTMENT, PHONE) VALUES ('Tony', 'Stark', 'Global', '444');"
        );

//        db.execSQL(
//            "INSERT INTO worker VALUES ('{\"name\":\"Bruce\", \"surname\": \"Wayne\", \"department\": Gotham, \"phone\": 222}');"
//        );

//        db.execSQL(
//            "INSERT INTO worker VALUES ('{\"name\":\"Peter\", \"surname\": \"Parker\", \"department\": NY, \"phone\": 123}');"
//        );

//        db.execSQL(
//            "INSERT INTO worker VALUES ('{\"name\":\"Bruce\", \"surname\": \"Bennet\", \"department\": Desert, \"phone\": 333}');"
//        );
//        db.execSQL(
//            "INSERT INTO worker VALUES ('{\"name\":\"Tony\", \"surname\": \"Stark\", \"department\": Global, \"phone\": 444}');"
//        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(tables[0].getDrop());
    }

    public String getWorkers () {

        Cursor cursor = db.rawQuery("SELECT * FROM worker", null);


        cursor.moveToFirst();
        System.out.println(cursor.getCount());
        System.out.println(cursor.getString(0));
        System.out.println(cursor.getString(1));
        System.out.println(cursor.getString(2));
        System.out.println(cursor.getString(3));

//        if (cursor.getCount() > 0) {
//            data = new Gson().toJson(data);
//        }

        cursor.close();

        return "";
    }
}
