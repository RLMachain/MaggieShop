package machain.com.maggieshop;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import machain.com.maggieshop.tabs.TabInicio;
import machain.com.maggieshop.tabs.TabProductos;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    Fragment fragment = null;
    VMain vMain;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Inicio";
                break;
            case 1:
                title = "Productos";
                break;

        }
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment = new TabInicio();
                break;
            case 1:
                fragment = new TabProductos();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

}
