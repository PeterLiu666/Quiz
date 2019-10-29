package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity
{
    private TextView scoreText;
    private Button restart;

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
        scoreText.setText(score + "/10");
        setListeners();
    }

    public void setListeners()
    {
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent targetIntent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(targetIntent);

            }
        });

    }


    public void wireWidgets()
    {
        scoreText = findViewById(R.id.textView_score_score);
        restart = findViewById(R.id.button_restart_score);


    }
}
