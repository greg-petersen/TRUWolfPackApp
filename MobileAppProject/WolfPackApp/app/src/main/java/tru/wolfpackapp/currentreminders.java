package tru.wolfpackapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashSet;
import java.util.Set;

public class currentreminders extends AppCompatActivity {

    private static final String APPDATA = "tru.wolfpackapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentreminders);

        ListView lv = (ListView)findViewById(R.id.remindersLV);

        SharedPreferences sp = getSharedPreferences(APPDATA, MODE_PRIVATE);

        Set<String> reminderSet = sp.getStringSet("REMINDERS", new HashSet<String>());
        String[] remArray = reminderSet.toArray(new String[reminderSet.size()]);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, remArray));

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
