package com.example.linearlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel
    Button btnLogin;
    private EditText edemail, edpassword;
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDftr)
        {
            //memanggil activity DaftarActivity
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel
        Button btnLogin = findViewById(R.id.btSignin);
        edemail = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan input user
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                //set data yang benar
                String email = "david";
                String pass = "666";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email & Password wajib Diisi!", Toast.LENGTH_LONG);
                    edemail.setError("Email Harus Diisi!!!");
                    edpassword.setError("Password Harus Diisi!!!");
                    t.show();
                }
                if (nama.equals("david") && password.equals("666")) {

                    Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", nama.trim());
                    b.putString("b", password.trim());

                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    i.putExtras(b);

                    startActivity(i);

                }
                else if (!nama.equals("david") && password.equals("666")) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (nama.equals("david") && !password.equals("666")) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Password salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password salah", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}