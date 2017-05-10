//
//  CardText
//
//  Created by ryan on 2017-04-22 16:19:27
//  Copyright (c) ryan All rights reserved.


/**
   
*/

package com.example.autotest.card;

import android.support.v7.widget.RecyclerView;

import com.example.autotest.item.Text;
import com.mdx.framework.widget.pagerecycleview.ada.Card;

public class CardText extends Card<String>{
	
	public CardText(String item) {
	    this.setItem(item);
    	this.type = com.example.autotest.R.string.id_text;
    }

     @Override
     public void bind(RecyclerView.ViewHolder viewHolder, int posion) {
        Text item = (Text) viewHolder;
        item.set(posion, this);
        this.lastitem = null;
     }
    
    

}


