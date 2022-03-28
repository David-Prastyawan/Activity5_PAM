package com.example.linearlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //deklarasi variabel dengan jenis data context
    Context mContext;

    //deklarasi variabel dengan jenis data layout onflater
    LayoutInflater inflater;

    //deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor listviewadapter
    public ListViewAdapter(Context context){
        //memberi nilai mContext dengan context
        mContext = context;

        //mengatur layoutflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arraylist dari classNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambhkan semua elemen ke arraylist
        this.arrayList.addAll(HomeActivity.classNamaArrayList);
    }

    public class ViewHolder{
        //mendeklarasikan variabel dengan jenis Textview
        TextView name;
    }


    @Override
    public int getCount() {
        return HomeActivity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return HomeActivity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data viewholder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if (view == null){

            //mebuat objek view holder
            holder = new ViewHolder();

            //layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data tdalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);

        }
        else {
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //set item ke TextViews
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getName());;

        //mengembalikan nilai ke variabel view
        return view;
    }
}
