package com.example.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chatlayout.R;
import com.example.module.ChatModule;

/**
 * Created by Administrator on 2015/3/24.
 */
public class ChatLinearLayout extends LinearLayout {

    private Context context;
    /**
     * 我方发信息或是对方发信息
     */
    private int typeId = -1;
    /**
     * 头像
     */
    private Bitmap headBitmap = null;
    private ImageView headImage = null;
    /**
     * text内容
     */
    private String content = null;
    private TextView contentText = null;
    /**
     * 布局里面装着头像和文字
     */
    private View chatView;

    public ChatLinearLayout(Context context) {
        this(context, null, null);
    }

    /**
     * id为0时，是我方发出信息，为1时，对方发出信息
     * @param context
     * @param attrs
     */
    public ChatLinearLayout(Context context, AttributeSet attrs, ChatModule chatModule){

        super(context, attrs);
        this.context = context;
        this.headBitmap = chatModule.getHeadBitmap();
        this.content = chatModule.getContent();
        this.typeId = chatModule.getTypeId();

        /**
         * 把linealayout的布局放进来
         */
        if(this.typeId == 1) {
            chatView = LayoutInflater.from(context).inflate(R.layout.chatlinear_left_layout, null, true);
            headImage = (ImageView)chatView.findViewById(R.id.chatlinear_left_head);
            contentText = (TextView)chatView.findViewById(R.id.chatlinear_left_content);
            /**
             * listView每一项都为屏幕高度的1/8
             */
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            setLayoutParams(lp);

            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            linearParams.leftMargin = 5;
            addView(chatView, linearParams);
        }else{
            chatView = LayoutInflater.from(context).inflate(R.layout.chatlinear_right_layout,null, true);
            headImage = (ImageView)chatView.findViewById(R.id.chatlinear_right_head);
            contentText = (TextView)chatView.findViewById(R.id.chatlinear_right_content);
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            setLayoutParams(lp);

            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            linearParams.rightMargin = 5;
            addView(chatView, linearParams);
        }

        /**
         * 传进来的头像和内容set进去
         */
        if (this.headBitmap != null) {
            headImage.setImageBitmap(this.headBitmap);
        }else{
            headImage.setImageResource(R.drawable.ic_launcher);
        }
        if (this.content != null) {
            contentText.setText(this.content);
        }else{
            contentText.setText("");
        }
    }



}
