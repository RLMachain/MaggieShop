package machain.com.maggieshop.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import machain.com.maggieshop.data.DATA_ScriptBD;

public class MaggieBD extends SQLiteOpenHelper {
    ScriptBD scriptBD;
    DATA_ScriptBD tablas[];

    public MaggieBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        scriptBD = new ScriptBD();
        tablas = scriptBD.getTablas();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        crearTablas(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        vaciarbd(db);
    }

    private void crearTablas(SQLiteDatabase db){
        for (int i = 0; i < tablas.length; i++){
            db.execSQL(tablas[i].getSql());
        }
    }

    private void vaciarTablas(SQLiteDatabase db) {
        for (int i = 0; i < tablas.length; i++){
            db.execSQL("drop table if exists " + tablas[i].getTabla());
        }
    }

    public void vaciarbd(SQLiteDatabase db){
        vaciarTablas(db);
        crearTablas(db);
        Log.e("maggie", "Se vacio la BD");
    }

    public void vaciarTabla(String tabla, SQLiteDatabase db){
        for (int i = 0; i < tablas.length; i++){
            if (tablas[i].is(tabla)){
                db.execSQL("drop table if exists "+tabla);
                db.execSQL(tablas[i].getSql());
            }
        }



    }
}
