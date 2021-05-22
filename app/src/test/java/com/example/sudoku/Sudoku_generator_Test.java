package com.example.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Sudoku_generator_Test {

    @Before

    @Test
    public void Check_squares_Sudoku_generator_true() {

        //given
        int[][] example_sudoku_tab = Sudoku_generator.Sudoku_generator();
        int square1 = 0, square2= 0, square3 = 0, square4 = 0, square5 = 0,
                square6 = 0, square7 = 0, square8 = 0, square9 = 0;
        boolean resault = true;
        // when

        for (int i = 0; i <= 2; i++)
        {
            for (int j = 0; j <= 2; j++)
            {
                square1 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 0; i <= 2; i++)
        {
            for (int j = 3; j <= 5; j++)
            {
                square2 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 0; i <= 2; i++)
        {
            for (int j = 6; j <= 8; j++)
            {
                square3 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 3; i <= 5; i++)
        {
            for (int j = 3; j <= 5; j++)
            {
                square4 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 3; i <= 5; i++)
        {
            for (int j = 0; j <= 2; j++)
            {
                square5 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 3; i <= 5; i++)
        {
            for (int j = 6; j <= 8; j++)
            {
                square6 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 6; i <= 8; i++)
        {
            for (int j = 3; j <= 5; j++)
            {
                square7 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 6; i <= 8; i++)
        {
            for (int j = 0; j <= 2; j++)
            {
                square8 += example_sudoku_tab[j][i];
            }
        }
        for (int i = 6; i <= 8; i++)
        {
            for (int j = 6; j <= 8; j++)
            {
                square9 += example_sudoku_tab[j][i];
            }
        }
        if (square1 != 45 || square2 != 45 || square3 != 45 || square4 != 45 || square5 != 45 || square6 != 45 || square7 != 45 || square8 != 45 || square9 != 45)
        {
            resault = false;
        }

        //then
        Assert.assertEquals(true, resault);

    }

    @Test
    public void Check_rows_Sudoku_generator_true(){

        //given
        int[][] example_sudoku_tab = Sudoku_generator.Sudoku_generator();
        int row1 = 0, row2 = 0, row3 = 0, row4 = 0,row5 = 0, row6 = 0, row7 = 0, row8 = 0, row9 = 0;

        //when
        for(int i = 0; i < 9; i++) {
            row1 += example_sudoku_tab[0][i];
            row2 += example_sudoku_tab[1][i];
            row3 += example_sudoku_tab[2][i];
            row4 += example_sudoku_tab[3][i];
            row5 += example_sudoku_tab[4][i];
            row6 += example_sudoku_tab[5][i];
            row7 += example_sudoku_tab[6][i];
            row8 += example_sudoku_tab[7][i];
            row9 += example_sudoku_tab[8][i];
        }

        //then
        Assert.assertEquals(45, row1);
        Assert.assertEquals(45, row2);
        Assert.assertEquals(45, row3);
        Assert.assertEquals(45, row4);
        Assert.assertEquals(45, row5);
        Assert.assertEquals(45, row6);
        Assert.assertEquals(45, row7);
        Assert.assertEquals(45, row8);
        Assert.assertEquals(45, row9);
    }

    @Test
    public void Check_columns_Sudoku_generator_true(){

        //given
        int[][] example_sudoku_tab = Sudoku_generator.Sudoku_generator();
        int column1 = 0, column2 = 0, column3 = 0, column4 = 0,
            column5 = 0, column6 = 0, column7 = 0, column8 = 0, column9 = 0;

        //when
        for(int i = 0; i < 9; i++) {
            column1 += example_sudoku_tab[i][0];
            column2 += example_sudoku_tab[i][1];
            column3 += example_sudoku_tab[i][2];
            column4 += example_sudoku_tab[i][3];
            column5 += example_sudoku_tab[i][4];
            column6 += example_sudoku_tab[i][5];
            column7 += example_sudoku_tab[i][6];
            column8 += example_sudoku_tab[i][7];
            column9 += example_sudoku_tab[i][8];
        }

        //then
        Assert.assertEquals(45, column1);
        Assert.assertEquals(45, column2);
        Assert.assertEquals(45, column3);
        Assert.assertEquals(45, column4);
        Assert.assertEquals(45, column5);
        Assert.assertEquals(45, column6);
        Assert.assertEquals(45, column7);
        Assert.assertEquals(45, column8);
        Assert.assertEquals(45, column9);

    }

    @Test
    public void not_empty_array_Test()
    {
        //given
        int resault = 0;
        int[][] example_sudoku_tab = Sudoku_generator.Sudoku_generator();

        //when
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                resault =+ example_sudoku_tab[i][j];
            }
        }

        //then
        Assert.assertNotEquals(resault, 0);
    }

    @Test
    public void random_boards_test(){

        //given
        int[][] board1 = Sudoku_generator.Sudoku_generator();
        int[][] board2 = Sudoku_generator.Sudoku_generator();
        int[][] board3 = Sudoku_generator.Sudoku_generator();
        int[][] board4 = Sudoku_generator.Sudoku_generator();
        int[][] board5 = Sudoku_generator.Sudoku_generator();

        //then
        Assert.assertNotEquals(board1, board2);
        Assert.assertNotEquals(board1, board3);
        Assert.assertNotEquals(board1, board4);
        Assert.assertNotEquals(board1, board5);
        Assert.assertNotEquals(board2, board3);
        Assert.assertNotEquals(board2, board4);
        Assert.assertNotEquals(board2, board5);
        Assert.assertNotEquals(board3, board4);
        Assert.assertNotEquals(board3, board5);
        Assert.assertNotEquals(board4, board5);
    }
}