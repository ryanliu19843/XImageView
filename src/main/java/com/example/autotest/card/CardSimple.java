//
//  CardSimple
//
//  Created by ryan on 2017-05-09 14:53:09
//  Copyright (c) ryan All rights reserved.


/**
   
*/

package com.example.autotest.card;

import android.support.v7.widget.RecyclerView;

import com.example.autotest.item.Simple;
import com.mdx.framework.widget.pagerecycleview.ada.Card;

public class CardSimple extends Card<Simple.SimpleSet>{
	
	public CardSimple(Simple.SimpleSet item) {
	    this.setItem(item);
    	this.type = com.example.autotest.R.string.id_simple;
    }

     @Override
     public void bind(RecyclerView.ViewHolder viewHolder, int posion) {
        Simple item = (Simple) viewHolder;
        item.set(posion, this);
        this.lastitem = null;
     }
    
    

}


