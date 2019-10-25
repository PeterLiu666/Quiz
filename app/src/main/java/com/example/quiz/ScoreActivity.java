package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity
{
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        wireWidgets();

        Intent lastIntent = getIntent();

        // open the extras
        int score = lastIntent.getIntExtra(MainActivity.EXTRA_SCORE, 0);


        //
        scoreText.setText("Score: " + score + "\nThanks for Playing");
    }

    public void wireWidgets()
    {
        scoreText = findViewById(R.id.textView_score_score);

    }
}
