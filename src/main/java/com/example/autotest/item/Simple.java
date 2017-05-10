//
//  Simple
//
//  Created by ryan on 2017-05-09 14:53:09
//  Copyright (c) ryan All rights reserved.


/**
   
*/

package com.example.autotest.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.autotest.R;
import com.example.autotest.card.CardSimple;
import com.mdx.framework.Frame;
import com.mdx.framework.server.image.impl.MBitmap;
import com.mdx.framework.widget.MImageView;


public class Simple extends BaseItem{
    public static int size=-1;
    public MImageView relalayout;
    public View overlayout;
    public MImageView imageView;
    public TextView txt;
    public MImageView icon1;
    public TextView txt1;
    public MImageView icon2;
    public TextView txt2;
    public SimpleSet aitem;



    public Simple(View itemView, Context context) {
        super(itemView);
        this.context=context;
        initView();
    }

    @SuppressLint("InflateParams")
    public static Simple getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView;
        if (parent == null) {
            convertView = flater.inflate(R.layout.item_simple, null);
        } else {
            convertView = flater.inflate(R.layout.item_simple, parent, false);
        }
        return new Simple(convertView, context);
    }

    private void initView() {
    	findVMethod();
    }

    private void findVMethod(){
        relalayout=(MImageView)findViewById(R.id.relalayout);
        overlayout=(View)findViewById(R.id.overlayout);
        imageView=(MImageView)findViewById(R.id.imageView);
        txt=(TextView)findViewById(R.id.txt);
        icon1=(MImageView)findViewById(R.id.icon1);
        txt1=(TextView)findViewById(R.id.txt1);
        icon2=(MImageView)findViewById(R.id.icon2);
        txt2=(TextView)findViewById(R.id.txt2);
    }

    @Override
    public void setXY(float l, float t) {
        super.setXY(l, t);
        if(t<=0){
            Object obj=card.getAdapter().params.get("size");
            if(obj!=null && !obj.equals(posion)) {
                Frame.HANDLES.sentAll("ActMain", 0, this.aitem);
            }
            card.getAdapter().params.put("size",posion);
        }
    }

    public void set(final int posion, CardSimple card){
        this.card=card;
        SimpleSet item=card.item;
        relalayout.setObj(item.bacground);
        relalayout.isPalette=true;
        this.aitem = item;
        relalayout.setOnImageLoaded(new MImageView.OnImageLoaded() {
            @Override
            public void onImageLoaded(Object obj, Drawable drawable, MBitmap mBitmap, int size, int length) {
                overlayout.setBackgroundColor(mBitmap.muted & 0xccffffff);
                aitem.bg = mBitmap.muted;
                aitem.tbg = 0xffffffff;
                aitem.litbg = mBitmap.vibrant;
                Log.d("sss", mBitmap.toString());
                if(Simple.this.card.getAdapter().params.get("size")==null && posion==0){
                    Frame.HANDLES.sentAll("ActMain", 0, aitem);
                }
            }
        });
//        relalayout.setBlur(10);
        imageView.setObj(item.icon);
        txt.setText(item.name);
        txt1.setText(item.value);
        txt2.setText(item.v2);
    }


    public static class SimpleSet {
        public String bacground;
        public String icon;
        public String name;
        public String value;
        public String v2;
        public int bg;
        public int tbg;
        public int litbg;

        public SimpleSet(String bacground, String icon, String name, String value, String v2) {
            this.bacground = bacground;
            this.icon = icon;
            this.name = name;
            this.value = value;
            this.v2 = v2;
        }
    }
    

}