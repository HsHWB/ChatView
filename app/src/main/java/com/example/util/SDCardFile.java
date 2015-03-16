package com.example.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import java.io.File;

/**
 * Created by Hs on 2015/3/14.
 */
public class SDCardFile {

    private Context context;
    private File file;
    private String path;
    private String name;

    /**
     * 一些路径的标准写法
     Environment.getDataDirectory() = /data
     Environment.getDownloadCacheDirectory() = /cache
     Environment.getExternalStorageDirectory() = /mnt/sdcard
     Environment.getRootDirectory() = /system
     context.getCacheDir() = /data/data/com.mt.mtpp/cache
     context.getExternalCacheDir() = /mnt/sdcard/Android/data/com.mt.mtpp/cache
     context.getFilesDir() = /data/data/com.mt.mtpp/files
     * @param path
     */
    public SDCardFile(String path){
        this(null, path);
    }

    public SDCardFile(Context context, String path){
        this.context = context;
        this.path = path;
    }

    /**
     * 获取图片
     * @return
     */
    public Bitmap getSDImage(){
        Bitmap bitmap;
        file = new File(path);
        if (isExit()){
            bitmap = BitmapFactory.decodeFile(path);
        }else{
            bitmap = null;
        }
        return bitmap;
    }

    /**
     * 获取文件的文字内容
     * @return
     */
    public StringBuffer getText(){
        return null;
    }

    /**
     * 获取音频
     */

    /**
     * 获取视频
     */

    /**
     * 判断文件是否存在
     */
    public boolean isExit(){
        if (file.isFile()){//若存在此文件
            return true;
        }
        return false;
    }

}
