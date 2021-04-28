package com.example.sudoku;

import java.util.ArrayList;
import java.util.Random;

public class Level_generator {
    public static int[][] lvl(int x){

        int y;
        if (x == 3){
            y = 22;                         // 22 fields for hard level
        }
        else if (x == 2)
        {
            y = 30;                         // 30 fields for medium level
        }
        else {
            y = 38;                         //38 fields for easy level
        }
        int[][] level = new int[2][y];              // Empty tab for idexes
        int[][] indeksy = new int[2][81];           // Indexes cannot be repetitive. Sudoku board has 81 fileds.
        ArrayList<Integer> l = new ArrayList<>();

        Random num = new Random();
        int c = 0;
        //Generator
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                {
                    indeksy[0][c] = i;
                    indeksy[1][c] = j;
                    c++;
                }
            }
        }
        for (int i = 0; i < y; i++) {
            int k;
            do {
                k = num.nextInt(81) ;
            } while (l.contains(k));
            l.add(k);
        }

        for (int i = 0; i <y; i++){
            level[0][i] =  indeksy[0][l.get(i)];
            level[1][i] = indeksy[1][l.get(i)];
        }

        return level;
    }
}
