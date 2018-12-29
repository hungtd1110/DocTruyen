package com.example.amin.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amin.project2.DanhSachCacChuong;
import com.example.amin.model.Chuong;
import com.example.amin.project2.R;

import java.util.List;

import static com.example.amin.project2.R.id.txtSoChuong;
import static com.example.amin.project2.R.id.txtTen;

/**
 * Created by amin on 4/6/2017.
 */

public class DanhSachChuongAdapter extends ArrayAdapter<Chuong> {
    Activity context;
    int resource;
    List<Chuong> objects;

    public class ViewHolder {
        TextView txtTenChuong;
    }

    ViewHolder viewHolder;

    public DanhSachChuongAdapter(Activity context, int resource, List<Chuong> objects) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_danh_sach_chuong,parent,false);
            viewHolder.txtTenChuong = (TextView) convertView.findViewById(R.id.txtTenChuong);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Chuong chuong = this.objects.get(position);
        viewHolder.txtTenChuong.setText(chuong.getTenChuong().toString());

        return convertView;
    }
}
