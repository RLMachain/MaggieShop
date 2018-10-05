package machain.com.maggieshop.dao;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import machain.com.maggieshop.data.DATA_Categoria;
import machain.com.maggieshop.data.DATA_Producto;
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

    public void agregarproducto(DATA_Producto producto){
        dao.agregarValues("nombre", producto.getNombre());
        dao.agregarValues("desproducto",  producto.getDescripcion());
        dao.agregarValues("idcategoria",  producto.getIdcategoria());
        dao.agregarValues("costo",  producto.getCosto() + "");
        dao.agregarValues("precio",  producto.getPrecio() + "");
        dao.agregarValues("existencia",  producto.getExistencia() + "");
        dao.insert("Producto");
        dao.limpiarValues();
    }

    public DATA_Producto[] getProductos(){
        DATA_Producto productos[] = null;
        try{
            if (dao.ejecutaselect("Producto","precio,costo,nombre,desproducto,existencia,idcategoria")){
                Cursor data = dao.getFila();//double precio, double costo, String nombre, String descripcion, int existencia
                if (data.getCount() > 0){
                    productos = new DATA_Producto[data.getCount()];
                    int cont = 0;
                    do {
                        productos[cont] = new DATA_Producto(data.getString(0),
                                data.getString(1),
                                data.getString(2),
                                data.getString(3),
                                data.getInt(4));


                        productos[cont].setIdcategoria(Integer.parseInt(data.getString(5)));
                        cont++;
                    }while (data.moveToNext());
                }
            }
        }catch (Exception e){
            escribirenconsola("getproductos error"+ e.getMessage());
        }
        return productos;
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
