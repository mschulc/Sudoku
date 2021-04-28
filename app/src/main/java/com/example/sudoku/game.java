package com.example.sudoku;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

public class game extends AppCompatActivity {
    ToggleButton pensil;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    ToggleButton tb[][];
    Button rubber;
    Button hint_btn;
    int[][] game_table;
    int[][] game_answ;
    int[][] indexes;
    int mistake;
    int hint_c;
    TextView mistakes;
    TextView hints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        int y;     // level
        mistake = 0;
        hint_c= 3;

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String text = bundle.getString("level");
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        }
        if (bundle.getInt("lvl") == 3){
            y = 22;
        }
        else if (bundle.getInt("lvl") == 2)
        {
            y = 30;
        }
        else {
            y = 38;
        }

        mistakes = findViewById(R.id.mistakes_text);   //TextView
        pensil = findViewById(R.id.pensil_btn);        //Toggle Button
        rubber = findViewById(R.id.rubber_btn);        //Buttons
        btn_1 = findViewById(R.id.btn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.btn3);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.btn5);
        btn_6 = findViewById(R.id.btn6);
        btn_7 = findViewById(R.id.btn7);
        btn_8 = findViewById(R.id.btn8);
        btn_9 = findViewById(R.id.btn9);
        hint_btn = findViewById(R.id.btn_hint);
        hints = findViewById(R.id.hint_text);        //TextView

        // Tab of togglebuttons game board
        tb = new ToggleButton[][]{new ToggleButton[]{findViewById(R.id.TB00), findViewById(R.id.TB01), findViewById(R.id.TB02), findViewById(R.id.TB03), findViewById(R.id.TB04), findViewById(R.id.TB05), findViewById(R.id.TB06), findViewById(R.id.TB07), findViewById(R.id.TB08)},
                new ToggleButton[]{findViewById(R.id.TB10), findViewById(R.id.TB11), findViewById(R.id.TB12), findViewById(R.id.TB13), findViewById(R.id.TB14), findViewById(R.id.TB15), findViewById(R.id.TB16), findViewById(R.id.TB17), findViewById(R.id.TB18)},
                new ToggleButton[]{findViewById(R.id.TB20), findViewById(R.id.TB21), findViewById(R.id.TB22), findViewById(R.id.TB23), findViewById(R.id.TB24), findViewById(R.id.TB25), findViewById(R.id.TB26), findViewById(R.id.TB27), findViewById(R.id.TB28)},
                new ToggleButton[]{findViewById(R.id.TB30), findViewById(R.id.TB31), findViewById(R.id.TB32), findViewById(R.id.TB33), findViewById(R.id.TB34), findViewById(R.id.TB35), findViewById(R.id.TB36), findViewById(R.id.TB37), findViewById(R.id.TB38)},
                new ToggleButton[]{findViewById(R.id.TB40), findViewById(R.id.TB41), findViewById(R.id.TB42), findViewById(R.id.TB43), findViewById(R.id.TB44), findViewById(R.id.TB45), findViewById(R.id.TB46), findViewById(R.id.TB47), findViewById(R.id.TB48)},
                new ToggleButton[]{findViewById(R.id.TB50), findViewById(R.id.TB51), findViewById(R.id.TB52), findViewById(R.id.TB53), findViewById(R.id.TB54), findViewById(R.id.TB55), findViewById(R.id.TB56), findViewById(R.id.TB57), findViewById(R.id.TB58)},
                new ToggleButton[]{findViewById(R.id.TB60), findViewById(R.id.TB61), findViewById(R.id.TB62), findViewById(R.id.TB63), findViewById(R.id.TB64), findViewById(R.id.TB65), findViewById(R.id.TB66), findViewById(R.id.TB67), findViewById(R.id.TB68)},
                new ToggleButton[]{findViewById(R.id.TB70), findViewById(R.id.TB71), findViewById(R.id.TB72), findViewById(R.id.TB73), findViewById(R.id.TB74), findViewById(R.id.TB75), findViewById(R.id.TB76), findViewById(R.id.TB77), findViewById(R.id.TB78)},
                new ToggleButton[]{findViewById(R.id.TB80), findViewById(R.id.TB81), findViewById(R.id.TB82), findViewById(R.id.TB83), findViewById(R.id.TB84), findViewById(R.id.TB85), findViewById(R.id.TB86), findViewById(R.id.TB87), findViewById(R.id.TB88)}};


        game_table = Sudoku_generator.Sudoku_generator();            // full soluted sudoku board
        game_answ = new int[9][9];                                   // empty answers tab
        indexes = Level_generator.lvl(bundle.getInt("lvl"));    // index level generator to chose randomly idndexes of numbers in the game_table (sudoku borad)

        for(int a = 0; a < 9; a++){                                 // Empty charsequence for pensil with size 17
            for (int b = 0; b < 9; b++){
                tb[a][b].setTextOn("     \n     \n     ");
                tb[a][b].setTextOff("     \n     \n     ");
            }
        }

        // level generator
        for(int i = 0; i < y; i++){
            tb[indexes[0][i]][indexes[1][i]].setText(String.valueOf(game_table[indexes[0][i]][indexes[1][i]]));
            tb[indexes[0][i]][indexes[1][i]].setTextOn(String.valueOf(game_table[indexes[0][i]][indexes[1][i]]));
            tb[indexes[0][i]][indexes[1][i]].setTextOff(String.valueOf(game_table[indexes[0][i]][indexes[1][i]]));
            tb[indexes[0][i]][indexes[1][i]].setTextColor(Color.parseColor("#000000"));
            tb[indexes[0][i]][indexes[1][i]].setTextSize(26);
            game_answ[indexes[0][i]][indexes[1][i]] = game_table[indexes[0][i]][indexes[1][i]];
        }
    }

    // End game function
    public void koniec(int x){
        Intent i;
        i = new Intent(game.this, end_game.class);
        if(x == 1) {
            i.putExtra("end", "ZWYCIESTWO!");           // when win
        }
        else{
            i.putExtra("end", "PRZEGRANA!");            // When lose
        }
        startActivity(i);
    }
    // Give up button function
    public void poddaj(View view) {
        Intent i;
        i = new Intent(game.this, MainActivity.class);
        startActivity(i);
    }

    // Change color number buttons (gray is pencil, blue is pen)
    public void pensil_click(View view) {
        if(pensil.isChecked())
        {
            btn_1.setTextColor(Color.GRAY);
            btn_2.setTextColor(Color.GRAY);
            btn_3.setTextColor(Color.GRAY);
            btn_4.setTextColor(Color.GRAY);
            btn_5.setTextColor(Color.GRAY);
            btn_6.setTextColor(Color.GRAY);
            btn_7.setTextColor(Color.GRAY);
            btn_8.setTextColor(Color.GRAY);
            btn_9.setTextColor(Color.GRAY);
        }
        else
        {
            btn_1.setTextColor(Color.parseColor("#FF0451A8"));
            btn_2.setTextColor(Color.parseColor("#FF0451A8"));
            btn_3.setTextColor(Color.parseColor("#FF0451A8"));
            btn_4.setTextColor(Color.parseColor("#FF0451A8"));
            btn_5.setTextColor(Color.parseColor("#FF0451A8"));
            btn_6.setTextColor(Color.parseColor("#FF0451A8"));
            btn_7.setTextColor(Color.parseColor("#FF0451A8"));
            btn_8.setTextColor(Color.parseColor("#FF0451A8"));
            btn_9.setTextColor(Color.parseColor("#FF0451A8"));
        }
    }

    // Light animation fuction
    public void light(View view) {
        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                if (tb[i][j].isChecked()) {
                    tb[i][j].setChecked(false);
                }
                restartColor();
            }
        }
        byte k = -1;
        byte g = -1;
        CharSequence value = "";
        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                if (tb[i][j].getId() == view.getId()) {
                    tb[i][j].setChecked(true);
                    k = i;
                    g = j;
                    value = tb[i][j].getTextOff();
                }
            }
        }
        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                if (i == k && (j < g || j > g)) {
                   tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_light));             // row lighter
                }
                if (j == g && (i < k || i > k)) {
                    tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_light));            // column lighter
                }
                if(tb[i][j].getTextOff().equals(value) && value.length() == 1 && tb[k][g].getId() != tb[i][j].getId()){
                    tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_number));            // digits lighter
                }
            }
        }
    }


    // Hint button fuction
    public void hint_btn(View view) {
        if(hint_c > 0){

            Random random = new Random();
            int x;
            int y;
            boolean flag;
            do {
                x = random.nextInt(9);                              // Randomly chose index for hint
                y = random.nextInt(9);
                if (tb[x][y].getText().equals("")) {
                    tb[x][y].setTextOff(String.valueOf(game_table[x][y]));
                    tb[x][y].setTextOn(String.valueOf(game_table[x][y]));
                    tb[x][y].setTextSize(25);
                    tb[x][y].setChecked(false);
                    game_answ[x][y] = game_table[x][y];
                    tb[x][y].setTextColor(Color.parseColor("#FF0451A8"));
                    flag = false;
                } else {
                    flag = true;
                }
            } while (flag);
            if (checker.check(game_table, game_answ)) {
                koniec(1);
            }
            hint_c--;                                       // hints counter
            hints.setText(String.valueOf(hint_c) + "/3");
        }
        if (hint_c == 0){                                   // After 3 hits button becames unclicable
            hint_btn.setClickable(false);
            hint_btn.setBackgroundColor(Color.GRAY);
        }
    }


    // Pencil and main pen fuctions to enter digits into empty filed
    public void number(View view) {
        for(byte i = 0; i<9; i++)
        {
            for(byte j = 0; j <9; j++)
            {
                if(pensil.isChecked()){   // pencil options. enter the number in proper index to empty string
                    if (tb[i][j].isChecked()) {
                        if (view.getId() == R.id.btn1 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(0) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 0, '1'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 0, '1'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 0, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 0, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn2 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(2) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 2, '2'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 2, '2'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 2, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 2, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn3 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(4) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 4, '3'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 4, '3'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 4, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 4, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn4 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(6) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 6, '4'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 6, '4'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 6, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 6, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn5 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(8) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 8, '5'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 8, '5'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 8, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 8, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn6 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(10) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 10, '6'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 10, '6'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 10, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 10, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn7 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(12) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 12, '7'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 12, '7'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 12, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 12, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn8 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(14) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 14, '8'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 14, '8'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 14, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 14, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                        else if (view.getId() == R.id.btn9 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if(tb[i][j].getTextOff().charAt(16) == ' ') {
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 16, '9'));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 16, '9'));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                            else{
                                tb[i][j].setTextOff(checker.replace(tb[i][j].getTextOff(), 16, ' '));
                                tb[i][j].setTextOn(checker.replace(tb[i][j].getTextOff(), 16, ' '));
                                tb[i][j].setTextSize(10);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#15233B"));
                                break;
                            }
                        }
                        //
                    }
                }
                else {  // Pen opions. enter the digit onto empty field. If answer is corect digit is blue, else is red
                    if (tb[i][j].isChecked()) {
                        if (view.getId() == R.id.btn1 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 1) {
                                tb[i][j].setTextOff("1");
                                tb[i][j].setTextOn("1");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("1");
                                tb[i][j].setTextOn("1");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn2 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 2) {
                                tb[i][j].setTextOff("2");
                                tb[i][j].setTextOn("2");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("2");
                                tb[i][j].setTextOn("2");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn3 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 3) {
                                tb[i][j].setTextOff("3");
                                tb[i][j].setTextOn("3");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("3");
                                tb[i][j].setTextOn("3");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn4 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 4) {
                                tb[i][j].setTextOff("4");
                                tb[i][j].setTextOn("4");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("4");
                                tb[i][j].setTextOn("4");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn5 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 5) {
                                tb[i][j].setTextOff("5");
                                tb[i][j].setTextOn("5");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("5");
                                tb[i][j].setTextOn("5");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn6 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 6) {
                                tb[i][j].setTextOff("6");
                                tb[i][j].setTextOn("6");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("6");
                                tb[i][j].setTextOn("6");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn7 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 7) {
                                tb[i][j].setTextOff("7");
                                tb[i][j].setTextOn("7");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("7");
                                tb[i][j].setTextOn("7");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn8 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 8) {
                                tb[i][j].setTextOff("8");
                                tb[i][j].setTextOn("8");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("8");
                                tb[i][j].setTextOn("8");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                        } else if (view.getId() == R.id.btn9 && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            if (game_table[i][j] == 9) {
                                tb[i][j].setTextOff("9");
                                tb[i][j].setTextOn("9");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                game_answ[i][j] = game_table[i][j];
                                tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                                break;
                            } else {
                                tb[i][j].setTextOff("9");
                                tb[i][j].setTextOn("9");
                                tb[i][j].setTextSize(25);
                                tb[i][j].setChecked(false);
                                tb[i][j].setTextColor(Color.parseColor("#B31818"));
                                mistake++;
                                mistakes.setText(String.valueOf(mistake) + "/3");
                                break;
                            }
                            // Rubber fuction button. Clear the filed
                        } else if (view.getId() == R.id.rubber_btn && !(tb[i][j].getCurrentTextColor() == Color.parseColor("#000000"))) {
                            tb[i][j].setTextOff("     \n     \n     ");
                            tb[i][j].setTextOn("     \n     \n     ");
                            tb[i][j].setText("     \n     \n     ");
                            tb[i][j].setTextSize(25);
                            tb[i][j].setChecked(false);
                            tb[i][j].setTextColor(Color.parseColor("#FF0451A8"));
                        }
                    }
                }
                restartColor();
            }
        }   // Answer checker
        if(checker.check(game_table, game_answ)){
            koniec(1);
        }
        // mistake counter
        else if(mistake == 3){
            koniec(2);
        }
    }

    // Restarts the animation lights fuction to preavius borad colors.
    public void restartColor(){
        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
            // First line 3x3
            if (i < 3 && j < 3) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_1));
            }
            if (i < 3 && j >= 3 && j < 6) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_2));
            }
            if (i < 3 && j >= 6 && j < 9) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_1));
            }
            // Second line 3x3
            if (i >= 3 && i < 6 && j < 3) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_3));
            }
            if (i >= 3 && i < 6 && j >= 3 && j < 6) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_4));
            }
            if (i >= 3 && i < 6 && j >= 6 && j < 9) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_3));
            }
            // Third line 3x3
            if (i >= 6 && i < 9 && j < 3) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_1));
            }
            if (i >= 6 && i < 9 && j >= 3 && j < 6) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_2));
            }
            if (i >= 6 && i < 9 && j >= 6 && j < 9) {
                tb[i][j].setBackground(getDrawable(R.drawable.toggle_color_selector_1));
            }
        }
    }
}

}