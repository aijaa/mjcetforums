package com.syedsauban.mjforums;

/**
 * Created by Syed on 19-02-2018.
 */



import java.util.ArrayList;

public class Post {
    private String AnswerString,AnswerWrittenBy;
    long timestamp;
    private boolean isDisplayAnswer;
    private ArrayList<String> tags;
    private String deptAndYear;
    private int numberOfUpvotes;
    private boolean hasAnswers;


    private String UserKey,UserId,QuestionString,QuestionDetailsString,NameOfAsker;
    public Post(long timestamp,String QuestionString, String QuestionDetailsString,String NameOfAsker, String AnswerString, String AnswerWrittenBy, String UserKey, String UserId, String deptAndYear, ArrayList<String> tags,int numberOfUpvotes
    )
    {
        this.isDisplayAnswer=false;
        this.numberOfUpvotes=numberOfUpvotes;
        this.timestamp=timestamp;
        this.NameOfAsker=NameOfAsker;
        this.deptAndYear=deptAndYear;
        this.tags=tags;
        this.QuestionString=QuestionString;
        this.QuestionDetailsString=QuestionDetailsString;
        this.UserId=UserId;
        this.UserKey=UserKey;
        this.AnswerString=AnswerString;
        this.AnswerWrittenBy=AnswerWrittenBy;

    }

    public Post(long timestamp,String QuestionString, String QuestionDetailsString,String NameOfAsker,ArrayList<String> tags)
    {
        this.isDisplayAnswer=false;
        this.numberOfUpvotes=numberOfUpvotes;
        this.timestamp=timestamp;
        this.NameOfAsker=NameOfAsker;
        this.QuestionString=QuestionString;
        this.QuestionDetailsString=QuestionDetailsString;
        this.tags=tags;
    }



    public Post()
    {

    }

    public Post(String nameOfAsker,String questionAskedByEmail,String QuestionString,String QuestionDetailsString,long timestamp,String userKey,ArrayList<String> tags)
    {
        this.NameOfAsker=nameOfAsker;
        this.QuestionString=QuestionString;
        this.QuestionDetailsString=QuestionDetailsString;
        this.UserKey=userKey;
        this.timestamp=timestamp;
        this.tags=tags;
    }


    public boolean isDisplayAnswer() {
        return isDisplayAnswer;
    }

    public void setDisplayAnswer(boolean displayAnswer) {
        isDisplayAnswer = displayAnswer;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNameOfAsker() {
        return NameOfAsker;
    }

    public void setNameOfAsker(String nameOfAsker) {
        NameOfAsker = nameOfAsker;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getDeptAndYear() {
        return deptAndYear;
    }

    public void setDeptAndYear(String deptAndYear) {
        this.deptAndYear = deptAndYear;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getQuestionDetailsString() {
        return QuestionDetailsString;
    }

    public String getQuestionString() {
        return QuestionString;
    }

    public void setQuestionDetailsString(String questionDetailsString) {
        QuestionDetailsString = questionDetailsString;
    }

    public void setQuestionString(String questionString) {
        QuestionString = questionString;
    }

    public String getUserKey() {
        return UserKey;
    }

    public String getUserId() {
        return UserId;
    }


    public String getAnswerString() {
        return AnswerString;
    }

    public String getAnswerWrittenBy() {
        return AnswerWrittenBy;
    }

    public void setUserKey(String userKey) {
        UserKey = userKey;
    }

    public void setAnswerString(String answerString) {
        AnswerString = answerString;
    }


    public void setAnswerWrittenBy(String answerWrittenBy) {
        AnswerWrittenBy = answerWrittenBy;
    }


    public void setUserId(String userId) {
        UserId = userId;
    }

    public int getNumberOfUpvotes() {
        return numberOfUpvotes;
    }

    public void setNumberOfUpvotes(int numberOfUpvotes) {
        this.numberOfUpvotes = numberOfUpvotes;
    }


    public void setHasAnswers(boolean hasAnswers) {
        this.hasAnswers = hasAnswers;
    }

    public boolean isHasAnswers() {
        return hasAnswers;
    }
}

