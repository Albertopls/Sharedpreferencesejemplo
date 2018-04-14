package com.example.eduardopalacios.sharedpreferencesejemplo;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button azul,rojo,naranja,verde,contador,resetear;
    TextView Midisplay;

    String colorDisplay;
    int contadorDisplay;

    int contadorporDefecto=0;
    String colorporDefecto="#dedcdc";

    SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencias=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);


        colorDisplay= preferencias.getString("color",colorporDefecto);
        contadorDisplay=preferencias.getInt("contador",contadorporDefecto);





        Midisplay=findViewById(R.id.display);

        Midisplay.setBackgroundColor(Color.parseColor(colorDisplay));
        Midisplay.setText(String.valueOf(contadorDisplay));


        azul=findViewById(R.id.btnColorAzul);
        azul.setOnClickListener(this);

        rojo=findViewById(R.id.btnColorRojo);
        rojo.setOnClickListener(this);

        verde=findViewById(R.id.btnColorVerde);
        verde.setOnClickListener(this);

        naranja=findViewById(R.id.btnColorNaranja);
        naranja.setOnClickListener(this);

        contador=findViewById(R.id.btnContador);
        contador.setOnClickListener(this);

        resetear=findViewById(R.id.btnResetear);
        resetear.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnColorAzul:

                Midisplay.setBackgroundColor(Color.parseColor("#49d3f5"));

                SharedPreferences.Editor insertarAzul=preferencias.edit();
                insertarAzul.putString("color","#49d3f5");
                insertarAzul.commit();


                break;

            case R.id.btnColorRojo:

                Midisplay.setBackgroundColor(Color.parseColor("#ef3759"));

                SharedPreferences.Editor insertarRojo=preferencias.edit();
                insertarRojo.putString("color","#ef3759");
                insertarRojo.commit();

                break;

            case R.id.btnColorVerde:


                Midisplay.setBackgroundColor(Color.parseColor("#79e44b"));

                SharedPreferences.Editor insertarVerde=preferencias.edit();
                insertarVerde.putString("color","#79e44b");
                insertarVerde.commit();

                break;

            case R.id.btnColorNaranja:


                Midisplay.setBackgroundColor(Color.parseColor("#f58b49"));

                SharedPreferences.Editor insertarNaranja=preferencias.edit();
                insertarNaranja.putString("color","#f58b49");
                insertarNaranja.commit();

                break;

            case R.id.btnContador:

                contadorDisplay++;
                Midisplay.setText(String.valueOf(contadorDisplay));

                SharedPreferences.Editor insertarContador=preferencias.edit();
                insertarContador.putInt("contador",contadorDisplay).commit();
                break;

            case R.id.btnResetear:
                contadorDisplay=0;

                Midisplay.setBackgroundColor(Color.parseColor(colorporDefecto));
                Midisplay.setText(String.valueOf(contadorDisplay));
                SharedPreferences.Editor resetear=preferencias.edit();
                resetear.clear().commit();
                break;

                default:

                    break;
        }

    }
}
