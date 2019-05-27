package techy.ap.dbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Docs.db";
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="doc";
    private static final String TABLE_BOOKING="booking_table";

    private static final String KEY_NAME="docs_name";
    private static final String KEY_ID="id";

    private static final String KEY_SPECIALIST="specialist";

    private static final String KEY_PATIENT_NAME="pat_name";
    private static final String KEY_PATIENT_NUMBER="pat_no";
   // private static final Date



    private static final String CREATE_TABLE_DOC="CREATE TABLE " +TABLE_NAME+ "("+KEY_ID+ " INTEGER PRIMARY KEY," + KEY_NAME+ " TEXT," +KEY_SPECIALIST+" TEXT"+")";
    private static final String CREATE_TABLE_BOOK="CREATE TABLE "+TABLE_BOOKING+"("+KEY_ID+ " INTEGER PRIMARY KEY," + KEY_NAME+"TEXT,"+KEY_PATIENT_NAME+" TEXT,"+KEY_PATIENT_NUMBER+" TEXT"+")";



    public Database(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_DOC);
        db.execSQL(CREATE_TABLE_BOOK);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_BOOKING);

        onCreate(db);

    }

    public void insertdata(Docs docs){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("docs_name",docs.getName());
        contentValues.put("specialist",docs.getSpecialist());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();


    }

    public ArrayList<Docs>getAllDocsDetail(){
        ArrayList<Docs>docsList=new ArrayList<>();

        String selectQuery=" SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                    Docs docs=new Docs();
                   docs.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                   docs.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                   docs.setSpecialist(cursor.getString(cursor.getColumnIndex(KEY_SPECIALIST)));
                   docsList.add(docs);
            }while (cursor.moveToNext());
        }
        db.close();
        return docsList;
    }









}
