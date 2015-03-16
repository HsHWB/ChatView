package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Hs on 2015/3/16.
 */
public class ChatView extends LinearLayout {

    private Context context;
    private int typeId;
    private String text;
    private TextView textView;

    public ChatView(){
        this(null, 0);
    }

    public ChatView (Context context, int id){
        this(context, null, id);
    }

    public ChatView (Context context, AttributeSet attrs, int id){
        super(context, attrs);
        this.context = context;
        this.typeId = id;
    }

    /**
     * id：0为textvew，1为image，2为视频
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        switch (this.typeId){
            case 0:
                textView = new TextView(context);

                break;
        }

    }

    /**
     * 给其传入字符串
     */
    public void putString(String text){
    }

    /**
     * 给其传入图片
     */

    public void putImage(ImageView view){}

    /**
     * 给其传入视频
     */
}
