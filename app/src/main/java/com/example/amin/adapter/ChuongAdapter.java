package com.example.amin.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.amin.project2.ChuongActivity;
import com.example.amin.project2.R;
import com.example.amin.model.Chuong;

import java.util.ArrayList;

/**
 * Created by amin on 4/6/2017.
 */

public class ChuongAdapter extends PagerAdapter {
    Context mContext;
    ArrayList<Chuong> dsChuong;

    TextView txtNoiDung,txtChuong,txtTongChuong;
    WebView wvNoiDung;

    public ChuongAdapter(Context mContext, ArrayList<Chuong> dsChuong) {
        this.mContext = mContext;
        this.dsChuong = dsChuong;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.noi_dung_chuong, container, false);
        txtNoiDung = (TextView) itemView.findViewById(R.id.txtNoiDung);
        txtChuong = (TextView) itemView.findViewById(R.id.txtchuong);
        txtTongChuong = (TextView) itemView.findViewById(R.id.txtTongChuong);

        txtNoiDung.setText(dsChuong.get(position).getNoiDung());
        txtChuong.setText(dsChuong.get(position).getChuong());
        txtTongChuong.setText(dsChuong.size()+"");

        container.addView(itemView);

        return itemView;
    }

    @Override
    public int getCount() {
        return dsChuong.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
