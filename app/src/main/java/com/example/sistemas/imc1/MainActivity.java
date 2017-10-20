package com.example.sistemas.imc1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private EditText etPeso;
    private  EditText etAltura;
    private ImageSwitcher imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPeso= (EditText)findViewById(R.id.etP);
        etAltura=(EditText)findViewById(R.id.etA);
        imagenes=(ImageSwitcher)findViewById(R.id.imagenes);

        imagenes.setFactory(new ViewSwitcher.ViewFactory()
        {
            public View makeView()
            {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
    }

    public void calcularImc(View view)

    {

        try{

            String valor1 = etPeso.getText().toString();
            String valor2 = etAltura.getText().toString();
            int peso = Integer.parseInt(valor1);
            int altura = Integer.parseInt(valor2);
            double imc = peso / (Math.pow(altura, 2) / 10000);

            if (imc < 16.00) {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.delgadezsevera), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.delgadezsevera);
            } else if (imc > 15.99 && imc < 16.99) {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.demode), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.elgadezmoderada);
            } else if (imc > 16.99 && imc < 18.50) {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.dele), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.delgadezleve);
            } else if (imc > 18.49 && imc < 25) {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.pesonormal), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.pesonormal);
            } else if (imc > 24.99 && imc < 30) {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.sope), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.sobrepeso);
            } else if (imc >= 30 && imc < 34.99) {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.obele), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.obesidadleve);
            } else if (imc >= 35 && imc < 39.99) {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.obme), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.obesidadmedia);
            } else {
                Toast notificacion = Toast.makeText(this,getResources().getString(R.string.obemo), Toast.LENGTH_LONG);
                notificacion.show();
                imagenes.setImageResource(R.drawable.morvida);
            }

        }

        catch (Exception e){

            if (etPeso.getText().toString().equals("")==true||etAltura.getText().toString().equals("")==true){
                Toast not=Toast.makeText(this, getResources().getString(R.string.txt_campos), Toast.LENGTH_LONG);
                not.show();
            }

        }

    }
    public void acercade(View V)
    {
        Intent i = new Intent(this, Acercade.class );
        startActivity(i);
    }
    public void info(View V)
    {
        Intent i = new Intent(this, informacion.class );
        startActivity(i);
    }

}