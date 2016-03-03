package com.conceptplays.komsonasa.elancopro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.conceptplays.komsonasa.elancopro.SowDrugCostPerWeekFragment;
import com.conceptplays.komsonasa.elancopro.SowDrugCostPerMonthFragment;
import com.conceptplays.komsonasa.elancopro.SowDrugCostPerSowFragment;
import com.conceptplays.komsonasa.elancopro.SowDrugCostSum;


/**
 * Created by komsonasa on 7/28/15 AD.
 */

public class ViewPagerSowDrugAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String titles[] = new String[]{"1.Per Sow", "2.Per week","3.Per month","Summary" };

    public ViewPagerSowDrugAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SowDrugCostPerSowFragment fragmenttab1 = new SowDrugCostPerSowFragment();
                return  fragmenttab1;

            case 1:
                SowDrugCostPerWeekFragment fragmenttab2 = new SowDrugCostPerWeekFragment();
                return  fragmenttab2;
            case 2:
                SowDrugCostPerMonthFragment fragmenttab3 = new SowDrugCostPerMonthFragment();
                return  fragmenttab3;
            case 3:
                SowDrugCostSum fragmenttab4 = new SowDrugCostSum();
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
