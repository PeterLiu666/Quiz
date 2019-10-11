package com.example.quiz;

import java.util.List;

public class Quiz
{

    private int currentQuestion;
    private List<Question> questions;
    private int score;


    public void checkAnswer(boolean answer)
    {

    }
    public boolean hasMoreQuestion()
    {
        if(questions.size() == currentQuestion + 1)
        {
            return false;
        }
        return true;


    }
    public Question nextQuestion()
    {
        currentQuestion++;
        return questions.get(currentQuestion + 1);

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

    public List<Question> getQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }
}

