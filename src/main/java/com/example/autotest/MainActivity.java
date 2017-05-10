package com.example.autotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.autotest.act.ActMain;
import com.example.autotest.frg.FrgRecyclerviewTest;
import com.mdx.framework.activity.MActivity;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;

public class MainActivity extends MActivity {

    public Toolbar toolbar;
    public Button botton1;
    public LinearLayout content_main;
    public FloatingActionButton fab;
    public Button botton2;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        findVMethod();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Helper.getPhotos(MainActivity.this, new PopUpdataPhoto.OnReceiverPhotos() {
//                    @Override
//                    public void onReceiverPhoto(ArrayList<String> photos) {
//                        photos.get(3);
//                    }
//                },1);
//
//            }
//        });
    }


    private void findVMethod() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        botton1 = (Button) findViewById(R.id.botton1);
        content_main = (LinearLayout) findViewById(R.id.content_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        botton2 = (Button) findViewById(R.id.botton2);

        botton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(MainActivity.this, FrgRecyclerviewTest.class, TitleAct.class);
            }
        });
        botton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ActMain.class));
            }
        });

    }
}
