package machain.com.maggieshop.data;

public class DATA_ScriptBD {
    String tabla, sql;

    public DATA_ScriptBD() {
        tabla = "";
        sql = "";
    }

    public boolean is(String nombre){
        return tabla.equals(nombre);
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
