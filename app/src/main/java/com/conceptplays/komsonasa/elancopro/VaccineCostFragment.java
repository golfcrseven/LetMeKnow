package com.conceptplays.komsonasa.elancopro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.conceptplays.komsonasa.elancopro.adapter.ViewPagerVaccineAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

public class VaccineCostFragment extends Fragment {

	public VaccineCostFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View v = inflater.inflate(R.layout.fragment_sow_drug_cost, container, false);
        ViewPager mViewPager = (ViewPager) v.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new ViewPagerVaccineAdapter(getChildFragmentManager()));

        Button btnAdd = (Button) getActivity().findViewById(R.id.btnAddMedicine);
        btnAdd.setVisibility(View.VISIBLE);

        FrameLayout frmPopup = (FrameLayout)v.findViewById(R.id.frameLayout_popup);
        frmPopup.setVisibility(View.GONE);

        return v;
    }
}
