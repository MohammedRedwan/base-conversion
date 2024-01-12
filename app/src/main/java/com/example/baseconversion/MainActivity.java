package com.example.baseconversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;

import android.os.Bundle;

import android.view.View;


import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private String x = "",s="";
    private Boolean[] clicked=new Boolean[4];
    private Boolean[] clicked2=new Boolean[4];
    private int originalBackgroundColorRes;
    private TextView editText, outputText;
    private ChipGroup  chipGroup1, chipGroup2;
    private ConstraintLayout customKeyboard;
    private Chip chip1,chip2,chip3,chip4,chip5,chip6,chip7,chip8,chip9,chip0,
    chipA,chipB,chipC,chipD,chipE,chipF;
    private ConstraintLayout layout;
    private DecTo Dec;
    private BinTo Bin;
    private OctTo Oct;
    private HexTo Hex;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customKeyboard=findViewById(R.id.customkeyboard);
        chipA=findViewById(R.id.chip45);
        chipB=findViewById(R.id.chip46);
        chipC=findViewById(R.id.chip47);
        chipD=findViewById(R.id.chip48);
        chipE=findViewById(R.id.chip49);
        chipF=findViewById(R.id.chip50);
        chip1=findViewById(R.id.chip51);
        chip2=findViewById(R.id.chip52);
        chip3=findViewById(R.id.chip53);
        chip4=findViewById(R.id.chip54);
        chip5=findViewById(R.id.chip55);
        chip6=findViewById(R.id.chip56);
        chip7=findViewById(R.id.chip57);
        chip8=findViewById(R.id.chip58);
        chip9=findViewById(R.id.chip59);
        chip0=findViewById(R.id.chip60);
        Chip[]arr={chipA,chipB,chipC,chipD,chipE,chipF,chip1,chip2,chip3,chip4,chip5
        ,chip6,chip7,chip8,chip9,chip0};

        chipGroup1 = findViewById(R.id.chipGroup);
        chipGroup2 = findViewById(R.id.chipGroup2);
        layout = findViewById(R.id.keyboard);
        editText = findViewById(R.id.outputTextView);
        outputText = findViewById(R.id.outputTextView2);

        Arrays.fill(clicked, false);


        Arrays.fill(clicked2, false);


        for (int i = 0; i < arr.length; i++) {

            arr[i].setOnClickListener(view -> {
                String str = ((Chip) view).getText().toString().trim();
                x = editText.getText().toString() + str;
                editText.setText(x);
                updateCalculationClasses();
            });
        }



        editText.setShowSoftInputOnFocus(false);
        originalBackgroundColorRes= R.color.ButtonBackgroundColorU;



    }


