package com.example.amin.project2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.amin.adapter.DanhSachChuongAdapter;
import com.example.amin.adapter.ListViewAdapter;
import com.example.amin.adapter.TimKiemChuongAdapter;
import com.example.amin.model.Chuong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by amin on 4/7/2017.
 */

public class DanhSachCacChuong extends Fragment {
    ListView lvDanhSachChuong;
    DanhSachChuongAdapter danhSachChuongAdapter;
    TimKiemChuongAdapter timKiemChuongAdapter;
    ImageView imgTimKiemChuong, imgRefresh;
    ArrayList<Chuong> dsTimKiemChuong = new ArrayList<>();
    ArrayList<Chuong> dsTimKiem1 = new ArrayList<>();
    ArrayList<Chuong> dsTimKiem2 = new ArrayList<>();
    ArrayList<Chuong> dsTimKiem3 = new ArrayList<>();
    ArrayList<Chuong> dsHienThi = new ArrayList<>();
    int timKiem = 0;
    final int[] kieuTimKiem = {0};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGroup = inflater.inflate(R.layout.danh_sach_cac_chuong,container,false);
        imgTimKiemChuong = (ImageView) viewGroup.findViewById(R.id.imgTimKiemChuong);
        imgRefresh = (ImageView) viewGroup.findViewById(R.id.imgRefresh);
        lvDanhSachChuong = (ListView) viewGroup.findViewById(R.id.lvDanhSachChuong);
        danhSachChuongAdapter = new DanhSachChuongAdapter(getActivity(), R.layout.item_danh_sach_chuong, ListViewAdapter.truyenSelected.getDsChuong());
        lvDanhSachChuong.setAdapter(danhSachChuongAdapter);

        events();

        return viewGroup;
    }

    private void events() {
        lvDanhSachChuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ChuongActivity.class);
                if (timKiem == 0) {
                    intent.putExtra("chuong", position);
                }
                else {
                    int chuong = Integer.parseInt(dsHienThi.get(position).getChuong()) - 1;
                    intent.putExtra("chuong",chuong);
                }
                startActivity(intent);
                getActivity().finish();
            }
        });

