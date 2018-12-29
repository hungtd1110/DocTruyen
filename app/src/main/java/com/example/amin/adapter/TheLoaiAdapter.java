package com.example.amin.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amin.project2.MainActivity;
import com.example.amin.project2.R;

import java.util.List;

/**
 * Created by amin on 4/10/2017.
 */

public class TheLoaiAdapter extends ArrayAdapter<String> {
    Activity context;
    int resource;
    List<String> objects;

    TextView txtTheLoai,txtMenu;
    ImageView imgNext;

    public TheLoaiAdapter(Activity context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);
        txtTheLoai = (TextView) row.findViewById(R.id.txtTheLoai);
        txtMenu = (TextView) row.findViewById(R.id.txtMenu);
        imgNext = (ImageView) row.findViewById(R.id.imgNext);

        String theLoai = getItem(position);
        if (position == 0) {
            txtMenu.setText("THỂ LOẠI");
            txtTheLoai.setVisibility(View.INVISIBLE);
            imgNext.setVisibility(View.INVISIBLE);
        }
        else if (position == MainActivity.sizeTheLoai - 2) {
            txtMenu.setText("THÊM TRUYỆN");
            txtTheLoai.setVisibility(View.INVISIBLE);
            imgNext.setVisibility(View.INVISIBLE);
        }
        else {
            txtTheLoai.setText(theLoai);
            txtMenu.setVisibility(View.INVISIBLE);
            imgNext.setVisibility(View.VISIBLE);
        }

        return  row;
    }
}
