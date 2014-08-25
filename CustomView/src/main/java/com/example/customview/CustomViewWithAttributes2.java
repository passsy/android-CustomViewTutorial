package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomViewWithAttributes2 extends View {

    private String mCustomValue;

    private Paint mPaint;

    public CustomViewWithAttributes2(final Context context) {
        this(context, null);
    }

    public CustomViewWithAttributes2(final Context context, final AttributeSet attrs) {
        this(context, attrs, R.attr.customViewWithAttrStyle);
    }

    public CustomViewWithAttributes2(final Context context, final AttributeSet attrs,
            final int defStyle) {
        super(context, attrs, defStyle);

        // load the styled attributes and set their properties
        final TypedArray attributes = context.obtainStyledAttributes(
                attrs, R.styleable.CustomViewWithAttributes, defStyle, 0);

        if (attributes != null) {
            try {
                // read custom attribute
                mCustomValue = attributes
                        .getString(R.styleable.CustomViewWithAttributes_customAttr);
            } finally {
                // make sure recycle is always called.
                attributes.recycle();
            }
        }

        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(40);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        try {
            final int degrees = Integer.parseInt(mCustomValue);
            canvas.rotate(degrees);
        } catch (NumberFormatException ex){
            // ignore
        }
        canvas.drawText(mCustomValue, 40, 80, mPaint);
    }
}
