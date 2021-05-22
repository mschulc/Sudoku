package com.example.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class Level_generator_Test {

    @Test
    public void check_easy_lvl_length_array(){

        //given
        int[][] indexes_tests = Level_generator.lvl(1);

        //then
        Assert.assertEquals(indexes_tests[0].length, 38);
        Assert.assertEquals(indexes_tests[1].length, 38);

    }

    @Test
    public void check_medium_lvl_length_array(){

        int[][] indexes_tests = Level_generator.lvl(2);

        //then
        Assert.assertEquals(indexes_tests[0].length, 30);
        Assert.assertEquals(indexes_tests[1].length, 30);

    }

    @Test
    public void check_hard_lvl_length_array(){

        int[][] indexes_tests = Level_generator.lvl(3);

        //then
        Assert.assertEquals(indexes_tests[0].length, 22);
        Assert.assertEquals(indexes_tests[1].length, 22);

    }

    @Test
    public void check_easy_lvl_unique_numbers(){
        //given
        int[][] indexes_tests = Level_generator.lvl(1);
        ArrayList<String> checkList = new ArrayList<>();
        boolean resault = true;

        //when
        for(int i = 0; i < indexes_tests[0].length; i++){
            String number = "";
            number = number + String.valueOf(indexes_tests[0][i]) + String.valueOf(indexes_tests[1][i]);
            checkList.add(number);
        }
        for(int i = 0; i < 38; i++){
            for(int j = 0; j < 38; j++){
                if(j != i){
                    if (checkList.get(i).equals(checkList.get(j))){
                        resault = false;
                    }
                }
            }
        }
        // then
        Assert.assertTrue(resault);
    }

    @Test
    public void check_medium_lvl_unique_numbers(){
        //given
        int[][] indexes_tests = Level_generator.lvl(2);
        ArrayList<String> checkList = new ArrayList<>();
        boolean resault = true;

        //when
        for(int i = 0; i < indexes_tests[0].length; i++){
            String number = "";
            number = number + String.valueOf(indexes_tests[0][i]) + String.valueOf(indexes_tests[1][i]);
            checkList.add(number);
        }
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                if(j != i){
                    if (checkList.get(i).equals(checkList.get(j))){
                        resault = false;
                    }
                }
            }
        }
        // then
        Assert.assertTrue(resault);
    }

    @Test
    public void check_hard_lvl_unique_numbers(){
        //given
        int[][] indexes_tests = Level_generator.lvl(3);
        ArrayList<String> checkList = new ArrayList<>();
        boolean resault = true;

        //when
        for(int i = 0; i < indexes_tests[0].length; i++){
            String number = "";
            number = number + String.valueOf(indexes_tests[0][i]) + String.valueOf(indexes_tests[1][i]);
            checkList.add(number);
        }
        for(int i = 0; i < 22; i++){
            for(int j = 0; j < 22; j++){
                if(j != i){
                    if (checkList.get(i).equals(checkList.get(j))){
                        resault = false;
                    }
                }
            }
        }
        // then
        Assert.assertTrue(resault);
    }

}
