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

public class BetOnWinnerAdapter extends RecyclerView.Adapter<BetOnWinnerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final ArrayList<String> betOnWinnerCountry;
    private final ArrayList<Object> betOnWinnerCoef;

    BetOnWinnerAdapter(Context context, ArrayList<String> betOnWinnerCountry, ArrayList<Object> betOnWinnerCoef){
        this.betOnWinnerCountry = betOnWinnerCountry;
        this.betOnWinnerCoef = betOnWinnerCoef;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BetOnWinnerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recylerview_item_coef, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BetOnWinnerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.betTeamTextView.setText(betOnWinnerCountry.get(position));
        holder.betOnButton.setText(betOnWinnerCoef.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return betOnWinnerCoef.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView betTeamTextView;
        final Button betOnButton;
        ViewHolder(View view){
            super(view);
            betTeamTextView = view.findViewById(R.id.betTeamTextView);
            betOnButton = view.findViewById(R.id.betOnButton);
        }
    }

}