package com.example.baseconversion;

public class HexTo  {
    protected String x;

    
    public HexTo(String x) {
        this.x=x;
        //TODO Auto-generated constructor stub
    }

    public String HexToDec(){

        int sum=0;
        double mul;
        int res=x.length()-1;
        for(int i=0;i<x.length();i++){
            char charValue = x.charAt(i);
            int intValue = Character.getNumericValue(charValue);
            mul=intValue*(Math.pow(16,res));
            int again = (int) Math.round(mul);
            sum+=again;
            res--;

        }
        String a = String.valueOf(sum);
        return a;

        


    }
    public String HexToBin(){

        String a =HexToDec();

        return a;

    }
     public String HexToOct(){

        String a =HexToDec();

        return a;

    }
    
}
