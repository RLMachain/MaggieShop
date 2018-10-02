package machain.com.maggieshop.data;

import android.util.Log;

public class DATA_Categoria {
    int idcategoria;
    String nombre, descripcion;

    public DATA_Categoria() {
        descripcion = nombre = "";
        idcategoria = 0;
    }

    public DATA_Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
