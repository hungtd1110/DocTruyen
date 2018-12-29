package com.example.amin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.amin.project2.NoiDungTruyen;
import com.example.amin.project2.DanhSachCacChuong;

/**
 * Created by amin on 4/7/2017.
 */

public class TruyenAdapter extends FragmentStatePagerAdapter {

    public TruyenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment flag = null;
        switch (position) {
            case 0 :
                flag = new DanhSachCacChuong();
                break;
            case 1 :
                flag = new NoiDungTruyen();
                break;
        }
        return flag;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
