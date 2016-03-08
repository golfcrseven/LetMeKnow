package com.conceptplays.komsonasa.elancopro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.conceptplays.komsonasa.elancopro.PigDrugCostPerMonthFragment;
import com.conceptplays.komsonasa.elancopro.PigDrugCostPerWeekFragment;
import com.conceptplays.komsonasa.elancopro.PigDrugCostPerHeadFragment;
import com.conceptplays.komsonasa.elancopro.PigDrugCostSum;


/**
 * Created by komsonasa on 7/28/15 AD.
 */

public class ViewPagerPigDrugAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String titles[] = new String[]{"1.Per Head", "2.Per week","3.Per month", "Summary" };

    public ViewPagerPigDrugAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PigDrugCostPerHeadFragment fragmenttab1 = new PigDrugCostPerHeadFragment();
                return  fragmenttab1;

            case 1:
                PigDrugCostPerWeekFragment fragmenttab2 = new PigDrugCostPerWeekFragment();
                return  fragmenttab2;
            case 2:
                PigDrugCostPerMonthFragment fragmenttab3 = new PigDrugCostPerMonthFragment();
                return  fragmenttab3;
            case 3:
                PigDrugCostSum fragmenttab4 = new PigDrugCostSum();
                return  fragmenttab4;
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
