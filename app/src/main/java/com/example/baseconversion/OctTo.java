package com.example.baseconversion;

public class OctTo  {
    protected String x;
    protected int count=0;
    
    public OctTo(String x) {
        this.x=x;
        //TODO Auto-generated constructor stub
    }

    public String OctToDec(){

        int sum=0;
        double mul;
        int res=x.length()-1;
        for(int i=0;i<x.length();i++){
            char charValue = x.charAt(i);
            int intValue = Character.getNumericValue(charValue);
            mul=intValue*(Math.pow(8,res));
            int again = (int) Math.round(mul);
            sum+=again;
            res--;

        }
        String a = String.valueOf(sum);
        return a;

        


    }
    public String OctToBin(){

        String a =OctToDec();

        return a;

    }
     public String OctToHex(){

        String a =OctToDec();

        return a;

    }
    
}
