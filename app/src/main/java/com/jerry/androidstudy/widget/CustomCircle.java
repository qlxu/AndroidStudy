package com.jerry.androidstudy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircle extends View {
    private Paint mPaint;

    public CustomCircle(Context context) {
        super(context);
        initPaint();
    }

    public CustomCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
//        mPaint.setTextSize(100);
        mPaint.setStrokeWidth(20);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.setMeasuredDimension(200,200);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(Color.RED);
//        RectF rectF = new RectF(10,10,10,10);
//        canvas.drawRoundRect(rectF,300,300,mPaint);
        canvas.drawCircle(200,200,100,mPaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
