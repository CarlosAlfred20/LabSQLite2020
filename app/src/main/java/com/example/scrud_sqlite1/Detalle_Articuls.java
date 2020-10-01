package com.example.scrud_sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Detalle_Articuls extends AppCompatActivity {

    private TextView codg, descr, ins;
    private TextView codg1,desc1,mas1, fecha1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_articulos);
        codg = (TextView) findViewById(R.id.TV_codU1);
        descr = (TextView) findViewById(R.id.tv_descdETT2);
        ins = (TextView) findViewById(R.id.tV_PrcDtt3);
        codg1 = (TextView) findViewById(R.id.TV_codU1);
        desc1 = (TextView) findViewById(R.id.Tv_Descdllt2);
        mas1 = (TextView) findViewById(R.id.Tvprecdt3);
        fecha1 = (TextView) findViewById(R.id.tv_fecha);
        Bundle obj = getIntent().getExtras();
        Dto dto = null;
        if (obj != null){
            dto = (Dto) obj.getSerializable("articulo");
            codg.setText(""+dto.getCodigo());
            descr.setText(dto.getDescripcion());
            ins.setText(""+dto.getPrecio());

            codg1.setText(""+dto.getCodigo());
            desc1.setText(dto.getDescripcion());
            mas1.setText(String.valueOf(dto.getPrecio()));
            fecha1.setText("Fecha de creacion: "+getDateTime());
        }
    }
    private String getDateTime(){
        SimpleDateFormat dates = new SimpleDateFormat(
                "yyyy-MM-dd-HH:mm:ss a", Locale.getDefault());
        Date day = new Date();
        return dates.format(day);
    }
    public  void  vol (View view){
        onBackPressed();
    }
}