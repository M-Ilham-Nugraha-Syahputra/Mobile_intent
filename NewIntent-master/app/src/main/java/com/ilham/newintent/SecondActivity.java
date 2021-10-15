package com.ilham.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // inisialisasi variable
    TextView txtnama, txttgl, txtprodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // mengakses layout TextView berdasarkan id
        txtnama = (TextView) findViewById(R.id.txtnama);
        txttgl = (TextView) findViewById(R.id.txttgl);
        txtprodi = (TextView) findViewById(R.id.txtprodi);

        // mengambil data dari extra yang input
        Bundle extras = getIntent().getExtras();
        String nama = extras.getString("nama");
        String tanggal = extras.getString("tgl");
        String prodi = extras.getString("prodi");

        // menampilkan data ke masing-masing TextView
        txtnama.setText(nama);
        txttgl.setText(tanggal);
        txtprodi.setText(prodi);
    }
}