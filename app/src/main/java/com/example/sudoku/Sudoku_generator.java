package com.example.sudoku;
import java.util.ArrayList;
import java.util.Random;

public class Sudoku_generator {

    public static int[][] Sudoku_generator(){

        // Sudoku solved game borad generator
        int[][] sudoku = new int[9][9];
        Random num = new Random();


        // 9 lines of borad. The digits cannot be repetitive
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        ArrayList<Integer> l4 = new ArrayList<>();
        ArrayList<Integer> l5 = new ArrayList<>();
        ArrayList<Integer> l6 = new ArrayList<>();
        ArrayList<Integer> l7 = new ArrayList<>();
        ArrayList<Integer> l8 = new ArrayList<>();
        ArrayList<Integer> l9 = new ArrayList<>();


        boolean flagG;
        do {
            int c = 0;
            flagG = false;

            // LINE 1
            for (int i = 0; i < 9; i++) {
                int k;
                do {
                    k = num.nextInt(9) + 1;
                } while (l1.contains(k));
                l1.add(k);
            }

            // LINE 2
            for (int i = 0; i < 9; i++) {
                int k, j = 0;
                boolean flag1, flag2, flag3;
                if (i < 3) {
                    do {
                        flag1 = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(0) || k == l1.get(1) || k == l1.get(2)) {
                            flag1 = true;
                        }
                        j++;
                        if (j == 50) {
                            l2.clear();
                            j = 0;
                            i = 0;
                        }
                    } while (l2.contains(k) || flag1);
                    l2.add(k);
                } else if (i < 6) {
                    do {
                        flag2 = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(3) || k == l1.get(4) || k == l1.get(5)) {
                            flag2 = true;
                        }
                        j++;
                        if (j == 50) {
                            l2.clear();
                            j = 0;
                            i = 0;
                        }
                    } while (l2.contains(k) || flag2);
                    l2.add(k);
                } else {
                    do {
                        flag3 = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(6) || k == l1.get(7) || k == l1.get(8)) {
                            flag3 = true;
                        }
                        j++;
                        if (j == 50) {
                            l2.clear();
                            j = 0;
                            i = 0;
                        }
                    } while (l2.contains(k) || flag3);
                    l2.add(k);
                }
            }


            // LINE 3
            for (int i = 0; i < 9; i++) {
                int k, j = 0;
                boolean flag1, flag2, flag3;
                if (i < 3) {
                    do {
                        flag1 = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(0) || k == l1.get(1) || k == l1.get(2) ||
                                k == l2.get(0) || k == l2.get(1) || k == l2.get(2)) {
                            flag1 = true;
                        }
                        j++;
                        if (j == 50) {
                            i = 0;
                            c++;
                            break;
                        }
                    } while (l3.contains(k) || flag1);
                    l3.add(k);
                } else if (i < 6) {
                    do {
                        flag2 = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(3) || k == l1.get(4) || k == l1.get(5)
                                || k == l2.get(3) || k == l2.get(4) || k == l2.get(5)) {
                            flag2 = true;
                        }
                        j++;
                        if (j == 50) {
                            i = 0;
                            c++;
                            break;
                        }
                    } while (l3.contains(k) || flag2);
                    l3.add(k);
                } else {
                    do {
                        flag3 = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(6) || k == l1.get(7) || k == l1.get(8)
                                || k == l2.get(6) || k == l2.get(7) || k == l2.get(8)) {
                            flag3 = true;
                        }
                        j++;
                        if (j == 50) {
                            i = 0;
                            c++;
                            break;
                        }
                    } while (l3.contains(k) || flag3);
                    l3.add(k);
                }
                if (c == 1){
                    flagG = true;
                    break;
                }
            }

            // LINE 4
            if(!flagG) {
                for (int i = 0; i < 9; i++) {
                    int k, j = 0;
                    boolean flag;
                    do {
                        flag = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(i) || k == l2.get(i) || k == l3.get(i)) {
                            flag = true;
                        }
                        j++;
                        if (j == 50) {
                            l4.clear();
                            i = 0;
                            c++;
                            break;
                        }
                    } while (l4.contains(k) || flag);
                    l4.add(k);
                    if (c == 1) {
                        flagG = true;
                        break;
                    }
                }
            }


            // LINE 5
            if(!flagG) {
                for (int i = 0; i < 9; i++) {
                    int k, j = 0;
                    boolean flag1, flag2, flag3;
                    if (i < 3) {
                        do {
                            flag1 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l4.get(0) || k == l4.get(1) || k == l4.get(2)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)) {
                                flag1 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l5.contains(k) || flag1);
                        l5.add(k);
                    } else if (i < 6) {
                        do {
                            flag2 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l4.get(3) || k == l4.get(4) || k == l4.get(5)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)) {
                                flag2 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l5.contains(k) || flag2);
                        l5.add(k);
                    } else {
                        do {
                            flag3 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l4.get(6) || k == l4.get(7) || k == l4.get(8)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)) {
                                flag3 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l5.contains(k) || flag3);
                        l5.add(k);
                    }
                    if (c == 1) {
                        flagG = true;
                        break;
                    }
                }
            }

            // LINE 6

            if(!flagG) {
                for (int i = 0; i < 9; i++) {
                    int k, j = 0;
                    boolean flag1, flag2, flag3;
                    if (i < 3) {
                        do {
                            flag1 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l4.get(0) || k == l4.get(1) || k == l4.get(2) ||
                                    k == l5.get(0) || k == l5.get(1) || k == l5.get(2)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)) {
                                flag1 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l6.contains(k) || flag1);
                        l6.add(k);
                    } else if (i < 6) {
                        do {
                            flag2 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l4.get(3) || k == l4.get(4) || k == l4.get(5)
                                    || k == l5.get(3) || k == l5.get(4) || k == l5.get(5)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)) {
                                flag2 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l6.contains(k) || flag2);
                        l6.add(k);
                    } else {
                        do {
                            flag3 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l4.get(6) || k == l4.get(7) || k == l4.get(8)
                                    || k == l5.get(6) || k == l5.get(7) || k == l5.get(8)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)) {
                                flag3 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l6.contains(k) || flag3);
                        l6.add(k);
                    }
                    if (c == 1) {
                        flagG = true;
                        break;
                    }
                }
            }

            //LINE 7

            if(!flagG) {
                for (int i = 0; i < 9; i++) {
                    int k, j = 0;
                    boolean flag;
                    do {
                        flag = false;
                        k = num.nextInt(9) + 1;
                        if (k == l1.get(i) || k == l2.get(i) || k == l3.get(i)
                                || k == l4.get(i) || k == l5.get(i) || k == l6.get(i)) {
                            flag = true;
                        }
                        j++;
                        if (j == 50) {
                            i = 0;
                            c++;
                            break;
                        }
                    } while (l7.contains(k) || flag);
                    l7.add(k);
                    if (c == 1) {
                        flagG = true;
                        break;
                    }
                }
            }

            // LINE 8
            if(!flagG) {
                for (int i = 0; i < 9; i++) {
                    int k, j = 0;
                    boolean flag1, flag2, flag3;
                    if (i < 3) {
                        do {
                            flag1 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l7.get(0) || k == l7.get(1) || k == l7.get(2)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)
                                    || k == l4.get(i) || k == l5.get(i) || k == l6.get(i)) {
                                flag1 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l8.contains(k) || flag1);
                        l8.add(k);
                    } else if (i < 6) {
                        do {
                            flag2 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l7.get(3) || k == l7.get(4) || k == l7.get(5)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)
                                    || k == l4.get(i) || k == l5.get(i) || k == l6.get(i)) {
                                flag2 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l8.contains(k) || flag2);
                        l8.add(k);
                    } else {
                        do {
                            flag3 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l7.get(6) || k == l7.get(7) || k == l7.get(8)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)
                                    || k == l4.get(i) || k == l5.get(i) || k == l6.get(i)) {
                                flag3 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l8.contains(k) || flag3);
                        l8.add(k);
                    }
                    if (c == 1) {
                        flagG = true;
                        break;
                    }
                }
            }

            // LINE 9
            if(!flagG) {
                for (int i = 0; i < 9; i++) {
                    int k, j = 0;
                    boolean flag1, flag2, flag3;
                    if (i < 3) {
                        do {
                            flag1 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l7.get(0) || k == l7.get(1) || k == l7.get(2) ||
                                    k == l8.get(0) || k == l8.get(1) || k == l8.get(2)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)
                                    || k == l4.get(i) || k == l5.get(i) || k == l6.get(i)) {
                                flag1 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l9.contains(k) || flag1);
                        l9.add(k);
                    } else if (i < 6) {
                        do {
                            flag2 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l7.get(3) || k == l7.get(4) || k == l7.get(5)
                                    || k == l8.get(3) || k == l8.get(4) || k == l8.get(5)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)
                                    || k == l4.get(i) || k == l5.get(i) || k == l6.get(i)) {
                                flag2 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l9.contains(k) || flag2);
                        l9.add(k);
                        c= 0;
                    } else {
                        do {
                            flag3 = false;
                            k = num.nextInt(9) + 1;
                            if (k == l7.get(6) || k == l7.get(7) || k == l7.get(8)
                                    || k == l8.get(6) || k == l8.get(7) || k == l8.get(8)
                                    || k == l1.get(i) || k == l2.get(i) || k == l3.get(i)
                                    || k == l4.get(i) || k == l5.get(i) || k == l6.get(i)) {
                                flag3 = true;
                            }
                            j++;
                            if (j == 50) {
                                i = 0;
                                c++;
                                break;
                            }
                        } while (l9.contains(k) || flag3);
                        l9.add(k);
                    }
                    if (c == 1) {
                        flagG = true;
                        break;
                    }
                }
            }
            if(flagG)
            {
                l1.clear();
                l2.clear();
                l3.clear();
                l4.clear();
                l5.clear();
                l6.clear();
                l7.clear();
                l8.clear();
                l9.clear();
            }
        }while (flagG);

        for (int i = 0; i < 9; i++){
            sudoku[0][i] = l1.get(i);
            sudoku[1][i] = l2.get(i);
            sudoku[2][i] = l3.get(i);
            sudoku[3][i] = l4.get(i);
            sudoku[4][i] = l5.get(i);
            sudoku[5][i] = l6.get(i);
            sudoku[6][i] = l7.get(i);
            sudoku[7][i] = l8.get(i);
            sudoku[8][i] = l9.get(i);
        }
        l1.clear();
        l2.clear();
        l3.clear();
        l4.clear();
        l5.clear();
        l6.clear();
        l7.clear();
        l8.clear();
        l9.clear();

        return sudoku;
    }

}
