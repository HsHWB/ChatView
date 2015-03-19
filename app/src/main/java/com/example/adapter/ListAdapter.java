package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.module.ChatMessage;

import java.util.List;

/**
 * Created by hs on 2015/3/17.
 */
public class ListAdapter extends BaseAdapter {

    protected static final String TAG = "listAdapter";
    private Context context;
    private List<ChatMessage> chatMessagesList;

    public ListAdapter(Context context) {
        this(context, null);
    }

    public ListAdapter(Context context, List<ChatMessage> chatMessagesList) {
        this.context = context;
        this.chatMessagesList = chatMessagesList;
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


    /**
     * View中的setTag(Onbect)表示给View添加一个格外的数据，以后可以用getTag()将这个数据取出来。
     * View的setTag和getTag方法可以给view的子控件绑定一个Object对象。我自己理解的,
     * tag顾名思义就是标签的意思，给view的子控件添加一个标签，可以根据标签判断给view不同的子控件，或者view相同的子控件添加不同的触发事件。
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tv = null;
        ChatMessage chatMessage = chatMessagesList.get(position);
        if ( convertView != null && chatMessagesList.size() > 0 ){



        }

        return null;
    }
}
