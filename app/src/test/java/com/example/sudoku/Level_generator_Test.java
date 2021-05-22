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

    @Test
    public void random_indexes_generator_test(){

        //given
        int[][] tab_easy1 = Level_generator.lvl(1);
        int[][] tab_easy2 = Level_generator.lvl(1);
        int[][] tab_easy3 = Level_generator.lvl(1);

        int[][] tab_medium1 = Level_generator.lvl(2);
        int[][] tab_medium2 = Level_generator.lvl(2);
        int[][] tab_medium3 = Level_generator.lvl(2);

        int[][] tab_hard1 = Level_generator.lvl(3);
        int[][] tab_hard2 = Level_generator.lvl(3);
        int[][] tab_hard3 = Level_generator.lvl(3);

        //then
            //easy
        Assert.assertNotEquals(tab_easy1, tab_easy2);
        Assert.assertNotEquals(tab_easy1, tab_easy3);
        Assert.assertNotEquals(tab_easy2, tab_easy3);
            //medium
        Assert.assertNotEquals(tab_medium1, tab_medium2);
        Assert.assertNotEquals(tab_medium1, tab_medium3);
        Assert.assertNotEquals(tab_medium2, tab_medium3);
            //hard
        Assert.assertNotEquals(tab_hard1, tab_hard2);
        Assert.assertNotEquals(tab_hard1, tab_hard3);
        Assert.assertNotEquals(tab_hard2, tab_hard3);



    }

}