//        imgTimKiemChuong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
//                dialog.setTitle("Tìm Kiếm Chương");
//                dialog.setIcon(R.drawable.search_chuong);
//                dialog.setCancelable(false);
//
//                final EditText txtTimKiem = new EditText(getActivity());
//                txtTimKiem.setHint("Nhập đoạn truyện                                                     ");
//                txtTimKiem.setTextSize(14);
//
//                LinearLayout lnTimKiem = new LinearLayout(getActivity());
//                lnTimKiem.addView(txtTimKiem);
//                lnTimKiem.setPadding(40,10,40,0);
//                dialog.setView(lnTimKiem);
//
//                dialog.setNegativeButton("Tìm Kiếm", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        timKiem = 1;
//                        for (Chuong chuong : ListViewAdapter.truyenSelected.getDsChuong()) {
//                            dsTimKiemChuong.add(chuong);
//                        }
//                        dsTimKiem1.clear();
//                        dsTimKiem2.clear();
//                        dsTimKiem3.clear();
//                        //tìm kiếm danh sách loại 1
//                        for (Chuong chuong : dsTimKiemChuong) {
//                            xuLyTimKiem1(chuong,txtTimKiem.getText().toString());
//                        }
//                        for (Chuong chuong : dsTimKiem1) {
//                            dsTimKiemChuong.remove(chuong);
//                        }
//                        //tìm kiếm danh sách loại 2
//                        for (Chuong chuong : dsTimKiemChuong) {
//                            xuLyTimKiem2(chuong,txtTimKiem.getText().toString());
//                        }
//                        for (Chuong chuong : dsTimKiem2) {
//                            dsTimKiemChuong.remove(chuong);
//                        }
//                        //tìm kiếm danh sách loại 3
//                        HashMap hashMap = new HashMap();
//                        ArrayList<Integer> dsIndexChuong = new ArrayList<Integer>();
//                        for (Chuong chuong : dsTimKiemChuong) {
//                            ArrayList<Chuong> ds = new ArrayList<Chuong>();
//                            int count = 0;
//                            int indexChuong = xuLyTimKiem3(chuong,txtTimKiem.getText().toString());
//
//                            if (indexChuong != 0) {
//                                //kiểm tra xem khóa tồn tại chưa
//                                for (int k = 0;k < dsIndexChuong.size();++k) {
//                                    if (indexChuong == dsIndexChuong.get(k)) {
//                                        ds = (ArrayList<Chuong>) hashMap.get(dsIndexChuong.get(k));
//                                        ds.add(chuong);
//                                        hashMap.put(indexChuong,ds);
//                                        count++;
//                                        break;
//                                    }
//                                }
//                                if (count == 0) {
//                                    ds.add(chuong);
//                                    hashMap.put(indexChuong, ds);
//                                    dsIndexChuong.add(indexChuong);
//                                }
//                            }
//                        }
//                        Collections.sort(dsIndexChuong);
//                        for (int k = dsIndexChuong.size()-1;k >= 0;k--) {
//                            ArrayList<Chuong> ds = (ArrayList<Chuong>) hashMap.get(dsIndexChuong.get(k));
//                            for (Chuong chuong : ds) {
//                                dsTimKiem3.add(chuong);
//                            }
//                        }
//                        //tập hợp lại kết quả tìm kiếm
//                        dsHienThi.clear();
//                        dsHienThi = ketQuaTimKiem();
//
//                        timKiemChuongAdapter = new TimKiemChuongAdapter(getActivity(),R.layout.item_tim_kiem_chuong,dsHienThi);
//                        lvDanhSachChuong.setAdapter(timKiemChuongAdapter);
//                    }
//                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                }).create();
//
//                dialog.show();
//            }
//        });

        imgTimKiemChuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int[] click = {0};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.search_chuong);
                builder.setCancelable(false);
                builder.setTitle("Chọn kiểu tìm kiếm");
                builder.setSingleChoiceItems(new CharSequence[]{"Tìm kiếm theo tên chương", "Tìm kiếm theo đoạn truyện"},
                        0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                kieuTimKiem[0] = i;
                                click[0]++;
                            }
                        })
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                timKiem = 1;
                                if (click[0] == 0) {
                                    kieuTimKiem[0] = 0;
                                }
                                if (kieuTimKiem[0] == 0) {
                                    //tìm kiếm theo tên chương
                                    xuLyTimKiemTheoTenChuong();
                                }
                                else {
                                    //tìm kiếm theo đoạn truyện
                                    xuLyTimKiemTheoDoanTruyen();
                                }
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create();

                builder.show();
            }
        });

        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timKiem = 0;
                lvDanhSachChuong.setAdapter(danhSachChuongAdapter);
            }
        });
    }

    private void xuLyTimKiemTheoDoanTruyen() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Tìm Kiếm Chương");
        dialog.setIcon(R.drawable.search_chuong);
        dialog.setCancelable(false);

        final EditText txtTimKiem = new EditText(getActivity());
        txtTimKiem.setHint("Nhập đoạn truyện                                                     ");
        txtTimKiem.setTextSize(14);

        LinearLayout lnTimKiem = new LinearLayout(getActivity());
        lnTimKiem.addView(txtTimKiem);
        lnTimKiem.setPadding(40,10,40,0);
        dialog.setView(lnTimKiem);

        dialog.setNegativeButton("Tìm Kiếm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //xử lý tim kiếm
                xuLyTimKiem(txtTimKiem.getText().toString());
            }
        }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();

        dialog.show();
    }

    private void xuLyTimKiem(String noiDungTimKiem) {
        dsTimKiemChuong.clear();
        for (Chuong chuong : ListViewAdapter.truyenSelected.getDsChuong()) {
            dsTimKiemChuong.add(chuong);
        }
        //tìm kiếm danh sách loại 1
        dsTimKiem1.clear();
        for (Chuong chuong : dsTimKiemChuong) {
            xuLyTimKiem1(chuong,noiDungTimKiem);
        }
        for (Chuong chuong : dsTimKiem1) {
            dsTimKiemChuong.remove(chuong);
        }
        //tìm kiếm danh sách loại 2
        dsTimKiem2.clear();
        for (Chuong chuong : dsTimKiemChuong) {
            xuLyTimKiem2(chuong,noiDungTimKiem);
        }
        for (Chuong chuong : dsTimKiem2) {
            dsTimKiemChuong.remove(chuong);
        }
        //tìm kiếm danh sách loại 3
        dsTimKiem3.clear();
        HashMap hashMap = new HashMap();
        ArrayList<Integer> dsIndexChuong = new ArrayList<Integer>();
        for (Chuong chuong : dsTimKiemChuong) {
            ArrayList<Chuong> ds = new ArrayList<Chuong>();
            int count = 0;
            int indexChuong = xuLyTimKiem3(chuong,noiDungTimKiem);

            if (indexChuong != 0) {
                //kiểm tra xem khóa tồn tại chưa
                for (int k = 0;k < dsIndexChuong.size();++k) {
                    if (indexChuong == dsIndexChuong.get(k)) {
                        ds = (ArrayList<Chuong>) hashMap.get(dsIndexChuong.get(k));
                        ds.add(chuong);
                        hashMap.put(indexChuong,ds);
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    ds.add(chuong);
                    hashMap.put(indexChuong, ds);
                    dsIndexChuong.add(indexChuong);
                }
            }
        }
        Collections.sort(dsIndexChuong);
        for (int k = dsIndexChuong.size()-1;k >= 0;k--) {
            ArrayList<Chuong> ds = (ArrayList<Chuong>) hashMap.get(dsIndexChuong.get(k));
            for (Chuong chuong : ds) {
                dsTimKiem3.add(chuong);
            }
        }
        //tập hợp lại kết quả tìm kiếm
        dsHienThi.clear();
        dsHienThi = ketQuaTimKiem();

        timKiemChuongAdapter = new TimKiemChuongAdapter(getActivity(),R.layout.item_tim_kiem_chuong,dsHienThi);
        lvDanhSachChuong.setAdapter(timKiemChuongAdapter);
    }

    private void xuLyTimKiemTheoTenChuong() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Tìm Kiếm Chương");
        dialog.setIcon(R.drawable.search_chuong);
        dialog.setCancelable(false);

        final EditText txtTimKiem = new EditText(getActivity());
        txtTimKiem.setHint("Nhập tên chương                                                      ");
        txtTimKiem.setTextSize(14);

        LinearLayout lnTimKiem = new LinearLayout(getActivity());
        lnTimKiem.addView(txtTimKiem);
        lnTimKiem.setPadding(40,10,40,0);
        dialog.setView(lnTimKiem);

        dialog.setNegativeButton("Tìm Kiếm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //xử lý tim kiếm
                xuLyTimKiem(txtTimKiem.getText().toString());
            }
        }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();

        dialog.show();
    }

    private ArrayList<Chuong> ketQuaTimKiem() {
        ArrayList<Chuong> dsHienThi = new ArrayList<>();

        for (Chuong chuong : dsTimKiem1) {
            dsHienThi.add(chuong);
        }
        for (Chuong chuong : dsTimKiem2) {
            dsHienThi.add(chuong);
        }
        for (Chuong chuong : dsTimKiem3) {
            dsHienThi.add(chuong);
        }

        return dsHienThi;
    }

    private int xuLyTimKiem3(Chuong chuong, String s) {
        String noiDung;
        if (kieuTimKiem[0] == 0) {
            noiDung = locKyTu(chuong.getTenChuong());
        }
        else {
            noiDung = locKyTu(chuong.getNoiDung());
        }
        String nd[] = noiDung.split(" ");
        String word[] = s.split(" ");
        int count = 0;
        String xauTimKiem = "";

        for (int i = 0;i < word.length;++i) {
            for (int j = 0;j < nd.length;++j) {
                if (word[i].toString().equalsIgnoreCase(nd[j].toString())) {
                    xauTimKiem += word[i]+" ";
                    count++;
                    break;
                }
            }
        }
        chuong.setXauTimKiem(xauTimKiem);
        return count;
    }

    private void xuLyTimKiem2(Chuong chuong, String s) {
        String noiDung;
        if (kieuTimKiem[0] == 0) {
            noiDung = locKyTu(chuong.getTenChuong());
        }
        else {
            noiDung = locKyTu(chuong.getNoiDung());
        }
        String nd[] = noiDung.split(" ");
        String word[] = s.split(" ");
        int count = 0;

        for (int i = 0;i < word.length;++i) {
            for (int j = 0;j < nd.length;++j) {
                if (word[i].toString().equalsIgnoreCase(nd[j].toString())) {
                    count++;
                    break;
                }
            }
        }

        if (count == word.length) {
            String xauTimKiem = "";
            for (int k = 0;k < word.length;++k) {
                xauTimKiem += word[k]+" ";
            }
            chuong.setXauTimKiem(xauTimKiem);
            dsTimKiem2.add(chuong);
        }
    }

    private void xuLyTimKiem1(Chuong chuong, String s) {
        String noiDung;
        if (kieuTimKiem[0] == 0) {
            noiDung = locKyTu(chuong.getTenChuong());
        }
        else {
            noiDung = locKyTu(chuong.getNoiDung());
        }
        String nd[] = noiDung.split(" ");
        String word[] = s.split(" ");
        int j = 0;

        for (int i = 0; i < nd.length; ++i) {
            if (nd[i].toString().equalsIgnoreCase(word[j].toString())) {
                j++;
                if (j == word.length) {
                    String xauTimKiem = "";
                    for (int k = 0; k < word.length; ++k) {
                        xauTimKiem += word[k] + " ";
                    }
                    chuong.setXauTimKiem(xauTimKiem);
                    dsTimKiem1.add(chuong);
                    break;
                }
            }
        }
    }

    private String locKyTu(String s) {
        String wordSpecical = "< > / . , ( ) ? ! ; - [ ] 0 1 2 3 4 5 6 7 8 9 ' : \" ; ";
        String[] word = wordSpecical.split(" ");
        for (int i = 0;i < word.length;++i) {
            s.replace(word[i],"");
        }

        return s;
    }
}
