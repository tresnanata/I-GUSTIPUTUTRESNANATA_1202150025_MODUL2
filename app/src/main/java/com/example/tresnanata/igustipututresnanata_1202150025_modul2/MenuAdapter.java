package com.example.tresnanata.igustipututresnanata_1202150025_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Tresnanata on 18/02/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    // untuk deklarasi objek
    private final LinkedList<String> mListMakanan;
    private final LinkedList<Integer> mListHarga;
    private final LinkedList<Integer> mListFoto;
    private LayoutInflater mInflater;

    public MenuAdapter(Context context, LinkedList<String> listMakanan, LinkedList<Integer> listHarga, LinkedList<Integer> listFoto) {
        mInflater = LayoutInflater.from(context);
        this.mListMakanan = listMakanan;
        this.mListHarga = listHarga;
        this.mListFoto = listFoto;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_menu, parent, false);
        return new MenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        String mCurrentFood = mListMakanan.get(position);
        Integer mCurrentPrice = mListHarga.get(position);
        Integer mCurrentPhoto = mListFoto.get(position);
        holder.makananItemView.setText(mCurrentFood);
        holder.hargaItemView.setText("Rp." + mCurrentPrice.toString());
        holder.fotoItemView.setImageResource(mCurrentPhoto);
    }

    @Override
    public int getItemCount() {
        return mListMakanan.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView makananItemView;
        public final TextView hargaItemView;
        public final ImageView fotoItemView;

        final MenuAdapter mAdapter;

        public MenuViewHolder(final View itemView, MenuAdapter adapter) {
            super(itemView);
            makananItemView = (TextView) itemView.findViewById(R.id.textmakanan);
            hargaItemView = (TextView) itemView.findViewById(R.id.textharga);
            fotoItemView = (ImageView) itemView.findViewById(R.id.imagephoto);
            fotoItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // untuk mendapatkan posisi item yang diklik
                    int mPosition = getLayoutPosition();
                    // untuk mengakses item yang terpengaruh di mWordList.
                    String food = mListMakanan.get(mPosition);
                    Integer price = mListHarga.get(mPosition);
                    Integer photo = mListFoto.get(mPosition);
                    Intent intent = new Intent(itemView.getContext(), DetailMenuActivity.class);
                    intent.putExtra("makanan", food);
                    intent.putExtra("harga", price);
                    intent.putExtra("foto", photo);
                    itemView.getContext().startActivity(intent);
                }
            });
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {
        }
}
}

