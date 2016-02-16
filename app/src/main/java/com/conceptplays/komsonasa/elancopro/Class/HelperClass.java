package com.conceptplays.komsonasa.elancopro.Class;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Created by komsonasa on 8/19/15 AD.
 */
public class HelperClass {
    public HelperClass() {
    }

    public Double string2double(String str){
        Double doub;
        try{
            DecimalFormat df = new DecimalFormat("0.00");
            Number num = df.parse(str);
            doub = num.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            doub = 0.0d;
        }
        return doub;
    }
    public Double string2double9df(String str){
        Double doub;
        try{
            DecimalFormat df = new DecimalFormat("0.000000000");
            Number num = df.parse(str);
            doub = num.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            doub = 0.00000000d;
        }
        return doub;
    }
    public Double string2double3df(String str){
        Double doub;
        try{
            DecimalFormat df = new DecimalFormat("0.000");
            Number num = df.parse(str);
            doub = num.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            doub = 0.00d;
        }
        return doub;
    }
    public Double string2double1df(String str){
        Double doub;
        try{
            DecimalFormat df = new DecimalFormat("0.0");
            Number num = df.parse(str);
            doub = num.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            doub = 0.d;
        }
        return doub;
    }
    public String df0(Double val){
        DecimalFormat f2 = new DecimalFormat("#,###,###");
        String data = f2.format(val);
        return  data;
    }

    public String df1(Double val){
        DecimalFormat f2 = new DecimalFormat("#,###,###.#");
        String data = f2.format(val);
        return  data;
    }
    public String df2(Double val){
        DecimalFormat f2 = new DecimalFormat("#,###,###.##");
        String data = f2.format(val);
        return  data;
    }
    public String df3(Double val){
        DecimalFormat f2 = new DecimalFormat("#,###,###.###");
        String data = f2.format(val);
        return  data;
    }
    public String df4(Double val){
        DecimalFormat f2 = new DecimalFormat("#,###,###.####");
        String data = f2.format(val);
        return  data;
    }
    public String df9(Double val){
        DecimalFormat f2 = new DecimalFormat("#,###,###.#########");
        String data = f2.format(val);
        return  data;
    }
}
