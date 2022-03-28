package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {

    //deklarasi variabel dengan jenis data Textview
    TextView tvnama, tvnomor;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString( "a");

        tvnama = (TextView) findViewById(R.id.tvNamaKontak);
        tvnomor = (TextView) findViewById(R.id.tvNomorTelepon);

        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("081254874523");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("085647821697");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("084987226641");
                break;
            case "Fikri":
                tvnama.setText("M Fikri");
                tvnomor.setText("084876363659");
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("081247874546");
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("081565478987");
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("081236987410");
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("085698787822");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi M");
                tvnomor.setText("082233664857");
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("089933487214");
                break;
        }
    }
}