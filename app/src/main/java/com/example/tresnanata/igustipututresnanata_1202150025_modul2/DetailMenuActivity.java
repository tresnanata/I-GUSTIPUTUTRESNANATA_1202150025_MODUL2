package com.example.tresnanata.igustipututresnanata_1202150025_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenuActivity extends AppCompatActivity {

    // untuk deklarasi objek
    TextView text_makanan, text_harga;
    ImageView image_foto;

    // method ketika dijalankan saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        Intent intent = getIntent(); // mengambil data dari activity sebeleumnya
        String food = intent.getStringExtra("makanan");
        Integer price = intent.getIntExtra("harga",0);
        Integer photo = intent.getIntExtra("foto",0);

        Log.d("getIntExtra", ""+price+photo);

        text_makanan = (TextView)findViewById(R.id.text_detail_makanan);
        text_harga = (TextView)findViewById(R.id.text_detail_harga);
        image_foto = (ImageView)findViewById(R.id.image_detail_foto);

        text_makanan.setText(food);
        text_harga.setText("Rp. "+price);
        image_foto.setImageResource(photo);
    }
}
