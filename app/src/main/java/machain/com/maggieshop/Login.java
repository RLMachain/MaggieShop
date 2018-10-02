package machain.com.maggieshop;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import machain.com.maggieshop.dao.DAO_Usuario;

public class Login extends Activity {

    Button btnlogin;
    EditText user,pass;

    DAO_Usuario dao_usuario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_login);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_login);


        btnlogin = (Button) findViewById(R.id.btnlogin);

        user = findViewById(R.id.user_login);
        pass = findViewById(R.id.pass_login);

        dao_usuario = new DAO_Usuario(this);
        //dao_usuario.vaciarBD();
        //dao_usuario.generarUsuario();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (dao_usuario.validarUsuario(user.getText().toString(), pass.getText().toString())) {
                        dao_usuario.activarUsuario();
                        irmain();
                    } else
                        Toast.makeText(Login.this, "Usuario o contraseña incorrectos!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });


        try {
            if (dao_usuario.islogin()){
                irmain();
            }
        }catch (Exception e){

        }

    }

    public void irmain(){
        Intent intent = new Intent(this, VMain.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dao_usuario != null) dao_usuario.cerrarcnx();
    }
}
