package com.example.amin.project2;

import android.content.ContextWrapper;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amin.model.Truyen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ThemTruyenActivity extends AppCompatActivity {

    ImageView imgSupport, imgBackMain;
    TextView txtHuongDan, txtNoiDung;
    EditText txtThemTruyen;
    Button btnThemTruyen;
    String truyenRead = null;
    static final String truyenName = "dsTruyenThem.txt";
    static final File file = Environment.getExternalStorageDirectory();
    int support = 0;
    static final String noiDung = "Nội dung";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_truyen);
        getSupportActionBar().hide();   //tạo cho layout full màn hình
        addControls();
        addEvents();
    }


    private void addEvents() {
        btnThemTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readTruyenExternal ();
            }
        });

        imgSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (support == 0) {
                    txtNoiDung.setVisibility(View.VISIBLE);
                    txtHuongDan.setVisibility(View.VISIBLE);
                    support = 1;
                }
                else {
                    txtNoiDung.setVisibility(View.INVISIBLE);
                    txtHuongDan.setVisibility(View.INVISIBLE);
                    support = 0;
                }
            }
        });

        imgBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void readTruyenExternal () {
        truyenRead = txtThemTruyen.getText().toString()+".txt";
        try {
            FileInputStream fis = new FileInputStream(file + "/" + truyenRead);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Truyen truyen = (Truyen) ois.readObject();
            int count = 0;
            for (Truyen t : MainActivity.dsTruyen) {
                if (t.getTen().toString().equals(truyen.getTen().toString())) {
                    count ++;
                    break;
                }
            }
            if (count == 0) {
                MainActivity.dsTruyenThem.add(truyen);
            }
            ois.close();
            fis.close();
            Toast.makeText(ThemTruyenActivity.this,"Thêm truyện thành công",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(ThemTruyenActivity.this,"Hãy nhập chính xác tên file",Toast.LENGTH_SHORT).show();
        }

    }

    private void addControls() {
        txtThemTruyen = (EditText) findViewById(R.id.txtThemTruyen);
        btnThemTruyen = (Button) findViewById(R.id.btnThemTruyen);
        imgSupport = (ImageView) findViewById(R.id.imgSupport);
        imgBackMain = (ImageView) findViewById(R.id.imgBackMain);
        txtHuongDan = (TextView) findViewById(R.id.txtHuongDan);
        txtNoiDung = (TextView) findViewById(R.id.txtNoiDung);
        txtNoiDung.setText(noiDung);
        txtNoiDung.setVisibility(View.INVISIBLE);
        txtHuongDan.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        writeTruyenInternal();
    }

    private void writeTruyenInternal() {
        try {
            FileOutputStream fos = openFileOutput(truyenName,MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(MainActivity.dsTruyenThem);
            oos.close();
            fos.close();
        }
        catch (Exception e) {
        }
    }
}
