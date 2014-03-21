package com.wayproyect.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.wayproyect.entidades.Usuario;

/**
 * Created by ADMIN on 20/03/14.
 *
 * @author Julio C. Ramos
 */
public class Login {
    Context context;
    LoginBD loginBD;

    public Login(Context context) {
        this.context = context;
        loginBD = new LoginBD(context);
    }

    public boolean iniciarSesion(Usuario usuario) {
        SQLiteDatabase baseDatos = loginBD.getReadableDatabase();
        Cursor c = baseDatos.rawQuery("SELECT * FROM tbl_users WHERE user=? AND pass=? ",
                new String[]{
                        usuario.getUsuario(),
                        usuario.getPassword()
                });
        return c.moveToFirst();
    }
}
