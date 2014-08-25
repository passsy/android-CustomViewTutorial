package com.example.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Pascal Welsch
 * @since 22.05.14.
 */
@SuppressLint("NewApi")
public class CompositeView extends LinearLayout {

    private final TextView mName;

    private final TextView mText;

    public CompositeView(final Context context) {
        this(context, null);
    }

    public CompositeView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompositeView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        LayoutInflater.from(context).inflate(R.layout.composite_layout, this);

        mName = (TextView) findViewById(R.id.name);
        mText = (TextView) findViewById(R.id.text);
    }
}

