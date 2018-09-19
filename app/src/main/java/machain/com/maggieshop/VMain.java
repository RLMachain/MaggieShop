package machain.com.maggieshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class VMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vmain);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_actionbar);
        getSupportActionBar().setTitle("COGNOEscolar");

    }
}
