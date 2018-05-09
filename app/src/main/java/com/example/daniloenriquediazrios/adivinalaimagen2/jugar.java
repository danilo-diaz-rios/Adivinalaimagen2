package com.example.daniloenriquediazrios.adivinalaimagen2;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class jugar extends AppCompatActivity {

    TextView puntos,contador,vidas,txtcorrecto,txtincorrecto;

    ImageView imagen;

    EditText txtedit;

    Button btnconfirmar;

    String [] nombre_pers={"black goku","charizard","gengar","articuno","shikamaru","hinata","gohan","azuma"};
    String [] nombre_pers2={"blackgoku","Charizard","Gengar","Articuno","Shikamaru","Hinata","Gohan","Azuma"};
    String [] imagen_pers={"img2","img3","img4","img5","img6","img7","img8","img9"};

    int intpunto=0;
    int intvidas=3;
    int numerogenerado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar2);

        txtcorrecto=(TextView)findViewById(R.id.txtcorrecto);
        txtincorrecto=(TextView)findViewById(R.id.txtincorrecto);


        puntos=(TextView)findViewById(R.id.Puntos);
        vidas=(TextView)findViewById(R.id.Vidas);
        contador=(TextView)findViewById(R.id.Cuenta);
        imagen=(ImageView)findViewById(R.id.imagen);
        txtedit=(EditText)findViewById(R.id.txtedit);
        btnconfirmar=(Button)findViewById(R.id.btnconfirmar);

        establecer_imagen(numerogenerado);


        btnconfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoconfirmar = txtedit.getText().toString().toLowerCase();
                if(textoconfirmar.equals(nombre_pers[numerogenerado])|textoconfirmar.equals(nombre_pers2[numerogenerado])){

                    txtcorrecto.setVisibility(View.VISIBLE);
                    intpunto=intpunto+1;
                    puntos.setText("Puntos: "+ intpunto);
                    espearar1();

                }else {

                    txtincorrecto.setVisibility(View.VISIBLE);
                    intvidas=intvidas-1;
                    vidas.setText("Vidas: "+ intvidas);
                    espearar2();

                }

            }
        });


    }

    void espearar2() {

        new CountDownTimer(2000,1) {
            @Override
            public void onTick(long millisUntilFinished) {

                btnconfirmar.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {

                btnconfirmar.setVisibility(View.VISIBLE);
                txtincorrecto.setVisibility(View.INVISIBLE);
                txtedit.setText("");
                txtedit.setHint("Ingrese el nombre del personaje");

            }
        }.start();
    }

    void espearar1(){

        new CountDownTimer(4000,1) {
            @Override
            public void onTick(long millisUntilFinished) {

                contador.setText(""+(millisUntilFinished/1000 +1 ));
                btnconfirmar.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {

                btnconfirmar.setVisibility(View.VISIBLE);
                numerogenerado=numerogenerado+1;
                contador.setText("");
                establecer_imagen(numerogenerado);
                txtcorrecto.setVisibility(View.INVISIBLE);
                txtedit.setText("");
                txtedit.setHint("Ingrese el nombre del personaje");

            }
        }.start();

    }

    void establecer_imagen(int numero){

        int id = getResources().getIdentifier(imagen_pers[numero], "mipmap",getPackageName());
        imagen.setImageResource(id);

    }
}
