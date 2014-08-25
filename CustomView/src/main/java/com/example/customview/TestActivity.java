package com.example.customview;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Pascal Welsch
 * @since 22.05.14.
 */
public class TestActivity extends Activity{

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final CustomView customView = new CustomView(this);


        setContentView(customView);
    }
}
