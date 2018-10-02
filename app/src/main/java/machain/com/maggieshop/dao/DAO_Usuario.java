package machain.com.maggieshop.dao;

import android.content.Context;
import android.util.Log;

public class DAO_Usuario {
    DAO_ManagerDB dao;


    public DAO_Usuario(Context context) {
        dao = new DAO_ManagerDB(context);
    }

    public void generarUsuario(){
        dao.agregarValues("login", "maggie");
        dao.agregarValues("pasword",  "maggie");
        dao.agregarValues("islogin",  "false");
        dao.insert("Usuario");
        dao.limpiarValues();
    }

    public void cerrarcnx(){
        dao.cerrarCnx();
    }

    public void vaciarBD(){
        dao.vaciarBD();
    }

    public void activarUsuario()throws Exception{
        dao.actualizastring("Usuario","islogin","true");
    }

    public boolean islogin() throws Exception{
        boolean res=false;
        if (dao.ejecutaselect("Usuario","islogin")){
            String result = dao.getString(0);
            if(result.equals("true")) res = true;
        }
        return res;
    }

    public boolean validarUsuario(String usuario, String pass) throws Exception{
        boolean res=false;
        if (dao.ejecutaselect("Usuario","login,pasword")){
            String u = dao.getString(0), p = dao.getString(1);

            if (usuario.equals(u) && pass.equals(p)){
                    res = true;
            }
        }
        return res;
    }

    public void escribirenconsola(String msg){
        Log.e("maggie", "DAO_Usuario "+msg);
    }
}
