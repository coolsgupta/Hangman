package com.sgupta.hangman;

import android.util.Log;

import java.util.Random;

public class Game {
     private Data mData=new Data();
    private String mHint;
    private String mAnswer;
    private boolean mHits[];
    private int mLives;
    private String mInputs ="";
    private int inputLength =0;
    private String mStatus;
    private int mI;

    public void setStatus(int i) {
        if(i==0){
            mStatus = "Start Game by entering first character.";
        }
        else if (i==1){
            mStatus = "correct! go on.";
        }
        else if (i==-1){
            mStatus = "oops!that was a wrong answer. you have "+mLives+" tries left!";
        }
        else if(i==2){
            mStatus = "You won!";
        }
        else if(i==-2){
            mStatus = "You lost!";
        }
        else if(i==3){
            mStatus="Already Tried! Try another one!";
        }
        else if(i==-3){
            mStatus="Invalid Input! try again.";
        }
    }

    public String getStatus() {
        return mStatus;
    }

    public void setLives(){
        mLives=5;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer() {
        mAnswer = mData.getAnswer(mI);
        mHits = new boolean[mAnswer.length()];
        for(int i=0;i<mAnswer.length();i++)
            mHits[i]=false;
    }

    public String getHint() {
        return mHint;
    }

    public void setHint() {
        mHint = mData.getHint(mI);
    }

    public String getFakeAnswer(){
        String fakeAnswer="";
        for(int i=0;i<mAnswer.length();i++)
        {
            if(mHits[i]==true)
                fakeAnswer+=mAnswer.charAt(i);
            else
                fakeAnswer+="_"+" ";
        }
        return fakeAnswer;
    }


    public String getInputs() {
        return mInputs;
    }

    public void setInputs() {
        mInputs = "";
        inputLength=0;
    }

    public void StartGame(){
        Random random = new Random();
        int length = mData.getLength();
        mI = random.nextInt(length);
        setAnswer();
        setHint();
        setStatus(0);
        setInputs();
        setLives();

    }

    public void checkAnswer(String answer)throws Exception {


            char a = answer.charAt(0);
            if(answer.length()==0)
                throw new Exception();
       /*if((a>='z' && a<='z')||(a>='A'&&a<='Z'))
            throw new IllegalArgumentException() ;*/
        int tem=0;
        int tem2=0;

        for(mI =0; mI < inputLength; mI++) {
            if (a == mInputs.charAt(mI)) {
                tem = 1;
                setStatus(3);
                break;
            }
        }
        if(tem==0) {
            for (int i = 0; i < mAnswer.length(); i++) {
                tem=0;
                if (a == mAnswer.charAt(i)){
                    tem = 1;
                    setStatus(1);
                    mHits[i] = true;
                    tem2=1;
                }
            }

            if (tem2 == 0) {
                mLives--;
                setStatus(-1);
            }
            mInputs += a;
            inputLength++;
        }
    }

    public int checkWin() {
        boolean flag = true;
        if(mLives<=0){
            setStatus(-2);
            return -1;
        }
        else if(mLives > 0){
            for(int i=0;i<mHits.length; i++){
                if(mHits[i]==false) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                setStatus(2);
                return 1;
            }
        }
        return 0;
    }
}