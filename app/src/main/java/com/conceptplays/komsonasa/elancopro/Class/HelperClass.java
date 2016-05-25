package com.conceptplays.komsonasa.elancopro.Class;

import android.content.Context;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;

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

    public static String formatPrice(double price) {
//        Currency currency = Currency.getInstance("THB");
//        NumberFormat format = NumberFormat.getCurrencyInstance();
//        format.setCurrency(currency);
//        return format.format(price);

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);
        return nf.format(price).trim();
    }

    public String currency(Double val){

        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        Currency currency = Currency.getInstance("USD");
        format.setCurrency(currency);
        //System.out.println(format.format(1234.23434));
        return  format.format(val);
    }

}
