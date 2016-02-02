package com.conceptplays.komsonasa.letmeknow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.conceptplays.komsonasa.letmeknow.VaccineCostPerWeekFragment;


/**
 * Created by komsonasa on 7/28/15 AD.
 */

public class ViewPagerVaccineAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 1;
    private String titles[] = new String[]{"Vaccine Cost(Per Week)" };

    public ViewPagerVaccineAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                VaccineCostPerWeekFragment fragmenttab1 = new VaccineCostPerWeekFragment();
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
