package com.assignment.spotsoon.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;

import com.assignment.spotsoon.R;

/**
 * Created by MAHESH on 10-Jun-17.
 */

    public class IconTextTabLayout extends TabLayout {

        public IconTextTabLayout(Context context) {
            super(context);
        }

        public IconTextTabLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public IconTextTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        public void setTabsFromPagerAdapter(@NonNull PagerAdapter adapter) {
            this.removeAllTabs();
            int i = 0;
            for (int count = adapter.getCount(); i < count; ++i) {
                this.addTab(this.newTab().setCustomView(R.layout.custom_tab)
                    ///    .setIcon(YourIcons[i])
                        .setText(adapter.getPageTitle(i)));
            }

}}
