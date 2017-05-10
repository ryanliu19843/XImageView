//
//  ActUpdateself
//
//  Created by ryan on 2017-04-28 13:30:59
//  Copyright (c) ryan All rights reserved.


/**
   
*/

package com.example.autotest.act;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.autotest.R;
import com.mdx.framework.widget.circularprogressdrawable.CircularProgressDrawable;
import com.mdx.framework.widget.pagerecycleview.MFRecyclerView;

public class ActUpdateself extends BaseAct{

    public MFRecyclerView mMFRecyclerView;
    public ImageView iv_drawable;
    CircularProgressDrawable drawable;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.act_updateself);
        initView();
        loaddata();
    }


    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mMFRecyclerView=(MFRecyclerView)findViewById(R.id.mMFRecyclerView);
        iv_drawable = (ImageView) findViewById(R.id.iv_drawable);



        drawable = new CircularProgressDrawable.Builder()
                .setRingWidth(getResources().getDimensionPixelSize(R.dimen.drawable_ring_size))
                .setOutlineColor(getResources().getColor(android.R.color.darker_gray))
                .setRingColor(getResources().getColor(android.R.color.holo_green_light))
                .setCenterColor(getResources().getColor(android.R.color.holo_blue_dark))
                .create();
        iv_drawable.setImageDrawable(drawable);

        drawable.setProgress(0.5f);

    }
    
    
    
     public void loaddata(){

    }
    

}
