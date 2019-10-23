package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private TextView questionText;
    private Button trueButton;
    private Button falseButton;
    private boolean waitAnswer;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputQuestionFile = getResources().openRawResource(R.raw.questions);


        wireWidgets();

        String json = readFile(inputQuestionFile);
        waitAnswer = true;


        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questionsArray =  gson.fromJson(json, Question[].class);
        // convert your array to a list using the Arrays utility class
        List<Question> questions = Arrays.asList(questionsArray);
        // verify that it read everything properly
        //Log.d(TAG, "onCreate: " + questions.toString());



        quiz = new Quiz(questions);
        questionText.setText(quiz.getQuestions().get(quiz.getCurrentQuestion()).getQuestion());


    }

    private void setListeners()
    {
        trueButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                quiz.checkAnswer(true);
                quiz.nextQuestion();
                if(quiz.hasMoreQuestion())
                {
                    questionText.setText(quiz.nextQuestion().getQuestion());

                }




            }
        });

        falseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                quiz.checkAnswer(false);

                if(quiz.hasMoreQuestion())
                {
                    questionText.setText(quiz.nextQuestion().getQuestion());
                }




            }
        });
    }



    public void wireWidgets()
    {
        questionText = findViewById(R.id.textView_question_main);
        trueButton = findViewById(R.id.button_true_main);
        falseButton = findViewById(R.id.button_false_main);

    }


    public String readFile(InputStream inputStream)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try
        {
            while ((len = inputStream.read(buf)) != -1)
            {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        }
        catch (IOException e)
        {

        }
        return outputStream.toString();
    }

}
