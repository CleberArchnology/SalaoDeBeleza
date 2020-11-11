package com.example.salaodebeleza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaLogin extends AppCompatActivity {
Button buttonEnviar;//declaração do objeto botão
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonEnviar = findViewById(R.id.buttonEnviar);//atribuição do Objeto Botão da Activity para
        abrirTelaMenu();                                               // para classe java.

    }

    public void abrirTelaMenu(){
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaMenu = new Intent(getApplicationContext(),ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });

    }


}