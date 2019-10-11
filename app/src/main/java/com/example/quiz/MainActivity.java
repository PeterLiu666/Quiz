package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import java.io.File;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    InputStream inputQuestionFile = getResources().openRawResource(R.raw.questions);

    String json = readFile(inputQuestionFile);




    private String readFile(InputStream questionFile)
    {

    }

}
