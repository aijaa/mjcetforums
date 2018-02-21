
package com.syedsauban.mjforums;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.futuremind.recyclerviewfastscroll.FastScroller;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Syed on 25-08-2017.
 */

public class ByTopic extends android.support.v4.app.Fragment {
    ArrayList<String> tagslist;

    ByTopicAdapter adapter;
    FastScroller fastScroller;
    FloatingActionButton fab;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.alltopics,container,false);
        fab=(FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        tagslist=new ArrayList<>();
        adapter= new ByTopicAdapter(getActivity(),tagslist);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        fastScroller = (FastScroller) view.findViewById(R.id.fastscroll);

        //has to be called AFTER RecyclerView.setAdapter()
        fastScroller.setRecyclerView(recyclerView);

        ValueEventListener listener=new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    if(dataSnapshot.exists()) {
                        String tag = (String)ds.child("Tag Name").getValue();
                        Log.v("Tags", tag);
                        tagslist.add(tag);
                        adapter.notifyDataSetChanged();
//                        tagslist.add(tag.getTagName());
                    }
                }




//                listView.setAdapter(new tagAdapter(AskQuestion.this, tagslist));
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        FirebaseDatabase.getInstance().getReference()
                .child("Tags").addValueEventListener(listener);


        return view;
    }

}
