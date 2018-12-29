package com.example.amin.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.amin.adapter.GridViewAdapter;
import com.example.amin.adapter.ListViewAdapter;
import com.example.amin.model.Truyen;

import java.util.ArrayList;

/**
 * Created by hungv on 4/1/2017.
 */

public class TrangChu extends Fragment {

    ListView lvDanhSach;
    GridView gvDanhSach;
    ListViewAdapter listViewAdapter;
    GridViewAdapter gridViewAdapter;

    boolean viewTrangChu = true;

    ArrayList<Truyen> dsTimKiem = new ArrayList<>();
    int index = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        //tham chieu tham so
        View viewGroup = inflater.inflate(R.layout.trang_chu,container,false);
        lvDanhSach = (ListView) viewGroup.findViewById(R.id.lvDanhSach);
        gvDanhSach = (GridView) viewGroup.findViewById(R.id.gvDanhSach);
        listViewAdapter = new ListViewAdapter(this.getActivity(),R.layout.item_list_view,MainActivity.dsTruyen);
        gridViewAdapter = new GridViewAdapter(this.getActivity(),R.layout.item_grid_view,MainActivity.dsTruyen);
        lvDanhSach.setAdapter(listViewAdapter);

        events();
        update();

        return viewGroup;
    }

    private void events() {
        gvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TruyenActivity.class);
                ListViewAdapter.truyenSelected = MainActivity.dsTruyen.get(position);
                intent.putExtra("diChuyen",1);
                startActivity(intent);
            }
        });

        MainActivity.imgTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewTrangChu == true) {
                    lvDanhSach.setAdapter(null);
                    gvDanhSach.setAdapter(gridViewAdapter);
                    MainActivity.imgTrangChu.setImageResource(R.drawable.grid_view);
                    viewTrangChu = false;
                } else {
                    gvDanhSach.setAdapter(null);
                    lvDanhSach.setAdapter(listViewAdapter);
                    MainActivity.imgTrangChu.setImageResource(R.drawable.list_view);
                    viewTrangChu = true;
                }
            }
        });

        MainActivity.autoTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (MainActivity.autoTimKiem.getText().toString().equals("")) {
                    lvDanhSach.setAdapter(listViewAdapter);
                }
                else {
                    dsTimKiem.clear();
                    for (Truyen truyen : MainActivity.dsTruyen) {
                        if (truyen.getTen().toString().equals(MainActivity.autoTimKiem.getText().toString())) {   //hoặc s.toString();
                            dsTimKiem.add(truyen);
                        }
                    }
                    gvDanhSach.setAdapter(null);
                    listViewAdapter = new ListViewAdapter(getActivity(), R.layout.item_list_view, dsTimKiem);
                    lvDanhSach.setAdapter(listViewAdapter);
                    MainActivity.imgTrangChu.setImageResource(R.drawable.list_view);
                    listViewAdapter = new ListViewAdapter(getActivity(), R.layout.item_list_view, MainActivity.dsTruyen);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void update() {
        MainActivity.viewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                index = position;
                if (position == 0) {
                    MainActivity.imgTrangChu.setVisibility(View.VISIBLE);
//                    MainActivity.imgTimKiemTT.setVisibility(View.VISIBLE);
                    gvDanhSach.setAdapter(null);
                    lvDanhSach.setAdapter(listViewAdapter);
                    MainActivity.imgTrangChu.setImageResource(R.drawable.list_view);
                    viewTrangChu = true;
                }
                else {
                    MainActivity.imgTrangChu.setVisibility(View.INVISIBLE);
//                    MainActivity.imgTimKiemTT.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        listViewAdapter.notifyDataSetChanged();
    }
}
