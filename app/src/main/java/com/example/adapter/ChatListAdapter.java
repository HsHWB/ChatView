package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.module.ChatModule;
import com.example.view.ChatLinearLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/3/26.
 */
public class ChatListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ChatModule> moduleList = null;
    private int screenHeight = -1;
    private int screenWidth = -1;

    public ChatListAdapter(Context context, int screenHeight, int screenWidth, ArrayList<ChatModule> moduleList) {

        this.context = context;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.moduleList = moduleList;

    }



    @Override
    public int getCount() {
        return this.moduleList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ChatLinearLayout chatLayout = new ChatLinearLayout(this.context, null, this.moduleList.get(position));
        return chatLayout;
    }
}
