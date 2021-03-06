package com.example.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    //deklarasi variabel dengan jenis data Listview
    private ListView list;

    //memanggil class ListViewAdapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //deklarasi array untuk menyimpan nama
    String[] listNama;

    //memanggil calss CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //membuat objek bundle
    Bundle bundle = new Bundle();

    //membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listNama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina", "Gita", "Vian", "Lutfi"};
        list = findViewById(R.id.ListKontak);

        //membuat objek dari class ClassNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada array ListNama
        for (int i = 0; i < listNama.length; i++)
        {
            //membuat objek classNama
            ClassNama classNama = new ClassNama(listNama[i]);

            //Binds string ke array
            classNamaArrayList.add(classNama);
        }
        //membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter(this);

        //Binds adapter ke listView
        list.setAdapter(adapter);

        //membuat event dari list onClick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //deklarasi variabel nama  yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                //memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                bundle.putString("a", nama.trim());

                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(HomeActivity.this);

                //menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //menampilakan popup menu
                pm.show();
            }
        });
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit kontak", Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

}
