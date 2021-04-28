package com.example.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class level extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }

    public void wroc(View view) {
        Intent i;
        i = new Intent(level.this, MainActivity.class);
        startActivity(i);
    }

    public void lvl_click(View view) {

        Intent i;
        if (view.getId() == R.id.easy_btn) {
            i = new Intent(level.this, game.class);
            i.putExtra("level", "Wybrałeś poziom łatwy! Powodzenia");
            i.putExtra("lvl", 1);
            startActivity(i);
        }
        else if (view.getId() == R.id.medium_btn) {
            i = new Intent(level.this, game.class);
            i.putExtra("level", "Wybrałeś poziom średni! Powodzenia");
            i.putExtra("lvl", 2);
            startActivity(i);
        }
        else if (view.getId() == R.id.hard_btn) {
            i = new Intent(level.this, game.class);
            i.putExtra("level", "Wybrałeś poziom trudny! Powodzenia");
            i.putExtra("lvl", 3);
            startActivity(i);
        }

    }
}