package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnVolley(View view){
        Intent intent = new Intent(MainActivity.this, MostrarDatos.class);
        EditText txtCod = (EditText)findViewById(R.id.txtCodigo);
        Bundle b = new Bundle();
        b.putString("COD", txtCod.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }
}