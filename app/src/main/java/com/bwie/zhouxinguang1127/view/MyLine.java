package com.bwie.zhouxinguang1127.view;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:8:59
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyLine extends ViewGroup {
    public Context context;

    public MyLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int s = 20;
        int top = 0;
        int button = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            left = right + s;
            right = left + measuredHeight;
            int width = getWidth();
            if (right > width) {
                left = s;
                right = left + measuredHeight;
            }
            childAt.measure(0, 0);
            childAt.layout(top, button, left, right);
        }
    }
    public void Addach(String cc){
        TextView textView = new TextView(context);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setText(cc);
        addView(textView);

    }
}
