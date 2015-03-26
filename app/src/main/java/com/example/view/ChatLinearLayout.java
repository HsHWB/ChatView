package com.example.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chatlayout.R;

/**
 * Created by Administrator on 2015/3/24.
 */
public class ChatLinearLayout extends LinearLayout {

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
        this(context, null, null, null,0);
    }

    /**
     * id为0时，是我方发出信息，为1时，对方发出信息
     * @param context
     * @param attrs
     * @param headBitmap
     * @param content
     * @param id
     */
    public ChatLinearLayout(Context context, AttributeSet attrs, Bitmap headBitmap, String content, Integer id){

        super(context, attrs);
        this.headBitmap = headBitmap;
        this.content = content;

        /**
         * 把linealayout的布局放进来
         */
        chatView = LayoutInflater.from(context).inflate(R.layout.chatlinear_layout, null, true);
        headImage = (ImageView)chatView.findViewById(R.id.chatlinear_head);
        contentText = (TextView)chatView.findViewById(R.id.chatlinear_content);

        /**
         * 传进来的头像和内容set进去
         */
        if (this.headBitmap != null) {
            headImage.setImageBitmap(this.headBitmap);
        }
        if (this.content != null) {
            contentText.setText(this.content);
        }
        setOrientation(HORIZONTAL);
        addView(chatView);
    }



}
