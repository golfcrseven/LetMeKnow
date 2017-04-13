package com.conceptplays.komsonasa.elancopro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.conceptplays.komsonasa.elancopro.FeedPigsFragment;
import com.conceptplays.komsonasa.elancopro.FeedSowsFragment;


/**
 * Created by komsonasa on 7/28/15 AD.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String titles[] = new String[]{"Feeding program of Sows", "Feeding program of Pigs"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FeedSowsFragment fragmenttab1 = new FeedSowsFragment();
                return  fragmenttab1;

            case 1:
                FeedPigsFragment fragmenttab2 = new FeedPigsFragment();
                return  fragmenttab2;
        }
        return null;
    }
    public CharSequence getPageTitle(int position){
        return titles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}
