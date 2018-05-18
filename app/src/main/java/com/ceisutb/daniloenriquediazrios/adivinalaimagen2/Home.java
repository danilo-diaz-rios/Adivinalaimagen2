package com.ceisutb.daniloenriquediazrios.adivinalaimagen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button btnjugar,btnayuda,btnacerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnjugar = (Button)findViewById(R.id.jugar);
        btnayuda = (Button)findViewById(R.id.ayuda);
        btnacerca = (Button)findViewById(R.id.acerca);


        btnjugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Home.this, jugar.class));
                //Intent pagina2 = new Intent(Home.this,jugar.class);
                // startActivity(pagina2);

            }
        });
        btnayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pagina3= new Intent(Home.this,ayuda.class);
                startActivity(pagina3);

            }
        });
        btnacerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pagina4= new Intent(Home.this,acerca.class);
                startActivity(pagina4);

            }
        });
    }
}
