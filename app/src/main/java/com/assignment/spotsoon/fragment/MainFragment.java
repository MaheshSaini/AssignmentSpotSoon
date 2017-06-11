package com.assignment.spotsoon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assignment.spotsoon.R;
import com.assignment.spotsoon.adapter.ViewPagerIndicatorAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by MAHESH on 10-Jun-17.
 */

public class MainFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener{
    @InjectView(R.id.viewpager)
    ViewPager viewPager;
    @InjectView(R.id.pager_introduction)
    ViewPager pager_introduction;
    @InjectView(R.id.tabs)
    TabLayout tabs;
    private int dotsCount;
    private ImageView[] dots;
    @InjectView(R.id.viewPagerCountDots)
    LinearLayout viewPagerCountDots;
    private ViewPagerIndicatorAdapter mAdapter;


    private int[] mImageResources = {
            R.drawable.bg,
            R.drawable.bg,
            R.drawable.bg,
            R.drawable.bg,
            R.drawable.bg
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.inject(this, layout);
        setReference();
        setupViewPager(viewPager);
        pager_introduction.setCurrentItem(0);
        pager_introduction.setOnPageChangeListener(this);
        tabs.setupWithViewPager(viewPager);
        setupTabIcons();
        return layout;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new VideosFragment(), "VIDEOS");
        adapter.addFragment(new VideosFragment(), "IMAGES");
        adapter.addFragment(new VideosFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);

    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabOne.setText("VIDEOS");

        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_video, 0, 0);
        tabOne.setCompoundDrawablePadding(10);
        tabs.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_image, 0, 0);
        tabOne.setCompoundDrawablePadding(10);
        tabs.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONE");
        tabOne.setCompoundDrawablePadding(10);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_milestone, 0, 0);

        tabs.getTabAt(2).setCustomView(tabThree);
    }

    public void setReference() {

        mAdapter = new ViewPagerIndicatorAdapter(getActivity(), mImageResources);
        pager_introduction.setAdapter(mAdapter);
        pager_introduction.setCurrentItem(0);
        pager_introduction.setOnPageChangeListener(this);
        setUiPageViewController();
    }
    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            viewPagerCountDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }



        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

