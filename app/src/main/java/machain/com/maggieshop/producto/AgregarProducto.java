package machain.com.maggieshop.producto;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import machain.com.maggieshop.R;
import machain.com.maggieshop.adapter.ListaCategoriasAdapter;
import machain.com.maggieshop.dao.DAO_Producto;
import machain.com.maggieshop.data.DATA_Spinner;

public class AgregarProducto extends AppCompatActivity {
    DATA_Spinner categorias[];

    Spinner spinner_categoria;

    DAO_Producto dao_producto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_productos_agregar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("MaggieShop");

        spinner_categoria = findViewById(R.id.categoria_agregarproducto);

        dao_producto = new DAO_Producto(this);
        categorias = dao_producto.getCategoriasSpinner();

        try {
            if (categorias != null && categorias.length > 0){
                spinner_categoria.setAdapter(getDataSpinner());
            }else{

            }
        }catch (Exception e){

        }


    }

    public ArrayAdapter<DATA_Spinner> getDataSpinner() throws Exception{
        ArrayList<DATA_Spinner> lista = new ArrayList<>();
        for (int i = 0; i <  categorias.length; i++){
            lista.add(categorias[i]);
        }

        ArrayAdapter<DATA_Spinner> spinner_adapter = new ArrayAdapter<DATA_Spinner> (this, R.layout.spinner_colorblack, lista);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return spinner_adapter;
    }
}
