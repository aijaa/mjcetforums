package com.syedsauban.mjforums;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ajaaz on 9/28/2017.
 */

public class FeedClass
{
    private String question,askedby,answeredby,answerPreview,answeredbyCred;
    private int answeredbyProfpic;
    private ArrayList<String> tags;
    int numberOfAnswers;
    public FeedClass(String question, String askedby, String answeredby, String answerPreview, String answeredbyCred, int answeredbyProfpic,ArrayList<String> tags,int numberOfAnswers) {
        this.question = question;
        this.askedby = askedby;
        this.answeredby = answeredby;
        this.answerPreview = answerPreview;
        this.answeredbyCred = answeredbyCred;
        this.answeredbyProfpic = answeredbyProfpic;
        this.numberOfAnswers=numberOfAnswers;
        this.tags=tags;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAskedby() {
        return askedby;
    }

    public void setAskedby(String askedby) {
        this.askedby = askedby;
    }

    public String getAnsweredby() {
        return answeredby;
    }

    public void setAnsweredby(String answeredby) {
        this.answeredby = answeredby;
    }

    public String getAnswerPreview() {
        return answerPreview;
    }

    public void setAnswerPreview(String answerPreview) {
        this.answerPreview = answerPreview;
    }

    public String getAnsweredbyCred() {
        return answeredbyCred;
    }

    public void setAnsweredbyCred(String answeredbyCred) {
        this.answeredbyCred = answeredbyCred;
    }

    public int getAnsweredbyProfpic() {
        return answeredbyProfpic;
    }

    public void setAnsweredbyProfpic(int answeredbyProfpic) {
        this.answeredbyProfpic = answeredbyProfpic;
    }
}
