package machain.com.maggieshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import machain.com.maggieshop.R;
import machain.com.maggieshop.data.DATA_Categoria;

public class ListaCategoriasAdapter extends BaseAdapter {

    DATA_Categoria categorias[];
    Context context;
    LayoutInflater layoutInflater;

    public ListaCategoriasAdapter(DATA_Categoria[] categorias, Context context) {
        this.categorias = categorias;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categorias.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       View itemView = layoutInflater.inflate(R.layout.layout_categoria_index_listitem, viewGroup, false);

        TextView nombre =(TextView) itemView.findViewById(R.id.nombre_itemlistcategoria);
        TextView descripcion = (TextView) itemView.findViewById(R.id.des_itemlistcategoria);

        nombre.setText(categorias[i].getNombre());
        descripcion.setText(categorias[i].getDescripcion());

        return itemView;
    }
}
