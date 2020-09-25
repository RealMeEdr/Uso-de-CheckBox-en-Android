package com.example.controlcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Primero se deben declarar las variables a utilizar
    private EditText et1,et2;
    private CheckBox ck1, ck2, ck3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //después se hace conexión con los ID´S de la app
        et1 = (EditText) findViewById(R.id.ed1);
        et2 = (EditText) findViewById(R.id.ed2);
        ck1 = (CheckBox) findViewById(R.id.check1);
        ck2 = (CheckBox) findViewById(R.id.check2);
        ck3 = (CheckBox) findViewById(R.id.check3);
        tv1 = (TextView) findViewById(R.id.tv1);
    }
    //Después se crea el método para lanzarlo al botón
    public void Calcular(View view) {
        //Después se pasa a String las variables para pòder realizar las operaciones
        try {
            String valor1_String = et1.getText().toString();
            String valor2_String = et2.getText().toString();

            if (valor1_String == null){
                Toast.makeText(this, "Debe poner un valor en el campo 1",Toast.LENGTH_LONG).show();
            }else if(valor2_String == null){
                Toast.makeText(this, "Debe poner un valor en el campo 2",Toast.LENGTH_LONG).show();
            }

                //Después crea otra variable entera para que se pueda captar lo que escribió el usuario
                int valor1_int = Integer.parseInt(valor1_String);
                int valor2_int = Integer.parseInt(valor2_String);

                String resultado = "";

                if ((ck1.isChecked() == false) && (ck2.isChecked() == false) && (ck3.isChecked() == false)) {
                    Toast.makeText(this, "debe Seleccionar que operación se debe realizar", Toast.LENGTH_LONG).show();
                }
                if (ck1.isChecked() == true) {
                    int suma = valor1_int + valor2_int;
                    resultado = " La Suma de la operación es: " + suma;
                }
                if (ck2.isChecked() == true) {
                    int resta = valor1_int - valor2_int;
                    resultado = resultado + "\n La resta de la operación es: " + resta;
                }
                if (ck3.isChecked() == true) {
                    int Multi = valor1_int * valor2_int;
                    resultado = resultado + "\n La multiplicación es: " + Multi;
                }
                tv1.setText(resultado);

        }catch (Exception m){
            Toast.makeText(this, "El error es: "+m.toString(),Toast.LENGTH_LONG).show();
        }
    }
}