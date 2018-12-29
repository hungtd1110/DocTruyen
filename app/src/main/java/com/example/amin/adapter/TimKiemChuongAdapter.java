package com.example.amin.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.amin.project2.R;
import com.example.amin.model.Chuong;

import java.util.List;

/**
 * Created by amin on 5/6/2017.
 */

public class TimKiemChuongAdapter extends ArrayAdapter<Chuong> {
    Activity context;
    int resource;
    List<Chuong> objects;

    public class ViewHolder {
        TextView txtTenChuong,txtXauTimKiem,txt1,txt2;
    }

    ViewHolder viewHolder;

    public TimKiemChuongAdapter(Activity context, int resource, List<Chuong> objects) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tim_kiem_chuong,parent,false);
            viewHolder.txtTenChuong = (TextView) convertView.findViewById(R.id.txtTenChuong);
            viewHolder.txtXauTimKiem = (TextView) convertView.findViewById(R.id.txtXauTimKiem);
            viewHolder.txt1 = (TextView) convertView.findViewById(R.id.txt1);
            viewHolder.txt2 = (TextView) convertView.findViewById(R.id.txt2);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Chuong chuong = this.objects.get(position);
        viewHolder.txtTenChuong.setText(chuong.getTenChuong().toString());
        viewHolder.txtXauTimKiem.setText(chuong.getXauTimKiem().toString());

        return convertView;
    }
}
