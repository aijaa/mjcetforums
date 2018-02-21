package com.syedsauban.mjforums;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TopicWiseFeed extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mReference;
    ArrayList<Post> answers;
    RecyclerView recyclerView;
    TextView headingTV;
    TopicWiseAdapter topicWiseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_wise_feed);
        headingTV=(TextView)findViewById(R.id.topicname);
        String topicName=getIntent().getStringExtra("topicName");
        headingTV.setText(topicName);
        try{
            answers = new ArrayList<>();
            mDatabase = FirebaseDatabase.getInstance();
            mReference = mDatabase.getReference();
            recyclerView = (RecyclerView) findViewById(R.id.trecyclerview);

            topicWiseAdapter = new TopicWiseAdapter(answers, TopicWiseFeed.this,topicName);

            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(TopicWiseFeed.this);
            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(topicWiseAdapter);

            Query query = mReference.child("Tags").child(topicName)
                    .child("Posts");


            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    long max = 0;
                    long numberOfUpvotes = 0;
                    if (dataSnapshot.exists()) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            if (ds.exists()) {
                                Log.v("TopicWiseFeed123",ds.toString());
                                Question question;
                                question = ds.getValue(Question.class);
                                Log.v(question.getQuestionString()+"132",question.isHasAnswers()+"");
                                String displayAnswerString = "notworking";
                                Post displayAnswer = null;
                                if (question.isHasAnswers()) {
                                    for (DataSnapshot answerChild : ds.getChildren()) {
                                        if (answerChild.exists()) {
                                            try {
                                                numberOfUpvotes = answerChild.child("Upvoters").getChildrenCount();
                                                Log.v("NumberOfUpvotes", answerChild.child("Upvoters").getChildrenCount() + "");
//                                    Log.v("NewestDS", answerChild.getValue(Answer.class).getAnswerString()+ "");
                                                if (max <= numberOfUpvotes) {
                                                    max = numberOfUpvotes;
                                                    displayAnswer = answerChild.getValue(Post.class);
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                        }
                                    }
                                    Log.v("QTest1", displayAnswerString);
                                    answers.add(displayAnswer);
                                    topicWiseAdapter.notifyDataSetChanged();
                                }
                                else
                                {
                                    Post post=new Post(
                                            question.getNameOfAsker(),question.getQuestionAskedByEmail(),
                                            question.getQuestionString(),question.getQuestionDetails(),
                                            question.getTimestamp(),question.getUserKey(),
                                            question.getTags()
                                    );
                                    answers.add(post);
                                    topicWiseAdapter.notifyDataSetChanged();
                                }
                                Log.v("QuestionTesting", question.getQuestionString());
//                            Answer displayAnswer=new Answer();
//                            Answer answer=new Answer();


//                            Log.v("PostdsInString2",ds.getChildren().iterator().next().child("nameOfAsker").toString());
//                            long max=0;
//                            long numberOfUpvotes=0;
////                            max=(Integer) ds.getChildren().iterator().next().child("numberOfUpvotes")
////                                    .getValue();
//                            Answer answer = new Answer();
//                            Answer displayAnswer=new Answer();
//                            String displayAnswerString="empty";
//                            for(DataSnapshot answerChild: ds.getChildren()) {
//                                if (answerChild.exists()) {
//                                    numberOfUpvotes = answerChild.child("Upvoters").getChildrenCount();
//                                    Log.v("NumberOfUpvotes",answerChild.child("Upvoters").getChildrenCount()+"");
////                                    Log.v("NewestDS", answerChild.getValue(Answer.class).getAnswerString()+ "");
//                                    if (max <= numberOfUpvotes) {
//                                        max = numberOfUpvotes;
//                                        displayAnswerString = answerChild.child("answerString")
//                                                .getValue().toString();
//                                        displayAnswer=answerChild.getValue(Answer.class);
//                                    }
//                                }
//                                Log.v("InAnsWB,max",displayAnswer.getAnswerWrittenBy()+","+max);
//                            }
//
//                            Log.v("OutAnsWB,max",displayAnswer.getAnswerWrittenBy()+","+max);
//
//                            answers.add(displayAnswer);
//                            topicWiseAdapter.notifyDataSetChanged();


                            }
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
