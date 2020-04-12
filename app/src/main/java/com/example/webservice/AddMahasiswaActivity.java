package com.example.webservice;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddMahasiswaActivity extends AppCompatActivity {
    EditText nrp, nama, prodi;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);


        nrp = (EditText) findViewById(R.id.nrpMhs);
        nama = (EditText) findViewById(R.id.namaMhs);
        prodi = (EditText) findViewById(R.id.prodi);
        insert = (Button) findViewById(R.id.btnInsert);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNrp = nrp.getText().toString().trim();
                String sNama = nama.getText().toString().trim();
                String sProdi = prodi.getText().toString().trim();

                DatabaseHelper dbHelper = new DatabaseHelper( AddMahasiswaActivity.this);

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.createMahasiswaTable(db);
                dbHelper.insertDataMahasiswa(db, sNrp, sNama, sProdi);
                Toast.makeText(AddMahasiswaActivity.this, "Insert Data Mahasiswa Success", Toast.LENGTH_LONG).show();

                nrp.setText("");
                nama.setText("");
                prodi.setText("");
            }
        });
    }
}
