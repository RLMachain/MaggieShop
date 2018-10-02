package machain.com.maggieshop.categoria;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import machain.com.maggieshop.R;
import machain.com.maggieshop.VMain;
import machain.com.maggieshop.dao.DAO_Producto;
import machain.com.maggieshop.data.DATA_Categoria;

public class AgregarCategoria extends AppCompatActivity {

    EditText nombre,descripcion;
    Button guardar;

    DAO_Producto dao_producto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_categoria_agregar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("MaggieShop");

        nombre = findViewById(R.id.nombre_addcategoria);
        descripcion = findViewById(R.id.des_addcategoria);

        guardar = findViewById(R.id.guardar_addcategoria);

        dao_producto = new DAO_Producto(this);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarcampos()){
                    dao_producto.agregarcategoria(new DATA_Categoria(getStringCampo(nombre), getStringCampo(descripcion)));
                    Toast.makeText(AgregarCategoria.this, "¡Categoria guardada!", Toast.LENGTH_SHORT).show();
                    irA(new Intent(AgregarCategoria.this, IndexCategoria.class));
                }else{
                    Toast.makeText(AgregarCategoria.this, "¡Los campos son requeridos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean validarcampos(){
        boolean res = false;
        if (!getStringCampo(nombre).equals("") && !getStringCampo(descripcion).equals(""))
            res = true;
        return res;
    }

    public String getStringCampo(EditText editText){
        return editText.getText().toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dao_producto != null) dao_producto.cerrarcnx();
    }

    public void irA(Intent intent){
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        irA(new Intent(this, IndexCategoria.class));
    }
}
