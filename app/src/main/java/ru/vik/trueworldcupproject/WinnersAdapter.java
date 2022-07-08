package ru.vik.trueworldcupproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WinnersAdapter extends RecyclerView.Adapter<WinnersAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final ArrayList<String> yearOfWinning, countryOfWinning;

    WinnersAdapter(Context context, ArrayList<String> yearOfWinning, ArrayList<String> countryOfWinning){
        this.yearOfWinning = yearOfWinning;
        this.countryOfWinning = countryOfWinning;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WinnersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recylerview_item_winners, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WinnersAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.yearOfWinningTextView.setText(yearOfWinning.get(position));
        holder.winnerTextView.setText(countryOfWinning.get(position));
    }

    @Override
    public int getItemCount() {
        return yearOfWinning.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView yearOfWinningTextView, winnerTextView;
        ViewHolder(View view){
            super(view);
            yearOfWinningTextView = view.findViewById(R.id.yearOfWinningTextView);
            winnerTextView = view.findViewById(R.id.winnerTextView);
        }
    }

}
