package com.wayproyect.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.wayproyect.entidades.Usuario;

/**
 * @author Julio C. Ramos
 */
public class Login extends Activity {

    //Declarar componentes a utilizar
    EditText usuario;
    EditText password;
    Button btn_login;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //Inicializar componentes
        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);

        //Inicializar eventos
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_loginOnClick();
            }
        });
    }

    private void btn_loginOnClick() {
        //Crear el objeto usuario y settear sus atributos
        Usuario usuario1 = new Usuario();
        usuario1.setPassword(password.getText().toString().trim());
        usuario1.setUsuario(usuario.getText().toString().trim());
        //Crear una instancia de Login para verificar si es correcto el Login
        com.wayproyect.persistencia.Login login = new com.wayproyect.persistencia.Login(this);
        //Si es correcto pasar a otra ventana
        if (login.iniciarSesion(usuario1)) {
            Toast.makeText(this, "INICIO CORRECTO", Toast.LENGTH_LONG).show();
        } else {
            //si no desplegar un mensaje
            Toast.makeText(this, "INICIO MAL\nVerifica tu usuario y contraseña", Toast.LENGTH_LONG).show();
        }
    }
}
