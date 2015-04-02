package com.example.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/2.
 */
public class TimeUtil {

    private Context context;

    public TimeUtil(Context context) {
        this.context = context;
    }

    /**
     * 获取当前时间
     * @return
     */
    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd   HH:mm：ss");
        Date returnDate = new Date(System.currentTimeMillis());//获取系统时间
        String date = formatter.format(returnDate);
        return date;
    }

    /**
     * 判断并获取系统小时制，12或24
     * @return
     */
    public int getSystemHourly(){

        ContentResolver cv = this.context.getContentResolver();
        String strTime = Settings.System.getString(cv, Settings.System.TIME_12_24);
        if (strTime.equals("24")){
            return 24;
        }else if(strTime.equals("12")){
            return 12;
        }
        return 0;
    }

}