public void BaseCalculation(){
    int count=1;
    for(int i=0;i<clicked.length;i++){
        for(int j=0;j<clicked2.length;j++){
            if ((clicked[i]==true && clicked2[j]==true)&&(i==j)){
                s="Invalid Selection";
                outputText.setText(s);
                count=0;
                break;

            }
            else if (clicked[i]==true && clicked2[j]==true){


                if (i==0 && j==1){

                    s=Dec.DecToBin();

                    outputText.setText(s);

                    count=0;
                    break;
                }
                if (i==0 && j==2){

                  s=Dec.DecToHex();
                    outputText.setText(s);

                    count=0;
                    break;
                }
                if (i==0 && j==3){

                 s=Dec.DecToOct();

                    outputText.setText(s);

                    count=0;
                    break;
                }
                if (i==1 && j==0){
                    int count1=0;
                    for(int k=0;k<x.length();k++){
                        if (x.charAt(k)=='0' || x.charAt(k)=='1'){
                            count1++;
                        }
                    }
                    if (count1!=x.length()) {
                        count=0;
                        s="Invalid Input";
                        outputText.setText(s);
                        break;
                    }



                   s=Bin.BinToDec();
                    outputText.setText(s);


                    count=0;
                    break;
                }

                if (i==1 && j==2){
                    int count1=0;
                    for(int k=0;k<x.length();k++){
                        if (x.charAt(k)=='0' || x.charAt(k)=='1'){
                            count1++;
                        }
                    }
                    if (count1!=x.length()) {
                        count=0;
                        s="Invalid Input";
                        outputText.setText(s);
                        break;
                    }

                    s=Bin.BinToHex();
                    Dec = new DecTo(s);
                    s=Dec.DecToHex();
                    outputText.setText(s);

                    count=0;
                    break;}
                if (i==1 && j==3){
                    int count1=0;
                    for(int k=0;k<x.length();k++){
                        if (x.charAt(k)=='0' || x.charAt(k)=='1'){

                            count1++;

                        }
                    }
                    if (count1!=x.length()) {
                        count=0;
                        outputText.setText("Invalid Input");
                        break;
                    }

                    s=Bin.BinToOct();
                    Dec = new DecTo(s);
                    s=Dec.DecToOct();
                    outputText.setText(s);


                    count=0;
                    break;
                }

                if (i==2 && j==0){

                    s=Hex.HexToDec();
                    outputText.setText(s);


                    count=0;
                    break;

                }

                if (i==2 && j==1){

                    s=Hex.HexToBin();
                    DecTo Dec = new DecTo(s);
                    s=Dec.DecToBin();
                    outputText.setText(s);


                    count=0;
                    break;
                }
                if (i==2 && j==3){

                    s=Hex.HexToOct();
                    DecTo Dec = new DecTo(s);
                    s=Dec.DecToOct();
                    outputText.setText(s);

                    count=0;
                    break;
                }

                if (i==3 && j==0){

                    s=Oct.OctToDec();
                    outputText.setText(s);

                    count=0;
                    break;
                }
                if (i==3 && j==1){

                    s=Oct.OctToBin();
                    DecTo Dec = new DecTo(s);
                    s=Dec.DecToBin();
                    outputText.setText(s);

                    count=0;
                    break;
                }
                if (i==3 && j==2){

                    s=Oct.OctToHex();
                    DecTo Dec = new DecTo(s);
                    s=Dec.DecToHex();
                    outputText.setText(s);

                    count=0;
                    break;
                }
            }
        }
        if (count==0)
            break;
    }

}
    public void updateCalculationClasses() {
        Dec = new DecTo(x);
        Bin = new BinTo(x);
        Oct = new OctTo(x);
        Hex = new HexTo(x);
    }

    public boolean checkallcondition(){
        if (x.length() != 0) {
            int doom = 0;
            for (boolean value : clicked) {
                if (value == true) {
                    doom = 1;
                    break;

                }
            }
            for (boolean value : clicked2) {
                if (value == true) {
                    doom += 1;
                    break;

                }
            }
            if (doom == 2) {
//                BaseCalculation();
                return true;
            }
        }
        return false;
    }


    public void OnClearClick(View view) {
        s="";
       x="";
        editText.setText("");


        outputText.setText("0");

    }


    public void OnTextClick(View view) {

        customKeyboard.setVisibility(View.VISIBLE);
        layout.setVisibility(View.VISIBLE);


    }

    public void DoneClick(View view) {


        customKeyboard.setVisibility(View.INVISIBLE);
        layout.setVisibility(View.INVISIBLE);

    }

    public void OnScreenClick(View view) {

        customKeyboard.setVisibility(View.INVISIBLE);
        layout.setVisibility(View.INVISIBLE);

    }

    public void OnBtnClick(View view) {
        Chip chip = (Chip) chipGroup1.getChildAt(0);
        reset();
        chip.setChipBackgroundColorResource(R.color.ButtonBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));
        clicked[0]=true;
        //BaseCalculation();

        if (checkallcondition()){

            BaseCalculation();



        }


    }


    public void OnBtnClick2(View view) {
        Chip chip = (Chip) chipGroup1.getChildAt(1);
        reset();

        chip.setChipBackgroundColorResource(R.color.ButtonBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));
        clicked[1]=true;
        if (checkallcondition()){

            BaseCalculation();



        }


    }


    public void OnBtnClick3(View view) {
        Chip chip = (Chip) chipGroup1.getChildAt(2);
        reset();

        chip.setChipBackgroundColorResource(R.color.ButtonBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));
        clicked[2] = true;

        if (checkallcondition()){

            BaseCalculation();



        }
    }

    public void OnBtnClick4(View view) {
        Chip chip = (Chip) chipGroup1.getChildAt(3);
        reset();
        chip.setChipBackgroundColorResource(R.color.ButtonBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));
        clicked[3]=true;

        if (checkallcondition()){

            BaseCalculation();



        }
    }

    public void OnBtnClick5(View view) {
        Chip chip = (Chip) chipGroup2.getChildAt(0);
        reset2();
        chip.setChipBackgroundColorResource(R.color.ButtonSecBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));
        clicked2[0]=true;

        if (checkallcondition()){

            BaseCalculation();



        }


    }

    public void OnBtnClick6(View view) {
        Chip chip = (Chip) chipGroup2.getChildAt(1);
        reset2();
        chip.setChipBackgroundColorResource(R.color.ButtonSecBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));
        clicked2[1]=true;

        if (checkallcondition()){

            BaseCalculation();



        }

    }

    public void OnBtnClick7(View view) {
        Chip chip = (Chip) chipGroup2.getChildAt(2);
        reset2();
        chip.setChipBackgroundColorResource(R.color.ButtonSecBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));


        clicked2[2]=true;

        if (checkallcondition()){

            BaseCalculation();



        }

    }

    public void OnBtnClick8(View view) {
        Chip chip = (Chip) chipGroup2.getChildAt(3);
        reset2();
        chip.setChipBackgroundColorResource(R.color.ButtonSecBackgroundColorC);
        chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorC));
        clicked2[3]=true;

        if (checkallcondition()){

            BaseCalculation();



        }
    }

    public void reset() {
        int numChips = chipGroup1.getChildCount();
        for (int i = 0; i < numChips; i++) {
            Chip chip = (Chip) chipGroup1.getChildAt(i);
            chip.setChipBackgroundColorResource(originalBackgroundColorRes);
            chip.setTextColor(getResources().getColor(R.color.TextSecBackgroundColorU));
        }
     for(int i=0;i<clicked.length;i++){
         clicked[i]=false;
     }

    }

    public void reset2() {
        int numChips = chipGroup2.getChildCount();
        for (int i = 0; i < numChips; i++) {
            Chip chip = (Chip) chipGroup2.getChildAt(i);
            chip.setChipBackgroundColorResource(originalBackgroundColorRes);
            chip.setTextColor(getResources().getColor(R.color.TextBackgroundColorU));
        }
        for(int i=0;i<clicked2.length;i++){
            clicked2[i]=false;
        }

    }


}