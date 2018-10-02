package machain.com.maggieshop.categoria;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import machain.com.maggieshop.R;
import machain.com.maggieshop.VMain;
import machain.com.maggieshop.adapter.ListaCategoriasAdapter;
import machain.com.maggieshop.dao.DAO_Producto;
import machain.com.maggieshop.data.DATA_Categoria;

public class IndexCategoria extends AppCompatActivity {

    Resources res;
    String[] categorydefault;

    FloatingActionButton fab;
    ListView listcategorias;

    DAO_Producto dao_producto;
    ListaCategoriasAdapter categoriasAdapter;

    DATA_Categoria categorias[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_categoria_index);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("MaggieShop");

        fab = (FloatingActionButton) findViewById(R.id.fabadd_categoria);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irA(new Intent(IndexCategoria.this, AgregarCategoria.class));
            }
        });

        listcategorias = findViewById(R.id.listcategorias_index);

        dao_producto = new DAO_Producto(this);
        categorias = dao_producto.getCategorias();

        if (categorias != null && categorias.length > 0){
            categoriasAdapter = new ListaCategoriasAdapter(categorias, this);
            listcategorias.setAdapter(categoriasAdapter);
        }else{
            guardarCategoriasDefault();
        }
    }

    public void guardarCategoriasDefault(){
        res = getResources();
        categorydefault = res.getStringArray(R.array.categoriasdefault);

        for (int i = 0; i < categorydefault.length; i++){
            dao_producto.agregarcategoria(new DATA_Categoria(categorydefault[i], "default"));
        }

        categorias = dao_producto.getCategorias();

        if (categorias != null && categorias.length > 0){
            categoriasAdapter = new ListaCategoriasAdapter(categorias, this);
            listcategorias.setAdapter(categoriasAdapter);
        }

    }

    public void irA(Intent intent){
        startActivity(intent);
        finish();
    }

    public void escribirenconsola(String msg){
        Log.e("maggie", msg);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        irA(new Intent(this, VMain.class));
    }
}
