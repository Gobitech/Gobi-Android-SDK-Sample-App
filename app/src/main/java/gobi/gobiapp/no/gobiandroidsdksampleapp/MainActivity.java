package gobi.gobiapp.no.gobiandroidsdksampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView storyText = findViewById(R.id.textView_activityMain_storyText);
        Button showStoryButton = findViewById(R.id.button_activityMain_showStory);
    }
}
