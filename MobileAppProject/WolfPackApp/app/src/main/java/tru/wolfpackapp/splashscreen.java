package tru.wolfpackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class splashscreen extends AppCompatActivity
{
    Button go_next_home_sc;//initializing the only button on the screen so far

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        go_next_home_sc = (Button) findViewById(R.id.go_next_home_sc);//initializing the go net button
        go_next_home_sc.setOnClickListener(goNext);//setting the onclick listener
    }
    private View.OnClickListener goNext = new View.OnClickListener()//function to call the next activity
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent (v.getContext(), homescreen.class);
            startActivity(intent);
        }
    };//i stopped here, just following our graphical flow from the draw.io
}
