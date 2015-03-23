package com.example.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Hs on 2015/3/16.
 */
public class ChatView extends View {

    private Context context;
    private int typeId;
    private String text;
    private Bitmap headPortrait;
    private TextView textContent;
    private Paint mPaint;

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
     * 传入头像
     */
    public void putHeadPortrait(Bitmap headPortrait){

        this.headPortrait = headPortrait;

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
