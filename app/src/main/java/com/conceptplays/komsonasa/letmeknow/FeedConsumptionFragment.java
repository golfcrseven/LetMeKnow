package com.conceptplays.komsonasa.letmeknow;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conceptplays.komsonasa.letmeknow.adapter.ViewPagerAdapter;

import java.lang.reflect.Field;

public class FeedConsumptionFragment extends android.support.v4.app.Fragment {
    public FeedConsumptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        /*ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_AppCompat_Light);
        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);*/
        View v =  inflater.inflate(R.layout.fragment_feed_consumption, container, false);
        ViewPager mViewPager = (ViewPager) v.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));


        return  v;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        try{
            Field childFragmentManager = android.support.v4.app.Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this,null);

        } catch (NoSuchFieldException e) {
            throw  new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw  new RuntimeException(e);
        }
    }

    public void onStart(){
        super.onStart();

    }

}
