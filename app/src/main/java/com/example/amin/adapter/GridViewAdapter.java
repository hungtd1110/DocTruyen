package com.example.amin.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.amin.model.Truyen;
import com.example.amin.project2.R;

import java.io.ByteArrayInputStream;
import java.util.List;


/**
 * Created by hungv on 4/1/2017.
 */

public class GridViewAdapter extends ArrayAdapter<Truyen> {

    Activity context;
    int resource;
    List<Truyen> objects;

//    ImageView imgItem;

    public class ViewHolder {
        ImageView imgItem;
    }

    ViewHolder viewHolder;

    public GridViewAdapter(Activity context, int resource, List<Truyen> objects) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_view,parent,false);
            viewHolder.imgItem = (ImageView) convertView.findViewById(R.id.imgItem);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Truyen truyen = this.objects.get(position);
        ByteArrayInputStream bis = new ByteArrayInputStream(truyen.getImg());
        Bitmap imgBitmap = BitmapFactory.decodeStream(bis);
        viewHolder.imgItem.setImageBitmap(imgBitmap);

        return convertView;
    }
}
