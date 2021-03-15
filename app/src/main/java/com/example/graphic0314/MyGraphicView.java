package com.example.graphic0314;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyGraphicView extends View {

    int startX = -1;
    int startY = -1;
    int stopX = -1;
    int stopY = -1;
    MainActivity mainActivity;
    Paint paint;
    ArrayList<MyPoint> arrayList = new ArrayList<>();


    public MyGraphicView(Context context) {
        super(context);
        mainActivity = (MainActivity) context;
        initPaint();
    }

    /* @Override
     public boolean onTouchEvent(MotionEvent event) {

         switch (event.getAction()) {
             case MotionEvent.ACTION_DOWN:
                 Log.d("my_tag", "ACTION_DOWN");
                 startX = (int) event.getX();
                 startY = (int) event.getY();
                 break;
             case MotionEvent.ACTION_MOVE:
                 Log.d("my_tag", "ACTION_MOVE");
             case MotionEvent.ACTION_UP:
                 Log.d("my_tag", "ACTION_UP");
                 stopX = (int) event.getX();
                 stopY = (int) event.getY();
                 invalidate(); // onDraw() 호출
                 break;
         }
         return true;
     }
 */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                arrayList.add(new MyPoint(event.getX(), event.getY(), false));
                break;
            case MotionEvent.ACTION_MOVE:
                arrayList.add(new MyPoint(event.getX(), event.getY(), true));
                invalidate();
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        switch (mainActivity.getCurShape()) {
            case MainActivity.LINE:
                canvas.drawLine(startX, startY, stopX, stopY, paint);
                break;
            case MainActivity.CIRCLE:
                int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                canvas.drawCircle(startX, startY, radius, paint);
                break;
            case MainActivity.FREE_LINE:
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).isDraw() == true) {
                        canvas.drawLine(arrayList.get(i - 1).getX(),
                                arrayList.get(i - 1).getY(),
                                arrayList.get(i).getX(),
                                arrayList.get(i).getY(), paint);
                    }
                }
                break;
        }
    }
}
