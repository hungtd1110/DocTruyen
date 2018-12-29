package com.example.amin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.amin.project2.TrangChu;
import com.example.amin.project2.YeuThich;

/**
 * Created by hungv on 4/1/2017.
 */

public class MainAdapter extends FragmentStatePagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0 :
                frag = new TrangChu();
                break;
            case 1 :
                frag = new YeuThich();
                break;
//            case 2 :
//                frag = new TheLoai();
//                break;
//            case 3 :
//                frag = new ThemTruyen();
//                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0 :
                title = "           Tất cả           ";
                break;
            case 1 :
                title = "          Yêu Thích          ";
                break;
//            case 2 :
//                title = "Thể Loại";
//                break;
//            case 3 :
//                title = "Thêm Truyện";
//                break;
        }
        return title;
    }
}
