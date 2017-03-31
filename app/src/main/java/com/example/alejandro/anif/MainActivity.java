package com.example.alejandro.anif;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private TextView resultado;
    private TextView valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1=(EditText)findViewById(R.id.valor1);
        valor2=(EditText)findViewById(R.id.valor2);
        resultado=(TextView)findViewById(R.id.resultado);
        valores=(TextView)findViewById(R.id.valores);

        // valor que permite guardar
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        valor1.setText(prefe.getString("Kilos",""));
        valor2.setText(prefe.getString("Estatura",""));
       resultado.setText(prefe.getString("Estado",""));

        valores.setText(prefe.getString("Resultado",""));


    }
    public void calcular(View view) {

        String casilla1=valor1.getText().toString();
        String casilla2=valor2.getText().toString();
        double nro1= Double.valueOf(casilla1).doubleValue();
        double nro2= Double.valueOf(casilla2).doubleValue();

        double multipliar=nro2*nro2;

        double dividir= nro1/multipliar;
        //double suma=nro1+nro2;
            if (dividir <= 15.99){
                String resu=String.valueOf(dividir);
                resultado.setText(R.string.delgadez);
            }
            else if (dividir >= 16.0 && dividir <=16.99){

                String resu=String.valueOf(dividir);
                resultado.setText(R.string.delgadezModerada);

            }
            else if (dividir >= 17.0 && dividir <=18.49){

                String resu=String.valueOf(dividir);
                resultado.setText(R.string.DelgadezNoMuyPronunciada);

            }
            else if (dividir >= 18.5 && dividir <=24.99){

                String resu=String.valueOf(dividir);
                resultado.setText(R.string.normal);

            }
            else if (dividir >= 25.00 && dividir <=29.99){

                String resu=String.valueOf(dividir);
                resultado.setText(R.string.sobrepeso);

            }
            else if (dividir >= 30.00 && dividir <=34.99){

                String resu=String.valueOf(dividir);
                resultado.setText(R.string.obesidadTipo1);

            }
            else if (dividir >= 35.00 && dividir <=39.99){

                String resu=String.valueOf(dividir);
                resultado.setText(R.string.obesidadTipo2);

            }
            else{
                String resu=String.valueOf(dividir);
                resultado.setText(R.string.obesidadTipo3);

            }



       String resu=String.valueOf(dividir);
       valores.setText(resu);



        // *************** METODO PARA GUARDAR********************
        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("Estado", resultado.getText().toString());
        editor.putString("Kilos", valor1.getText().toString());
        editor.putString("Estatura", valor2.getText().toString());
        editor.putString("Resultado", valores.getText().toString());
        editor.commit();

        //*******************METODO PARA GUARDAR EN BD********************




    }


    public void acercade(View view) {
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);
    }

    public void guardarBoton(View view) {
        Intent i = new Intent(this, guardar.class );
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopcioes, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.acercade) {
            Intent i = new Intent(this, AcercaDe.class );
            startActivity(i);
        }
        if (id==R.id.opcion2) {
            Toast.makeText(this, R.string.segundaOpcion,Toast.LENGTH_LONG).show();
        }
        if (id==R.id.salirImc) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

//*************CREAR OPCION PARA CERRAR LA APK*******
public void salir(View view){
    finish();

}


}
