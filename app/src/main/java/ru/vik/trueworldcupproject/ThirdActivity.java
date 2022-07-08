package ru.vik.trueworldcupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static ArrayList<String> betOnWinnerCountry = new ArrayList<>();
    public static ArrayList<Object> betOnWinnerCoef = new ArrayList<>();
    public Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initialize();
        recyclerView = findViewById(R.id.thirdActivityRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter<BetOnWinnerAdapter.ViewHolder> adapter = new BetOnWinnerAdapter(this, betOnWinnerCountry, betOnWinnerCoef);
        recyclerView.setAdapter(adapter);

        button = findViewById(R.id.betOnButton);
    }

    private void initialize(){
        betOnWinnerCountry.add("Qatar");
        betOnWinnerCountry.add("Ecuador");
        betOnWinnerCountry.add("Senegal");
        betOnWinnerCountry.add("Netherlands");
        betOnWinnerCountry.add("England");
        betOnWinnerCountry.add("IR Iran");
        betOnWinnerCountry.add("USA");
        betOnWinnerCountry.add("Wales");
        betOnWinnerCountry.add("Argentina");
        betOnWinnerCountry.add("Saudi Arabia");
        betOnWinnerCountry.add("Mexico");
        betOnWinnerCountry.add("Poland");
        betOnWinnerCountry.add("France");
        betOnWinnerCountry.add("Denmark");
        betOnWinnerCountry.add("Tunisia");
        betOnWinnerCountry.add("Australia");
        betOnWinnerCountry.add("Spain");
        betOnWinnerCountry.add("Germany");
        betOnWinnerCountry.add("Japan");
        betOnWinnerCountry.add("Costa Rica");
        betOnWinnerCountry.add("Belgium");
        betOnWinnerCountry.add("Canada");
        betOnWinnerCountry.add("Morocco");
        betOnWinnerCountry.add("Croatia");
        betOnWinnerCountry.add("Brazil");
        betOnWinnerCountry.add("Serbia");
        betOnWinnerCountry.add("Switzerland");
        betOnWinnerCountry.add("Cameroon");
        betOnWinnerCountry.add("Portugal");
        betOnWinnerCountry.add("Ghana");
        betOnWinnerCountry.add("Switzerland");
        betOnWinnerCountry.add("Korea Republic");

        betOnWinnerCoef.add(2.2);
        betOnWinnerCoef.add(4.5);
        betOnWinnerCoef.add(19);
        betOnWinnerCoef.add(5.3);
        betOnWinnerCoef.add(3.7);
        betOnWinnerCoef.add(23);
        betOnWinnerCoef.add(18);
        betOnWinnerCoef.add(14);
        betOnWinnerCoef.add(7.8);
        betOnWinnerCoef.add(20);
        betOnWinnerCoef.add(21);
        betOnWinnerCoef.add(18);
        betOnWinnerCoef.add(3.2);
        betOnWinnerCoef.add(5.5);
        betOnWinnerCoef.add(10);
        betOnWinnerCoef.add(26);
        betOnWinnerCoef.add(4.2);
        betOnWinnerCoef.add(3.9);
        betOnWinnerCoef.add(25);
        betOnWinnerCoef.add(23);
        betOnWinnerCoef.add(4.1);
        betOnWinnerCoef.add(21.2);
        betOnWinnerCoef.add(29);
        betOnWinnerCoef.add(4.4);
        betOnWinnerCoef.add(4.0);
        betOnWinnerCoef.add(18);
        betOnWinnerCoef.add(23);
        betOnWinnerCoef.add(21.2);
        betOnWinnerCoef.add(7.4);
        betOnWinnerCoef.add(9.8);
        betOnWinnerCoef.add(9.5);
        betOnWinnerCoef.add(23.3);
    }

    public void getError(View view){
        FragmentManager manager = getSupportFragmentManager();
        InternetErrorDialogFragment myDialogFragment = new InternetErrorDialogFragment();
        myDialogFragment.show(manager, "myDialog");
    }
}