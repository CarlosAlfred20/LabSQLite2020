package com.example.scrud_sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class consulta extends AppCompatActivity {
    private Spinner ConsultSPN;
    private TextView CdConsul1,DescpConsul2,preConsul3;
    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto dato = new Dto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        //inicio del menu
        FloatingActionButton fab1 = findViewById(R.id.uno);
        FloatingActionButton fab2 = findViewById(R.id.dos);
        FloatingActionButton fab3 = findViewById(R.id.tres);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(consulta.this,"salir ",Toast.LENGTH_SHORT).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(consulta.this,"autor",Toast.LENGTH_SHORT).show();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(consulta.this,"retornar",Toast.LENGTH_SHORT).show();
            }
        });

        //fin del menu
        ConsultSPN = (Spinner)findViewById(R.id.SP_Options1);
        CdConsul1 = (TextView) findViewById(R.id.Tv_Cod1);
        DescpConsul2 = (TextView) findViewById(R.id.Tv_Descripcion2);
        preConsul3 = (TextView) findViewById(R.id.pin);
        conexion.consultarListaArticulos();
        ArrayAdapter<CharSequence> adap = new ArrayAdapter(this,android.R.layout.simple_spinner_item,conexion.obtenerListaArticulos());
        ConsultSPN.setAdapter(adap);
        ConsultSPN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    CdConsul1.setText("Codigo: "+conexion.consultarListaArticulos().get(i-1).getCodigo());
                    DescpConsul2.setText("Descripcion: "+conexion.consultarListaArticulos().get(i-1).getDescripcion());
                    preConsul3.setText("Precio: "+conexion.consultarListaArticulos().get(i-1).getPrecio());
                }else
                {
                    CdConsul1.setText("El Codigo esta Vacio");
                    DescpConsul2.setText("Descripción esta Vacio");
                    preConsul3.setText("Precio esta Vacio");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    public  void  vol (View view){
        onBackPressed();
    }
}