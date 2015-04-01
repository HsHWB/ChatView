package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.view.ChatLinearLayout;

/**
 * Created by Administrator on 2015/3/26.
 */
public class ChatListAdapter extends BaseAdapter {

    private Context context;
    private int screenHeight = -1;
    private int screenWidth = -1;

    public ChatListAdapter(Context context, int screenHeight, int screenWidth) {

        this.context = context;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;

    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linearLayout = new LinearLayout(this.context);
        /**
         * listView每一项都为屏幕高度的1/8
         */
        AbsListView.LayoutParams listParams = new AbsListView.LayoutParams(screenWidth, screenHeight/8);
        linearLayout.setLayoutParams(listParams);



        return null;
    }
}
