package com.example.woochulhyun.educationalgameapp.Model;

/**
 * Created by WOOCHUL HYUN on 2018-01-13.
 */

public class Question {
    private String Qestion, AnsaweA, AnswerB, AnswerC, AnswerD, CorrectAnswer, categoryID, isImageQuestion;

    public Question() {
    }

    public Question(String qestion, String ansaweA, String answerB, String answerC, String answerD, String correctAnswer, String categoryID, String isImageQuestion) {
        Qestion = qestion;
        AnsaweA = ansaweA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        CorrectAnswer = correctAnswer;
        this.categoryID = categoryID;
        this.isImageQuestion = isImageQuestion;
    }

    public String getQestion() {
        return Qestion;
    }

    public void setQestion(String qestion) {
        Qestion = qestion;
    }

    public String getAnsaweA() {
        return AnsaweA;
    }

    public void setAnsaweA(String ansaweA) {
        AnsaweA = ansaweA;
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

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getIsImageQuestion() {
        return isImageQuestion;
    }

    public void setIsImageQuestion(String isImageQuestion) {
        this.isImageQuestion = isImageQuestion;
    }
}
