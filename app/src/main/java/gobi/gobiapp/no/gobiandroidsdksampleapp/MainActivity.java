package gobi.gobiapp.no.gobiandroidsdksampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import no.gobiapp.gobi.sdk.Gobi;
import rx.CompletableSubscriber;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView storyText = findViewById(R.id.textView_activityMain_storyText);
        Button showStoryButton = findViewById(R.id.button_activityMain_showStory);

        showStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStory();
            }
        });
    }

    public void showStory() {
        Gobi.showStory(Stories.TEAM_GOBI, getSupportFragmentManager())
                .subscribe(new CompletableSubscriber() {
                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "Failed to show the story", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSubscribe(Subscription d) { }
                });
    }
}
