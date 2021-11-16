package com.itca.proyectofinaldaute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registrar_us extends AppCompatActivity {
private Button reg;
    private EditText mail, contra;

    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_us);


        firebaseAuth = FirebaseAuth.getInstance();
        reg = findViewById(R.id.reg);
        mail = findViewById(R.id.mail);
        contra = findViewById(R.id.contra);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registro();
            }
        });
    }
    public void registro() {
        String email = mail.getText().toString().trim();
        String password = contra.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(registrar_us.this, "EL REGISTRO FUE CORRECTO", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(registrar_us.this, login.class);
                    startActivity(intent);
                    finish();
                } else {
                    String e = task.getException().toString();
                    Toast.makeText(registrar_us.this, e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    }
