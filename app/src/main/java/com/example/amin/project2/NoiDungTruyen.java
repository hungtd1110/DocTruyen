package com.example.amin.project2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amin.adapter.ListViewAdapter;

import java.io.ByteArrayInputStream;

/**
 * Created by amin on 4/7/2017.
 */

public class NoiDungTruyen extends Fragment {
    TextView txtTomTat;
    ImageView imgTomTat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGroup = inflater.inflate(R.layout.noi_dung_truyen, container, false);
        txtTomTat = (TextView) viewGroup.findViewById(R.id.txtTomTat);
        imgTomTat = (ImageView) viewGroup.findViewById(R.id.imgTomTat);

        txtTomTat.setText(ListViewAdapter.truyenSelected.getTomTat().toString());
        ByteArrayInputStream bis = new ByteArrayInputStream(ListViewAdapter.truyenSelected.getImg());
        Bitmap imgBitmap = BitmapFactory.decodeStream(bis);
        imgTomTat.setImageBitmap(imgBitmap);

        return viewGroup;
    }
}
