package com.itca.proyectofinaldaute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private Button btniniciar;
    private EditText et1, passwd;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        firebaseAuth = FirebaseAuth.getInstance();

        btniniciar=findViewById(R.id.btniniciar);
        et1 = findViewById(R.id.et1);
        passwd = findViewById(R.id.passwd);


        btniniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login(){
        String email = et1.getText().toString().trim();
        String password = passwd.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(login.this, "Has iniciado sesion correctamente!", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(getApplicationContext(),ActivityMenu.class);
                    startActivity(home);
                } else {
                    Toast.makeText(login.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
