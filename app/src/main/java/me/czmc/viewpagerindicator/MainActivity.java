package me.czmc.viewpagerindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] titles = {"菜单一", "菜单二", "菜单三", "菜单四", "菜单五", "菜单六", "菜单七", "菜单八"};
    private ViewPager mViewPager;
    public ArrayList<TagFragment> mContents;
    private TagFragmentPagerAdapter fragmentPagerAdapter;
    private ViewPagerIndicator mViewPagerIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.viewPagerIndicator);
        mViewPagerIndicator.setViewPager(mViewPager);
        initData();
    }

    private void initData() {
        mContents = new ArrayList();
        for (String title : titles) {
            TagFragment fragment = TagFragment.newInstance(title);
            mContents.add(fragment);
        }
        mViewPager.setAdapter(fragmentPagerAdapter = new TagFragmentPagerAdapter(getSupportFragmentManager(), mContents));
    }

    private class TagFragmentPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<TagFragment> content;

        public TagFragmentPagerAdapter(FragmentManager fm, ArrayList<TagFragment> mContents) {
            super(fm);
            this.content = mContents;
        }

        @Override
        public int getCount() {
            return content.size();
        }

        @Override
        public Fragment getItem(int position) {
            return content.get(position);
        }
    }
}
