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
import machain.com.maggieshop.producto.AgregarProducto;

public class TabProductos extends Fragment {
    FloatingActionButton fab;

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
