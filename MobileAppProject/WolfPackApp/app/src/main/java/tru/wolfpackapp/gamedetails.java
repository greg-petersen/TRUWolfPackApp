package tru.wolfpackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class gamedetails extends AppCompatActivity {

    private static final String APPDATA = "tru.wolfpackapp";

    private eventObj data;
    private ArrayList<String> dataToDisplay = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamedetails);

        Intent intent = getIntent();
        data = (eventObj)intent.getSerializableExtra("gameinfo");

        Log.d("data", "Sport: " + data.getSport());
        Log.d("data", "Gender: " + data.getGender());
        Log.d("data", "Date: " + data.getDate());

        if(data.getSport().equals("swimming"))
            // Special case for swimming.
        {
            dataToDisplay.add(data.getEventName());
            DateFormat df = new SimpleDateFormat("yyyy EEE MMM d", Locale.ENGLISH);
            dataToDisplay.add(df.format(data.getDate()));
            dataToDisplay.add(data.getLocation());
        }
        else{
            DateFormat df = new SimpleDateFormat("yyyy EEE MMM d", Locale.ENGLISH);
            dataToDisplay.add(df.format(data.getDate()));
            dataToDisplay.add(data.getVersus());
            dataToDisplay.add(data.getLocation());
            dataToDisplay.add(data.getTime());
            dataToDisplay.add(data.getResult());
        }

        ListView lv = (ListView)findViewById(R.id.gameDetailsLV);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataToDisplay));

        findViewById(R.id.setRemBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(gamedetails.this, "Reminder set.", Toast.LENGTH_SHORT).show();

                SharedPreferences sp = getSharedPreferences(APPDATA, MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();

                Set<String> reminderSet = sp.getStringSet("REMINDERS", new HashSet<String>());
                String reminderToSet = dataToDisplay.toString();
                reminderSet.add(reminderToSet);
                edit.putStringSet("REMINDERS", reminderSet);
                edit.commit();
            }
        });

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

