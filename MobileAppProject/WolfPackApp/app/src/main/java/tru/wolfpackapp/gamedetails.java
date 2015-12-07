package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class gamedetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamedetails);

        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra(gamesList.GAMEINFO);

        ListView lv = ((ListView)findViewById(R.id.gameDetailsLV));
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data));

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

