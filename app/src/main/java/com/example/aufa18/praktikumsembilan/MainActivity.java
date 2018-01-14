package com.example.aufa18.praktikumsembilan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getListData();
    }

    private void getListData() {
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO(this);
        final List<Mahasiswa> mahasiswaList = mahasiswaDAO.getAllData();

        final ListView listView = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<Mahasiswa> adapter = new ArrayAdapter<Mahasiswa>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mahasiswaList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                Mahasiswa mahasiswa = mahasiswaList.get(position);
                Toast.makeText(getApplicationContext(), "Anda klik " + mahasiswa.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openAddNew(View v) {
        Intent intent = new Intent(this, MahasiswaActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListData();
    }
}
