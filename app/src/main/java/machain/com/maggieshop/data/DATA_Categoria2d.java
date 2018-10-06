package machain.com.maggieshop.data;

import android.util.Log;

import machain.com.maggieshop.R;

public class DATA_Categoria2d {
    DATA_Categoria categoriauno, categoriados;

    public DATA_Categoria2d() {
    }

    public DATA_Categoria getCategoriauno() {
        return categoriauno;
    }

    public void setCategoriauno(DATA_Categoria categoriauno) {
        this.categoriauno = categoriauno;
    }

    public DATA_Categoria getCategoriados() {
        return categoriados;
    }

    public void setCategoriados(DATA_Categoria categoriados) {
        this.categoriados = categoriados;
    }


    public int getImage(DATA_Categoria cat){
        int res = 0;
        Log.e("maggie", "buscamos" + cat.nombre);
        if (cat.nombre.equals("Sueter")){
            res= R.drawable.categoria_sueter;
        }
        if (cat.nombre.equals("Blusas")){
            res= R.drawable.categoria_blusa;
        }

        if (res == 0){
            res = R.drawable.hanger;
        }

        return res;
    }
}
