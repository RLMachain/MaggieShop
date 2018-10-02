package machain.com.maggieshop.dao;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import machain.com.maggieshop.data.DATA_Categoria;
import machain.com.maggieshop.data.DATA_Spinner;

public class DAO_Producto {
    DAO_ManagerDB dao;


    public DAO_Producto(Context context) {
        dao = new DAO_ManagerDB(context);
    }

    public void agregarcategoria(DATA_Categoria categoria){
        dao.agregarValues("nombre", categoria.getNombre());
        dao.agregarValues("descategoria",  categoria.getDescripcion());
        dao.insert("Categoria");
        dao.limpiarValues();
    }

    public DATA_Categoria[] getCategorias(){
        DATA_Categoria categorias[] = null;
        try{
            if (dao.ejecutaselect("Categoria","idcategoria,nombre,descategoria")){
                Cursor data = dao.getFila();
                if (data.getCount() > 0){
                    categorias = new DATA_Categoria[data.getCount()];
                    int cont = 0;
                    do {
                        categorias[cont] = new DATA_Categoria(data.getString(1), data.getString(2));
                        categorias[cont].setIdcategoria(Integer.parseInt(data.getString(0)));
                        cont++;
                    }while (data.moveToNext());
                }
            }
        }catch (Exception e){
            escribirenconsola("getcategorias error"+ e.getMessage());
        }
        return categorias;
    }

    public DATA_Spinner[] getCategoriasSpinner(){
        DATA_Spinner categorias[] = null;
        try{
            if (dao.ejecutaselect("Categoria","idcategoria,nombre")){
                Cursor data = dao.getFila();
                if (data.getCount() > 0){
                    categorias = new DATA_Spinner[data.getCount()];
                    int cont = 0;
                    do {
                        categorias[cont] = new DATA_Spinner();
                        categorias[cont].setDisplayfield(dao.getString(1));
                        categorias[cont].setValuefield(dao.getString(0));
                        cont++;
                    }while (data.moveToNext());
                }
            }
        }catch (Exception e){
            escribirenconsola("getcategorias error"+ e.getMessage());
        }
        return categorias;
    }

    public void cerrarcnx(){
        dao.cerrarCnx();
    }

    public void escribirenconsola(String msg){
        Log.e("maggie", msg);
    }

}
