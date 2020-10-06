package com.example.test_nestscorllview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> listFragment;
    private List<String> listTitle;
    private FragmentPagerAdapter mAdapter;
    private Scorll scroll_main;
    private ImageView img_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.vp_main);
        tabLayout = findViewById(R.id.tab_layout_main);

        img_main=findViewById(R.id.img_main);
        scroll_main=findViewById(R.id.Scroll_main);
        if (getSupportActionBar()!= null) {
            getSupportActionBar().hide();
        }
        listFragment = new ArrayList<>(3);
        listTitle = new ArrayList<>(3);
        listTitle.add("车位订单");
        listFragment.add(new BlankFragment());
        listTitle.add("支出订单");
        listFragment.add(new BlankFragment());
        listTitle.add("充值订单");
        listFragment.add(new BlankFragment());
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), listFragment, listTitle);
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);//与ViewPage建立关系
        scroll_main.setScrollListener(new Scorll.ScrollListener() {
            @Override
            public void onScroll(int ScrollY) {
//                if (ScrollY>img_main.getHeight()){
//                    tabLayout2.setVisibility(View.VISIBLE);
//
//                }else {
//                    tabLayout2.setVisibility(View.GONE);
//                }
            }
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            int height = scroll_main.getMeasuredHeight() - tabLayout.getLayoutParams().height;//计算ViewPage适和高度
            ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
            layoutParams.height = height;//修改ViewPage高度
            viewPager.setLayoutParams(layoutParams);//更新ViewPage高度
        }
    }


    private class FragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList;//各导航的Fragment
        private List<String> mTitle; //导航的标题

        public FragmentAdapter(FragmentManager fragmentManager, List<Fragment> fragments, List<String> title) {
            super(fragmentManager);
            mFragmentList = fragments;
            mTitle = title;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }
    }
}