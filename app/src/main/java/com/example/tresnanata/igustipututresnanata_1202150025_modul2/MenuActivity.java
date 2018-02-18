package com.example.tresnanata.igustipututresnanata_1202150025_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {
    private final LinkedList<String> makanan = new LinkedList<>();
    private final LinkedList<Integer> harga = new LinkedList<>();
    private final LinkedList<Integer> foto = new LinkedList<>();
    private int mCount = 0;

    private RecyclerView mRecyclerView;
    private MenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        dummiesData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MenuAdapter(this,makanan, harga,foto);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void dummiesData() {
        for (int i = 0; i < 3; i++) {
            // memberi dan memanggil nama untuk data yang ditampilkan
            makanan.add("Cheese Pizza");
            makanan.add("Meat&Cheese Pizza");
            makanan.add("Meat red Pizza");
            makanan.add("american pizza");
            makanan.add("pizzi pizza");
            makanan.add("Leaf Pizza");
            makanan.add("Leaf Pizza with cheese");
            makanan.add("European Pizza");
            makanan.add("Pizza Pudding");

            // mamanggil harga
            harga.add(50000);
            harga.add(70000);
            harga.add(75000);
            harga.add(60000);
            harga.add(56000);
            harga.add(67000);
            harga.add(56000);
            harga.add(98000);
            harga.add(44000);

            // memanggil foto yang ada di drawable
            foto.add(R.drawable.pizza1);
            foto.add(R.drawable.pizza2);
            foto.add(R.drawable.pizza3);
            foto.add(R.drawable.pizza4);
            foto.add(R.drawable.pizza5);
            foto.add(R.drawable.pizza6);
            foto.add(R.drawable.pizza6);
            foto.add(R.drawable.pizza7);
            foto.add(R.drawable.pizza8);
        }
    }
}