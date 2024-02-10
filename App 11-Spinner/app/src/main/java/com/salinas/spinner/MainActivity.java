package com.salinas.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Spinner cmbDia;
    Spinner cmbMes;
    TextInputEditText txAno;
    Button btnCalcular;
    Button btnNuevo;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String opcionDias [] ={"--SELECCIONE DÍA--","1","2","3","4","5","6","7","8","10","11","12","13","14",
                "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String opcionMes []={"--SELECCIONE MES--","ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","DICIEMBRE"};
        cmbDia = findViewById(R.id.spDias);
        cmbMes = findViewById(R.id.spinner);
        txAno = findViewById(R.id.txtAnio);
        btnCalcular = findViewById(R.id.buttonCalcular);
        btnNuevo = findViewById(R.id.buttonNuevo);
        btnSalir = findViewById(R.id.buttonSalir);

        ArrayAdapter<String>adapDias = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,opcionDias);
        ArrayAdapter<String>adapMes = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,opcionMes);

        cmbDia.setAdapter(adapDias);
        cmbMes.setAdapter(adapMes);
        //
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int noDia;
                int noMes;
                int anio;

                noDia = cmbDia.getSelectedItemPosition();
                noMes = cmbMes.getSelectedItemPosition();
                anio = Integer.parseInt(txAno.getText().toString());


                if (noDia == 0){
                    Toast.makeText(getApplicationContext(),
                            "Seleccione un Dia",
                            Toast.LENGTH_LONG).show();
                }else if (noMes == 0){
                    Toast.makeText(getApplicationContext(),
                            "Seleccione un Mes",
                            Toast.LENGTH_LONG).show();
                }else if(txAno.length() == 0){
                    txAno.setError("Debe ingresar Año");
                    txAno.requestFocus();
                }else{
                    anio = Integer.parseInt(txAno.getText().toString());
                    Toast.makeText(getApplicationContext(),
                            "dia: " + noDia +
                                    "\nmes: " + noMes +
                                    "\naño:" + anio,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txAno.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}