package com.test.tt101201;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int i = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        tv.setText(String.valueOf(i));
        new Thread(){
            @Override
            public void run() {
                super.run();
                do{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i--;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(String.valueOf(i));
                        }
                    });
                } while (i > 0);
            }
        }.start();
    }

}
