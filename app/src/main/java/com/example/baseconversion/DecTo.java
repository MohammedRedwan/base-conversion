package com.example.baseconversion;

import android.annotation.SuppressLint;

public class DecTo {
    protected String x,text="",text1="",text2="",text3="",text4="",text5="",text6="",text8="",finali="";
    protected int count=0;


    public DecTo(String x) {
        this.x=x;
        //TODO Auto-generated constructor stub
    }
    public void clearAll(){
        text = ""; text1 = ""; text2 = "";
        text3 = ""; text4 = "";
        text5 = ""; text6 = "";
        text8 = ""; finali = "";
        count=0;

    }
    public String DecToBin() {
        clearAll();
        if (x.contains(String.valueOf('.'))) {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != '.') {
                    text += x.charAt(i);

                } else {
                    Long num = Long.parseLong(text);
                    while (true) {
                        if (num % 2 == 0) {
                            text1 += '0';

                        } else {
                            text1 += '1';
                        }
                        num = num / 2;
                        if (num == 0) {
                            break;
                        }

                    }
                    for (int j = i; j < x.length(); j++) {
                        text2 += x.charAt(j);

                    }
                    Double num1 = Double.parseDouble(text2);
                    while (true) {
                        num1 = num1 * 2;
                        String sub = String.valueOf(num1);
                        char a = sub.charAt(0);
                        text3 += a;
                        StringBuilder stringBuilder = new StringBuilder(sub);
                        stringBuilder.setCharAt(0, '0');
                        String modifiedString = stringBuilder.toString();
                        num1 = Double.parseDouble(modifiedString);
                        if (num1 == Math.round(num1)) {
                            break;
                        }
                        if (count == 10) {
                            break;
                        }
                        count++;

                    }

                }
            }
            text1 = new StringBuilder(text1).reverse().toString();
            finali=text1+'.'+text3;
            return(finali);

        } else {
            Long num = Long.parseLong(x);
            while (true) {
                if (num % 2 == 0) {
                    text += '0';

                } else {
                    text += '1';
                }
                num = num / 2;
                if (num == 0) {
                    break;
                }

            }
            text = new StringBuilder(text).reverse().toString();
            return text;

        }

    }

    public String DecToHex() {
        clearAll();
        int sum = 0, count = 0, pointer = 0;
        String y = "", z = "", w = "";

        String x = DecToBin();


        int rev = 3;
        if (x.contains(String.valueOf('.'))) {
            pointer = 1;
            int decimalIndex = x.indexOf(".");
            for (int i = decimalIndex + 1; i < x.length(); i++) {
                if (x.charAt(i) == '1') {

                    sum += (Math.pow(2, rev));

                }
                rev--;
                if (rev == -1) {
                    if (sum == 10) {
                        w += 'A';
                    } else if (sum == 11) {

                        w += 'B';
                    } else if (sum == 12) {
                        w += 'C';
                    } else if (sum == 13) {
                        w += 'D';
                    } else if (sum == 14) {
                        w += 'E';
                    } else if (sum == 15) {
                        w += 'F';
                    } else {


                        w += String.valueOf(sum);
                    }

                    rev = 3;
                    sum = 0;

                }

            }
            if (sum != 0) {
                if (sum == 10) {
                    w += 'A';
                } else if (sum == 11) {

                    w += 'B';
                } else if (sum == 12) {
                    w += 'C';
                } else if (sum == 13) {
                    w += 'D';
                } else if (sum == 14) {
                    w += 'E';
                } else if (sum == 15) {
                    w += 'F';
                } else {

                    w += String.valueOf(sum);
                }
            }
            for (int i = 0; i < decimalIndex; i++) {
                z += x.charAt(i);

            }
            x = z;

        }

        sum = 0;
        rev = 0;

        for (int i = x.length() - 1; i >= 0; i--) {

            if (x.charAt(i) == '1') {


                sum += (Math.pow(2, rev));


            }

            rev++;

            if (rev != 0 && rev % 4 == 0) {
                if (sum == 10) {
                    y += 'A';
                } else if (sum == 11) {
                    y += 'B';
                } else if (sum == 12) {
                    y += 'C';
                } else if (sum == 13) {
                    y += 'D';
                } else if (sum == 14) {
                    y += 'E';
                } else if (sum == 15) {
                    y += 'F';
                } else {
                    y += String.valueOf(sum);
                }

                rev = 0;
                sum = 0;

            }
        }
        if (sum != 0) {
            if (sum == 10) {
                y += 'A';
            } else if (sum == 11) {
                y += 'B';
            } else if (sum == 12) {
                y += 'C';
            } else if (sum == 13) {
                y += 'D';
            } else if (sum == 14) {
                y += 'E';
            } else if (sum == 15) {
                y += 'F';
            } else {
                y += String.valueOf(sum);
            }
        }
        if (pointer == 1) {
            String a;
            y = new StringBuilder(y).reverse().toString();
            a = y + '.' + w;
            return a;
        } else
            y = new StringBuilder(y).reverse().toString();
        return y;

    }

    public String DecToOct() {
        clearAll();

        int sum = 0, pointer = 0;
        String y = "", z = "", w = "";

        String x = DecToBin();

        int rev = 2;
        if (x.contains(String.valueOf('.'))) {
            pointer = 1;
            int decimalIndex = x.indexOf(".");
            for (int i = decimalIndex + 1; i < x.length(); i++) {
                if (x.charAt(i) == '1') {

                    sum += (Math.pow(2, rev));

                }
                rev--;
                if (rev == -1) {


                    w += String.valueOf(sum);

                    rev = 2;
                    sum = 0;

                }

            }
            if (sum != 0) {

                w += String.valueOf(sum);

            }
            for (int i = 0; i < decimalIndex; i++) {
                z += x.charAt(i);

            }
            x = z;

        }

        sum = 0;
        rev = 0;

        for (int i = x.length() - 1; i >= 0; i--) {

            if (x.charAt(i) == '1') {


                sum += (Math.pow(2, rev));


            }

            rev++;

            if (rev != 0 && rev % 3 == 0) {

                y += String.valueOf(sum);

                rev = 0;
                sum = 0;

            }
        }
        if (sum != 0) {

            y += String.valueOf(sum);

        }
        if (pointer == 1) {
            String a;
            y = new StringBuilder(y).reverse().toString();
            a = y + '.' + w;
            return a;
        } else
            y = new StringBuilder(y).reverse().toString();
        return y;

    }

}


