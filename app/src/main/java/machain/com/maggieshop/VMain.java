package machain.com.maggieshop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import machain.com.maggieshop.categoria.IndexCategoria;

public class VMain extends AppCompatActivity {

    ViewPager pager;
    TabLayout tabLayout;
    TabsPagerAdapter adapter;

    int color = Color.argb(200,226,226,226);
    int colorIndicador = Color.parseColor("#365180");
    int colorNegro = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vmain);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_actionbar);
        getSupportActionBar().setTitle("MaggieShop");

        pager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setBackgroundColor(color);
        tabLayout.setSelectedTabIndicatorColor(colorIndicador);
        tabLayout.setTabTextColors(colorNegro,colorIndicador);
        tabLayout.setupWithViewPager(pager);

        FragmentManager manager = getSupportFragmentManager();
        adapter = new TabsPagerAdapter(manager);
        pager.setAdapter(adapter);

        pager.setCurrentItem(0);
        focusedIcon(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
                focusedIcon(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    public void focusedIcon(int position){
        iconsGray(position);
        iconFocus(position);
    }

    public void iconsGray(int excepto){
        if(excepto==0){
            tabLayout.getTabAt(1).setIcon(R.mipmap.ic_productos_gris);
        }if(excepto==1){

            tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home_gris);
        }
    }

    public void iconFocus(int focus){
        if(focus==0){
            tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home_blanco);
        }
        if(focus==1) {
            tabLayout.getTabAt(1).setIcon(R.mipmap.ic_productos_blanco);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vmain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_categoria:
                irA(new Intent(this, IndexCategoria.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void irA(Intent intent){
        startActivity(intent);
        finish();
    }

    public void escribirtoast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

}
