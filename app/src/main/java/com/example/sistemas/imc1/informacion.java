package com.example.sistemas.imc1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
    }

    public void salir2(View v) {
        finish();
    }
}
