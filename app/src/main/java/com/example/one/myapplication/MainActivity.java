package com.example.one.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {


    private ViewPager mViewPager;
    private FragmentPagerAdapter  pagerAdapter;
    private List<Fragment> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        mViewPager = (ViewPager)findViewById(R.id.id_viewPager);
        mData = new ArrayList<Fragment>();
        ChatTabFragment  chatFragment = new ChatTabFragment();
        FriendTabFragment friendFragment = new FriendTabFragment();
        ContactTabFragment contactFragment = new ContactTabFragment();

        mData.add(chatFragment);
        mData.add(friendFragment);
        mData.add(contactFragment);

        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mData.get(position);
            }

            @Override
            public int getCount() {
                return mData.size();
            }
        };

        mViewPager.setAdapter(pagerAdapter);
    }
}
