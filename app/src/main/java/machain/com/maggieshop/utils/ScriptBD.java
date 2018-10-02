package machain.com.maggieshop.utils;


import machain.com.maggieshop.data.DATA_ScriptBD;

public class ScriptBD {
    DATA_ScriptBD tablas[];

    public ScriptBD() {
        tablas = new DATA_ScriptBD[3];

        tablas[0] = new DATA_ScriptBD();
        tablas[0].setTabla("Usuario");
        tablas[0].setSql("create table Usuario(login text, pasword text, islogin text)");

        tablas[1] = new DATA_ScriptBD();
        tablas[1].setTabla("Categoria");
        tablas[1].setSql("create table Categoria(idcategoria INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, descategoria text)");

        tablas[2] = new DATA_ScriptBD();
        tablas[2].setTabla("Producto");
        tablas[2].setSql("create table Producto(idproducto INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, desproducto text, idcategoria integer, costo text, precio text, existencia text" +
                ",disponible text)");

    }

    public DATA_ScriptBD[] getTablas() {
        return tablas;
    }


}
