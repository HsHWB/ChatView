package com.example.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.chatlayout.R;

/**
 * Created by Administrator on 2015/3/14.
 */
public class CirclePicture extends View {

    private Paint paint;
    private Context context;

    public CirclePicture(Context context) {
        super(context, null);
    }

    public CirclePicture(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (context != null) {
            Bitmap bitmapPicture = null;
            SDCardFile sdCardImage = new SDCardFile(Environment.getExternalStorageDirectory()
                    + "/Download/" + "head.jpg");
            if(sdCardImage.getSDImage() != null) {
                bitmapPicture = sdCardImage.getSDImage();
            }else{
                bitmapPicture = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
            }

//            System.out.println("bitmapPicture == "+bitmapPicture);

            Bitmap bitmap = zoomBitmap(bitmapPicture, 100, 100);
            Bitmap roundBitmap = getRoundBitmap(bitmap);

            Rect src = new Rect();
            Rect dst = new Rect();// 屏幕位置及尺寸
            src.left = 0;
            src.top = 0;
            src.right = roundBitmap.getWidth();//这个是桌面图的宽度，
            src.bottom = roundBitmap.getHeight();//这个是桌面图的高度的一半
            dst.left = 0;
            dst.top = 0;
            dst.right = roundBitmap.getWidth();    //表示需绘画的图片的右上角
            dst.bottom = roundBitmap.getHeight();    //表示需绘画的图片的右下角
            canvas.drawBitmap(roundBitmap, src, dst, paint);
        }
    }

    /**
     * 用一个圆形，和图片做重叠，多余的部分裁掉，剩下的就是圆形头像
     */

    private Bitmap getRoundBitmap(Bitmap bitmap) {

        int width = bitmap.getWidth();//圆形图片的长和宽
        int height = bitmap.getHeight();
        int r = width > height ? height : width;//正方形的边长,选取最短的作为边长

        //构建一个Bitmap
        Bitmap backRound = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(backRound);//新画布，用来在backRound上画图
        Paint paint = new Paint();
        paint.setAntiAlias(true);//设置边缘光滑，去掉锯齿

        /**
         * RectF:坐标绘制 left,top,right,bottom
         * RectF 这个类包含一个矩形的四个单精度浮点坐标。
         */
        RectF rectF = new RectF(0, 0, r, r);//正方形

        //通过制定的rect画一个圆角矩形，当圆角X轴方向的半径等于Y轴方向的半径且都为r/2时
        // ，画出来的圆角矩形即是圆形
        //drawRoundRect是圆角矩形的方法(RectF对象,x方向上的圆角半径,y方向上的圆角半径,绘制时所使用的画笔)
        canvas.drawRoundRect(rectF, r / 2, r / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rectF, paint);

        return backRound;
    }

    /**
     * 裁剪方法
     *
     * @param bitmap
     * @return
     */
    private Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap oldMap = bitmap;
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newMap = Bitmap.createBitmap(oldMap, 0, 0, width, height, matrix, true);
        newMap = getRCB(newMap, 20f);
        return newMap;
    }

    private Bitmap getRCB(Bitmap bitmap, float roundPX) {
        Bitmap dstbmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dstbmp);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff424242);
        canvas.drawRoundRect(rectF, roundPX, roundPX, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return dstbmp;
    }
}
