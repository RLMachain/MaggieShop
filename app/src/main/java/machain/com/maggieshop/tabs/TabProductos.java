package machain.com.maggieshop.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import machain.com.maggieshop.R;
import machain.com.maggieshop.categoria.AgregarCategoria;
import machain.com.maggieshop.categoria.IndexCategoria;
import machain.com.maggieshop.dao.DAO_Producto;
import machain.com.maggieshop.data.DATA_Producto;
import machain.com.maggieshop.producto.AgregarProducto;

public class TabProductos extends Fragment {
    FloatingActionButton fab;

    DATA_Producto productos[];
    DAO_Producto dao_producto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_tab_productos, container, false);

        fab = (FloatingActionButton) rootView.findViewById(R.id.fabadd_producto);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irA(new Intent( getContext(), AgregarProducto.class));
            }
        });

        dao_producto = new DAO_Producto(getContext());
        productos = dao_producto.getProductos();

        if (productos != null && productos.length > 0){
            for (int i = 0; i<productos.length; i++){
                escribirenconsola(productos[i].getNombre());
            }
        }

        return rootView;
    }

    public void irA(Intent intent){
        startActivity(intent);
        getActivity().finish();
    }

    public void escribirenconsola(String msg){
        Log.e("maggie", msg);
    }
}
