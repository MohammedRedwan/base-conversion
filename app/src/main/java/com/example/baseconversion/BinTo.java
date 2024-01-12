package com.example.baseconversion;

public class BinTo {
    protected String x;
    protected int count=0;
    public BinTo(String x) {
        this.x=x;
        //TODO Auto-generated constructor stub
    }
    public String BinToDec(){
        int sum=0;
        double mul;
        int res=x.length()-1;
        for(int i=0;i<x.length();i++){
            char charValue = x.charAt(i);
            int intValue = Character.getNumericValue(charValue);
            mul=intValue*(Math.pow(2,res));
            int again = (int) Math.round(mul);
            sum+=again;
            res--;

        }
        return String.valueOf(sum);
    }

    public String BinToHex(){
       String a=BinToDec();
       String c= String.valueOf(a);
        return c;
    }
    public String BinToOct(){
       String a=BinToDec();
       String c= String.valueOf(a);
        return c;
    }

    
    
}
