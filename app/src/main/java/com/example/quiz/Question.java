package com.example.quiz;

public class Question
{

    private boolean answer;
    private String question;

    public Question(String question, boolean answer)
    {
        this.question = question;
        this.answer = answer;

    }



    public boolean getAnswer()
    {
        return answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setAnswer(boolean answer)
    {
        this.answer = answer;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public boolean checkAnswer()
    {
        return true;
    }



}
