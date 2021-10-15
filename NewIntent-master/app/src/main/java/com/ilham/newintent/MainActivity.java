package com.ilham.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //inisialisasi variable
    EditText txtnama, txttgl, txtprodi;
    Button explicitintent, implicitintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mengakses id tombol masing masing
        explicitintent = (Button) findViewById(R.id.explicit);
        explicitintent.setOnClickListener(this);
        implicitintent = (Button) findViewById(R.id.implicit);
        implicitintent.setOnClickListener(this);

        //mengakses layout EditText dengan id
        txtnama = (EditText) findViewById(R.id.txtnama);
        txttgl = (EditText) findViewById(R.id.txttgl);
        txtprodi = (EditText) findViewById(R.id.txtprodi);


    }

    @Override
    public void onClick(View v) {
        //membuat pengkondisian untuk mentukan tombol mana yang dijalankan
        switch(v.getId()) {
            // memberi aksi untuk tombol explicit
            case (R.id.explicit) :
                String nama = txtnama.getText().toString(); // mengambil data nama
                String tanggal = txttgl.getText().toString(); // mengambil data tanggal
                String prodi = txtprodi.getText().toString(); // mengambil data prodi
                Intent explicit = new Intent(MainActivity.this, SecondActivity.class); //mengarahkan intent ke activity lain
                explicit.putExtra("nama", nama); //menambahkan data nama
                explicit.putExtra("tgl",tanggal); // menambahkan data tanggal
                explicit.putExtra("prodi", prodi); // menambahkan data prodi
                startActivity(explicit); // pindah activity
                break;

                // memberi aksi untuk tombol implisit
            case (R.id.implicit):
                // mengakses url tertentu, maka akan ada opsi membuka dengan app lain
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chrome.google.com"));
                startActivity(implicit);
                break;
            default:
                break;
        }
    }
}