package com.jorgeyampara.raices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText Correo;
    private EditText Contraseña;
    private Button botonIniciarSecion;
    private Button botonCrearCuenta;
    private Button reestablecerContraseña;
    //variables de los datos del usuario

    private String name;
    private String email;
    private String password;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Correo = (EditText) findViewById(R.id.correoElectronico);
        Contraseña = (EditText) findViewById(R.id.contraseña);
        botonCrearCuenta = (Button) findViewById(R.id.crearCuenta);
        botonIniciarSecion = (Button) findViewById(R.id.iniciarSecion);
        reestablecerContraseña = (Button) findViewById(R.id.reestablecerPassword);


        //boton crear cuenta
        botonCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.jorgeyampara.raices.LoginActivity.this, RegistrarseActivity.class));
            }
        });


        //boton reestablecer contraseña
        reestablecerContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.jorgeyampara.raices.LoginActivity.this, ResetPassword.class));
            }
        });

        //boton inisiar sesion
        botonIniciarSecion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                email= Correo.getText().toString();
                password = Contraseña.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                startActivity(new Intent(com.jorgeyampara.raices.LoginActivity.this, MainActivity.class));
                                finish();
                            }
                            else {
                                Toast.makeText(com.jorgeyampara.raices.LoginActivity.this, "Usuario o contraseña incorrecto",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else {
                    Toast.makeText(com.jorgeyampara.raices.LoginActivity.this, "Debe completar todos los campos",Toast.LENGTH_SHORT).show();
                }
            }
        }
        );

    }
}
