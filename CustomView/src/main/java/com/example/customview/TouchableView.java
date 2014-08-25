package com.example.customview;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Pascal Welsch
 * @since 24.05.14.
 */
public class TouchableView extends View {

    private static final String STATE_PROGRESS = "state::progress";

    private static final String STATE_SUPER = "state::super";

    private float mProgress;

    public TouchableView(final Context context) {
        this(context, null);
    }

    public TouchableView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchableView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onRestoreInstanceState(final Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            mProgress = bundle.getFloat(STATE_PROGRESS);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        bundle.putFloat(STATE_PROGRESS, mProgress);
        return bundle;
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }
}
