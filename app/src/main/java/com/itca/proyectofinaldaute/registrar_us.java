package com.itca.proyectofinaldaute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrar_us extends AppCompatActivity {
private Button reg;
    private EditText mail, contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_us);



        reg = findViewById(R.id.reg);
        mail = findViewById(R.id.mail);
        contra = findViewById(R.id.contra);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // login(); nombre del metodo
            }
        });
    }
    }
