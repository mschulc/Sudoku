package com.example.sudoku;

public class checker {

    public static boolean check(int[][] tab1, int[][] tab2){
        boolean flag = false;

            outer: for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(tab1[i][j] != tab2[i][j]){
                        flag = false;
                        break outer;
                    }
                    else{
                        flag = true;
                    }
                }
            }
        return flag;
    }

    public static String replace(CharSequence text, int index, char c){

        String text1 = "";
        for(int i = 0; i < text.length(); i++){
            if(index == i){
                text1 = text1 + c;
            }
            else {
                text1 = text1 + text.charAt(i);
            }
        }
        return text1;
    }
}
