package com.example.woochulhyun.educationalgameapp.Model;

/**
 * Created by WOOCHUL HYUN on 2018-01-13.
 */

public class Question {
    private String Qestion, AnswerA, AnswerB, AnswerC, AnswerD, CorrectAnswer, CategoryId, IsImageQuestion;

    public Question() {
    }

    public Question(String qestion, String answerA, String answerB, String answerC, String answerD, String correctAnswer, String categoryId, String isImageQuestion) {
        Qestion = qestion;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        CorrectAnswer = correctAnswer;
        CategoryId = categoryId;
        IsImageQuestion = isImageQuestion;
    }

    public String getQestion() {
        return Qestion;
    }

    public void setQestion(String qestion) {
        Qestion = qestion;
    }

    public String getAnsaweA() {
        return AnswerA;
    }

    public void setAnsaweA(String ansaweA) {
        AnswerA = ansaweA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getIsImageQuestion() {
        return IsImageQuestion;
    }

    public void setIsImageQuestion(String isImageQuestion) {
        IsImageQuestion = isImageQuestion;
    }
}
