package com.example.quiz;

import java.util.List;

public class Quiz
{

    private int currentQuestion;
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions)
    {
        this.questions = questions;
        currentQuestion = 0;
        score = 0;
    }


    public boolean checkAnswer(boolean answer)
    {
        if(answer == questions.get(currentQuestion).getAnswer())
        {
            score++;
            return true;

        }
        return false;


    }
    public boolean hasMoreQuestion()
    {
        if(currentQuestion + 1 == questions.size())
        {
            return false;
        }
        return true;


    }
    public Question nextQuestion()
    {
        currentQuestion = currentQuestion + 1;



        return questions.get(currentQuestion);

    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public List<Question> getQuestions()
    {
        return questions;
    }

    public int getScore() {
        return score;
    }
}

