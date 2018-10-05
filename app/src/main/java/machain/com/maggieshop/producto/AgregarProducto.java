package machain.com.maggieshop.producto;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import machain.com.maggieshop.R;
import machain.com.maggieshop.VMain;
import machain.com.maggieshop.adapter.ListaCategoriasAdapter;
import machain.com.maggieshop.categoria.IndexCategoria;
import machain.com.maggieshop.dao.DAO_Producto;
import machain.com.maggieshop.data.DATA_Categoria;
import machain.com.maggieshop.data.DATA_Producto;
import machain.com.maggieshop.data.DATA_Spinner;

public class AgregarProducto extends AppCompatActivity {
    DATA_Spinner categorias[];

    Spinner spinner_categoria;
    EditText nombre, descripcion, costo, precio;
    TextView lblExistencia;
    Button guardar;
    ImageView masExistencia, menosExistencia;

    DAO_Producto dao_producto;

    Resources res;
    String[] categorydefault;

    int existencia = 0;

    DATA_Producto producto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_productos_agregar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("MaggieShop");

        spinner_categoria = findViewById(R.id.categoria_agregarproducto);

        nombre = findViewById(R.id.nombre_addproducto);
        descripcion = findViewById(R.id.des_addproducto);
        costo = findViewById(R.id.costo_addproducto);
        precio = findViewById(R.id.precio_addproducto);

        lblExistencia = findViewById(R.id.existencia_addproducto);

        guardar = findViewById(R.id.guardar_addproducto);
        masExistencia = findViewById(R.id.btnmasexistencia_addproducto);
        menosExistencia = findViewById(R.id.btnmenosexistencia_addproducto);

        dao_producto = new DAO_Producto(this);
        categorias = dao_producto.getCategoriasSpinner();

        try {
            if (categorias != null && categorias.length > 0){
                spinner_categoria.setAdapter(getDataSpinner());
            }else{
                guardarCategoriasDefault();
            }
        }catch (Exception e){

        }

        masExistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                existencia++;
                actualizarExistencia();
            }
        });

        menosExistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (existencia > 0){
                    existencia--;
                    actualizarExistencia();
                }
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarCampos()){
                    producto = new DATA_Producto(getStringCampo(precio),
                                                    getStringCampo(costo),
                                                    getStringCampo(nombre),
                                                    getStringCampo(descripcion),
                                                    existencia);

                    DATA_Spinner categoria = (DATA_Spinner) spinner_categoria.getSelectedItem();
                    producto.setIdcategoria(categoria.getValuefield());

                    dao_producto.agregarproducto(producto);
                    Toast.makeText(AgregarProducto.this, "Se ha agregado el producto!", Toast.LENGTH_SHORT).show();
                    irA(new Intent(AgregarProducto.this, VMain.class));
                }else {
                    Toast.makeText(AgregarProducto.this, "Campos vacios!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validarCampos(){
        if (!isCampoVacio(nombre) && !isCampoVacio(descripcion) && !isCampoVacio(precio) && !isCampoVacio(costo) ) {
            return true;
        }else
            return false;
    }

    public String getStringCampo(EditText editText){
        return editText.getText().toString();
    }

    public boolean isCampoVacio(EditText editText){
        return editText.getText().toString().equals("");
    }

    public void actualizarExistencia(){
        lblExistencia.setText("Existencia: " + existencia + " ");
    }

    public void guardarCategoriasDefault() throws Exception{
        res = getResources();
        categorydefault = res.getStringArray(R.array.categoriasdefault);

        for (int i = 0; i < categorydefault.length; i++){
            dao_producto.agregarcategoria(new DATA_Categoria(categorydefault[i], "default"));
        }

        categorias = dao_producto.getCategoriasSpinner();

        if (categorias != null && categorias.length > 0){
            spinner_categoria.setAdapter(getDataSpinner());
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

    public void irA(Intent intent){
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        irA(new Intent(this, VMain.class));
    }
}
