//
//  Text
//
//  Created by ryan on 2017-04-22 16:19:27
//  Copyright (c) ryan All rights reserved.


/**
   
*/

package com.example.autotest.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.autotest.R;
import com.example.autotest.card.CardText;


public class Text extends BaseItem{
    public LinearLayout contentView;
    public TextView text;



    public Text(View itemView, Context context) {
        super(itemView);
        this.context=context;
        initView();
    }



    @Override
    public void setXY(float l, float t) {
        super.setXY(l, t);
    }

    @SuppressLint("InflateParams")
    public static Text getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView;
        if (parent == null) {
            convertView = flater.inflate(R.layout.item_text, null);
        } else {
            convertView = flater.inflate(R.layout.item_text, parent, false);
        }
        return new Text(convertView, context);
    }

    private void initView() {
    	findVMethod();
    }

    private void findVMethod(){
        contentView=(LinearLayout)findViewById(R.id.contentView);
        text=(TextView)findViewById(R.id.text);


    }

    public void set(int posion,CardText card){
        this.card=card;
        this.text.setText(card.item);

    }
    
    

}