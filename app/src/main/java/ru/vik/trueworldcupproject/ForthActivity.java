
package ru.vik.trueworldcupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class ForthActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static ArrayList<String> yearOfWinning = new ArrayList<>();
    public static ArrayList<String> countryOfWinning = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
        initialize();
        recyclerView = findViewById(R.id.forthActivityRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter<WinnersAdapter.ViewHolder> adapter = new WinnersAdapter(this, yearOfWinning, countryOfWinning);
        recyclerView.setAdapter(adapter);
    }

    private void initialize(){
        yearOfWinning.add("2018");
        yearOfWinning.add("2014");
        yearOfWinning.add("2010");
        yearOfWinning.add("2006");
        yearOfWinning.add("2002");
        yearOfWinning.add("1998");
        yearOfWinning.add("1994");
        yearOfWinning.add("1990");
        yearOfWinning.add("1986");
        yearOfWinning.add("1982");
        yearOfWinning.add("1978");
        yearOfWinning.add("1974");
        yearOfWinning.add("1970");
        yearOfWinning.add("1966");

        countryOfWinning.add("France");
        countryOfWinning.add("Germany");
        countryOfWinning.add("Spain");
        countryOfWinning.add("Italy");
        countryOfWinning.add("Brazil");
        countryOfWinning.add("France");
        countryOfWinning.add("Brazil");
        countryOfWinning.add("Germany");
        countryOfWinning.add("Argentina");
        countryOfWinning.add("Italy");
        countryOfWinning.add("Argentina");
        countryOfWinning.add("Germany");
        countryOfWinning.add("Brazil");
        countryOfWinning.add("England");
    }
}