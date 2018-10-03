package id.technoit.dev.appiresto.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import id.technoit.dev.appiresto.R;

public class MenuActivity extends AppCompatActivity {

    SessionManager sessionManager;

    ImageView mnMeja, mnMenu, mnPesanan, mnKasir, mnLaporan, mnKeluar;

    TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        mnMeja = findViewById(R.id.mnMeja);
        mnMenu = findViewById(R.id.mnMenu);
        mnPesanan = findViewById(R.id.mnPesanan);
        mnKasir = findViewById(R.id.mnKasir);
        mnLaporan = findViewById(R.id.mnLaporan);
        mnKeluar = findViewById(R.id.mnKeluar);

        txtUser = findViewById(R.id.txtUser);

        // memanggil method getUserDetail untuk mengecek data user yg login
        HashMap<String, String> user = sessionManager.getUserDetail();

        // inisialisasi variabel dengan atribut data user yg login
        String vid_user = user.get(sessionManager.ID_USER);
        String vnama_user = user.get(sessionManager.NAMA_USER);

        txtUser.setText("User : " + vid_user + " | " + vnama_user);

        mnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logout();
            }
        });

    }
}
