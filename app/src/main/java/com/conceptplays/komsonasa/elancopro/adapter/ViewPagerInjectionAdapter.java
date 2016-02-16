package com.conceptplays.komsonasa.elancopro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.conceptplays.komsonasa.elancopro.InjectionCostPerWeekFragment;


/**
 * Created by komsonasa on 7/28/15 AD.
 */

public class ViewPagerInjectionAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 1;
    private String titles[] = new String[]{"Injection Cost(Per Week)" };

    public ViewPagerInjectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                InjectionCostPerWeekFragment fragmenttab1 = new InjectionCostPerWeekFragment();
                return  fragmenttab1;
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
