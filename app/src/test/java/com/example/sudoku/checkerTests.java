package com.example.sudoku;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class checkerTests {

    @Test
    public void check_array_is_equal_true(){

        //given
        int[][] board1 = Sudoku_generator.Sudoku_generator();
        int[][] board2 = board1;

        //then
        Assert.assertTrue(checker.check(board1, board2));
    }

    @Test
    public void check_array_is_equal_flase(){

        //given
        int[][] board1 = Sudoku_generator.Sudoku_generator();
        int[][] board2 = Sudoku_generator.Sudoku_generator();

        //then
        Assert.assertFalse(checker.check(board1, board2));
    }

    @Test
    public void should_replace_char_at_index_true(){

        Assert.assertEquals(checker.replace("aaaaaaaaa", 8, 'X'), "aaaaaaaaX");
        Assert.assertEquals(checker.replace("0123456789", 0, 'z'), "z123456789");
        Assert.assertEquals(checker.replace("11223344556677889900", 9, '6'), "11223344566677889900");
        Assert.assertEquals(checker.replace("Testy_Jednostkowe", 5, ' '), "Testy Jednostkowe");
        Assert.assertEquals(checker.replace("Chciałbym ocene 4", 16, '5'), "Chciałbym ocene 5");
        Assert.assertEquals(checker.replace("MaciejX", 6, 'S'), "MaciejS");
        Assert.assertEquals(checker.replace("123   789", 4, '5' ), "123 5 789");
        Assert.assertEquals(checker.replace("1 2 3 4 5 6 7 8 9", 12, ' '), "1 2 3 4 5 6   8 9");
        Assert.assertEquals(checker.replace("abcdefghijklmnopqrstuvwxyz", 1, 'B'), "aBcdefghijklmnopqrstuvwxyz");
        Assert.assertEquals(checker.replace("         ", 5, '6'), "     6   ");
        Assert.assertEquals(checker.replace("1 2   4     7 8  ", 16, '9'), "1 2   4     7 8 9");
        Assert.assertEquals(checker.replace("Panda3", 5, '4'), "Panda4");
        Assert.assertEquals(checker.replace("PANDA_4", 6, '5'), "PANDA_5");
        Assert.assertEquals(checker.replace("Maciej", 5, 'k'), "Maciek");

    }

    @Test
    public void should_replace_char_at_index_false(){

        Assert.assertNotEquals(checker.replace("ABC", 1, 'X'), "ABC");
        Assert.assertNotEquals(checker.replace("maciej", 5, '3'), "Maciek");
        Assert.assertNotEquals(checker.replace("123456789", 5, ' '), "1234  789");
        Assert.assertNotEquals(checker.replace("XYZ", 0, '9'), "abc");
        Assert.assertNotEquals(checker.replace("1 2 3 4 5 6 7 8 9", 7, ' '), "                 ");

    }
}
