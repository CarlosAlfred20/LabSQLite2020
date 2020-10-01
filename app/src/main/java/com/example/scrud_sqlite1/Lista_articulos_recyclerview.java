package com.example.scrud_sqlite1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Lista_articulos_recyclerview extends AppCompatActivity {
    private RecyclerView recycler;
    private ActualizArticls actualizArticls;
    ConexionSQLite datos = new ConexionSQLite(Lista_articulos_recyclerview.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos_recyclerview);
        recycler = (RecyclerView)findViewById(R.id.rview);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        actualizArticls = new ActualizArticls(Lista_articulos_recyclerview.this,
                datos.mostrarArticulos());
        recycler.setAdapter(actualizArticls);
    }
}
