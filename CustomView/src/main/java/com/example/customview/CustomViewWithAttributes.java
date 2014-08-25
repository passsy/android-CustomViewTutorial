package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

public class CustomViewWithAttributes extends View {

    private String mCustomValue;

    public CustomViewWithAttributes(final Context context) {
        this(context, null);
    }

    public CustomViewWithAttributes(final Context context, final AttributeSet attrs) {
        this(context, attrs, R.attr.customViewWithAttrStyle);
    }

    public CustomViewWithAttributes(final Context context, final AttributeSet attrs,
            final int defStyle) {
        super(context, attrs, defStyle);

        // load the styled attributes and set their properties
        final TypedArray attributes = context.obtainStyledAttributes(
                attrs, R.styleable.CustomViewWithAttributes, defStyle, 0);

        // read custom attribute
        mCustomValue = attributes.getString(R.styleable.CustomViewWithAttributes_customAttr);

        // make sure recycle is always called.
        attributes.recycle();
    }
}
