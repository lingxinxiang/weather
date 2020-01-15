package com.example.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class CityFragmentPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentsList;

    public CityFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentsLis) {
        super(fm);
        this.fragmentsList = fragmentsLis;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
    int childCount =0;
    //当ViewPager的页数发生改变时，必须要重写两个函数


    @Override
    public void notifyDataSetChanged() {
        this.childCount=getCount();
        super.notifyDataSetChanged();

    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (childCount>0){
            childCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }
}
