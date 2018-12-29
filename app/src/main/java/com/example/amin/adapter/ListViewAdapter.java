package com.example.amin.adapter;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amin.project2.MainActivity;
import com.example.amin.model.Chuong;
import com.example.amin.model.Truyen;
import com.example.amin.project2.R;
import com.example.amin.project2.TruyenActivity;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hungv on 3/25/2017.
 */

public class ListViewAdapter extends ArrayAdapter<Truyen> {

    Activity context;
    int resource;
    List<Truyen> objects;

    public class ViewHolder {
        ImageView imgItem;
        TextView txtTen, txtSoChuong, txtXemTruyen, txtTheLoai;
    }

    ViewHolder viewHolder;

    public static HashMap hashMap = new HashMap();
    public static Truyen truyenSelected = new Truyen();

    public ListViewAdapter(Activity context, int resource, List<Truyen> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view,parent,false);
            viewHolder.txtTen = (TextView) convertView.findViewById(R.id.txtTen);
            viewHolder.txtSoChuong = (TextView) convertView.findViewById(R.id.txtSoChuong);
            viewHolder.imgItem = (ImageView) convertView.findViewById(R.id.imgItem);
            viewHolder.txtXemTruyen = (TextView) convertView.findViewById(R.id.txtXemTruyen);
            viewHolder.txtTheLoai = (TextView) convertView.findViewById(R.id.txtTheLoai);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Truyen truyen = this.objects.get(position);
        viewHolder.txtTen.setText(truyen.getTen());
        viewHolder.txtTheLoai.setText(truyen.getTheLoai());
        viewHolder.txtSoChuong.setText(truyen.getSoChuong());
        ByteArrayInputStream bis = new ByteArrayInputStream(truyen.getImg());
        Bitmap imgBitmap = BitmapFactory.decodeStream(bis);
        viewHolder.imgItem.setImageBitmap(imgBitmap);

        events(truyen);

        return convertView;
    }

    private void events(final Truyen truyen) {
        viewHolder.txtXemTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TruyenActivity.class);
                truyenSelected = truyen;
                intent.putExtra("diChuyen",1);
                getContext().startActivity(intent);
            }
        });
    }
}
