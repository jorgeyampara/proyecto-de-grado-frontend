package co.chenao.stroopers.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import co.chenao.stroopers.R;

public class LoginActivity extends AppCompatActivity {
    private EditText Correo;
    private EditText Contraseña;
    private Button botonIniciarSecion;
    private Button botonCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Correo = (EditText) findViewById(R.id.correo);
        Contraseña = (EditText) findViewById(R.id.contraseña);
        botonCrearCuenta = (Button) findViewById(R.id.crearCuenta);

        botonCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrarseActivity.class));
            }
        });
    }
}
