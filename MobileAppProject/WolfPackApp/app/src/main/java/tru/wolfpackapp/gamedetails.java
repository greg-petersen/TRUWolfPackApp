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

import java.util.HashSet;
import java.util.Set;

public class gamedetails extends AppCompatActivity {

    private static final String APPDATA = "tru.wolfpackapp";
    private String[] data;
    private String sport, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamedetails);

        Intent intent = getIntent();
        data = intent.getStringArrayExtra("gameinfo");
        gender = intent.getStringExtra("gender");
        sport = intent.getStringExtra("sport");

        Log.d("testest", "Gender passed: " + gender);
        Log.d("testest", "Sport passed: " + sport);

        switch(gender){
            case "men": gender = "Men's"; break;
            case "wom": gender = "Wom's"; break;
            case "both" : gender = "Mixed"; break;
            default: Log.d("testest", "What happened?");break;
        }
        switch(sport){
            case "bask": sport = "Basketball"; break;
            case "soc": sport = "Soccer"; break;
            case "vol": sport = "Volleyball"; break;
            case "swimming": sport = "Swimming"; break;
            case "baseball": sport = "Baseball"; break;
            default: Log.d("testest", "What happened?");break;
        }

        Log.d("testest", "Sport: " + sport);
        Log.d("testest", "Gender: " + gender);

        ListView lv = ((ListView)findViewById(R.id.gameDetailsLV));
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data));

        findViewById(R.id.setRemBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(gamedetails.this, "Reminder set.", Toast.LENGTH_SHORT).show();

                SharedPreferences sp = getSharedPreferences(APPDATA, MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                Set<String> reminderSet = sp.getStringSet("REMINDERS", new HashSet<String>());

                String toPlace = "";
                toPlace += data[0];
                for(int x = 1; x<data.length; x++)
                    toPlace += "," + data[x];
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

