package com.syedsauban.mjforums;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Syed on 16-02-2018.
 */
public class ByTopicAdapter extends RecyclerView.Adapter<ByTopicAdapter.RecyclerViewHolder>
implements SectionTitleProvider
{

    private ArrayList<String> arrayList=new ArrayList<String>();
    Context context;
    public ByTopicAdapter(Context context,ArrayList<String> arrayList)
    {
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public ByTopicAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_item,parent,false);

        ByTopicAdapter.RecyclerViewHolder recyclerViewHolder=new ByTopicAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public void onBindViewHolder(ByTopicAdapter.RecyclerViewHolder holder, int position) {
        String topicName=arrayList.get(position);
        holder.topicTextView.setText(topicName);
        holder.topicTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topicName=((TextView) v).getText().toString();
                Intent intent=new Intent(context,TopicWiseFeed.class);
                intent.putExtra("topicName",topicName);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    @Override
    public String getSectionTitle(int position) {
        return arrayList.get(position).substring(0, 1);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView topicTextView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);

            topicTextView=(TextView)itemView.findViewById(R.id.topicNameView);


        }
    }
}

