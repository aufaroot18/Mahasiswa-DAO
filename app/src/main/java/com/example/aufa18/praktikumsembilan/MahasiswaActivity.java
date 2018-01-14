package com.example.aufa18.praktikumsembilan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by aufa18 on 14/01/18.
 */

public class MahasiswaActivity extends AppCompatActivity {
    private MahasiswaDAO mahasiswaDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        mahasiswaDAO = new MahasiswaDAO(this);

        ((Button) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nim = ((TextView) findViewById(R.id.txt_nim)).getText().toString();
                String nama = ((TextView) findViewById(R.id.txt_nama)).getText().toString();
                String jurusan = ((TextView) findViewById(R.id.txt_jurusan)).getText().toString();

                Mahasiswa m = new Mahasiswa(null, nim, nama, jurusan);

                if (mahasiswaDAO.insert(m)>0) {
                    Toast.makeText(MahasiswaActivity.this, "Data disimpan",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MahasiswaActivity.this, "Data Gagal Disimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
