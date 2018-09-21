package machain.com.maggieshop.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import machain.com.maggieshop.utils.MaggieBD;

public class DAO_ManagerDB {
    MaggieBD maggieDB;
    SQLiteDatabase bd;
    ContentValues values;
    Cursor fila;
    String sql="";

    public DAO_ManagerDB(Context context) {
        maggieDB = new MaggieBD(context,"CognoEscolarDB",null,2);
        bd = maggieDB.getWritableDatabase();
        values = new ContentValues();
    }

    public void vaciarBD(){
        maggieDB.vaciarbd(bd);
    }

    public void limpiarValues(){
        values.clear();
    }

    public void agregarValues(String campo, String valor){
        values.put(campo, valor);
    }

    public void agregarValues(String campo, int valor){
        values.put(campo, valor + "");
    }

    public void insert(String tabla){
        bd.insert(tabla, null, values);
    }

    public void cerrarCnx(){
        bd.close();
    }

    public void actualizastring(String tabla, String campo, String valor, String where){
        sql = "UPDATE " + tabla + " SET " + campo + "='" + valor + "' WHERE " + where;
        bd.execSQL(sql);
    }

    public SQLiteDatabase getBd() {
        return bd;
    }

    public int getInt(int position){
        return fila.getInt(position);
    }

    public String getString(int position){
        return fila.getString(position);
    }

    public boolean ejecutaselect(String campos, String tabla, String where) throws Exception {
        boolean res = false;
        fila = null;
        sql = "select " + campos + " from " + tabla + " where " + where;
        fila = ejecutasentencia();
        if (fila.moveToFirst() && fila.getCount()>0) res = true;
        return res;
    }

    public boolean ejecutaselectall(String tabla) throws Exception {
        boolean res=false;
        sql = "select* from " + tabla;
        fila = ejecutasentencia();
        if (fila.moveToFirst() && fila.getCount()>0) res = true;
        return res;
    }

    public boolean ejecutaselect(String tabla, String campos) throws Exception {
        boolean res=false;
        sql = "select " + campos + " from " + tabla;
        fila = ejecutasentencia();
        if (fila.moveToFirst() && fila.getCount()>0) res = true;
        return res;
    }

    public boolean ejecutarSQL(String sentencia) throws Exception {
        boolean res=false;
        sql = sentencia;
        fila = ejecutasentencia();
        if (fila.moveToFirst() && fila.getCount()>0) res = true;
        return res;
    }

    public Cursor ejecutasentencia()throws Exception {
        return bd.rawQuery(sql,null);
    }

    public Cursor getFila() {
        return fila;
    }

    public void vaciarTabla(String tabla){
        maggieDB.vaciarTabla(tabla, bd);
    }

    public void eliminarregistro(String tabla, String where){
        bd.execSQL("DELETE FROM "+tabla+" where "+where);
    }

}
