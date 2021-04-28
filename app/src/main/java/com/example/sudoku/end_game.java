package com.example.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class end_game extends AppCompatActivity {

    TextView text_end;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        text_end = findViewById(R.id.finish);
        image = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String text = bundle.getString("end");
            text_end.setText(text);
            if(text.equals("ZWYCIESTWO!"))
            {
                image.setImageDrawable(getDrawable(R.drawable.win));
            }
            else{
                image.setImageDrawable(getDrawable(R.drawable.lost));
            }
        }
    }

    public void again(View view) {
        Intent i;
        i = new Intent(end_game.this, level.class);
        startActivity(i);
    }
}