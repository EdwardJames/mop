package com.xp.springboot.mop.sign;

public class Maopao {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] score = {5,2,1,4,3};
        for(int i=0;i<score.length;i++){
            for(int j=0;j<score.length-i-1;j++){
                if(score[j]>score[j+1]){
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
           
        }
        for(int a = 0;a<score.length;a++){
            System.out.println(score[a]);
        }
    }

}
