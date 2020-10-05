package com.example.test_nestscorllview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.widget.NestedScrollView;

public class Scorll extends NestedScrollView  {
    private static final String TAG = "Scorll";
   private ScrollListener scrollListener;


    public Scorll(@NonNull Context context) {
        super(context);
    }

    public Scorll(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Scorll(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollListener(ScrollListener scrollListener){
        this.scrollListener=scrollListener;
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        int headerViewHeight = getChildAt(0).getMeasuredHeight()-getMeasuredHeight();
        boolean hideTop =dy>0&&getScrollY()<headerViewHeight;
        Log.d(TAG, "onNestedPreScroll: hideTop="+hideTop+" dy="+dy+
                " headerViewHeight="+headerViewHeight +" getScrollY()="+getScrollY()
        +"\ngetChildAt="+getChildAt(0).getMeasuredHeight()+" getMeasuredHeight="+getMeasuredHeight());
        if (hideTop){
            scrollBy(0,dy);
            consumed[1]=dy;
        }
        if (scrollListener!=null){
            scrollListener.onScroll(getScrollY());
        }
    }


    public interface ScrollListener{
        void onScroll(int ScrollY);
    }
}
