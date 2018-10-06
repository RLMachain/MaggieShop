package machain.com.maggieshop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import machain.com.maggieshop.R;
import machain.com.maggieshop.data.DATA_Categoria;
import machain.com.maggieshop.data.DATA_Categoria2d;

public class ListMenuCategoriasAdapter extends BaseAdapter {
    DATA_Categoria2d categorias[];
    LayoutInflater inflater;
    Context context;

    public ListMenuCategoriasAdapter(DATA_Categoria2d []categorias, Context context) {
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
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.layout_item_listcategorias, viewGroup, false);

        TextView lbluno = convertView.findViewById(R.id.textouno_listcategoria);
        TextView lbldos = convertView.findViewById(R.id.textodos_listcategoria);

        ImageView img1 = convertView.findViewById(R.id.imguno_listcategoria);
        ImageView img2 = convertView.findViewById(R.id.imgdos_listcategoria);

        if (categorias[i].getCategoriauno() != null){
            lbluno.setText(categorias[i].getCategoriauno().getNombre());
            img1.setImageResource(categorias[i].getImage(categorias[i].getCategoriauno()));
        }

        if (categorias[i].getCategoriados() != null){
            lbldos.setText(categorias[i].getCategoriados().getNombre());
            img2.setImageResource(categorias[i].getImage(categorias[i].getCategoriados()));
        }

        return convertView;
    }
}
