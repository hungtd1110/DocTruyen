package com.example.amin.project2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar proBar;
    TextView textView;
    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        getSupportActionBar().hide();
        addControls();
        proBar.setMax(100);
        Handel();
    }

    private void Handel() {
        final Handler handler = new Handler();
        proBar.setVisibility(View.VISIBLE);
        status = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(status<100){
                    status = doWork();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            proBar.setProgress(status);
                            textView.setText(String.valueOf(status)+"%");
                        }
                    });
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ProgressBarActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }).start();
    }

    private int doWork() {
        try{
            Thread.sleep(50);
        }catch (InterruptedException e){
            status = 0;
        }
        status++;
        return status;
    }

    private void addControls() {
        proBar=(ProgressBar) findViewById(R.id.pgBar);
        textView=(TextView) findViewById(R.id.tvPhanTram);
    }
}
