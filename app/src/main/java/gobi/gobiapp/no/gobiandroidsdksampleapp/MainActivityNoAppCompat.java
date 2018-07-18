package gobi.gobiapp.no.gobiandroidsdksampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import no.gobiapp.gobi.sdk.Gobi;
import no.gobiapp.gobi.sdk.data.StoryData;
import rx.CompletableSubscriber;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * An alternative to {@link MainActivity} for those that do not use {@link AppCompatActivity}
 * but rather {@link Activity} as the base class.
 *
 * @author Kristian 'krissrex' Rekstad
 */
public class MainActivityNoAppCompat extends Activity {

    private TextView storyText;
    private final CompositeSubscription subscriptions = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storyText = findViewById(R.id.textView_activityMain_storyText);
        Button showStoryButton = findViewById(R.id.button_activityMain_showStory);

        showStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStory();
            }
        });
        loadStoryInfo();
    }

    public void showStory() {
        Gobi.showStory(Stories.TEAM_GOBI, this)
                .subscribe(new CompletableSubscriber() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivityNoAppCompat.this, "Failed to show the story", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSubscribe(Subscription d) {
                    }
                });
    }

    private void loadStoryInfo() {
        final Subscription storyDataSubscription = Gobi.getStoryDataForId(Stories.TEAM_GOBI)
                .subscribe(new SingleSubscriber<StoryData>() {
                    @Override
                    public void onSuccess(StoryData storyData) {
                        storyText.setText("View " + storyData.getStoryName());
                    }

                    @Override
                    public void onError(Throwable error) {
                        storyText.setText("Error: Failed to get story info");
                    }
                });
        subscriptions.add(storyDataSubscription);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriptions.clear();
    }
}
