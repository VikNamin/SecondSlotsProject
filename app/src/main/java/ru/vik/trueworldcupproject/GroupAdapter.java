package ru.vik.trueworldcupproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final ArrayList<String> groups1, groups2, groupsText1, groupsText2;

    GroupAdapter(Context context, ArrayList<String> groups1, ArrayList<String> groups2, ArrayList<String> groupsText1, ArrayList<String> groupsText2) {
        this.groups1 = groups1;
        this.groups2 = groups2;
        this.groupsText1 = groupsText1;
        this.groupsText2 = groupsText2;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recylerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.firstTitle.setText(groups1.get(position));
        holder.firstText.setText(groupsText1.get(position));
        holder.secondTitle.setText(groups2.get(position));
        holder.secondText.setText(groupsText2.get(position));
    }

    @Override
    public int getItemCount() {
        return groups1.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView firstTitle, secondTitle, firstText, secondText;
        ViewHolder(View view){
            super(view);
            firstTitle = view.findViewById(R.id.firstGroupTitleText);
            secondTitle = view.findViewById(R.id.secondGroupTitleText);
            firstText = view.findViewById(R.id.firstGroupText);
            secondText = view.findViewById(R.id.secondGroupText);
        }
    }

}