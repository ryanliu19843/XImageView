//
//  DfText
//
//  Created by ryan on 2017-04-22 16:19:27
//  Copyright (c) ryan All rights reserved.


/**
   
*/

package com.example.autotest.dataformat;

import android.content.Context;

import com.example.autotest.card.CardText;
import com.mdx.framework.server.api.Son;
import com.mdx.framework.widget.pagerecycleview.ada.Card;
import com.mdx.framework.widget.pagerecycleview.ada.CardAdapter;
import com.mdx.framework.widget.util.DataFormat;

import java.util.ArrayList;
import java.util.List;

public class DfText extends DataFormat{
    int size = 1;

	@Override
	public boolean hasNext() {
		return true;
	}

    public CardAdapter getCardAdapter(Context context, Son son, int page) {
        List<Card> list = new ArrayList<>();
		for(int i=0;i<25;i++){
               CardText card=new CardText("1111"+i);
			   if(i%10==0){
				   card.setShowType(1);
			   }
               list.add(card);
        }
        return new CardAdapter(context,list);
    }

	@Override
	public String[][] getPageNext() {
		return null;
	}

	@Override
	public void reload() {

	}
}
