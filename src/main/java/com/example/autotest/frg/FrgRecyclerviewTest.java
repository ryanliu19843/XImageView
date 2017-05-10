//
//  FrgRecyclerviewTest
//
//  Created by ryan on 2017-04-22 15:27:43
//  Copyright (c) ryan All rights reserved.


/**
   
*/

package com.example.autotest.frg;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.autotest.R;
import com.example.autotest.dataformat.DfText;
import com.mdx.framework.server.api.base.ApiUpdateApi;
import com.mdx.framework.widget.pagerecycleview.widget.OnPageSwipListener;


public class FrgRecyclerviewTest extends BaseFrg{


    public com.mdx.framework.widget.pagerecycleview.MFRecyclerView mMFRecyclerView;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_recyclerview_test);
        initView();
        loaddata();
    }

    private void initView(){
        findVMethod();
    }
    
    private void findVMethod() {
        mMFRecyclerView = (com.mdx.framework.widget.pagerecycleview.MFRecyclerView) findViewById(R.id.mMFRecyclerView);
        mMFRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        List<Card> list = new ArrayList<>();
//        for(int i=0;i<100;i++){
//            CardText card=new CardText("1111"+i);
//            if(i%10==0){
////                card.setShowType(1);
//            }
//            list.add(card);
//        }
//
//        SAdapter sAdapter=new SAdapter(getContext(),list);
//        sAdapter.setRecyclerView(mMFRecyclerView);
//        mMFRecyclerView.setAdapter(sAdapter);

        mMFRecyclerView.setOnSwipLoadListener(new OnPageSwipListener(getContext(), new ApiUpdateApi().set("com.udows.xdt",1,"ios","sss","0",""), new DfText()));
        mMFRecyclerView.reload();


//        mMFRecyclerView.setOnPullListener(new MRecyclerView.OnPullListener() {
//            @Override
//            public void onPullListener(float mv, float mt, int orientation, float over) {
//                Log.d("test",""+mv);
//            }
//        });


    }
    
    public void loaddata(){

    }
    
   
 
}