package com.example.module;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by hs on 2015/3/26.
 */
public class ChatModule {

    private Context context;
    public int typeId = -1;
    public Bitmap headBitmap = null;
    public String content = null;

    public ChatModule(Context context){
        this.context = context;
    }

    public void setTypeId(int id){
        this.typeId = id;
    }

    public void setHeadBitmap(Bitmap headBitmap){
        this.headBitmap = headBitmap;
    }

    public void setContent(String content){
        this.content = content;
    }

    public int getTypeId(){
        return this.typeId;
    }

    public Bitmap getHeadBitmap(){
        return this.headBitmap;
    }

    public String getContent(){
        return this.content;
    }
}
