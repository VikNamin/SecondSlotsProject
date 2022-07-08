package ru.vik.trueworldcupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static ArrayList<String> groups1 = new ArrayList<>();
    public static  ArrayList<String> groups2 = new ArrayList<>();
    public static ArrayList<String> groupsText1 = new ArrayList<>();
    public static  ArrayList<String> groupsText2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
        recyclerView = findViewById(R.id.secondActivityRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter<GroupAdapter.ViewHolder> adapter = new GroupAdapter(this, groups1, groups2, groupsText1, groupsText2);
        recyclerView.setAdapter(adapter);
    }

    private void initialize(){
        groups1.add("GROUP A");
        groups1.add("GROUP C");
        groups1.add("GROUP E");
        groups1.add("GROUP G");
        groups2.add("GROUP B");
        groups2.add("GROUP D");
        groups2.add("GROUP F");
        groups2.add("GROUP H");

        groupsText1.add("A1. Qatar\n" +
                "A2. Ecuador\n" +
                "A3. Senegal\n" +
                "A4. Netherlands\n");
        groupsText1.add("C1. Argentina\n" +
                "C2. Saudi Arabia\n" +
                "C3. Mexico\n" +
                "C4. Poland\n");
        groupsText1.add("E1.  Spain\n" +
                "E2. Germany\n" +
                "E3. Japan\n" +
                "E4. Costa Rica\n");
        groupsText1.add("G1. Brazil\n" +
                "G2. Serbia\n" +
                "G3. Switzerland\n" +
                "G4. Cameroon\n");
        groupsText2.add("B1. England\n" +
                "B2. IR Iran\n" +
                "B3. USA\n" +
                "B4. Wales\n");
        groupsText2.add("D1. France\n" +
                "D2. Denmark\n" +
                "D3. Tunisia\n" +
                "D4. Australia\n");
        groupsText2.add("F1. Belgium\n" +
                "F2. Canada\n" +
                "F3. Morocco\n" +
                "F4. Croatia\n");
        groupsText2.add("H1. Portugal\n" +
                "H2. Ghana\n" +
                "H3. Uruguay\n" +
                "H4. Korea Republic\n");
    }
}