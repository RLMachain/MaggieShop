package machain.com.maggieshop.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import machain.com.maggieshop.R;
import machain.com.maggieshop.adapter.ListMenuCategoriasAdapter;
import machain.com.maggieshop.categoria.AgregarCategoria;
import machain.com.maggieshop.categoria.IndexCategoria;
import machain.com.maggieshop.dao.DAO_Producto;
import machain.com.maggieshop.data.DATA_Categoria;
import machain.com.maggieshop.data.DATA_Categoria2d;
import machain.com.maggieshop.data.DATA_Producto;
import machain.com.maggieshop.producto.AgregarProducto;

public class TabProductos extends Fragment {
    FloatingActionButton fab;

    DATA_Producto productos[];
    DATA_Categoria categorias[];
    DAO_Producto dao_producto;

    DATA_Categoria2d categories[];
    ListMenuCategoriasAdapter adapter;

    ListView list;

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

        list = rootView.findViewById(R.id.listproductos);

        dao_producto = new DAO_Producto(getContext());
        categorias = dao_producto.getCategorias();
        productos = dao_producto.getProductos();

        /*if (productos != null && productos.length > 0){
            for (int i = 0; i<productos.length; i++){
                escribirenconsola(productos[i].getNombre());
            }
        }*/

        if (categorias != null && categorias.length > 0){
            set2dimensionArray();
            adapter = new ListMenuCategoriasAdapter(categories, getContext());
            list.setAdapter(adapter);
        }

        return rootView;
    }

    public void set2dimensionArray(){
        int rows = 1;
        if (categorias.length >=2 ){
            if (categorias.length % 2 == 0){
                rows = (categorias.length) / 2;
            }else{
                rows = (categorias.length / 2) + 1;
            }
        }
        categories = new DATA_Categoria2d[rows];

        int j = 0, cont = 0;
        for (int i = 0; i< (categorias.length); i++){
            if (j==0){
                categories[cont] = new DATA_Categoria2d();
                categories[cont].setCategoriauno(categorias[i]);
                j++;
            }else{
                categories[cont].setCategoriados(categorias[i]);
                j--;
                cont++;
            }

        }

    }

    public void irA(Intent intent){
        startActivity(intent);
        getActivity().finish();
    }

    public void escribirenconsola(String msg){
        Log.e("maggie", msg);
    }
}
